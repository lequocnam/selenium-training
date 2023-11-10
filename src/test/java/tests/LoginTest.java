package tests;

import bases.BaseTest;
import dataprovider.LoginDataProvider;
import driver.DriverManager;
import hepers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest  extends BaseTest {


    @Test (priority = -1, groups = {"login-2"})
    public void testLoginSuccess() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage();

        loginPage.inputEmail("user@lavalite.org");
        loginPage.inputPassword("user@lavalite");
        loginPage.submit();
        Assert.assertEquals(driver.getCurrentUrl(),"https://cms.testlery.com/user");
    }

    @Test (dataProvider = "login-success-data", dataProviderClass = LoginDataProvider.class, groups = {"login-success"}, priority = 1)
    public void testLoginFailed(String username, String password, String errorMessage) {
        WebDriver driver = DriverManager.getDriver();
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage();

        String message = loginPage.login(username, password);
        if (driver.getCurrentUrl().equals(LoginPage.URL))
        {
            Assert.assertEquals(errorMessage, message);
        } else {
            Assert.fail();
        }
    }

    @Test(priority = 0, groups = {"login-success"}, timeOut = 5000)
    public void testNegativePriority() {

    }
}
