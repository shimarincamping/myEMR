package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TreatmentCourseForm {
    // Text fields & labels for the Treatment Course Form
    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();
    public Scene getTreatmentCourse() throws FileNotFoundException {
        Pane accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6;");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        // Non-clickable Type of Treatment
        Button lbl_treatmentType = new Button("Type of Treatment");
        lbl_treatmentType.getStyleClass().addAll( "accentedColor", "formLabel");
        lbl_treatmentType.relocate(100,200);

        // Type of Treatment text field
        TextField tf_treatmentType = new TextField();
        tf_treatmentType.setPromptText("Type of Treatment");
        tf_treatmentType.setText(HomeScreen.currentPatient.getTypeOfTreatment());
        tf_treatmentType.getStyleClass().add("fullwidthInput");
        tf_treatmentType.relocate(100, 250);

        //Non-clickable Treatment Start Date
        Button lbl_treatmentStartDate = new Button("Start Date");
        lbl_treatmentStartDate.getStyleClass().addAll( "accentedColor", "formLabel");
        lbl_treatmentStartDate.relocate(100,350);

        // Start Date text field
        TextField tf_treatmentStartDate = new TextField();
        tf_treatmentStartDate.setText(HomeScreen.currentPatient.getTreatmentStartDate());
        tf_treatmentStartDate.getStyleClass().addAll("fullwidthInput", "disabled");
        tf_treatmentStartDate.relocate(100, 400);
        tf_treatmentStartDate.setEditable(false);

        //Non-clickable Treatment End Date
        Button lbl_treatmentEndDate = new Button("End Date");
        lbl_treatmentEndDate.getStyleClass().addAll( "accentedColor", "formLabel");
        lbl_treatmentEndDate.relocate(800,350);

        // End Date text field
        TextField tf_treatmentEndDate = new TextField();
        tf_treatmentEndDate.setText(HomeScreen.currentPatient.getTreatmentEndDate());
        tf_treatmentEndDate.getStyleClass().addAll("fullwidthInput", "disabled");
        tf_treatmentEndDate.relocate(800, 400);
        tf_treatmentEndDate.setEditable(false);

        Button btn_beginTreatment = new Button("Begin Treatment");
        Button btn_endTreatment = new Button("End Treatment");

        // Begin Treatment button
        btn_beginTreatment.getStyleClass().addAll("clickable", "accentedColor", "genericUIButton");
        btn_beginTreatment.relocate(100, 670);
        btn_beginTreatment.setOnMouseClicked(e -> {
            tf_treatmentStartDate.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")));
            tf_treatmentEndDate.clear();
            btn_endTreatment.setVisible(true);
        });

        // End Treatment button
        btn_endTreatment.getStyleClass().addAll("clickable", "accentedColor", "genericUIButton");
        btn_endTreatment.relocate(450, 670);
        btn_endTreatment.setOnMouseClicked(e -> tf_treatmentEndDate.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm"))));
        if (tf_treatmentStartDate.getText().equals("")) btn_endTreatment.setVisible(false);

        // Submit button
        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setTypeOfTreatment(tf_treatmentType.getText());
                HomeScreen.currentPatient.setTreatmentStartDate(tf_treatmentStartDate.getText());
                HomeScreen.currentPatient.setTreatmentEndDate(tf_treatmentEndDate.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchMainMenu(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_treatmentType, tf_treatmentType,
                lbl_treatmentStartDate, tf_treatmentStartDate,
                lbl_treatmentEndDate, tf_treatmentEndDate,
                btn_beginTreatment, btn_endTreatment,
                btn_submit
        );

        // Add header & back button
        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_treatment_course.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "MainMenu");

        return new Scene(accentPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }
}