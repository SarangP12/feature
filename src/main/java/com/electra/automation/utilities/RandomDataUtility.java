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
    //generate a random indexNumber
    public static int getRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
    //generate a random index
        public static int getRandomIndex(int size) {


        if(size <= 0) {

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
        patient.setLastName("Doe");
        patient.setBirthYear(getAgeNo());
        patient.setGender("Female");
        patient.setMobile(getMobileNumber());
        patient.setAge(getAgeNo());
        patient.setEmail(getEmail());
        patient.setAddress(getAddresss());
        patient.setNextToKin("Spouse");
        patient.setKinsRelation("Family");
        patient.setKinsContact("John Doe");
        patient.setKinsAddress("123 Main St, Cityville");
        patient.setKinsContactNumber("9876543210");

        return patient;
    }


}
