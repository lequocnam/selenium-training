package tests;

import bases.BaseTest;
import driver.DriverManager;
import hepers.WaitHelper;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {
    @Test
    public void testSignUp() {

        SignUpPage signUpPage = new SignUpPage();
        DriverManager.getDriver().get(SignUpPage.URL);
        WaitHelper.sleep(3);
        signUpPage.signUp();
    }
}
