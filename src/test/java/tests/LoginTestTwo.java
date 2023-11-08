package tests;

import bases.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestTwo extends BaseTest {

    @Test
    public void testLogin() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        WebDriver driver = DriverManager.getDriver();
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage();

        loginPage.inputEmail("user@lavalite.org");
        loginPage.inputPassword("user@lavalite");
        loginPage.submit();
        Assert.assertEquals(driver.getCurrentUrl(),"https://cms.testlery.com/user");
    }

    @Test
    public void testLoginFailed() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        WebDriver driver = DriverManager.getDriver();

        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage();

        loginPage.inputEmail("user@lavalite.org");
        loginPage.inputPassword("user@lavalite1");
        loginPage.submit();

        Assert.assertTrue(loginPage.isLoginFailed());
    }
}
