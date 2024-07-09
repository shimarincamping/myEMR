package com.myemr.myemr;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.FileNotFoundException;

public class ScreenController {
    private Stage stage;
    private Scene scene;

    // Launches the relevant scenes from a mouse event (button press)
    public void launchHomeScreen(MouseEvent e) throws FileNotFoundException {
        HomeScreen homeScreen = new HomeScreen();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = homeScreen.getHomeScene();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Home");

        stage.show();
    }

    public void launchMainMenu(MouseEvent e) throws FileNotFoundException {
        MainMenu mainMenu = new MainMenu();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = mainMenu.getMainMenu();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Main Menu");

        stage.show();
    }

    public void launchPatientForm(MouseEvent e) throws FileNotFoundException {
        PatientForm patientForm = new PatientForm();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = patientForm.getPatientForm();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Patient Form");

        stage.show();
    }

    public void launchMedicineProcedureForm(MouseEvent e) throws FileNotFoundException {
        MedicineProcedureForm medicineProcedureForm = new MedicineProcedureForm();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = medicineProcedureForm.getMedicineProcedureForm();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Procedure & Medicine Form");

        stage.show();
    }

    public void launchDiagnosisForm(MouseEvent e) throws FileNotFoundException {
        DiagnosisForm diagnosisForm = new DiagnosisForm();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = diagnosisForm.getDiagnosisForm();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Diagnosis Form");

        stage.show();
    }

    public void launchTreatmentCourseForm(MouseEvent e) throws FileNotFoundException {
        TreatmentCourseForm treatmentCourseForm = new TreatmentCourseForm();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = treatmentCourseForm.getTreatmentCourse();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Treatment Course Form");

        stage.show();
    }

    public void launchMedicalHistory(MouseEvent e) throws FileNotFoundException {
        MedicalHistory medicalHistory = new MedicalHistory();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = medicalHistory.getMedicalHistory();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Medical History");

        stage.show();
    }

    public void launchAnalysisForm(MouseEvent e) throws FileNotFoundException {
        AnalysisForm analysisForm = new AnalysisForm();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = analysisForm.getAnalysisForm();
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("myEMR | Analysis Form");

        stage.show();
    }
}
