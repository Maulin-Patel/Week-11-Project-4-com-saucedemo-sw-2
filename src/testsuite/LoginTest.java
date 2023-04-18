package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before // JUnit Annotation which will run before every method

    public void setUp() { // calling openBrowser method using baseUrl value
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");// Find username field and provide valid username
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");// Find password field and provide valid password
        driver.findElement(By.xpath("//input[@type='submit']")).click();// Find Login button and click on it
        String expectedText = "PRODUCTS"; //Expected text from requirement
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText().toUpperCase();// Finding text element and converting to uppercase
        Assert.assertEquals("User was not able to login successfully.",expectedText, actualText);//Validating expected and actual text
    }

    @Test

    public void verifyThatSixProductsAreDisplayedOnPage() {

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");// Find username field and provide valid username
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");// Find password field and provide valid password
        driver.findElement(By.xpath("//input[@type='submit']")).click();// Find Login button and click on it
        int expectedNumberOfProducts = 6; // as per Requirement
        int actualNumberOfProducts = driver.findElements(By.className("inventory_item")).size(); // Finding number of products stored in list
        Assert.assertEquals("Different number of products are displayed on the page.",expectedNumberOfProducts, actualNumberOfProducts); // Validating expected and actual number of products
    }

    @After // JUnit Annotation which will run after every method
    public void tearDown() {
        closeBrowser();
    }
}
