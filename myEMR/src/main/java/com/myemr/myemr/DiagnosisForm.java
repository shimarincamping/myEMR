package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DiagnosisForm {

    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();
    public Scene getDiagnosisForm() throws FileNotFoundException {
        Pane accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6;");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        // Diagnosed Sickness
        Button lbl_diagnosis = new Button("Diagnosis");
        lbl_diagnosis.getStyleClass().addAll( "accentedColor", "formLabel");
        lbl_diagnosis.relocate(100,200);

        TextField tf_diagnosis = new TextField();
        tf_diagnosis.setPromptText("Diagnosis");
        tf_diagnosis.setText(HomeScreen.currentPatient.getDiagnnosis());
        tf_diagnosis.getStyleClass().add("fullwidthInput");
        tf_diagnosis.relocate(100, 250);

        // Diagnosing Doctor
        Button lbl_diagnosedBy = new Button("Diagnosed by");
        lbl_diagnosedBy.getStyleClass().addAll( "accentedColor", "formLabel");
        lbl_diagnosedBy.relocate(100,350);

        TextField tf_diagnosedBy = new TextField();
        tf_diagnosedBy.setPromptText("Diagnosed by");
        tf_diagnosedBy.setText(HomeScreen.currentPatient.getDiagnosedBy());
        tf_diagnosedBy.getStyleClass().add("fullwidthInput");
        tf_diagnosedBy.relocate(100, 400);

        // Diagnosed Date
        Button lbl_diagnosisDate = new Button("Date of Diagnosis");
        lbl_diagnosisDate.getStyleClass().addAll( "accentedColor", "formLabel");
        lbl_diagnosisDate.relocate(100,500);

        TextField tf_diagnosisDate = new TextField();
        tf_diagnosisDate.setPromptText("Date of Diagnosis");
        tf_diagnosisDate.setText(HomeScreen.currentPatient.getDateOfDiagnosis());
        tf_diagnosisDate.getStyleClass().add("fullwidthInput");
        tf_diagnosisDate.relocate(100, 550);

        // Remarks
        Button lbl_remarks = new Button("Remarks");
        lbl_remarks.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_remarks.relocate(800,200);

        TextArea ta_remarks = new TextArea();
        ta_remarks.setPromptText("Remarks");
        ta_remarks.setText(HomeScreen.currentPatient.getDiagnosisRemarks());
        ta_remarks.getStyleClass().add("textAreaInput");
        ta_remarks.relocate(800, 250);

        // Submit button
        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setDiagnnosis(tf_diagnosis.getText());
                HomeScreen.currentPatient.setDiagnosedBy(tf_diagnosedBy.getText());
                HomeScreen.currentPatient.setDateOfDiagnosis(tf_diagnosisDate.getText());
                HomeScreen.currentPatient.setDiagnosisRemarks(ta_remarks.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchMainMenu(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_diagnosis, tf_diagnosis,
                lbl_diagnosedBy, tf_diagnosedBy,
                lbl_diagnosisDate, tf_diagnosisDate,
                lbl_remarks, ta_remarks,
                btn_submit
        );

        // Add header & back button
        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_diagnosis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "MainMenu");

        return new Scene(accentPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }
}