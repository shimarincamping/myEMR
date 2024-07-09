package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu {

    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();
    public Scene getMainMenu() throws FileNotFoundException {
        Pane accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6;");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        // Patient Form Button
        Button btn_patientForm = new Button("Patient Form");
        btn_patientForm.getStyleClass().addAll("clickable", "baseColor", "mainMenuButton");
        btn_patientForm.relocate(130, 270);
        btn_patientForm.setOnMouseClicked(e -> {
            try {
                SCREEN_CONTROLLER.launchPatientForm(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Image img_patientForm = new Image(new FileInputStream("src/main/resources/images/icon_patient.png"));
        ImageView imgv_patientForm = new ImageView(img_patientForm);
        imgv_patientForm.setPreserveRatio(true);
        imgv_patientForm.setFitHeight(175);
        imgv_patientForm.relocate(90, 230);

        // Treatment Course Button
        Button btn_treatmentCourse = new Button("Treatment Course");
        btn_treatmentCourse.getStyleClass().addAll("clickable", "baseColor", "mainMenuButton");
        btn_treatmentCourse.relocate(130, 440);
        btn_treatmentCourse.setOnMouseClicked(e -> {
            try {
                SCREEN_CONTROLLER.launchTreatmentCourseForm(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Image img_treatmentCourse = new Image(new FileInputStream("src/main/resources/images/icon_treatment.png"));
        ImageView imgv_treatmentCourse = new ImageView(img_treatmentCourse);
        imgv_treatmentCourse.setPreserveRatio(true);
        imgv_treatmentCourse.setFitHeight(175);
        imgv_treatmentCourse.relocate(90, 400);

        // Analysis Button
        Button btn_analysis = new Button("Analysis");
        btn_analysis.getStyleClass().addAll("clickable", "baseColor", "mainMenuButton");
        btn_analysis.relocate(130, 610);
        btn_analysis.setOnMouseClicked(e -> {
            try {
                SCREEN_CONTROLLER.launchAnalysisForm(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Image img_analysis = new Image(new FileInputStream("src/main/resources/images/icon_analysis.png"));
        ImageView imgv_analysis = new ImageView(img_analysis);
        imgv_analysis.setPreserveRatio(true);
        imgv_analysis.setFitHeight(175);
        imgv_analysis.relocate(90, 570);

        // Medical History Button
        Button btn_medicalHistory = new Button("Medical History");
        btn_medicalHistory.getStyleClass().addAll("clickable", "baseColor", "mainMenuButton");
        btn_medicalHistory.relocate(790, 270);
        btn_medicalHistory.setOnMouseClicked(e -> {
            try {
                SCREEN_CONTROLLER.launchMedicalHistory(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Image img_medicalHistory = new Image(new FileInputStream("src/main/resources/images/icon_history.png"));
        ImageView imgv_medicalHistory = new ImageView(img_medicalHistory);
        imgv_medicalHistory.setPreserveRatio(true);
        imgv_medicalHistory.setFitHeight(175);
        imgv_medicalHistory.relocate(750, 230);

        // Procedure & Medicine Button
        Button btn_procedureMedicine = new Button("Procedure & Medicine");
        btn_procedureMedicine.getStyleClass().addAll("clickable", "baseColor", "mainMenuButton");
        btn_procedureMedicine.relocate(790, 440);
        btn_procedureMedicine.setOnMouseClicked(e -> {
            try {
                SCREEN_CONTROLLER.launchMedicineProcedureForm(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Image img_procedureMedicine = new Image(new FileInputStream("src/main/resources/images/icon_procedure.png"));
        ImageView imgv_procedureMedicine = new ImageView(img_procedureMedicine);
        imgv_procedureMedicine.setPreserveRatio(true);
        imgv_procedureMedicine.setFitHeight(175);
        imgv_procedureMedicine.relocate(750, 400);

        // Diagnosis Button
        Button btn_diagnosis = new Button("Diagnosis");
        btn_diagnosis.getStyleClass().addAll("clickable", "baseColor", "mainMenuButton");
        btn_diagnosis.relocate(790, 610);
        btn_diagnosis.setOnMouseClicked(e -> {
            try {
                SCREEN_CONTROLLER.launchDiagnosisForm(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Image img_diagnosis = new Image(new FileInputStream("src/main/resources/images/icon_diagnosis.png"));
        ImageView imgv_diagnosis = new ImageView(img_diagnosis);
        imgv_diagnosis.setPreserveRatio(true);
        imgv_diagnosis.setFitHeight(175);
        imgv_diagnosis.relocate(750, 570);

        accentPane.getChildren().addAll(
                btn_patientForm, imgv_patientForm,
                btn_treatmentCourse, imgv_treatmentCourse,
                btn_analysis, imgv_analysis,
                btn_medicalHistory, imgv_medicalHistory,
                btn_procedureMedicine, imgv_procedureMedicine,
                btn_diagnosis, imgv_diagnosis);

        // Add header & back button
            // TODO: Read JSON here and pass the stored values
        accentPane = UI_ATTACHER.attachHeader(accentPane, "small_logo.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "HomeScreen");

        return new Scene(accentPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }
}
