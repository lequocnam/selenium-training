package tests;

import bases.BaseTest;
import driver.DriverManager;
import hepers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementNotInteractableException;



public class WaitTest extends BaseTest {
//    @Test
    public void testSleep() {
        WaitHelper.sleep(10);
    }
    @Test (priority = 1)
    public void testImplicit() {
        WebDriver driver = DriverManager.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();

        WebElement added = driver.findElement(By.id("box0"));

        Assert.assertEquals("redbox", added.getDomAttribute("class"));
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }
    @Test (priority = 0)
    public void testExplicit() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
        WebElement a = wait.until(ExpectedConditions.elementToBeClickable(By.id("box0")));

        driver.findElement(By.id("nam")).click();
    }
    @Test (priority = 2)
    public void testFluent() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement revealed = driver.findElement(By.id("revealed"));
        driver.findElement(By.id("nam")).click();

        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        wait.until(
                d -> {
                    revealed.sendKeys("Displayed");
                    return true;
                });

        Assert.assertEquals("Displayed", revealed.getDomProperty("value"));
    }
}
