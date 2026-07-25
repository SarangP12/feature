package com.electra.automation.utilities;
import java.util.Random;
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

        StringBuilder name = new StringBuilder("AutoPatient");

        for (int i = 0; i < 5; i++) {
            name.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }

        return name.toString();
    }

    // public static String getPatientName() {

    //     // return "AutoPatient" + System.currentTimeMillis();
    //         return "AutoPatient_" +
    //         System.currentTimeMillis() +
    //         "_" +
    //         random.nextInt(1000);
    // }

    // Generate Dynamic Mobile Number
    public static String getMobileNumber() {
        return "9" + (100000000 + random.nextInt(900000000));
    }

    // Generate Dynamic Email
    public static String getEmail() {
        return "auto" + System.currentTimeMillis() + "@gmail.com";
    }

    // Generate Complete Patient Object
    public static PatientData generatePatient() {

        PatientData patient = new PatientData();

        patient.setCategoryType("Staff");
        patient.setCategoryID("Staff Benefit");
        patient.setTariff("Staff Patient");
        patient.setSalutation("Mrs.");
        patient.setFirstName(getPatientName());
        patient.setLastName("Agnihotri");
        patient.setBirthYear("99");
        patient.setMobile(getMobileNumber());
        patient.setEmail(getEmail());
        patient.setAddress("118 Main St, Roing");

        // Uncomment if PatientData has Email field
        // patient.setEmail(getEmail());

        return patient;
    }


}
