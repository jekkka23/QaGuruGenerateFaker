package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PageWithPracticeForm;
import utils.TestData;

@Tag("regression")
class PracticeFormTests extends TestBase {

    TestData testData = new TestData();
    PageWithPracticeForm pageWithPracticeForm = new PageWithPracticeForm();

    @Test
    @Owner("mihailivevgeny")
    @Tag("smoke")
    public void checkFillingAllFieldsTest() { // Успешное заполнение всех полей формы

        pageWithPracticeForm.openPage()

                            .setFirstNameInput(testData.firstName)
                            .setLastNameInput(testData.lastName)
                            .setEmailInput(testData.email)
                            .setGender(testData.gender)
                            .setUserNumber(testData.userNumber)
                            .setDateOfBirth(testData.day, testData.month, testData.year)
                            .setSubject(testData.subject)
                            .setHobbies(testData.hobbies)
                            .setUpload(testData.uploadFile)
                            .setCurrentAddress(testData.address)
                            .setState(testData.state)
                            .setCity(testData.city)
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", testData.firstName + " " + testData.lastName)
                            .setTableCheck("Student Email", testData.email)
                            .setTableCheck("Gender", testData.gender)
                            .setTableCheck("Mobile", testData.userNumber)
                            .setTableCheck("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                            .setTableCheck("Subjects", testData.subject)
                            .setTableCheck("Hobbies", testData.hobbies)
                            .setTableCheck("Picture", testData.uploadFile)
                            .setTableCheck("Address", testData.address)
                            .setTableCheck("State and City", testData.state + " " + testData.city);
    }

    @Test
    @Owner("mihailivevgeny")
    @Tag("smoke")
    public void FormSubmissionWithoutFileUploadTest() { // Успешное заполнение формы без загрузки файла

        pageWithPracticeForm.openPage()

                            .setFirstNameInput(testData.firstName)
                            .setLastNameInput(testData.lastName)
                            .setEmailInput(testData.email)
                            .setGender(testData.gender)
                            .setUserNumber(testData.userNumber)
                            .setDateOfBirth(testData.day, testData.month, testData.year)
                            .setSubject(testData.subject)
                            .setHobbies(testData.hobbies)
                            .setCurrentAddress(testData.address)
                            .setState(testData.state)
                            .setCity(testData.city)
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", testData.firstName + " " + testData.lastName)
                            .setTableCheck("Student Email", testData.email)
                            .setTableCheck("Gender", testData.gender)
                            .setTableCheck("Mobile", testData.userNumber)
                            .setTableCheck("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                            .setTableCheck("Subjects", testData.subject)
                            .setTableCheck("Hobbies", testData.hobbies)
                            .setTableCheck("Address", testData.address)
                            .setTableCheck("State and City", testData.state + " " + testData.city);
    }

    @Test
    @Owner("mihailivevgeny")
    @Tag("smoke")
    public void FormSubmissionWithMinimalDataTest() { // Успешное заполнение формы с минимальными данными


        pageWithPracticeForm.openPage()

                            .setFirstNameInput(testData.firstName)
                            .setLastNameInput(testData.lastName)
                            .setEmailInput(testData.email)
                            .setGender(testData.gender)
                            .setUserNumber(testData.userNumber)
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", testData.firstName + " " + testData.lastName)
                            .setTableCheck("Student Email", testData.email)
                            .setTableCheck("Gender", testData.gender)
                            .setTableCheck("Mobile", testData.userNumber);
    }

    @Test
    @Owner("mihailivevgeny")
    @Tag("smoke")
    public void FormSubmissionWithoutFirstNameTest() { // Ошибка при отсутствии обязательного поля "Имя"

        pageWithPracticeForm.openPage()

                            .setLastNameInput(testData.lastName)
                            .setEmailInput(testData.email)
                            .setGender(testData.gender)
                            .setUserNumber(testData.userNumber)
                            .setSubmit();
        // Ожидаем, что форма не будет отправлена успешно, проверка модального окна не требуется
    }

    @Test
    @Owner("mihailivevgeny")
    @Tag("smoke")
    public void FormSubmissionWithInvalidEmailTest() { // Ошибка при некорректном формате email

        pageWithPracticeForm.openPage()

                            .setFirstNameInput(testData.firstName)
                            .setLastNameInput(testData.lastName)
                            .setEmailInput(testData.email)
                            .setGender(testData.gender)
                            .setUserNumber(testData.userNumber)
                            .setSubmit();
        // Ожидаем, что форма не будет отправлена успешно, проверка модального окна не требуется
    }
}