import chrome.chromeRunner;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class roomsHotels extends chromeRunner {
    @Test
    public void rooms() {
        SoftAssert soft = new SoftAssert();
        $(byText("Welcome to Georgia")).waitUntil(Condition.visible, 1000);
        $(".header__top__nav__item", 0).$(byText("Tbilisi")).click();
        String expectedResult = "Old City. New City.".toUpperCase();
        soft.assertEquals(expectedResult,$("h1").getText());
        $(".menu-toggler__icon").click();
        $(".container").$(byText("Events Calendar")).click();
        $("#type-button").click();
        $("#ui-id-2").click();
        soft.assertEquals("All", $("#type-button").getText());
        $("#from").click();
        $(".ui-datepicker-next").click();
        $(byLinkText("24")).click();
        sleep(500);
        soft.assertEquals("24/06/21",$("#from").getValue());
        sleep(3000);
        soft.assertAll();

    }

}

