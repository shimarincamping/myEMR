package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class MedicalHistory {
    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();
    private Pane accentPane;
    private int currentPage = 1;
    private final int TOTAL_PAGES = HomeScreen.currentPatient.getMEDICAL_HISTORY().size();
    private ScrollPane sp_entriesContainer;
    private Button lbl_pageSequence, btn_previousPage, btn_nextPage;

    private void addHistoryButtonHandler() throws FileNotFoundException {
        accentPane.getChildren().removeAll(accentPane.getChildren());

        // Date of Treatment
        Button lbl_treatmentDate = new Button("Date of Treatment");
        lbl_treatmentDate.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_treatmentDate.relocate(100,200);

        TextField tf_treatmentDate = new TextField();
        tf_treatmentDate.setPromptText("Date of Treatment");
        tf_treatmentDate.getStyleClass().add("halfwidthInput");
        tf_treatmentDate.relocate(100,250 );

        //Ward
        Button lbl_patientWard = new Button("Ward");
        lbl_patientWard.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientWard.relocate(465,200);

        TextField tf_patientWard = new TextField();
        tf_patientWard.setPromptText("Ward");
        tf_patientWard.getStyleClass().add("halfwidthInput");
        tf_patientWard.relocate(465, 250);

        //Type of treatment
        Button lbl_treatmentType = new Button("Type of Treatment");
        lbl_treatmentType.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_treatmentType.relocate(100,350);

        TextField tf_treatmentType = new TextField();
        tf_treatmentType.setPromptText("Type of Treatment");
        tf_treatmentType.getStyleClass().add("fullwidthInput");
        tf_treatmentType.relocate(100, 400);

        //Observation
        Button lbl_patientObservation = new Button("Observation");
        lbl_patientObservation.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientObservation.relocate(100,500);

        TextField tf_patientObservation = new TextField();
        tf_patientObservation.setPromptText("Observation");
        tf_patientObservation.getStyleClass().add("fullwidthInput");
        tf_patientObservation.relocate(100, 550);

        //Medical Complication
        Button lbl_majorComplications = new Button("Medical Complication");
        lbl_majorComplications.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_majorComplications.relocate(100,650);

        TextField tf_majorComplications = new TextField();
        tf_majorComplications.setPromptText("Medical Complication");
        tf_majorComplications.getStyleClass().add("fullwidthInput");
        tf_majorComplications.relocate(100, 700);

        //Attending Staff
        Button lbl_attendingDoctor = new Button("Attending Doctor");
        lbl_attendingDoctor.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_attendingDoctor.relocate(800,200);

        TextField tf_attendingDoctor = new TextField();
        tf_attendingDoctor.setPromptText("Attending Doctor");
        tf_attendingDoctor.getStyleClass().add("fullwidthInput");
        tf_attendingDoctor.relocate(800, 250);

        //Results & Remarks
        Button lbl_patientRemarks = new Button("Results & Remarks");
        lbl_patientRemarks.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_patientRemarks.relocate(800,350);

        TextArea ta_patientRemarks = new TextArea();
        ta_patientRemarks.setPromptText("Results & Remarks");
        ta_patientRemarks.getStyleClass().add("textAreaShort");
        ta_patientRemarks.relocate(800, 400);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.getMEDICAL_HISTORY().add(0, new HashMap<>() {{
                    put("dateOfTreatment", tf_treatmentDate.getText());
                    put("hospitalName", UIAttacher.getHOSPITAL_NAME());
                    put("ward", tf_patientWard.getText());
                    put("typeOfTreatment", tf_treatmentType.getText());
                    put("observation", tf_patientObservation.getText());
                    put("medicalComplication", tf_majorComplications.getText());
                    put("attendingDoctor", tf_attendingDoctor.getText());
                    put("resultsRemarks", ta_patientRemarks.getText());
                }});
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchMedicalHistory(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_treatmentDate, tf_treatmentDate,
                lbl_patientWard, tf_patientWard,
                lbl_treatmentType, tf_treatmentType,
                lbl_patientObservation, tf_patientObservation,
                lbl_majorComplications, tf_majorComplications,
                lbl_attendingDoctor, tf_attendingDoctor,
                lbl_patientRemarks, ta_patientRemarks,
                btn_submit
        );
        
        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_medical_history.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "MedicalHistory");
    }

    // Returns a TextFlow of the specified page of the medical history
    private TextFlow getMedicalHistoryPage(int page) {
        HashMap<String, String> currentPage = HomeScreen.currentPatient.getMEDICAL_HISTORY().get(page - 1);
        Text historyText1 = new Text(currentPage.get("dateOfTreatment") + "\n");
        historyText1.setFill(Color.rgb(29, 155, 240));
        historyText1.getStyleClass().add("dataDisplayBold");
        Text historyText2 = new Text(String.format("""
                    %s
                    %s
                                    
                    """, currentPage.get("hospitalName"), currentPage.get("ward")));
        historyText2.getStyleClass().add("dataDisplayBold");
        Text historyText3 = new Text("Type of Treatment: ");
        historyText3.getStyleClass().add("dataDisplayBold");
        Text historyText4 = new Text(currentPage.get("typeOfTreatment") + "\n");
        historyText4.getStyleClass().add("dataDisplayText");
        Text historyText5 = new Text("Observation: ");
        historyText5.getStyleClass().add("dataDisplayBold");
        Text historyText6 = new Text(currentPage.get("observation") + "\n");
        historyText6.getStyleClass().add("dataDisplayText");
        Text historyText7 = new Text("Major complications: ");
        historyText7.getStyleClass().add("dataDisplayBold");
        Text historyText8 = new Text(currentPage.get("medicalComplication") + "\n");
        historyText8.getStyleClass().add("dataDisplayText");
        Text historyText9 = new Text("Attending doctor: ");
        historyText9.getStyleClass().add("dataDisplayBold");
        Text historyText10 = new Text(currentPage.get("attendingDoctor").toUpperCase() + "\n");
        historyText10.getStyleClass().add("dataDisplayText");
        Text historyText11 = new Text("Results & Remarks: ");
        historyText11.getStyleClass().add("dataDisplayBold");
        Text historyText12 = new Text(currentPage.get("resultsRemarks"));
        historyText12.getStyleClass().add("dataDisplayText");

        TextFlow outputTextFlow = new TextFlow();
        outputTextFlow.getChildren().addAll(
                historyText1, historyText2,
                historyText3, historyText4,
                historyText5, historyText6,
                historyText7, historyText8,
                historyText9, historyText10,
                historyText11, historyText12
        );
        return outputTextFlow;
    }
    public Scene getMedicalHistory() throws FileNotFoundException {

        accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6;");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        // Page Sequence
        lbl_pageSequence = new Button(String.format("Page %d of %d", currentPage, TOTAL_PAGES));
        lbl_pageSequence.getStyleClass().addAll( "accentedColor","longFormLabel");
        lbl_pageSequence.relocate(100,200);

        // History text
        TextFlow historyTextFlow = new TextFlow();
        if (TOTAL_PAGES > 0) {
            historyTextFlow = getMedicalHistoryPage(1);
        } else {
            lbl_pageSequence.setText("No pages to display.");
            Text historyTextNull = new Text("No records found.");
            historyTextNull.getStyleClass().add("dataDisplayText");
            historyTextFlow.getChildren().add(historyTextNull);
        }

        sp_entriesContainer = new ScrollPane(historyTextFlow);
        sp_entriesContainer.getStyleClass().add("dataDisplay");
        sp_entriesContainer.setFitToWidth(true);
        sp_entriesContainer.relocate(100, 275);

        //Add new history button
        Button btn_newHistory = new Button("Add New History");
        btn_newHistory.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_newHistory.relocate(100, 670);
        btn_newHistory.setOnMouseClicked(e -> {
            try {
                addHistoryButtonHandler();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Previous button
        btn_previousPage = new Button("Previous");
        btn_previousPage.getStyleClass().addAll("clickable", "accentedColor", "genericUIButton");
        btn_previousPage.relocate(470, 670);
        btn_previousPage.setVisible(false);
        btn_previousPage.setOnMouseClicked(e -> {
            btn_nextPage.setVisible(true);
            if (--currentPage == 1) btn_previousPage.setVisible(false);
            lbl_pageSequence.setText(String.format("Page %d of %d", currentPage, TOTAL_PAGES));
            accentPane.getChildren().remove(sp_entriesContainer);
            sp_entriesContainer = new ScrollPane(getMedicalHistoryPage(currentPage));
            sp_entriesContainer.getStyleClass().add("dataDisplay");
            sp_entriesContainer.setFitToWidth(true);
            sp_entriesContainer.relocate(100, 275);
            accentPane.getChildren().add(sp_entriesContainer);
        });

        //Next  button
        btn_nextPage = new Button("Next");
        btn_nextPage.getStyleClass().addAll("clickable", "accentedColor", "genericUIButton");
        btn_nextPage.relocate(690, 670);
        if (TOTAL_PAGES < 2) btn_nextPage.setVisible(false);
        btn_nextPage.setOnMouseClicked(e -> {
            btn_previousPage.setVisible(true);
            if (++currentPage == TOTAL_PAGES) btn_nextPage.setVisible(false);
            lbl_pageSequence.setText(String.format("Page %d of %d", currentPage, TOTAL_PAGES));
            accentPane.getChildren().remove(sp_entriesContainer);
            sp_entriesContainer = new ScrollPane(getMedicalHistoryPage(currentPage));
            sp_entriesContainer.getStyleClass().add("dataDisplay");
            sp_entriesContainer.setFitToWidth(true);
            sp_entriesContainer.relocate(100, 275);
            accentPane.getChildren().add(sp_entriesContainer);
        });

        accentPane.getChildren().addAll(
                lbl_pageSequence, sp_entriesContainer,
                btn_newHistory,
                btn_previousPage, btn_nextPage
        );

        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_medical_history.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "MainMenu");

        return new Scene(accentPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }
}
