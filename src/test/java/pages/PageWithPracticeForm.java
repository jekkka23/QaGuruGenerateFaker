package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageWithPracticeForm {

    public static SelenideElement firstNameInput = $("#firstName");
    public static SelenideElement lastNameInput = $("#lastName");
    public static SelenideElement emailInput = $("#userEmail");
    public static SelenideElement genderInput = $("#genterWrapper");
    public static SelenideElement userNumberInput = $("#userNumber");
    public static SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    //public static SelenideElement yearDateInput = $(".react-datepicker__year-select"); //убрал в календарь компонент
    //public static SelenideElement monthDateInput = $(".react-datepicker__month-select"); //убрал в календарь компонент
    //public static SelenideElement dayDateInput = $(".react-datepicker__day--023"); //убрал в календарь компонент
    public static SelenideElement subjectInput = $("#subjectsContainer input");
    public static SelenideElement hobbiesInput = $("#hobbiesWrapper");
    public static SelenideElement uploadFileInput = $("#uploadPicture");
    public static SelenideElement currentAddressInput = $("#currentAddress");
    public static SelenideElement stateInput = $("#state");
    public static SelenideElement cityInput = $("#city");
    public static SelenideElement selectCityAndStateInput = $("#stateCity-wrapper");
    public static SelenideElement submitInput = $("#submit");
    public static SelenideElement assertModalDialogInput = $(".modal-dialog");
    public static SelenideElement assertExampleModalSizeInput = $("#example-modal-sizes-title-lg");
    public static SelenideElement assertTableCheckInput = $(".table-responsive");

    public void openPage() {
        open("/automation-practice-form");
    }

    public PageWithPracticeForm setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PageWithPracticeForm setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PageWithPracticeForm setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PageWithPracticeForm setGender(String value) {
        genderInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    public PageWithPracticeForm setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PageWithPracticeForm setDateOfBirth(String day, String month, String year) { //для даты создал отдельный компонент
        dateOfBirthInput.click();
        CalendarComponent.setBirthDate(day, month, year);
        return this;
    }

    public PageWithPracticeForm setSubject (String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public PageWithPracticeForm setHobbies(String value) {
        hobbiesInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    public PageWithPracticeForm setUpload(String value) {
        uploadFileInput.uploadFromClasspath(value); //работает везде, где есть загрузчик файлов
        return this;
    }

    public PageWithPracticeForm setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public PageWithPracticeForm setState(String value) {
        stateInput.click();
        selectCityAndStateInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    public PageWithPracticeForm setCity(String value) {
        cityInput.click();
        selectCityAndStateInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    public PageWithPracticeForm setSubmit() {
        Selenide.executeJavaScript("arguments[0].click();", submitInput); //Если прокрутка не помогает, можно использовать JavaScript для выполнения клика. Это обойдет любые проблемы с перекрытием.
        //submitInput.click();
        return this;
    }

    public PageWithPracticeForm setModalDialog() { //проверка, что таблица появилась
        assertModalDialogInput.should(appear);
        return this;
    }

    public PageWithPracticeForm setTableHeaderCheck(String value) { //проверка заголовка
        assertExampleModalSizeInput.shouldHave(text(value));
        return this;
    }

    public PageWithPracticeForm setTableCheck(String key, String value) { //проверка заполненности строк в таблице
        assertTableCheckInput.$(byText(key)).parent().shouldHave(text(value));
        return this;
        //resultTable.$(byText(key)): находит элемент в таблице, содержащий текст key
        //.parent(): поднимается на уровень родительского элемента, который содержит как ключ, так и значение
        //.shouldHave(text(value)): проверяет, что родительский элемент содержит текст value
    }



}
