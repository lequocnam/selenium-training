package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static final String URL = "https://cms.testlery.com/user/login";

    @FindBy (id = "email")
    private WebElement emailInput;

    @FindBy (id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement alertDiv;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void submit() {
        signInButton.click();
    }

    public boolean isLoginFailed() {
        return alertDiv.isDisplayed();
    }
}
