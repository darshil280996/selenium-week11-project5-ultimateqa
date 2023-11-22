package ultimateqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.get("https://courses.ultimateqa.com/");
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        WebElement welcomeText = driver.findElement(By.xpath("//h3[text()='Welcome Back!']"));
        Assert.assertTrue(welcomeText.isDisplayed());
    }

    @Test
    public void verifyTheErrorMessage() {
        // Implement your test steps for this scenario
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginbtn"));

        // Enter invalid username and password
        usernameField.sendKeys("invalidUsername");
        passwordField.sendKeys("invalidPassword");
        loginButton.click();

        // Verify the error message
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Invalid email or password.')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}

