package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MedicineProcedureForm {

    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();

    public Scene getMedicineProcedureForm() throws FileNotFoundException {
        // Text fields and labels for the Procedure and Medicine form
        Pane accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6;");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        Button lbl_medicineName = new Button("Medicine Name");
        lbl_medicineName.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_medicineName.relocate(100,200);

        TextField tf_medicineName = new TextField();
        tf_medicineName.setPromptText("Medicine Name");
        tf_medicineName.setText(HomeScreen.currentPatient.getMedicineName());
        tf_medicineName.getStyleClass().add("fullwidthInput");
        tf_medicineName.relocate(100, 250);

        Button lbl_medicineDosage = new Button("Dosage");
        lbl_medicineDosage.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_medicineDosage.relocate(100,350);

        TextField tf_medicineDosage = new TextField();
        tf_medicineDosage.setPromptText("Dosage");
        tf_medicineDosage.setText(HomeScreen.currentPatient.getMedicineDosage());
        tf_medicineDosage.getStyleClass().add("fullwidthInput");
        tf_medicineDosage.relocate(100,400 );

        Button lbl_expirationDate = new Button("Medicine Expiration Date");
        lbl_expirationDate.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_expirationDate.relocate(100,500);

        TextField tf_expirationDate = new TextField();
        tf_expirationDate.setPromptText("Medicine Expiration Date");
        tf_expirationDate.setText(HomeScreen.currentPatient.getMedicineExpirationDate());
        tf_expirationDate.getStyleClass().add("fullwidthInput");
        tf_expirationDate.relocate(100, 550);

        Button lbl_procedureDate = new Button("Procedure Date");
        lbl_procedureDate.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_procedureDate.relocate(800,200);

        TextField tf_procedureDate = new TextField();
        tf_procedureDate.setPromptText("Procedure Date");
        tf_procedureDate.setText(HomeScreen.currentPatient.getProcedureDate());
        tf_procedureDate.getStyleClass().add("fullwidthInput");
        tf_procedureDate.relocate(800, 250);

        Button lbl_procedureType = new Button("Procedure Type");
        lbl_procedureType.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_procedureType.relocate(800,350);

        TextField tf_procedureType = new TextField();
        tf_procedureType.setPromptText("Procedure Type");
        tf_procedureType.setText(HomeScreen.currentPatient.getProcedureType());
        tf_procedureType.getStyleClass().add("fullwidthInput");
        tf_procedureType.relocate(800, 400);

        Button lbl_procedureStatus = new Button("Procedure Status");
        lbl_procedureStatus.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_procedureStatus.relocate(800,500);

        TextField tf_procedureStatus = new TextField();
        tf_procedureStatus.setPromptText("Procedure Status");
        tf_procedureStatus.setText(HomeScreen.currentPatient.getProcedureStatus());
        tf_procedureStatus.getStyleClass().add("fullwidthInput");
        tf_procedureStatus.relocate(800, 550);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setMedicineName(tf_medicineName.getText());
                HomeScreen.currentPatient.setMedicineDosage(tf_medicineDosage.getText());
                HomeScreen.currentPatient.setMedicineExpirationDate(tf_expirationDate.getText());
                HomeScreen.currentPatient.setProcedureDate(tf_procedureDate.getText());
                HomeScreen.currentPatient.setProcedureType(tf_procedureType.getText());
                HomeScreen.currentPatient.setProcedureStatus(tf_procedureStatus.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchMainMenu(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_medicineName, tf_medicineName,
                lbl_medicineDosage, tf_medicineDosage,
                lbl_expirationDate, tf_expirationDate,
                lbl_procedureDate, tf_procedureDate,
                lbl_procedureType, tf_procedureType,
                lbl_procedureStatus, tf_procedureStatus,
                btn_submit
        );
        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_procedure_medicine.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "MainMenu");

        return new Scene(accentPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }

}
