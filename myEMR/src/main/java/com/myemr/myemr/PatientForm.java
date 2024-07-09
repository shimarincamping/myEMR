package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PatientForm{
    private Pane accentPane;
    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();
    public Scene getPatientForm() throws FileNotFoundException {
        // Text fields and labels for the patient form
        String originalID = HomeScreen.currentPatient.getPatientID();

        accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6;");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        Button lbl_patientID = new Button("Patient ID");
        lbl_patientID.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientID.relocate(100,200);

        TextField tf_patientID = new TextField();
        tf_patientID.setPromptText("Patient ID");
        tf_patientID.setText(HomeScreen.currentPatient.getPatientID());
        tf_patientID.getStyleClass().add("fullwidthInput");
        tf_patientID.relocate(100, 250);

        Button lbl_patientName = new Button("Patient Name");
        lbl_patientName.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientName.relocate(100,350);

        TextField tf_patientName = new TextField();
        tf_patientName.setPromptText("Patient Name");
        tf_patientName.setText(HomeScreen.currentPatient.getPatientName());
        tf_patientName.getStyleClass().add("fullwidthInput");
        tf_patientName.relocate(100,400 );

        Button lbl_patientSex = new Button("Sex");
        lbl_patientSex.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientSex.relocate(100,500);

        TextField tf_patientSex = new TextField();
        tf_patientSex.setPromptText("Sex");
        tf_patientSex.setText(HomeScreen.currentPatient.getPatientSex());
        tf_patientSex.getStyleClass().add("halfwidthInput");
        tf_patientSex.relocate(100, 550);

        Button lbl_patientDOB = new Button("Date of Birth");
        lbl_patientDOB.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientDOB.relocate(465,500);

        TextField tf_patientDOB = new TextField();
        tf_patientDOB.setPromptText("Date of Birth");
        tf_patientDOB.setText(HomeScreen.currentPatient.getPatientDOB());
        tf_patientDOB.getStyleClass().add("halfwidthInput");
        tf_patientDOB.relocate(465, 550);

        Button lbl_patientContact = new Button("Contact Number");
        lbl_patientContact.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientContact.relocate(100,650);

        TextField tf_patientContact = new TextField();
        tf_patientContact.setPromptText("Contact Number");
        tf_patientContact.setText(HomeScreen.currentPatient.getPatientContact());
        tf_patientContact.getStyleClass().add("fullwidthInput");
        tf_patientContact.relocate(100, 700);

        Button lbl_patientAddress = new Button("Address");
        lbl_patientAddress.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientAddress.relocate(800,200);

        TextArea ta_patientAddress = new TextArea();
        ta_patientAddress.setPromptText("Address");
        ta_patientAddress.setText(HomeScreen.currentPatient.getPatientAddress());
        ta_patientAddress.getStyleClass().add("textAreaInput");
        ta_patientAddress.relocate(800, 250);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                tf_patientID.setText(tf_patientID.getText().strip());

                HomeScreen.currentPatient.setPatientID(tf_patientID.getText());
                HomeScreen.currentPatient.setPatientName(tf_patientName.getText());
                HomeScreen.currentPatient.setPatientSex(tf_patientSex.getText());
                HomeScreen.currentPatient.setPatientDOB(tf_patientDOB.getText());
                HomeScreen.currentPatient.setPatientContact(tf_patientContact.getText());
                HomeScreen.currentPatient.setPatientAddress(ta_patientAddress.getText());

                File originalFile = new File("src/main/resources/data/" + originalID + ".json");
                File targetFile = new File("src/main/resources/data/" + tf_patientID.getText() + ".json");
                boolean safeToWrite = false;

                if (HomeScreen.currentPatient.getPatientID().equals("")) { // A blank ID will delete the file (DELETE feature)
                    // Display confirm box for delete
                    Pane popupPane = new Pane();
                    Text popupErrorText = new Text(30, 30, """
                            WARNING:
                            Emptying the ID field will delete the patient's data.
                            Proceed?""");
                    popupErrorText.setFill(Color.RED);
                    popupErrorText.setStyle("""
                        -fx-font-family: 'AvenirNext LT Pro Bold';
                        -fx-font-size: 40px;
                    """);
                    popupErrorText.relocate(200, 150);

                    // Cancel to close the popup
                    Button btn_cancel = new Button("Cancel");
                    btn_cancel.getStyleClass().addAll("clickable", "genericUIButton", "baseColor");
                    btn_cancel.relocate(430, 500);
                    btn_cancel.setOnMouseClicked(ev -> {
                        tf_patientID.setText(originalID);
                        accentPane.getChildren().remove(popupPane);
                    });

                    // OK to delete the record
                    Button btn_ok = new Button("OK");
                    btn_ok.getStyleClass().addAll("clickable", "genericUIButton", "accentedColor");
                    btn_ok.relocate(1000, 500);
                    btn_ok.setOnMouseClicked(ev -> {
                        originalFile.delete();
                        try {
                            SCREEN_CONTROLLER.launchHomeScreen(e);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    });

                    popupPane.getChildren().addAll(
                            popupErrorText,
                            btn_cancel, btn_ok
                    );
                    popupPane.relocate(0, 150);
                    popupPane.getStyleClass().add("popupPane");
                    accentPane.getChildren().add(popupPane);

                } else if (!tf_patientID.getText().matches("[0-9]+")) {
                    // Display error box for non-numeric characters
                    Pane popupPane = new Pane();
                    Text popupErrorText = new Text(30, 30, """
                            ERROR:
                            ID must only contain numbers.
                            Please try again""");
                    popupErrorText.setStyle("""
                        -fx-font-family: 'AvenirNext LT Pro Bold';
                        -fx-font-size: 40px;
                    """);
                    popupErrorText.relocate(200, 150);

                    // OK to close prompt
                    Button btn_ok = new Button("OK");
                    btn_ok.getStyleClass().addAll("clickable", "genericUIButton", "accentedColor");
                    btn_ok.relocate(1000, 500);
                    btn_ok.setOnMouseClicked(ev -> accentPane.getChildren().remove(popupPane));

                    popupPane.getChildren().addAll(
                            popupErrorText,
                            btn_ok
                    );
                    popupPane.relocate(0, 150);
                    popupPane.getStyleClass().add("popupPane");
                    accentPane.getChildren().add(popupPane);
                } else if (!originalID.equals(HomeScreen.currentPatient.getPatientID())) {
                    if (targetFile.exists()) {
                        // Display error box for duplicate ID
                        Pane popupPane = new Pane();
                        Text popupErrorText = new Text(30, 30, """
                            ERROR:
                            This ID already belongs to another patient.
                            Please try again.""");
                        popupErrorText.setStyle("""
                            -fx-font-family: 'AvenirNext LT Pro Bold';
                            -fx-font-size: 40px;
                        """);
                        popupErrorText.relocate(200, 150);

                        // OK to close prompt
                        Button btn_ok = new Button("OK");
                        btn_ok.getStyleClass().addAll("clickable", "genericUIButton", "accentedColor");
                        btn_ok.relocate(1000, 500);
                        btn_ok.setOnMouseClicked(ev -> accentPane.getChildren().remove(popupPane));

                        popupPane.getChildren().addAll(
                                popupErrorText,
                                btn_ok
                        );
                        popupPane.relocate(0, 150);
                        popupPane.getStyleClass().add("popupPane");
                        accentPane.getChildren().add(popupPane);
                    } else {
                        PatientInitialiser.renamePatient(originalID, HomeScreen.currentPatient.getPatientID());
                        safeToWrite = true;
                    }
                } else safeToWrite = true;
                if (safeToWrite) {
                    PatientInitialiser.writePatient(HomeScreen.currentPatient);
                    SCREEN_CONTROLLER.launchMainMenu(e);
                } else HomeScreen.currentPatient.setPatientID(originalID);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_patientID, tf_patientID,
                lbl_patientName, tf_patientName,
                lbl_patientSex, tf_patientSex,
                lbl_patientDOB, tf_patientDOB,
                lbl_patientContact, tf_patientContact,
                lbl_patientAddress, ta_patientAddress,
                btn_submit
        );

        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_patient_form.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "MainMenu");
        return new Scene(accentPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }

}
