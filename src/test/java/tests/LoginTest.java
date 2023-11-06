package tests;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest  extends BaseTest {

    @Test
    public void testLogin() {
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputEmail("user@lavalite.org");
        loginPage.inputPassword("user@lavalite");
        loginPage.submit();
        Assert.assertEquals(driver.getCurrentUrl(),"https://cms.testlery.com/user");
    }

    @Test
    public void testLoginFailed() {
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputEmail("user@lavalite.org");
        loginPage.inputPassword("user@lavalite1");
        loginPage.submit();

        Assert.assertTrue(loginPage.isLoginFailed());
    }
}
