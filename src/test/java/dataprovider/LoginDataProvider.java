package dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider (name = "login-success-data")
    public Object[][] loginSucecssData() {
        return new Object[][] {
            {"nam@example.com", "12345678", "These credentials do not match our records."},
//            {"nam@example1.com", "12345678", "",}
        };
    }
}
