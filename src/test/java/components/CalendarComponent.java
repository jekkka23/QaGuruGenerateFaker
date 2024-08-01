package components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public static void setBirthDate(String day, String month, String year) { //говорю, что дату буду передавать с помощью строк дня месяца и года

        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOption(month);
        $("#dateOfBirth").$(".react-datepicker__month").find(byText(day)).click();


    }
}