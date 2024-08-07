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

        pageWithPracticeForm.openPage()

                            .setFirstNameInput(firstName)
                            .setLastNameInput(lastName)
                            .setEmailInput(email)
                            .setGender(gender)
                            .setUserNumber(userNumber)
                            .setDateOfBirth(day, month, year)
                            .setSubject(subject)
                            .setHobbies(hobbies)
                            .setUpload(uploadFile)
                            .setCurrentAddress(address)
                            .setState(state)
                            .setCity(city)
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", firstName + " " + lastName)
                            .setTableCheck("Student Email", email)
                            .setTableCheck("Gender", gender)
                            .setTableCheck("Mobile", userNumber)
                            .setTableCheck("Date of Birth", day + " " + month + "," + year)
                            .setTableCheck("Subjects", subject)
                            .setTableCheck("Hobbies", hobbies)
                            .setTableCheck("Picture", uploadFile)
                            .setTableCheck("Address", address)
                            .setTableCheck("State and City", state + " " + city);
    }

    @Test
    public void FormSubmissionWithoutFileUploadTest() { // Успешное заполнение формы без загрузки файла
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

        pageWithPracticeForm.openPage()

                            .setFirstNameInput(firstName)
                            .setLastNameInput(lastName)
                            .setEmailInput(email)
                            .setGender(gender)
                            .setUserNumber(userNumber)
                            .setDateOfBirth(day, month, year)
                            .setSubject(subject)
                            .setHobbies(hobbies)
                            .setCurrentAddress(address)
                            .setState(state)
                            .setCity(city)
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", firstName + " " + lastName)
                            .setTableCheck("Student Email", email)
                            .setTableCheck("Gender", gender)
                            .setTableCheck("Mobile", userNumber)
                            .setTableCheck("Date of Birth", day + " " + month + "," + year)
                            .setTableCheck("Subjects", subject)
                            .setTableCheck("Hobbies", hobbies)
                            .setTableCheck("Address", address)
                            .setTableCheck("State and City", state + " " + city);
    }

    @Test
    public void FormSubmissionWithMinimalDataTest() { // Успешное заполнение формы с минимальными данными
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        pageWithPracticeForm.openPage()

                            .setFirstNameInput(firstName)
                            .setLastNameInput(lastName)
                            .setEmailInput(email)
                            .setGender(gender)
                            .setUserNumber(userNumber)
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", firstName + " " + lastName)
                            .setTableCheck("Student Email", email)
                            .setTableCheck("Gender", gender)
                            .setTableCheck("Mobile", userNumber);
    }

    @Test
    public void FormSubmissionWithoutFirstNameTest() { // Ошибка при отсутствии обязательного поля "Имя"
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        pageWithPracticeForm.openPage()

                            .setLastNameInput(lastName)
                            .setEmailInput(email)
                            .setGender(gender)
                            .setUserNumber(userNumber)
                            .setSubmit();
        // Ожидаем, что форма не будет отправлена успешно, проверка модального окна не требуется
    }

    @Test
    public void FormSubmissionWithInvalidEmailTest() { // Ошибка при некорректном формате email
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "invalid-email";  // Намеренно некорректный email
        String gender = faker.demographic().sex();
        String userNumber = faker.phoneNumber().subscriberNumber(10);

        pageWithPracticeForm.openPage()

                            .setFirstNameInput(firstName)
                            .setLastNameInput(lastName)
                            .setEmailInput(email)
                            .setGender(gender)
                            .setUserNumber(userNumber)
                            .setSubmit();
        // Ожидаем, что форма не будет отправлена успешно, проверка модального окна не требуется
    }
}