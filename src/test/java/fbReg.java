import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class fbReg {
    @Test
    public void homeWork5() throws IOException, BiffException {
        String FilePath = "files\\forEmail.xls";
        FileInputStream fs = new FileInputStream(FilePath);
        Workbook wb = Workbook.getWorkbook(fs);
        Sheet sheet = wb.getSheet("Sheet1");
        int totalNoOfRows = sheet.getRows();

        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
        Configuration.startMaximized = true;


        Selenide.open("https://www.facebook.com//");
        $("._6ltg",1).click();
        $(byName("firstname")).sendKeys("სახელი");
        $(byName("lastname")).sendKeys("gvari");

        for (int row = 0; row < totalNoOfRows; row++) {
            $(byName("reg_email__")).setValue(sheet.getCell(1,row).getContents());
            sleep(500);
        }
        $("#password_step_input").sendKeys("password123");
        $("#month").selectOption("Jan");
        $("#day").selectOption("6");
        $("#year").selectOption("1992");
        $("._58mt", 2).click();
        $(byName("preferred_pronoun")).selectOption("She: \"Wish her a happy birthday!\"");
        $("._58mt", 0).click();
        sleep(5000);


    }
}
