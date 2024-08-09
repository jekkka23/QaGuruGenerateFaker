package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageWithPracticeForm {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            //yearDateInput = $(".react-datepicker__year-select"), //убрал в календарь компонент
            //monthDateInput = $(".react-datepicker__month-select"), //убрал в календарь компонент
            //dayDateInput = $(".react-datepicker__day--023"), //убрал в календарь компонент
            subjectInput = $("#subjectsContainer input"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            selectCityAndStateInput = $("#stateCity-wrapper"),
            submitInput = $("#submit"),
            assertModalDialogInput = $(".modal-dialog"),
            assertExampleModalSizeInput = $("#example-modal-sizes-title-lg"),
            assertTableCheckInput = $(".table-responsive");


    @Step("Открыть страницу формы")
    public PageWithPracticeForm openPage() {
        open("/automation-practice-form");
        removeBannersAndFooter();
        return this;
    }

    @Step("Установить имя: {value}")
    public PageWithPracticeForm setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Установить фамилию: {value}")
    public PageWithPracticeForm setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Установить email: {value}")
    public PageWithPracticeForm setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Установить пол: {value}")
    public PageWithPracticeForm setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    @Step("Установить номер телефона: {value}")
    public PageWithPracticeForm setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Установить дату рождения: день {day}, месяц {month}, год {year}")
    public PageWithPracticeForm setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        CalendarComponent.setBirthDate(day, month, year);
        return this;
    }

    @Step("Установить предмет: {value}")
    public PageWithPracticeForm setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Установить хобби: {value}")
    public PageWithPracticeForm setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    @Step("Загрузить файл: {value}")
    public PageWithPracticeForm setUpload(String value) {
        uploadFileInput.uploadFromClasspath(value);
        return this;
    }

    @Step("Установить текущий адрес: {value}")
    public PageWithPracticeForm setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Установить штат: {value}")
    public PageWithPracticeForm setState(String value) {
        removeBannersAndFooter();
        Selenide.executeJavaScript("window.scrollBy(0,500);"); //делаем прокрутку ОБЯЗАТЕЛЬНО
        stateInput.click();
        selectCityAndStateInput.$(byText(value)).click();
        return this;
    }

    @Step("Установить город: {value}")
    public PageWithPracticeForm setCity(String value) {
        removeBannersAndFooter();
        cityInput.click();
        selectCityAndStateInput.$(byText(value)).click();
        return this;
    }

    @Step("Нажать кнопку отправки")
    public PageWithPracticeForm setSubmit() {
        removeBannersAndFooter();
        Selenide.executeJavaScript("arguments[0].click();", submitInput); //Если прокрутка не помогает, можно использовать JavaScript для выполнения клика. Это обойдет любые проблемы с перекрытием.
        return this;
    }

    @Step("Проверить, что модальное окно появилось")
    public PageWithPracticeForm setModalDialog() {
        assertModalDialogInput.should(appear);
        return this;
    }

    @Step("Проверить заголовок таблицы: {value}")
    public PageWithPracticeForm setTableHeaderCheck(String value) {
        assertExampleModalSizeInput.shouldHave(text(value));
        return this;
    }

    @Step("Проверить строку в таблице: ключ {key}, значение {value}")
    public PageWithPracticeForm setTableCheck(String key, String value) {
        assertTableCheckInput.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    private void removeBannersAndFooter() { //МЕТОД, КОТОРЫЙ УБИРАЕТ ВСЕ БАННЕРЫ, НУЖНО СВЫВОДИТЬ В ОТДЕЛЬНЫЙ КЛАСС И ДОБАЛЯТЬ В OPEN
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
    }
}
