package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeScreen {

    private Pane accentPane;
    private Text errorText;
    public static Patient currentPatient = new Patient();
    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();

    private void patientTypeButtonHandler(boolean patientExists) throws FileNotFoundException {
        // Clears the accent pane
        accentPane.getChildren().removeAll(accentPane.getChildren());

        // Adds a text field
        TextField tf_patientIDInput = new TextField();
        tf_patientIDInput.setFocusTraversable(false);
        tf_patientIDInput.setPromptText("Enter patient ID...");
        tf_patientIDInput.getStyleClass().add("enlargedInput");
        tf_patientIDInput.relocate(80, 300);

        // Adds the text field label
        Button lbl_patientType = new Button(
                (patientExists) ? "An Existing Patient" : "A New Patient"
        );
        lbl_patientType.getStyleClass().add(
                (patientExists) ? "accentedColor" : "baseColor"
        );
        lbl_patientType.setId("homePatientTypeLabel");
        lbl_patientType.relocate(45, 270);

        // Adds the submit button
        Button btn_homeSubmit = new Button("Submit");
        btn_homeSubmit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_homeSubmit.relocate(499, 460);
        btn_homeSubmit.setOnMouseClicked(e -> {
            errorText.setVisible(false);
            tf_patientIDInput.setText(tf_patientIDInput.getText().strip());
            try {
                if (tf_patientIDInput.getText().equals("")) { // Error condition: Field is blank
                    errorText.setText("""
                            ERROR:
                            Patient ID field is empty.""");
                    errorText.setVisible(true);
                    return;
                }
                if (!tf_patientIDInput.getText().matches("[0-9]+")) { // Error condition: Non-numeric characters
                    errorText.setText("""
                        ERROR:
                        Patient ID contains non-numeric characters.""");
                    errorText.setVisible(true);
                    return;
                }

                File patientData = new File("src/main/resources/data/" + tf_patientIDInput.getText() + ".json");
                if (patientExists) {
                    if (!patientData.exists()) { // Error condition: Existing patient selected but data does not exist
                        errorText.setText("""
                                ERROR:
                                Patient does not exist.""");
                        errorText.setVisible(true);
                        return;
                    }
                    currentPatient = PatientInitialiser.initialisePatient(tf_patientIDInput.getText()); // Grabs JSON data and loads it into the currentPatient object
                } else {
                    if (patientData.exists()) { // Error condition: New patient selected but data already exists
                        errorText.setText("""
                                ERROR:
                                Patient already exists.""");
                        errorText.setVisible(true);
                        return;
                    }
                    patientData.createNewFile(); // Creates a new JSON file
                    currentPatient = new Patient(); // Sets currentPatient to an empty Patient object
                    currentPatient.setPatientID(tf_patientIDInput.getText());
                    PatientInitialiser.writePatient(currentPatient); // Writes the ID to JSON
                }
            } catch (IOException ex) { // Catch for other IOExceptions
                errorText.setText("""
                        ERROR:
                        An IOException has occurred.
                        Check if the patient data files still exist?""");
                errorText.setVisible(true);
                return;
            }

            // Advance to the main menu screen
            try {
                SCREEN_CONTROLLER.launchMainMenu(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Error Pane, to be set visible by the above error checking methods
        errorText = new Text("");
        errorText.setFill(Color.RED);
        errorText.setStyle("""
            -fx-font-family: 'AvenirNext LT Pro Regular';
            -fx-font-size: 30px;
        """);
        errorText.setVisible(false);
        errorText.relocate(90, 100);

        accentPane.getChildren().addAll(
                tf_patientIDInput,
                lbl_patientType,
                btn_homeSubmit,
                errorText
        );
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "HomeScreen");
        accentPane.getChildren().get(accentPane.getChildren().size() - 1).setLayoutX(582);
    }

    public Scene getHomeScene() throws FileNotFoundException {
        // Main pane
        Pane mainPane = new Pane();
        mainPane.setStyle("-fx-background-color: #F8FCFD;");
        mainPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        // Sub-pane (right half of screen)
        accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6;");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH / 2.0, Launcher.SCREEN_HEIGHT);
        accentPane.relocate(Launcher.SCREEN_WIDTH / 2.0, 0);

        // myEMR logo
        Image img_mainLogo = new Image(new FileInputStream("src/main/resources/images/main_logo.png"));
        ImageView imgv_mainLogo = new ImageView(img_mainLogo);
        imgv_mainLogo.setPreserveRatio(true);
        imgv_mainLogo.setFitHeight(270);
        imgv_mainLogo.relocate(0, 250);

        // "I am treating..." text
        Text welcomeScreenText = new Text(30, 30, "I am treating...");
        welcomeScreenText.setId("welcomeScreenText");
        welcomeScreenText.relocate(280, 240);

        // Existing patient button
        Button btn_existingPatient = new Button("An Existing Patient");
        btn_existingPatient.getStyleClass().addAll("accentedColor", "clickable" ,"homeLargeButton");
        btn_existingPatient.relocate(180, 330);
        btn_existingPatient.setOnAction(e -> {
            try {
                patientTypeButtonHandler(true);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        // New patient button
        Button btn_newPatient = new Button("A New Patient");
        btn_newPatient.getStyleClass().addAll("baseColor", "clickable" ,"homeLargeButton");
        btn_newPatient.relocate(180, 450);
        btn_newPatient.setOnAction(e -> {
            try {
                patientTypeButtonHandler(false);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        mainPane.getChildren().addAll(
                accentPane,
                imgv_mainLogo
        );
        accentPane.getChildren().addAll(
                welcomeScreenText,
                btn_existingPatient,
                btn_newPatient
        );

        return new Scene(mainPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }
}