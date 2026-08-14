package com.electra.automation.utilities;

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

    // Generate Dynamic First Name (Only Alphabets)
    public static String getPatientName() {

        StringBuilder name = new StringBuilder("Smith");

        for (int i = 0; i < 2; i++) {
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
        return String.format("%.1f", value);
    }

    // Generate Dynamic Height: 140.0 - 200.0 cm
    public static String Height() {
        double height = 140.0 + (random.nextInt(601) / 10.0);
        return String.format("%.1f", height);
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
    // Generate Dynamic BP: 90/60 - 140/90

    public static String BP() {
        int systolic = 90 + random.nextInt(51);   // 90 - 140
        int diastolic = 60 + random.nextInt(31);  // 60 - 90

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

        patient.setCategoryType("General");
        patient.setCategoryID("General");
        patient.setTariff("General");
        // patient.setCategoryType("Staff");
        // patient.setCategoryID("Staff Benefit");
        // patient.setTariff("Staff Patient");
        patient.setDepartment("General Medicine");
        patient.setUnit("General Medicine - Unit A");
        patient.setDoctor("Dr Sarang D Pawar"); //Dr Roshan G
        patient.setSalutation("Mrs");
        patient.setVisitType("Initial Visit");
        patient.setFirstName(getPatientName());
        patient.setLastName("Maxwell");
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
        // patient.setCategoryType("Staff");
        // patient.setCategoryID("Staff Benefit");
        // patient.setTariff("Staff Patient");
        // patient.setDepartment("General Medicine");
        // patient.setUnit("General Medicine - Unit A");
        // patient.setDoctor("Dr Sarang D Pawar"); //Dr Roshan G
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
