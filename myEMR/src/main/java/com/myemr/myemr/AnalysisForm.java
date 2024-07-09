package com.myemr.myemr;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AnalysisForm {
    private final ScreenController SCREEN_CONTROLLER = new ScreenController();
    private final UIAttacher UI_ATTACHER = new UIAttacher();
    private Pane accentPane;
    private TextField tf_forcedVitalCapacity, tf_forcedExpiratoryVolume = null, tf_FEV1FVCRatio = null;

    public Scene getAnalysisForm() throws FileNotFoundException {
        accentPane = new Pane();
        accentPane.setStyle("-fx-background-color: #C8F6F6");
        accentPane.setPrefSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);

        // Dropdown menu to select analysis
        String[] analysis = {"Urine Test", "Blood Test", "Imaging Test", "Biopsy", "Pulmonary Function Test"};

        ComboBox cb_analysisSelect = new ComboBox(FXCollections.observableArrayList(analysis));
        cb_analysisSelect.setPromptText("Please Select...");
        cb_analysisSelect.getStyleClass().addAll("comboBox");
        cb_analysisSelect.relocate(325, 300);

        // Label for dropdown menu
        Button lbl_comboBoxHeader = new Button("Type of Analysis");
        lbl_comboBoxHeader.getStyleClass().addAll("comboBoxHeader", "accentedColor");
        lbl_comboBoxHeader.relocate(475, 280);

        Button btn_continue = new Button("Continue");
        btn_continue.getStyleClass().addAll("genericUIButton", "clickable", "accentedColor");
        btn_continue.relocate(525, 650);
        btn_continue.setOnMouseClicked(e -> {
            if (cb_analysisSelect.getValue() == null) return;
            // Change accent pane to analysis form based on selection
            accentPane.getChildren().clear();
            try {
                switch (cb_analysisSelect.getValue().toString()) {
                    case "Urine Test" -> getUrineTestForm();
                    case "Blood Test" -> getBloodTestForm();
                    case "Imaging Test" -> getImagingTestForm();
                    case "Biopsy" -> getBiopsyTestForm();
                    case "Pulmonary Function Test" -> getPulmonaryTestForm();
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        // 'Others' button for different types of analyses
        Button btn_others = new Button("Others...");
        btn_others.getStyleClass().addAll("genericUIButton", "clickable", "baseColor");
        btn_others.relocate(775, 650);
        btn_others.setOnMouseClicked(e-> {
            accentPane.getChildren().clear();
            try {
                getOtherTestForm();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                cb_analysisSelect,
                lbl_comboBoxHeader,
                btn_continue,
                btn_others
        );
        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_analysis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "MainMenu");

        return new Scene(accentPane, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
    }

    private void getUrineTestForm() throws FileNotFoundException {
        // Text fields and labels for urine test
        Button lbl_pHLevel = new Button("pH Level");
        lbl_pHLevel.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_pHLevel.relocate(100,200);

        TextField tf_pHLevel = new TextField();
        tf_pHLevel.setPromptText("pH Level");
        tf_pHLevel.setText(HomeScreen.currentPatient.getUrine_pHLevel());
        tf_pHLevel.getStyleClass().add("halfwidthInput");
        tf_pHLevel.relocate(100, 250);

        Button lbl_specificGravity = new Button("Specific Gravity");
        lbl_specificGravity.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_specificGravity.relocate(465,200);

        TextField tf_specificGravity = new TextField();
        tf_specificGravity.setPromptText("Specific Gravity");
        tf_specificGravity.setText(HomeScreen.currentPatient.getUrine_specificGravity());
        tf_specificGravity.getStyleClass().add("halfwidthInput");
        tf_specificGravity.relocate(465,250);

        Button lbl_proteinLevels = new Button("Protein Levels");
        lbl_proteinLevels.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_proteinLevels.relocate(100,350);

        TextField tf_proteinLevels = new TextField();
        tf_proteinLevels.setPromptText("Protein Levels (mg/dL)");
        tf_proteinLevels.setText(HomeScreen.currentPatient.getUrine_proteinLevels());
        tf_proteinLevels.getStyleClass().add("halfwidthInput");
        tf_proteinLevels.relocate(100, 400);

        Button lbl_glucoseLevels = new Button("Glucose Levels");
        lbl_glucoseLevels.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_glucoseLevels.relocate(465,350);

        TextField tf_glucoseLevels = new TextField();
        tf_glucoseLevels.setPromptText("Glucose Levels (mg/dL)");
        tf_glucoseLevels.setText(HomeScreen.currentPatient.getUrine_glucoseLevels());
        tf_glucoseLevels.getStyleClass().add("halfwidthInput");
        tf_glucoseLevels.relocate(465, 400);

        Button lbl_ketoneLevels = new Button("Ketone Levels");
        lbl_ketoneLevels.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_ketoneLevels.relocate(100,500);

        TextField tf_ketoneLevels = new TextField();
        tf_ketoneLevels.setPromptText("Ketone Levels (mg/dL)");
        tf_ketoneLevels.setText(HomeScreen.currentPatient.getUrine_ketoneLevels());
        tf_ketoneLevels.getStyleClass().add("halfwidthInput");
        tf_ketoneLevels.relocate(100, 550);

        Button lbl_urobilinogenLevels = new Button("Urobilinogen Levels");
        lbl_urobilinogenLevels.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_urobilinogenLevels.relocate(465,500);

        TextField tf_urobilinogenLevels = new TextField();
        tf_urobilinogenLevels.setPromptText("Urobilinogen (mg/dL)");
        tf_urobilinogenLevels.setText(HomeScreen.currentPatient.getUrine_urobilinogenLevels());
        tf_urobilinogenLevels.getStyleClass().add("halfwidthInput");
        tf_urobilinogenLevels.relocate(465,550);

        Button lbl_nitrites = new Button("Nitrites");
        lbl_nitrites.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_nitrites.relocate(100,650);

        TextField tf_nitrites = new TextField();
        tf_nitrites.setPromptText("Nitrites (Y/N)");
        tf_nitrites.setText(HomeScreen.currentPatient.getUrine_nitrites());
        tf_nitrites.getStyleClass().add("halfwidthInput");
        tf_nitrites.relocate(100, 700);

        Button lbl_leukocytes = new Button("Leukocytes");
        lbl_leukocytes.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_leukocytes.relocate(465,650);

        TextField tf_leukocytes = new TextField();
        tf_leukocytes.setPromptText("Leukocytes (Y/N)");
        tf_leukocytes.setText(HomeScreen.currentPatient.getUrine_leukocytes());
        tf_leukocytes.getStyleClass().add("halfwidthInput");
        tf_leukocytes.relocate(465, 700);

        Button lbl_bilirubin = new Button("Bilirubin");
        lbl_bilirubin.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_bilirubin.relocate(800,200);

        TextField tf_bilirubin = new TextField();
        tf_bilirubin.setPromptText("Bilirubin (Y/N)");
        tf_bilirubin.setText(HomeScreen.currentPatient.getUrine_bilirubin());
        tf_bilirubin.getStyleClass().add("halfwidthInput");
        tf_bilirubin.relocate(800,250);

        Button lbl_blood = new Button("Blood");
        lbl_blood.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_blood.relocate(1165, 200);

        TextField tf_blood = new TextField();
        tf_blood.setPromptText("Blood (Y/N)");
        tf_blood.setText(HomeScreen.currentPatient.getUrine_blood());
        tf_blood.getStyleClass().add("halfwidthInput");
        tf_blood.relocate(1165, 250);

        Button lbl_bloodCasts = new Button("Blood Cell Casts");
        lbl_bloodCasts.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_bloodCasts.relocate(800,350);

        TextField tf_bloodCasts = new TextField();
        tf_bloodCasts.setPromptText("Blood Cell Casts (Y/N)");
        tf_bloodCasts.setText(HomeScreen.currentPatient.getUrine_bloodCasts());
        tf_bloodCasts.getStyleClass().add("halfwidthInput");
        tf_bloodCasts.relocate(800, 400);

        Button lbl_bacteriaYeast = new Button("Bacteria & Yeast");
        lbl_bacteriaYeast.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_bacteriaYeast.relocate(1165, 350);

        TextField tf_bacteriaYeast = new TextField();
        tf_bacteriaYeast.setPromptText("Bacteria & Yeast (Y/N)");
        tf_bacteriaYeast.setText(HomeScreen.currentPatient.getUrine_bacteriaYeast());
        tf_bacteriaYeast.getStyleClass().add("halfwidthInput");
        tf_bacteriaYeast.relocate(1165, 400);

        Button lbl_crystals = new Button("Crystals");
        lbl_crystals.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_crystals.relocate(800,500);

        TextField tf_crystals = new TextField();
        tf_crystals.setPromptText("Crystals (Y/N)");
        tf_crystals.setText(HomeScreen.currentPatient.getUrine_crystals());
        tf_crystals.getStyleClass().add("halfwidthInput");
        tf_crystals.relocate(800,550);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setUrine_pHLevel(tf_pHLevel.getText());
                HomeScreen.currentPatient.setUrine_specificGravity(tf_specificGravity.getText());
                HomeScreen.currentPatient.setUrine_proteinLevels(tf_proteinLevels.getText());
                HomeScreen.currentPatient.setUrine_glucoseLevels(tf_glucoseLevels.getText());
                HomeScreen.currentPatient.setUrine_ketoneLevels(tf_ketoneLevels.getText());
                HomeScreen.currentPatient.setUrine_urobilinogenLevels(tf_urobilinogenLevels.getText());
                HomeScreen.currentPatient.setUrine_nitrites(tf_nitrites.getText());
                HomeScreen.currentPatient.setUrine_leukocytes(tf_leukocytes.getText());
                HomeScreen.currentPatient.setUrine_bilirubin(tf_bilirubin.getText());
                HomeScreen.currentPatient.setUrine_blood(tf_blood.getText());
                HomeScreen.currentPatient.setUrine_bloodCasts(tf_bloodCasts.getText());
                HomeScreen.currentPatient.setUrine_bacteriaYeast(tf_bacteriaYeast.getText());
                HomeScreen.currentPatient.setUrine_crystals(tf_crystals.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchAnalysisForm(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_pHLevel, tf_pHLevel,
                lbl_specificGravity, tf_specificGravity,
                lbl_proteinLevels, tf_proteinLevels,
                lbl_glucoseLevels, tf_glucoseLevels,
                lbl_ketoneLevels, tf_ketoneLevels,
                lbl_urobilinogenLevels, tf_urobilinogenLevels,
                lbl_nitrites, tf_nitrites,
                lbl_leukocytes, tf_leukocytes,
                lbl_bilirubin, tf_bilirubin,
                lbl_blood, tf_blood,
                lbl_bloodCasts, tf_bloodCasts,
                lbl_bacteriaYeast, tf_bacteriaYeast,
                lbl_crystals, tf_crystals,
                btn_submit
        );

        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_analysis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "Analysis");
    }

    private void getBloodTestForm() throws FileNotFoundException {
        // Text fields and labels for blood test form
        Button lbl_RBCCount = new Button("RBC Count");
        lbl_RBCCount.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_RBCCount.relocate(100,200);

        TextField tf_RBCCount = new TextField();
        tf_RBCCount.setPromptText("RBC (cells/μL)");
        tf_RBCCount.setText(HomeScreen.currentPatient.getBlood_rbcCount());
        tf_RBCCount.getStyleClass().add("halfwidthInput");
        tf_RBCCount.relocate(100, 250);

        Button lbl_WBCCount = new Button("WBC Count");
        lbl_WBCCount.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_WBCCount.relocate(465,200);

        TextField tf_WBCCount = new TextField();
        tf_WBCCount.setPromptText("WBC (cells/μL)");
        tf_WBCCount.setText(HomeScreen.currentPatient.getBlood_wbcCount());
        tf_WBCCount.getStyleClass().add("halfwidthInput");
        tf_WBCCount.relocate(465,250);

        Button lbl_plateletCount = new Button("Platelet Count");
        lbl_plateletCount.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_plateletCount.relocate(100,350);

        TextField tf_plateletCount = new TextField();
        tf_plateletCount.setPromptText("Platelets (cells/μL)");
        tf_plateletCount.setText(HomeScreen.currentPatient.getBlood_plateletCount());
        tf_plateletCount.getStyleClass().add("halfwidthInput");
        tf_plateletCount.relocate(100,400);

        Button lbl_haemoglobin = new Button("Haemoglobin");
        lbl_haemoglobin.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_haemoglobin.relocate(465,350);

        TextField tf_haemoglobin = new TextField();
        tf_haemoglobin.setPromptText("Haemoglobin (g/dL)");
        tf_haemoglobin.setText(HomeScreen.currentPatient.getBlood_haemoglobinCount());
        tf_haemoglobin.getStyleClass().add("halfwidthInput");
        tf_haemoglobin.relocate(465,400);

        Button lbl_glucose = new Button("Glucose");
        lbl_glucose.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_glucose.relocate(100,500);

        TextField tf_glucose = new TextField();
        tf_glucose.setPromptText("Gluc. (mg/dL)");
        tf_glucose.setText(HomeScreen.currentPatient.getBlood_glucose());
        tf_glucose.getStyleClass().add("oneThirdWidthInput");
        tf_glucose.relocate(100,550);

        Button lbl_cholesterol = new Button("Cholesterol");
        lbl_cholesterol.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_cholesterol.relocate(330,500);

        TextField tf_cholesterol = new TextField();
        tf_cholesterol.setPromptText("Chol. (mg/dL)");
        tf_cholesterol.setText(HomeScreen.currentPatient.getBlood_cholesterol());
        tf_cholesterol.getStyleClass().add("oneThirdWidthInput");
        tf_cholesterol.relocate(330,550);

        Button lbl_protein = new Button("Protein");
        lbl_protein.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_protein.relocate(560,500);

        TextField tf_protein = new TextField();
        tf_protein.setPromptText("Prot. (mg/dL)");
        tf_protein.setText(HomeScreen.currentPatient.getBlood_protein());
        tf_protein.getStyleClass().add("oneThirdWidthInput");
        tf_protein.relocate(560,550);

        Button lbl_ureaNitrogen = new Button("Blood Urea Nitrogen");
        lbl_ureaNitrogen.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_ureaNitrogen.relocate(100,650);

        TextField tf_ureaNitrogen = new TextField();
        tf_ureaNitrogen.setPromptText("BUN (mg/dL)");
        tf_ureaNitrogen.setText(HomeScreen.currentPatient.getBlood_ureaNitrogen());
        tf_ureaNitrogen.getStyleClass().add("halfwidthInput");
        tf_ureaNitrogen.relocate(100, 700);

        Button lbl_creatinine = new Button("Creatinine");
        lbl_creatinine.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_creatinine.relocate(465,650);

        TextField tf_creatinine = new TextField();
        tf_creatinine.setPromptText("Creatinine (mg/dL)");
        tf_creatinine.setText(HomeScreen.currentPatient.getBlood_creatinine());
        tf_creatinine.getStyleClass().add("halfwidthInput");
        tf_creatinine.relocate(465, 700);

        Button lbl_sodium = new Button("Sodium");
        lbl_sodium.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_sodium.relocate(800,200);

        TextField tf_sodium = new TextField();
        tf_sodium.setPromptText("Na (mEq/L)");
        tf_sodium.setText(HomeScreen.currentPatient.getBlood_sodium());
        tf_sodium.getStyleClass().add("oneThirdWidthInput");
        tf_sodium.relocate(800,250);

        Button lbl_potassium = new Button("Potassium");
        lbl_potassium.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_potassium.relocate(1030, 200);

        TextField tf_potassium = new TextField();
        tf_potassium.setPromptText("K (mEq/L)");
        tf_potassium.setText(HomeScreen.currentPatient.getBlood_potassium());
        tf_potassium.getStyleClass().add("oneThirdWidthInput");
        tf_potassium.relocate(1030, 250);

        Button lbl_calcium = new Button("Calcium");
        lbl_calcium.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_calcium.relocate(1260,200);

        TextField tf_calcium = new TextField();
        tf_calcium.setPromptText("Ca (mEq/L)");
        tf_calcium.setText(HomeScreen.currentPatient.getBlood_calcium());
        tf_calcium.getStyleClass().add("oneThirdWidthInput");
        tf_calcium.relocate(1260, 250);

        Button lbl_bloodType = new Button("Blood Type");
        lbl_bloodType.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_bloodType.relocate(800,350);

        TextField tf_bloodType = new TextField();
        tf_bloodType.setPromptText("Blood Type");
        tf_bloodType.setText(HomeScreen.currentPatient.getBlood_bloodType());
        tf_bloodType.getStyleClass().add("oneThirdWidthInput");
        tf_bloodType.relocate(800,400);

        Button lbl_thyroidStimulatingHormone = new Button("TSH");
        lbl_thyroidStimulatingHormone.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_thyroidStimulatingHormone.relocate(1030, 350);

        TextField tf_thyroidStimulatingHormone = new TextField();
        tf_thyroidStimulatingHormone.setPromptText("TSH (μIU/mL)");
        tf_thyroidStimulatingHormone.setText(HomeScreen.currentPatient.getBlood_TSH());
        tf_thyroidStimulatingHormone.getStyleClass().add("oneThirdWidthInput");
        tf_thyroidStimulatingHormone.relocate(1030, 400);

        Button lbl_testosterone = new Button("Testosterone");
        lbl_testosterone.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_testosterone.relocate(1260,350);

        TextField tf_testosterone = new TextField();
        tf_testosterone.setPromptText("Test. (ng/dL)");
        tf_testosterone.setText(HomeScreen.currentPatient.getBlood_testosterone());
        tf_testosterone.getStyleClass().add("oneThirdWidthInput");
        tf_testosterone.relocate(1260, 400);

        Button lbl_oestrogen = new Button("Oestrogen");
        lbl_oestrogen.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_oestrogen.relocate(1030, 500);

        TextField tf_oestrogen = new TextField();
        tf_oestrogen.setPromptText("Oest. (μIU/mL)");
        tf_oestrogen.setText(HomeScreen.currentPatient.getBlood_oestrogen());
        tf_oestrogen.getStyleClass().add("oneThirdWidthInput");
        tf_oestrogen.relocate(1030, 550);

        Button lbl_cortisol = new Button("Cortisol");
        lbl_cortisol.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_cortisol.relocate(1260,500);

        TextField tf_cortisol = new TextField();
        tf_cortisol.setPromptText("Cort. (ng/dL)");
        tf_cortisol.setText(HomeScreen.currentPatient.getBlood_cortisol());
        tf_cortisol.getStyleClass().add("oneThirdWidthInput");
        tf_cortisol.relocate(1260, 550);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setBlood_rbcCount(tf_RBCCount.getText());
                HomeScreen.currentPatient.setBlood_wbcCount(tf_WBCCount.getText());
                HomeScreen.currentPatient.setBlood_plateletCount(tf_plateletCount.getText());
                HomeScreen.currentPatient.setBlood_haemoglobinCount(tf_haemoglobin.getText());
                HomeScreen.currentPatient.setBlood_glucose(tf_glucose.getText());
                HomeScreen.currentPatient.setBlood_cholesterol(tf_cholesterol.getText());
                HomeScreen.currentPatient.setBlood_protein(tf_protein.getText());
                HomeScreen.currentPatient.setBlood_ureaNitrogen(tf_ureaNitrogen.getText());
                HomeScreen.currentPatient.setBlood_creatinine(tf_creatinine.getText());
                HomeScreen.currentPatient.setBlood_sodium(tf_sodium.getText());
                HomeScreen.currentPatient.setBlood_potassium(tf_potassium.getText());
                HomeScreen.currentPatient.setBlood_calcium(tf_calcium.getText());
                HomeScreen.currentPatient.setBlood_bloodType(tf_bloodType.getText());
                HomeScreen.currentPatient.setBlood_TSH(tf_thyroidStimulatingHormone.getText());
                HomeScreen.currentPatient.setBlood_testosterone(tf_testosterone.getText());
                HomeScreen.currentPatient.setBlood_oestrogen(tf_oestrogen.getText());
                HomeScreen.currentPatient.setBlood_cortisol(tf_cortisol.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchAnalysisForm(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_RBCCount, tf_RBCCount,
                lbl_WBCCount, tf_WBCCount,
                lbl_plateletCount, tf_plateletCount,
                lbl_haemoglobin, tf_haemoglobin,
                lbl_glucose, tf_glucose,
                lbl_cholesterol, tf_cholesterol,
                lbl_protein, tf_protein,
                lbl_ureaNitrogen, tf_ureaNitrogen,
                lbl_creatinine, tf_creatinine,
                lbl_sodium, tf_sodium,
                lbl_potassium, tf_potassium,
                lbl_calcium, tf_calcium,
                lbl_bloodType, tf_bloodType,
                lbl_thyroidStimulatingHormone, tf_thyroidStimulatingHormone,
                lbl_testosterone, tf_testosterone,
                lbl_oestrogen, tf_oestrogen,
                lbl_cortisol, tf_cortisol,
                btn_submit
        );

        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_analysis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "Analysis");
    }

    private void getImagingTestForm() throws FileNotFoundException {
        // Text fields and lables for imaging test form
        Button lbl_xrayResults = new Button("X-Ray");
        lbl_xrayResults.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_xrayResults.relocate(100,200);

        TextField tf_xrayResults = new TextField();
        tf_xrayResults.setPromptText("X-Ray Results");
        tf_xrayResults.setText(HomeScreen.currentPatient.getImaging_xRay());
        tf_xrayResults.getStyleClass().add("fullwidthInput");
        tf_xrayResults.relocate(100, 250);

        Button lbl_CTResults = new Button("Computed Tomography Scan");
        lbl_CTResults.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_CTResults.relocate(100,350);

        TextField tf_CTResults = new TextField();
        tf_CTResults.setPromptText("CT Scan Result");
        tf_CTResults.setText(HomeScreen.currentPatient.getImaging_CT());
        tf_CTResults.getStyleClass().add("fullwidthInput");
        tf_CTResults.relocate(100,400 );

        Button lbl_MRIResults = new Button("Magnetic Resonance Imaging");
        lbl_MRIResults.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_MRIResults.relocate(100,500);

        TextField tf_MRIResults = new TextField();
        tf_MRIResults.setPromptText("MRI Result");
        tf_MRIResults.setText(HomeScreen.currentPatient.getImaging_MRI());
        tf_MRIResults.getStyleClass().add("fullwidthInput");
        tf_MRIResults.relocate(100, 550);

        Button lbl_ultrasoundResults = new Button("Ultrasound");
        lbl_ultrasoundResults.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_ultrasoundResults.relocate(100,650);

        TextField tf_ultrasoundResults = new TextField();
        tf_ultrasoundResults.setPromptText("Ultrasound Result");
        tf_ultrasoundResults.setText(HomeScreen.currentPatient.getImaging_ultrasound());
        tf_ultrasoundResults.getStyleClass().add("fullwidthInput");
        tf_ultrasoundResults.relocate(100, 700);

        Button lbl_PETResults = new Button("Positron Emission Tomography Scan");
        lbl_PETResults.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_PETResults.relocate(800,200);

        TextField tf_PETResults = new TextField();
        tf_PETResults.setPromptText("PET Scan Result");
        tf_PETResults.setText(HomeScreen.currentPatient.getImaging_PET());
        tf_PETResults.getStyleClass().add("fullwidthInput");
        tf_PETResults.relocate(800, 250);

        Button lbl_remarks = new Button("Remarks");
        lbl_remarks.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_remarks.relocate(800,350);

        TextArea ta_remarks = new TextArea();
        ta_remarks.setPromptText("Remarks...");
        ta_remarks.setText(HomeScreen.currentPatient.getImaging_remarks());
        ta_remarks.getStyleClass().add("textAreaShort");
        ta_remarks.relocate(800, 400);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setImaging_xRay(tf_xrayResults.getText());
                HomeScreen.currentPatient.setImaging_CT(tf_CTResults.getText());
                HomeScreen.currentPatient.setImaging_MRI(tf_MRIResults.getText());
                HomeScreen.currentPatient.setImaging_ultrasound(tf_ultrasoundResults.getText());
                HomeScreen.currentPatient.setImaging_PET(tf_PETResults.getText());
                HomeScreen.currentPatient.setImaging_remarks(ta_remarks.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchAnalysisForm(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        accentPane.getChildren().addAll(
                lbl_xrayResults, tf_xrayResults,
                lbl_CTResults, tf_CTResults,
                lbl_MRIResults, tf_MRIResults,
                lbl_ultrasoundResults, tf_ultrasoundResults,
                lbl_PETResults, tf_PETResults,
                lbl_remarks, ta_remarks,
                btn_submit
        );
        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_analysis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "Analysis");
    }

    private void getBiopsyTestForm() throws FileNotFoundException {
        // Text fields and labels for biopsy form
        Button lbl_tumourSize = new Button("Tumour Size");
        lbl_tumourSize.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_tumourSize.relocate(100,200);

        TextField tf_tumourSize = new TextField();
        tf_tumourSize.setPromptText("Tumour Size (mm)");
        tf_tumourSize.setText(HomeScreen.currentPatient.getBiopsy_tumourSize());
        tf_tumourSize.getStyleClass().add("fullwidthInput");
        tf_tumourSize.relocate(100, 250);

        Button lbl_marginStatus = new Button("Margin Status");
        lbl_marginStatus.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_marginStatus.relocate(100,350);

        TextField tf_marginStatus = new TextField();
        tf_marginStatus.setPromptText("Margin Status");
        tf_marginStatus.setText(HomeScreen.currentPatient.getBiopsy_marginStatus());
        tf_marginStatus.getStyleClass().add("fullwidthInput");
        tf_marginStatus.relocate(100,400 );

        Button lbl_molecularTesting = new Button("Molecular Testing");
        lbl_molecularTesting.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_molecularTesting.relocate(100,500);

        TextField tf_molecularTesting = new TextField();
        tf_molecularTesting.setPromptText("Molecular Testing (%)");
        tf_molecularTesting.setText(HomeScreen.currentPatient.getBiopsy_molecularTesting());
        tf_molecularTesting.getStyleClass().add("fullwidthInput");
        tf_molecularTesting.relocate(100, 550);

        Button lbl_remarks = new Button("Remarks");
        lbl_remarks.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_remarks.relocate(800,200);

        TextArea ta_remarks = new TextArea();
        ta_remarks.setPromptText("Remarks");
        ta_remarks.setText(HomeScreen.currentPatient.getBiopsy_remarks());
        ta_remarks.relocate(800, 250);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setBiopsy_tumourSize(tf_tumourSize.getText());
                HomeScreen.currentPatient.setBiopsy_marginStatus(tf_marginStatus.getText());
                HomeScreen.currentPatient.setBiopsy_molecularTesting(tf_molecularTesting.getText());
                HomeScreen.currentPatient.setBiopsy_remarks(ta_remarks.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchAnalysisForm(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_tumourSize, tf_tumourSize,
                lbl_marginStatus, tf_marginStatus,
                lbl_molecularTesting, tf_molecularTesting,
                lbl_remarks, ta_remarks,
                btn_submit
        );

        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_analysis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "Analysis");
    }

    private void getPulmonaryTestForm() throws FileNotFoundException {
        // Text fields and labels for pulmonary test form
        Button lbl_forcedVitalCapacity = new Button("Forced Vital Capacity (FVC)");
        lbl_forcedVitalCapacity.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_forcedVitalCapacity.relocate(100,200);

        tf_forcedVitalCapacity = new TextField();
        tf_forcedVitalCapacity.setPromptText("FVC (L)");
        tf_forcedVitalCapacity.setText(HomeScreen.currentPatient.getPulmonary_FVC());
        tf_forcedVitalCapacity.getStyleClass().add("fullwidthInput");
        tf_forcedVitalCapacity.relocate(100, 250);

        Button lbl_forcedExpiratoryVolume = new Button("Forced Expiratory Volume in 1 Second (FEV1)");
        lbl_forcedExpiratoryVolume.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_forcedExpiratoryVolume.relocate(100,350);

        tf_forcedExpiratoryVolume = new TextField();
        tf_forcedExpiratoryVolume.setPromptText("FEV1 (L)");
        tf_forcedExpiratoryVolume.setText(HomeScreen.currentPatient.getPulmonary_FEV1());
        tf_forcedExpiratoryVolume.getStyleClass().add("fullwidthInput");
        tf_forcedExpiratoryVolume.relocate(100,400);

        Button lbl_FEV1FVCRatio = new Button("FEV1/FVC Ratio");
        lbl_FEV1FVCRatio.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_FEV1FVCRatio.relocate(100,500);

        tf_FEV1FVCRatio = new TextField();
        tf_FEV1FVCRatio.setText(HomeScreen.currentPatient.getPulmonary_FEV1FVCRatio());
        tf_FEV1FVCRatio.getStyleClass().addAll("fullwidthInput", "disabled");
        tf_FEV1FVCRatio.relocate(100, 550);
        tf_FEV1FVCRatio.setEditable(false);

        Button lbl_peakExpiratoryFlow = new Button("Peak Expiratory Flow");
        lbl_peakExpiratoryFlow.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_peakExpiratoryFlow.relocate(100,650);

        TextField tf_peakExpiratoryFlow = new TextField();
        tf_peakExpiratoryFlow.setPromptText("Peak Expiratory Flow (L/min)");
        tf_peakExpiratoryFlow.setText(HomeScreen.currentPatient.getPulmonary_expiratoryFlow());
        tf_peakExpiratoryFlow.getStyleClass().add("fullwidthInput");
        tf_peakExpiratoryFlow.relocate(100, 700);

        Button lbl_totalLungCapacity = new Button("Total Lung Capacity");
        lbl_totalLungCapacity.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_totalLungCapacity.relocate(800,200);

        TextField tf_totalLungCapacity = new TextField();
        tf_totalLungCapacity.setPromptText("Total Lung Capacity (L)");
        tf_totalLungCapacity.setText(HomeScreen.currentPatient.getPulmonary_totalLungCapacity());
        tf_totalLungCapacity.getStyleClass().add("fullwidthInput");
        tf_totalLungCapacity.relocate(800, 250);

        Button lbl_residualVolume = new Button("Residual Volume");
        lbl_residualVolume.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_residualVolume.relocate(800,350);

        TextField tf_residualVolume = new TextField();
        tf_residualVolume.setPromptText("Residual Volume (L)");
        tf_residualVolume.setText(HomeScreen.currentPatient.getPulmonary_residualVolume());
        tf_residualVolume.getStyleClass().add("fullwidthInput");
        tf_residualVolume.relocate(800, 400);

        Button lbl_diffusingCapacity = new Button("Diffusing Capacity for Carbon Monoxide");
        lbl_diffusingCapacity.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_diffusingCapacity.relocate(800,500);

        TextField tf_diffusingCapacity = new TextField();
        tf_diffusingCapacity.setPromptText("CO Lung Diffusing Capacity (mL/min/mmHg)");
        tf_diffusingCapacity.setText(HomeScreen.currentPatient.getPulmonary_diffusingCapacity());
        tf_diffusingCapacity.getStyleClass().add("fullwidthInput");
        tf_diffusingCapacity.relocate(800, 550);

        Button btn_calculateRatio = new Button("Calculate Ratio");
        btn_calculateRatio.getStyleClass().addAll("clickable", "accentedColor", "genericUIButton");
        btn_calculateRatio.relocate(900, 670);
        btn_calculateRatio.setOnMouseClicked(e -> {
            try {
                double ratio = Double.parseDouble(tf_forcedExpiratoryVolume.getText()) / Double.parseDouble(tf_forcedVitalCapacity.getText()) * 100;
                tf_FEV1FVCRatio.setText(
                        String.format("%.2f%%", ratio)
                );
            } catch (NumberFormatException ex) {}
        });

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setPulmonary_FVC(tf_forcedVitalCapacity.getText());
                HomeScreen.currentPatient.setPulmonary_FEV1(tf_forcedExpiratoryVolume.getText());
                HomeScreen.currentPatient.setPulmonary_FEV1FVCRatio(tf_FEV1FVCRatio.getText());
                HomeScreen.currentPatient.setPulmonary_expiratoryFlow(tf_peakExpiratoryFlow.getText());
                HomeScreen.currentPatient.setPulmonary_totalLungCapacity(tf_totalLungCapacity.getText());
                HomeScreen.currentPatient.setPulmonary_residualVolume(tf_residualVolume.getText());
                HomeScreen.currentPatient.setPulmonary_diffusingCapacity(tf_diffusingCapacity.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchAnalysisForm(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_forcedVitalCapacity, tf_forcedVitalCapacity,
                lbl_forcedExpiratoryVolume, tf_forcedExpiratoryVolume,
                lbl_FEV1FVCRatio, tf_FEV1FVCRatio,
                lbl_peakExpiratoryFlow, tf_peakExpiratoryFlow,
                lbl_totalLungCapacity, tf_totalLungCapacity,
                lbl_residualVolume, tf_residualVolume,
                lbl_diffusingCapacity, tf_diffusingCapacity,
                btn_calculateRatio, btn_submit
        );
        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_analysis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "Analysis");
    }

    private void getOtherTestForm() throws FileNotFoundException {
        // Text fields and labels for Other Tests form
        Button lbl_testName = new Button("Name of Test");
        lbl_testName.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_testName.relocate(100,200);

        TextField tf_testName = new TextField();
        tf_testName.setPromptText("Name of Test");
        tf_testName.setText(HomeScreen.currentPatient.getOther_nameOfTest());
        tf_testName.getStyleClass().add("fullwidthInput");
        tf_testName.relocate(100, 250);

        Button lbl_results = new Button("Results of Test");
        lbl_results.getStyleClass().addAll( "accentedColor","formLabel");
        lbl_results.relocate(800,200);

        TextArea ta_results = new TextArea();
        ta_results.setPromptText("Results...");
        ta_results.setText(HomeScreen.currentPatient.getOther_testResults());
        ta_results.relocate(800, 250);

        Button btn_submit = new Button("Submit");
        btn_submit.getStyleClass().addAll("clickable", "baseColor", "genericUIButton");
        btn_submit.relocate(1200, 670);
        btn_submit.setOnMouseClicked(e -> {
            try {
                HomeScreen.currentPatient.setOther_nameOfTest(tf_testName.getText());
                HomeScreen.currentPatient.setOther_testResults(ta_results.getText());
                PatientInitialiser.writePatient(HomeScreen.currentPatient);
                SCREEN_CONTROLLER.launchAnalysisForm(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        accentPane.getChildren().addAll(
                lbl_testName, tf_testName,
                lbl_results, ta_results,
                btn_submit
        );

        accentPane = UI_ATTACHER.attachHeader(accentPane, "btn_analysis.png");
        accentPane = UI_ATTACHER.attachBackButton(accentPane, "Analysis");
    }
}
