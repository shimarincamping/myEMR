package com.myemr.myemr;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PatientInitialiser {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    // Reading from the corresponding JSON file and returning a corresponding Patient object
    public static Patient initialisePatient(String filename) throws IOException {
        return OBJECT_MAPPER.readValue(new File("src/main/resources/data/" + filename + ".json"), Patient.class);
    }
    // Saves data to JSON
    public static void writePatient(Patient currentPatient) throws IOException {
        OBJECT_MAPPER.writeValue(new File("src/main/resources/data/" + currentPatient.getPatientID() + ".json"), currentPatient);
    }
    // Used when Patient ID is modified safely
    public static boolean renamePatient(String originalID, String newID) {
        File originalFile = new File("src/main/resources/data/" + originalID + ".json");
        File newFile = new File("src/main/resources/data/" + newID + ".json");
        return originalFile.renameTo(newFile);
    }
}
