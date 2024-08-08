package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en-US"));
    public String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            gender = getRandomGender(),
            userNumber = getRandomMobilePhone(),
            month = getRandomMonth(),
            year = getRandomYear(),
            day = getRandomDay(),
            subject = getRandomSubject(),
            hobbies = getRandomHobbies(),
            uploadFile = getRandomFile(),
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);


    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String getRandomMobilePhone() {
        return faker.number().digits(10);
    }

    public static String getRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getRandomMonth() {
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(month);
    }

    public static String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1950, 2012));
    }

    public static String getRandomSubject() {
        return faker.options().option("English", "Maths", "Arts", "Hindi", "History");
    }

    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {
        String city = "";
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomFile() {
        return faker.options().option("testsPhoto.png");
    }

}
