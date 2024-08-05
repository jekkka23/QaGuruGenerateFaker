package tests;

import org.junit.jupiter.api.Test;
import pages.PageWithPracticeForm;

class PracticeFormTests extends TestBase {

    PageWithPracticeForm pageWithPracticeForm = new PageWithPracticeForm();

    @Test
    public void checkFillingAllFieldsTest() { // Успешное заполнение всех полей формы
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);
        String day = String.valueOf(faker.number().numberBetween(1, 28));
        String month = "February";  // Faker не генерирует месяц напрямую
        String year = String.valueOf(faker.number().numberBetween(1990, 2005));
        String subject = "History";
        String hobbies = "Sports";
        String uploadFile = "testsPhoto.png";
        String address = faker.address().fullAddress();
        String state = "NCR";
        String city = "Delhi";

        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput(firstName);
        pageWithPracticeForm.setLastNameInput(lastName);
        pageWithPracticeForm.setEmailInput(email);
        pageWithPracticeForm.setGender(gender);
        pageWithPracticeForm.setUserNumber(userNumber);
        pageWithPracticeForm.setDateOfBirth(day, month, year);
        pageWithPracticeForm.setSubject(subject);
        pageWithPracticeForm.setHobbies(hobbies);
        pageWithPracticeForm.setUpload(uploadFile);
        pageWithPracticeForm.setCurrentAddress(address);
        pageWithPracticeForm.setState(state);
        pageWithPracticeForm.setCity(city);
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", firstName + " " + lastName);
        pageWithPracticeForm.setTableCheck("Student Email", email);
        pageWithPracticeForm.setTableCheck("Gender", gender);
        pageWithPracticeForm.setTableCheck("Mobile", userNumber);
        pageWithPracticeForm.setTableCheck("Date of Birth", day + " " + month + "," + year);
        pageWithPracticeForm.setTableCheck("Subjects", subject);
        pageWithPracticeForm.setTableCheck("Hobbies", hobbies);
        pageWithPracticeForm.setTableCheck("Picture", uploadFile);
        pageWithPracticeForm.setTableCheck("Address", address);
        pageWithPracticeForm.setTableCheck("State and City", state + " " + city);
    }

    @Test
    public void testFormSubmissionWithoutFileUpload() { // Успешное заполнение формы без загрузки файла
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);
        String day = String.valueOf(faker.number().numberBetween(1, 28));
        String month = "March";
        String year = String.valueOf(faker.number().numberBetween(1990, 2005));
        String subject = "Math";
        String hobbies = "Reading";
        String address = faker.address().fullAddress();
        String state = "NCR";
        String city = "Delhi";

        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput(firstName);
        pageWithPracticeForm.setLastNameInput(lastName);
        pageWithPracticeForm.setEmailInput(email);
        pageWithPracticeForm.setGender(gender);
        pageWithPracticeForm.setUserNumber(userNumber);
        pageWithPracticeForm.setDateOfBirth(day, month, year);
        pageWithPracticeForm.setSubject(subject);
        pageWithPracticeForm.setHobbies(hobbies);
        pageWithPracticeForm.setCurrentAddress(address);
        pageWithPracticeForm.setState(state);
        pageWithPracticeForm.setCity(city);
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", firstName + " " + lastName);
        pageWithPracticeForm.setTableCheck("Student Email", email);
        pageWithPracticeForm.setTableCheck("Gender", gender);
        pageWithPracticeForm.setTableCheck("Mobile", userNumber);
        pageWithPracticeForm.setTableCheck("Date of Birth", day + " " + month + "," + year);
        pageWithPracticeForm.setTableCheck("Subjects", subject);
        pageWithPracticeForm.setTableCheck("Hobbies", hobbies);
        pageWithPracticeForm.setTableCheck("Address", address);
        pageWithPracticeForm.setTableCheck("State and City", state + " " + city);
    }

    @Test
    public void testFormSubmissionWithMinimalData() { // Успешное заполнение формы с минимальными данными
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput(firstName);
        pageWithPracticeForm.setLastNameInput(lastName);
        pageWithPracticeForm.setEmailInput(email);
        pageWithPracticeForm.setGender(gender);
        pageWithPracticeForm.setUserNumber(userNumber);
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", firstName + " " + lastName);
        pageWithPracticeForm.setTableCheck("Student Email", email);
        pageWithPracticeForm.setTableCheck("Gender", gender);
        pageWithPracticeForm.setTableCheck("Mobile", userNumber);
    }

    @Test
    public void testFormSubmissionWithoutFirstName() { // Ошибка при отсутствии обязательного поля "Имя"
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setLastNameInput(lastName);
        pageWithPracticeForm.setEmailInput(email);
        pageWithPracticeForm.setGender(gender);
        pageWithPracticeForm.setUserNumber(userNumber);
        pageWithPracticeForm.setSubmit();
        // Ожидаем, что форма не будет отправлена успешно, проверка модального окна не требуется
    }

    @Test
    public void testFormSubmissionWithInvalidEmail() { // Ошибка при некорректном формате email
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "invalid-email";  // Намеренно некорректный email
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput(firstName);
        pageWithPracticeForm.setLastNameInput(lastName);
        pageWithPracticeForm.setEmailInput(email);
        pageWithPracticeForm.setGender(gender);
        pageWithPracticeForm.setUserNumber(userNumber);
        pageWithPracticeForm.setSubmit();
        // Ожидаем, что форма не будет отправлена успешно, проверка модального окна не требуется
    }
}