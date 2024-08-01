package tests;

import org.junit.jupiter.api.Test;
import pages.PageWithPracticeForm;

class PracticeFormTests extends TestBase {

    PageWithPracticeForm pageWithPracticeForm = new PageWithPracticeForm();

    @Test
    public void checkFillingAllFieldsTest() { //Успешное заполнение всех полей формы
        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput("Evgeny");
        pageWithPracticeForm.setLastNameInput("Mihailov");
        pageWithPracticeForm.setEmailInput("jekkka23@mail.ru");
        pageWithPracticeForm.setGender("Female");
        pageWithPracticeForm.setUserNumber("1111111111");
        pageWithPracticeForm.setDateOfBirth("23", "February", "1995");
        pageWithPracticeForm.setSubject("History");
        pageWithPracticeForm.setHobbies("Sports");
        pageWithPracticeForm.setUpload("testsPhoto.png");
        pageWithPracticeForm.setCurrentAddress("Russia");
        pageWithPracticeForm.setState("NCR");
        pageWithPracticeForm.setCity("Delhi");
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", "Evgeny Mihailov");
        pageWithPracticeForm.setTableCheck("Student Email", "jekkka23@mail.ru");
        pageWithPracticeForm.setTableCheck("Gender", "Female");
        pageWithPracticeForm.setTableCheck("Mobile", "1111111111");
        pageWithPracticeForm.setTableCheck("Date of Birth", "23 February,1995");
        pageWithPracticeForm.setTableCheck("Subjects", "History");
        pageWithPracticeForm.setTableCheck("Hobbies", "Sports");
        pageWithPracticeForm.setTableCheck("Picture", "testsPhoto.png");
        pageWithPracticeForm.setTableCheck("Address", "Russia");
        pageWithPracticeForm.setTableCheck("State and City", "NCR Delhi");
    }

    @Test
    public void testFormSubmissionWithoutFileUpload() { //Успешное заполнение формы без загрузки файла
        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput("Anna");
        pageWithPracticeForm.setLastNameInput("Ivanova");
        pageWithPracticeForm.setEmailInput("anna@mail.ru");
        pageWithPracticeForm.setGender("Female");
        pageWithPracticeForm.setUserNumber("2222222222");
        pageWithPracticeForm.setDateOfBirth("15", "March", "1990");
        pageWithPracticeForm.setSubject("Math");
        pageWithPracticeForm.setHobbies("Reading");
        pageWithPracticeForm.setCurrentAddress("Russia");
        pageWithPracticeForm.setState("NCR");
        pageWithPracticeForm.setCity("Delhi");
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", "Anna Ivanova");
        pageWithPracticeForm.setTableCheck("Student Email", "anna@mail.ru");
        pageWithPracticeForm.setTableCheck("Gender", "Female");
        pageWithPracticeForm.setTableCheck("Mobile", "2222222222");
        pageWithPracticeForm.setTableCheck("Date of Birth", "15 March,1990");
        pageWithPracticeForm.setTableCheck("Subjects", "Math");
        pageWithPracticeForm.setTableCheck("Hobbies", "Reading");
        pageWithPracticeForm.setTableCheck("Address", "Russia");
        pageWithPracticeForm.setTableCheck("State and City", "NCR Delhi");
    }

    @Test
    public void testFormSubmissionWithMinimalData() { //Успешное заполнение формы с минимальными данными
        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput("John");
        pageWithPracticeForm.setLastNameInput("Doe");
        pageWithPracticeForm.setEmailInput("john.doe@mail.com");
        pageWithPracticeForm.setGender("Male");
        pageWithPracticeForm.setUserNumber("3333333333");
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", "John Doe");
        pageWithPracticeForm.setTableCheck("Student Email", "john.doe@mail.com");
        pageWithPracticeForm.setTableCheck("Gender", "Male");
        pageWithPracticeForm.setTableCheck("Mobile", "3333333333");
    }

    @Test
    public void testFormSubmissionWithoutFirstName() { //Ошибка при отсутствии обязательного поля "Имя"
        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setLastNameInput("Doe");
        pageWithPracticeForm.setEmailInput("john.doe@mail.com");
        pageWithPracticeForm.setGender("Male");
        pageWithPracticeForm.setUserNumber("3333333333");
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", "John Doe");
        pageWithPracticeForm.setTableCheck("Student Email", "john.doe@mail.com");
        pageWithPracticeForm.setTableCheck("Gender", "Male");
        pageWithPracticeForm.setTableCheck("Mobile", "3333333333");
    }

    @Test
    public void testFormSubmissionWithInvalidEmail() { //Ошибка при некорректном формате email
        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput("John");
        pageWithPracticeForm.setLastNameInput("Doe");
        pageWithPracticeForm.setEmailInput("john.doe@mail");
        pageWithPracticeForm.setGender("Male");
        pageWithPracticeForm.setUserNumber("3333333333");
        pageWithPracticeForm.setSubmit();
        pageWithPracticeForm.setModalDialog();
        pageWithPracticeForm.setTableHeaderCheck("Thanks for submitting the form");
        pageWithPracticeForm.setTableCheck("Student Name", "John Doe");
        pageWithPracticeForm.setTableCheck("Student Email", "john.doe@mail.com");
        pageWithPracticeForm.setTableCheck("Gender", "Male");
        pageWithPracticeForm.setTableCheck("Mobile", "3333333333");


    }
}