package pages;

import driver.DriverManager;
import hepers.WaitHelper;
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

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']/ul/li")
    private WebElement errorMessage;

//    private String errorMessageXpath = "//div[@class='alert alert-danger alert-dismissible']/ul/li";

    public LoginPage() {
        WebDriver driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void inputEmail(String email) {
        if (!email.isEmpty()) {
            emailInput.sendKeys(email);
        }
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void submit() {
        signInButton.click();
    }

    public String login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();

        WaitHelper.sleep(3);

        return errorMessage.getText();
    }

    public boolean isLoginFailed() {
        return alertDiv.isDisplayed();
    }

}
