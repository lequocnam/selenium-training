package pages;

import driver.DriverManager;
import hepers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage {
    public static final String URL = "https://demo.automationtesting.in/Register.html";

    @FindBy(xpath = "//div[@id='msdd']")
    private WebElement multiSelectLanguageInput;

    public SignUpPage() {
        WebDriver driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void signUp() {
        WebDriver driver = DriverManager.getDriver();
        multiSelectLanguageInput.click();

        WaitHelper.sleep(2);

        List<WebElement> listSelect = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));

        listSelect.forEach(element -> {
            String text = element.findElement(By.tagName("a")).getText();
            System.out.println(text);
            if (text.equals("Vietnamese")) {
                element.findElement(By.tagName("a")).click();
            }
        });

        WaitHelper.sleep(5);
    }
}
