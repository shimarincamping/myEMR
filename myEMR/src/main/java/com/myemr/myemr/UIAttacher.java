package com.myemr.myemr;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UIAttacher {
    // Hospital name can be changed here
    private static final String HOSPITAL_NAME = "Subang Jaya Medical Centre";
    private final ScreenController SCREEN_CONTROLLER = new ScreenController();

    // Attaches the header (image, hospital name, ID, patient name) to a given Pane
    public Pane attachHeader(Pane pane, String imageName) throws FileNotFoundException {
        Pane headerPane = new Pane();
        headerPane.setStyle("-fx-background-color: #F8FCFD;");
        headerPane.setPrefSize(Launcher.SCREEN_WIDTH, 150);

        Image img_headerImage = new Image(new FileInputStream("src/main/resources/images/" + imageName));
        ImageView imgv_headerImage = new ImageView(img_headerImage);
        imgv_headerImage.setPreserveRatio(true);
        imgv_headerImage.setFitHeight(110);
        imgv_headerImage.relocate(20, 25);

        Text hospitalNameText = new Text(30, 30, HOSPITAL_NAME);
        hospitalNameText.setWrappingWidth(580);
        hospitalNameText.setTextAlignment(TextAlignment.RIGHT);
        hospitalNameText.relocate(Launcher.SCREEN_WIDTH - 600, 20);
        hospitalNameText.setStyle("""
            -fx-font-family: 'AvenirNextLTW02-BoldItalic';
            -fx-fill: black;
            -fx-font-size: 25px;""");

        Text patientIDText = new Text(30, 30, "ID   " + HomeScreen.currentPatient.getPatientID());
        patientIDText.setWrappingWidth(580);
        patientIDText.setTextAlignment(TextAlignment.RIGHT);
        patientIDText.relocate(Launcher.SCREEN_WIDTH - 600, 85);
        patientIDText.setStyle("""
            -fx-font-family: 'AvenirNextLTW02-BoldItalic';
            -fx-fill: #7F7F7F;
            -fx-font-size: 30px;""");

        Text patientNameText = new Text(30, 30, HomeScreen.currentPatient.getPatientName().toUpperCase());
        patientNameText.setWrappingWidth(580);
        patientNameText.setTextAlignment(TextAlignment.RIGHT);
        patientNameText.relocate(Launcher.SCREEN_WIDTH - 600, 120);
        patientNameText.setStyle("""
            -fx-font-family: 'AvenirNextLTW02-BoldItalic';
            -fx-fill: #1D9BF0;
            -fx-font-size: 30px;""");

        headerPane.getChildren().addAll(
                imgv_headerImage,
                hospitalNameText,
                patientIDText, patientNameText
        );
        pane.getChildren().add(headerPane);
        return pane;
    }

    // Attaches the back button, which launches a given destination scene
    public Pane attachBackButton(Pane pane, String destination) throws FileNotFoundException {
        Image img_backButton = new Image(new FileInputStream("src/main/resources/images/btn_return.png"));
        ImageView imgv_backButton = new ImageView(img_backButton);
        imgv_backButton.setPreserveRatio(true);
        imgv_backButton.setFitHeight(200);
        imgv_backButton.relocate(1350, 640);
        imgv_backButton.getStyleClass().add("clickable");
        imgv_backButton.setOnMouseClicked(e -> {
            try {
                switch (destination) {
                    case "HomeScreen" -> SCREEN_CONTROLLER.launchHomeScreen(e);
                    case "MainMenu" -> SCREEN_CONTROLLER.launchMainMenu(e);
                    case "MedicalHistory" -> SCREEN_CONTROLLER.launchMedicalHistory(e);
                    case "Analysis" -> SCREEN_CONTROLLER.launchAnalysisForm(e);
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        pane.getChildren().add(imgv_backButton);
        return pane;
    }

    public static String getHOSPITAL_NAME() {
        return HOSPITAL_NAME;
    }
}
