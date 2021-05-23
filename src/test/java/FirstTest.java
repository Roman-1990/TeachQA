import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {


    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void TeachingSubmitTest() {
        open("https://demoqa.com/automation-practice-form");

        //Data entry
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Kudinov");
        $("#userEmail").setValue("auto@auto.ru");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("9169999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label='Choose Monday, April 30th, 1990']").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Merrut").pressEnter();
        $("#submit").click();

        // Result

        $(".table-responsive").shouldHave(text("Roman Kudinov"), text("auto@auto.ru"),
                text("Male"), text("9169999999"), text("30 April,1990"),
                text("Uttar Pradesh Merrut"));
    }
}







