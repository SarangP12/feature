package com.electra.automation.utilities;
import java.util.Locale;
import java.util.Random;
import com.electra.automation.models.OPD_Data;
import com.electra.automation.models.PatientData;

public class RandomDataUtility {

    // Prevent object creation
    private RandomDataUtility() {
    }

    // Single Random object
    private static final Random random = new Random();

    // Generate Dynamic First Name
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

// Generate Dynamic Patient First Name
// Format: Veera + 3 Random Alphabets
public static String getPatientName() {
    StringBuilder name = new StringBuilder("Veera");

    for (int i = 0; i < 3; i++) {
        name.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
    }

    return name.toString();
}

    // Generate Dynamic Mobile Number
    public static String getMobileNumber() {
        return "9" + (100000000 + random.nextInt(900000000));
    }

    // Generate Dynamic Age Number 10-99 
    public static String TwoDigitNo() {
        return String.valueOf(10 + random.nextInt(90));
    }

    // Generate Dynamic Point Value: 90.0 - 99.9
    public static String getPointValue() {
        double value = 90.0 + (random.nextInt(100) / 10.0);
        return String.format(Locale.US, "%.1f", value);
    }

    // Generate Dynamic Height: 140.0 - 200.0 cm
    public static String Height() {
        double height = 140.0 + (random.nextInt(601) / 10.0);
        return String.format(Locale.US, "%.1f", height);
    }

// Generate Dynamic Email
    public static String getEmail() {
        return "Auto" + (10 + random.nextInt(90)) + "@gmail.com";
    }

    // Generate Dynamic Pain: 1 - 10
    public static String pain() {
        return String.valueOf(1 + random.nextInt(10));
    }

    // Generate Dynamic RRNumber: 14 - 20
    public static String RR() {
        return String.valueOf(14 + random.nextInt(7));
    }
    // Generate Dynamic BP: 90/60 - 140/90 with systolic always greater than diastolic
    public static String BP() {
        int systolic = 90 + random.nextInt(51); // 90 - 140
        int maxDiastolic = Math.min(90, systolic - 1);
        int diastolic = 60 + random.nextInt(Math.max(1, maxDiastolic - 60 + 1)); // 60 - maxDiastolic

        return systolic + "/" + diastolic;
    }
// Generate Dynamic Address

    public static String getAddresss() {
        int houseNo = 1 + random.nextInt(9999);
        return "House No. " + houseNo + ", MG Road, Pune, Maharashtra";
    }

    //generate a random indexNumber
    public static int getRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    //generate a random index
    public static int getRandomIndex(int size) {
        if (size <= 0) {

            throw new IllegalArgumentException(
                    "List size cannot be zero"
            );
        }
        return random.nextInt(size);
    }

    // Generate Complete Patient Object
    public static PatientData generatePatient() {

        PatientData patient = new PatientData();

        patient.setCategoryType("Staff");
        patient.setCategoryID("Staff Benefit");
        patient.setTariff("Corporate & Private TPA Insurance Tariff");
        // patient.setCategoryType("Staff");
        // patient.setCategoryID("Staff Benefit");
        // patient.setTariff("Staff Patient");
        patient.setDepartment("General Medicine");
        patient.setUnit("General Medicine - Unit A");
        patient.setDoctor("Dr Aarav Sharma"); //Dr Roshan G Dr. Aarav Sharma Dr Sarang D Pawar
        patient.setSalutation("Mrs");
        patient.setVisitType("Initial Visit");
        patient.setFirstName(getPatientName());
        patient.setLastName("Kohli");
        patient.setBirthYear(TwoDigitNo());
        patient.setGender("Female");
        patient.setMobile(getMobileNumber());
        patient.setAge(TwoDigitNo());
        patient.setEmail(getEmail());
        patient.setAddress(getAddresss());
        patient.setNextToKin("Spouse");
        patient.setKinsRelation("Family");
        patient.setKinsContact("John Doe");
        patient.setKinsAddress("123 Main St, Cityville");
        patient.setKinsContactNumber("9876543210");

        return patient;
    }
    // Generate Complete OPD Object

    public static OPD_Data generateOPData() {

        OPD_Data opd = new OPD_Data();

        opd.setOPDEMREHRBP(BP());
        opd.setOPDEMREHRPulse(TwoDigitNo());
        opd.setOPDEMREHRTemp(getPointValue());
        opd.setOPDEMREHRSpO2(TwoDigitNo());
        opd.setOPDEMREHRRR(RR());
        opd.setOPDEMREHRPain(pain());
        opd.setOPDEMREHRGlucose(TwoDigitNo());
        opd.setOPDEMREHRWeight(TwoDigitNo());
        opd.setOPDEMREHRHeight(Height());
//CC&HP
        opd.setAssociatedSymptoms("Hematuria (Blood In Urine) ");
        opd.setDurationCCHP("3");
        opd.setDaysCCHP("Days");
        opd.setOnsetCCHP("Sudden");
        opd.setSeverity("Moderate");
        opd.setProgression("Stable");
//Allergy
        opd.setAllergy_Medicine("Latex");
        opd.setAllergenInput("Pinnuts");
        opd.setSeverity("Moderate");
        opd.setAllergy_Reaction("Skin Rash");
//Lab Test
        opd.setLab_Test("Liver Function Test");
        opd.setLab_Specimen("Blood");
        opd.setPriority("Urgent");
        opd.setlabInstruction("Fasting hrs, early morning sample");
//Radiology
        opd.setRad_Test("MRI Brain Plain");
        opd.setradBodyPart("Brain");
        opd.setrad_Indication("fracture");
//Pharmacy -Prescription
        opd.setPharma_Drug("Amlodipine 5mg Tablet");
        opd.setPharma_Dose("650mg");
        opd.setPharma_Type("Capsule");
        opd.setPharma_Route("Oral");
        opd.setPharma_Frequency("1-1");
        opd.setpharmaDuration("7 days");
        opd.setpharmaQuantity("10");
//Procedure
        opd.setProcedure_Input("Foley Catheterization");
        opd.setLaterality("Right arm");
        opd.setIndication("Diagnostic");
//Diet Order
        opd.setDiet_Order("Non-Veg");
        opd.setDiet_MealFrequency("3 times/day");
        opd.setDiet_Calorie("1800 (kcal/day)");
        opd.setDiet_Fluid("1500 (mL/day)");
        opd.setDiet_SpecialInstructions("Low salt, avoid fried foods");
//ADTF Transfer
        opd.setADTFTransferDept("General Medicine");
        opd.setADTF_TransferUnit("General Medicine - Unit A");
        opd.setADTF_TransferDoctor("Dr. Aarav Sharma");
        opd.setADTF_SelectBedWard("Private & Deluxe Inpatient Wing");
        opd.setADTF_TransferReason("Patient requires specialized care in the orthopedic ward.");
        opd.setADTFTransferRemark("Patient has a history of orthopedic issues and needs further evaluation and treatment in the orthopedic ward.");
//ADTF Dicharge
        opd.setEMRDischargeReason("LAMA");
//ADTF Referral
        opd.setEMRReferralType("External");
        opd.setEMRReferralDisposition("Patient is being referred to an external specialist for further evaluation and management of their condition.");
        opd.setEMRReferralRemark("Patient requires specialized care and follow-up with an external specialist to ensure optimal management of their condition.");
        opd.setEMRReferralDepartment("General Medicine");
        opd.setEMRReferralUnit("General Medicine - Unit A");
        opd.setEMRReferralDoctor("Dr. Aarav Sharma");
//Clinical Notes - SOAP
        opd.setSoapSubjectiveInput("Patient presents with complaints of fever, fatigue");
        opd.setSoapObjectiveInput("Vitals: BP 120/80 mmHg, Pulse 80 bpm, Temp 101°F, SpO2 98%, RR 18/min,");
        opd.setSoapAssessmentInput("Working diagnosis: Viral infection, clinical impression: Monitor and manage symptoms");
        opd.setSoapPlanInput("Treatment plan: Prescribe antipyretics, advise rest and hydration, follow-up in 3 days");
        opd.setSoapDoctorInput("Dr. Aarav Sharma");
        opd.setSoapMCIInput("MCI-12345");
        opd.setSoapDepartmentInput("General Medicine");
//Physical Examination
        opd.setphysicalBuiltInput("Well-built and well-nourished");
        opd.setPosture("Comfortable");
        opd.setphysicalPallorInput("Absent");
        opd.setphysicalCyanosisInput("Absent");
        opd.setphysicalIcterusInput("Absent");
        opd.setphysicalLymphadenopathyInput("Absent");
        opd.setphysicalClubbingInput("Absent");
        opd.setphysicalEdemaInput("Absent");
        opd.setphysicalNeurocutaneousMarkersInput("Absent");
//



        // patient.setSalutation("Mrs");
        // patient.setVisitType("Initial Visit");
        // patient.setFirstName(getPatientName());
        // patient.setLastName("Maxwell");
        // patient.setBirthYear(getAgeNo());
        // patient.setGender("Female");
        // patient.setMobile(getMobileNumber());
        // patient.setAge(getAgeNo());
        // patient.setEmail(getEmail());
        // patient.setAddress(getAddresss());
        // patient.setNextToKin("Spouse");
        // patient.setKinsRelation("Family");
        // patient.setKinsContact("John Doe");
        // patient.setKinsAddress("123 Main St, Cityville");
        // patient.setKinsContactNumber("9876543210");
        return opd;
    }
}
