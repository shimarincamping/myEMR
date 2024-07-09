package com.myemr.myemr;

import java.util.ArrayList;
import java.util.HashMap;

// Patient POJO (private fields, getters and setters)
// To be used to read from and write to JSON
public class Patient {

    // Fields
    private String patientID = "";
    private String patientName = "";
    private String patientSex = "";
    private String patientDOB = "";
    private String patientContact = "";
    private String patientAddress = "";
    private String typeOfTreatment = "";
    private String treatmentStartDate = "";
    private String treatmentEndDate = "";
    private String urine_pHLevel = "";
    private String urine_specificGravity = "";
    private String urine_proteinLevels = "";
    private String urine_glucoseLevels = "";
    private String urine_ketoneLevels = "";
    private String urine_urobilinogenLevels = "";
    private String urine_nitrites = "";
    private String urine_leukocytes = "";
    private String urine_bilirubin = "";
    private String urine_blood = "";
    private String urine_bloodCasts = "";
    private String urine_bacteriaYeast = "";
    private String urine_crystals = "";
    private String blood_rbcCount = "";
    private String blood_wbcCount = "";
    private String blood_plateletCount = "";
    private String blood_haemoglobinCount = "";
    private String blood_glucose = "";
    private String blood_cholesterol = "";
    private String blood_protein = "";
    private String blood_ureaNitrogen = "";
    private String blood_creatinine = "";
    private String blood_sodium = "";
    private String blood_potassium = "";
    private String blood_calcium = "";
    private String blood_bloodType = "";
    private String blood_TSH = "";
    private String blood_testosterone = "";
    private String blood_oestrogen = "";
    private String blood_cortisol = "";
    private String imaging_xRay = "";
    private String imaging_CT = "";
    private String imaging_MRI = "";
    private String imaging_ultrasound = "";
    private String imaging_PET = "";
    private String imaging_remarks = "";
    private String biopsy_tumourSize = "";
    private String biopsy_marginStatus = "";
    private String biopsy_molecularTesting = "";
    private String biopsy_remarks = "";
    private String pulmonary_FVC = "";
    private String pulmonary_FEV1 = "";
    private String pulmonary_FEV1FVCRatio = "";
    private String pulmonary_expiratoryFlow = "";
    private String pulmonary_totalLungCapacity = "";
    private String pulmonary_residualVolume = "";
    private String pulmonary_diffusingCapacity = "";
    private String other_nameOfTest = "";
    private String other_testResults = "";
    private final ArrayList<HashMap<String, String>> MEDICAL_HISTORY = new ArrayList<>();
    private String medicineName = "";
    private String medicineDosage = "";
    private String medicineExpirationDate = "";
    private String procedureDate = "";
    private String procedureType = "";
    private String procedureStatus = "";
    private String diagnnosis = "";
    private String diagnosedBy = "";
    private String dateOfDiagnosis = "";
    private String diagnosisRemarks = "";

    // Getters and setters

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getTypeOfTreatment() {
        return typeOfTreatment;
    }

    public void setTypeOfTreatment(String typeOfTreatment) {
        this.typeOfTreatment = typeOfTreatment;
    }

    public String getTreatmentStartDate() {
        return treatmentStartDate;
    }

    public void setTreatmentStartDate(String treatmentStartDate) {
        this.treatmentStartDate = treatmentStartDate;
    }

    public String getTreatmentEndDate() {
        return treatmentEndDate;
    }

    public void setTreatmentEndDate(String treatmentEndDate) {
        this.treatmentEndDate = treatmentEndDate;
    }

    public String getUrine_pHLevel() {
        return urine_pHLevel;
    }

    public void setUrine_pHLevel(String urine_pHLevel) {
        this.urine_pHLevel = urine_pHLevel;
    }

    public String getUrine_specificGravity() {
        return urine_specificGravity;
    }

    public void setUrine_specificGravity(String urine_specificGravity) {
        this.urine_specificGravity = urine_specificGravity;
    }

    public String getUrine_proteinLevels() {
        return urine_proteinLevels;
    }

    public void setUrine_proteinLevels(String urine_proteinLevels) {
        this.urine_proteinLevels = urine_proteinLevels;
    }

    public String getUrine_glucoseLevels() {
        return urine_glucoseLevels;
    }

    public void setUrine_glucoseLevels(String urine_glucoseLevels) {
        this.urine_glucoseLevels = urine_glucoseLevels;
    }

    public String getUrine_ketoneLevels() {
        return urine_ketoneLevels;
    }

    public void setUrine_ketoneLevels(String urine_ketoneLevels) {
        this.urine_ketoneLevels = urine_ketoneLevels;
    }

    public String getUrine_urobilinogenLevels() {
        return urine_urobilinogenLevels;
    }

    public void setUrine_urobilinogenLevels(String urine_urobilinogenLevels) {
        this.urine_urobilinogenLevels = urine_urobilinogenLevels;
    }

    public String getUrine_nitrites() {
        return urine_nitrites;
    }

    public void setUrine_nitrites(String urine_nitrites) {
        this.urine_nitrites = urine_nitrites;
    }

    public String getUrine_leukocytes() {
        return urine_leukocytes;
    }

    public void setUrine_leukocytes(String urine_leukocytes) {
        this.urine_leukocytes = urine_leukocytes;
    }

    public String getUrine_bilirubin() {
        return urine_bilirubin;
    }

    public void setUrine_bilirubin(String urine_bilirubin) {
        this.urine_bilirubin = urine_bilirubin;
    }

    public String getUrine_blood() {
        return urine_blood;
    }

    public void setUrine_blood(String urine_blood) {
        this.urine_blood = urine_blood;
    }

    public String getUrine_bloodCasts() {
        return urine_bloodCasts;
    }

    public void setUrine_bloodCasts(String urine_bloodCasts) {
        this.urine_bloodCasts = urine_bloodCasts;
    }

    public String getUrine_bacteriaYeast() {
        return urine_bacteriaYeast;
    }

    public void setUrine_bacteriaYeast(String urine_bacteriaYeast) {
        this.urine_bacteriaYeast = urine_bacteriaYeast;
    }

    public String getUrine_crystals() {
        return urine_crystals;
    }

    public void setUrine_crystals(String urine_crystals) {
        this.urine_crystals = urine_crystals;
    }

    public String getBlood_rbcCount() {
        return blood_rbcCount;
    }

    public void setBlood_rbcCount(String blood_rbcCount) {
        this.blood_rbcCount = blood_rbcCount;
    }

    public String getBlood_wbcCount() {
        return blood_wbcCount;
    }

    public void setBlood_wbcCount(String blood_wbcCount) {
        this.blood_wbcCount = blood_wbcCount;
    }

    public String getBlood_plateletCount() {
        return blood_plateletCount;
    }

    public void setBlood_plateletCount(String blood_plateletCount) {
        this.blood_plateletCount = blood_plateletCount;
    }

    public String getBlood_haemoglobinCount() {
        return blood_haemoglobinCount;
    }

    public void setBlood_haemoglobinCount(String blood_haemoglobinCount) {
        this.blood_haemoglobinCount = blood_haemoglobinCount;
    }

    public String getBlood_glucose() {
        return blood_glucose;
    }

    public void setBlood_glucose(String blood_glucose) {
        this.blood_glucose = blood_glucose;
    }

    public String getBlood_cholesterol() {
        return blood_cholesterol;
    }

    public void setBlood_cholesterol(String blood_cholesterol) {
        this.blood_cholesterol = blood_cholesterol;
    }

    public String getBlood_protein() {
        return blood_protein;
    }

    public void setBlood_protein(String blood_protein) {
        this.blood_protein = blood_protein;
    }

    public String getBlood_ureaNitrogen() {
        return blood_ureaNitrogen;
    }

    public void setBlood_ureaNitrogen(String blood_ureaNitrogen) {
        this.blood_ureaNitrogen = blood_ureaNitrogen;
    }

    public String getBlood_creatinine() {
        return blood_creatinine;
    }

    public void setBlood_creatinine(String blood_creatinine) {
        this.blood_creatinine = blood_creatinine;
    }

    public String getBlood_sodium() {
        return blood_sodium;
    }

    public void setBlood_sodium(String blood_sodium) {
        this.blood_sodium = blood_sodium;
    }

    public String getBlood_potassium() {
        return blood_potassium;
    }

    public void setBlood_potassium(String blood_potassium) {
        this.blood_potassium = blood_potassium;
    }

    public String getBlood_calcium() {
        return blood_calcium;
    }

    public void setBlood_calcium(String blood_calcium) {
        this.blood_calcium = blood_calcium;
    }

    public String getBlood_bloodType() {
        return blood_bloodType;
    }

    public void setBlood_bloodType(String blood_bloodType) {
        this.blood_bloodType = blood_bloodType;
    }

    public String getBlood_TSH() {
        return blood_TSH;
    }

    public void setBlood_TSH(String blood_TSH) {
        this.blood_TSH = blood_TSH;
    }

    public String getBlood_testosterone() {
        return blood_testosterone;
    }

    public void setBlood_testosterone(String blood_testosterone) {
        this.blood_testosterone = blood_testosterone;
    }

    public String getBlood_oestrogen() {
        return blood_oestrogen;
    }

    public void setBlood_oestrogen(String blood_oestrogen) {
        this.blood_oestrogen = blood_oestrogen;
    }

    public String getBlood_cortisol() {
        return blood_cortisol;
    }

    public void setBlood_cortisol(String blood_cortisol) {
        this.blood_cortisol = blood_cortisol;
    }

    public String getImaging_xRay() {
        return imaging_xRay;
    }

    public void setImaging_xRay(String imaging_xRay) {
        this.imaging_xRay = imaging_xRay;
    }

    public String getImaging_CT() {
        return imaging_CT;
    }

    public void setImaging_CT(String imaging_CT) {
        this.imaging_CT = imaging_CT;
    }

    public String getImaging_MRI() {
        return imaging_MRI;
    }

    public void setImaging_MRI(String imaging_MRI) {
        this.imaging_MRI = imaging_MRI;
    }

    public String getImaging_ultrasound() {
        return imaging_ultrasound;
    }

    public void setImaging_ultrasound(String imaging_ultrasound) {
        this.imaging_ultrasound = imaging_ultrasound;
    }

    public String getImaging_PET() {
        return imaging_PET;
    }

    public void setImaging_PET(String imaging_PET) {
        this.imaging_PET = imaging_PET;
    }

    public String getImaging_remarks() {
        return imaging_remarks;
    }

    public void setImaging_remarks(String imaging_remarks) {
        this.imaging_remarks = imaging_remarks;
    }

    public String getBiopsy_tumourSize() {
        return biopsy_tumourSize;
    }

    public void setBiopsy_tumourSize(String biopsy_tumourSize) {
        this.biopsy_tumourSize = biopsy_tumourSize;
    }

    public String getBiopsy_marginStatus() {
        return biopsy_marginStatus;
    }

    public void setBiopsy_marginStatus(String biopsy_marginStatus) {
        this.biopsy_marginStatus = biopsy_marginStatus;
    }

    public String getBiopsy_molecularTesting() {
        return biopsy_molecularTesting;
    }

    public void setBiopsy_molecularTesting(String biopsy_molecularTesting) {
        this.biopsy_molecularTesting = biopsy_molecularTesting;
    }

    public String getBiopsy_remarks() {
        return biopsy_remarks;
    }

    public void setBiopsy_remarks(String biopsy_remarks) {
        this.biopsy_remarks = biopsy_remarks;
    }

    public String getPulmonary_FVC() {
        return pulmonary_FVC;
    }

    public void setPulmonary_FVC(String pulmonary_FVC) {
        this.pulmonary_FVC = pulmonary_FVC;
    }

    public String getPulmonary_FEV1() {
        return pulmonary_FEV1;
    }

    public void setPulmonary_FEV1(String pulmonary_FEV1) {
        this.pulmonary_FEV1 = pulmonary_FEV1;
    }

    public String getPulmonary_FEV1FVCRatio() {
        return pulmonary_FEV1FVCRatio;
    }

    public void setPulmonary_FEV1FVCRatio(String pulmonary_FEV1FVCRatio) {
        this.pulmonary_FEV1FVCRatio = pulmonary_FEV1FVCRatio;
    }

    public String getPulmonary_expiratoryFlow() {
        return pulmonary_expiratoryFlow;
    }

    public void setPulmonary_expiratoryFlow(String pulmonary_expiratoryFlow) {
        this.pulmonary_expiratoryFlow = pulmonary_expiratoryFlow;
    }

    public String getPulmonary_totalLungCapacity() {
        return pulmonary_totalLungCapacity;
    }

    public void setPulmonary_totalLungCapacity(String pulmonary_totalLungCapacity) {
        this.pulmonary_totalLungCapacity = pulmonary_totalLungCapacity;
    }

    public String getPulmonary_residualVolume() {
        return pulmonary_residualVolume;
    }

    public void setPulmonary_residualVolume(String pulmonary_residualVolume) {
        this.pulmonary_residualVolume = pulmonary_residualVolume;
    }

    public String getPulmonary_diffusingCapacity() {
        return pulmonary_diffusingCapacity;
    }

    public void setPulmonary_diffusingCapacity(String pulmonary_diffusingCapacity) {
        this.pulmonary_diffusingCapacity = pulmonary_diffusingCapacity;
    }

    public String getOther_nameOfTest() {
        return other_nameOfTest;
    }

    public void setOther_nameOfTest(String other_nameOfTest) {
        this.other_nameOfTest = other_nameOfTest;
    }

    public String getOther_testResults() {
        return other_testResults;
    }

    public void setOther_testResults(String other_testResults) {
        this.other_testResults = other_testResults;
    }

    public ArrayList<HashMap<String, String>> getMEDICAL_HISTORY() {
        return MEDICAL_HISTORY;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineDosage() {
        return medicineDosage;
    }

    public void setMedicineDosage(String medicineDosage) {
        this.medicineDosage = medicineDosage;
    }

    public String getMedicineExpirationDate() {
        return medicineExpirationDate;
    }

    public void setMedicineExpirationDate(String medicineExpirationDate) {
        this.medicineExpirationDate = medicineExpirationDate;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(String procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

    public String getDiagnnosis() {
        return diagnnosis;
    }

    public void setDiagnnosis(String diagnnosis) {
        this.diagnnosis = diagnnosis;
    }

    public String getDiagnosedBy() {
        return diagnosedBy;
    }

    public void setDiagnosedBy(String diagnosedBy) {
        this.diagnosedBy = diagnosedBy;
    }

    public String getDateOfDiagnosis() {
        return dateOfDiagnosis;
    }

    public void setDateOfDiagnosis(String dateOfDiagnosis) {
        this.dateOfDiagnosis = dateOfDiagnosis;
    }

    public String getDiagnosisRemarks() {
        return diagnosisRemarks;
    }

    public void setDiagnosisRemarks(String diagnosisRemarks) {
        this.diagnosisRemarks = diagnosisRemarks;
    }
}
