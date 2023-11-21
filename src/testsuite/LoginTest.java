package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Enter the username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Thread.sleep(5000);
        //Enter the password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(5000);
        //Click on Login
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        Thread.sleep(5000);
        //Verify the text
//
        String expectedText = "Secure Area";
        WebElement actualText = driver.findElement(By.xpath("//h2"));
        String actualResult = actualText.getText();
        Assert.assertEquals(expectedText  , actualResult);
    }

    @Test
    public void verifyTheUsernameErrorMessage() throws InterruptedException {
        //Enter the username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        Thread.sleep(5000);
        //Enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(5000);
        //Click on login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        //Verify the Error message
        String expectedText = "Your username is invalid!\n×";
        WebElement actualText = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualResult = actualText.getText();
        Assert.assertEquals(expectedText , actualResult);
    }

    @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {
        //Enter the username
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(5000);
        //Enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(5000);
        //Click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        Thread.sleep(5000);
        //Verify the Error message
        String expectedText = "Your password is invalid!\n×";
        WebElement actualText = driver.findElement(By.id("flash"));
        String actualResult = actualText.getText();
        Assert.assertEquals(expectedText , actualResult);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
