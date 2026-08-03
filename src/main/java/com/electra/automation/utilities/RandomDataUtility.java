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

        StringBuilder name = new StringBuilder("Auto");

        for (int i = 0; i < 2; i++) {
            name.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }

        return name.toString();
    }
    // Generate Dynamic Mobile Number
    public static String getMobileNumber() {
        return "9" + (100000000 + random.nextInt(900000000));
    }
    // Generate Dynamic Age Number
    public static String getAgeNo() {
        return String.valueOf(12 + random.nextInt(63)); // 18 to 80
}
// Generate Dynamic Email
public static String getEmail() {
    return "Auto" + (10 + random.nextInt(90)) + "@gmail.com";
}
// Generate Dynamic Address
public static String getAddresss() {
    int houseNo = 1 + random.nextInt(9999);
    return "House No. " + houseNo + ", MG Road, Pune, Maharashtra";
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
        patient.setDoctor("Dr Roshan G");
        patient.setSalutation("Mrs");
        patient.setVisitType("Initial Visit");
        patient.setFirstName(getPatientName());
        patient.setLastName("Agnihotri");
        patient.setBirthYear(getAgeNo());
        patient.setGender("Female");
        patient.setMobile(getMobileNumber());
        patient.setAge(getAgeNo());
        patient.setEmail(getEmail());
        patient.setAddress(getAddresss());

        return patient;
    }


}
