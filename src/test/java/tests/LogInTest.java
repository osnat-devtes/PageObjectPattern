package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class LogInTest {
    public static WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(" https://hotel-testlab.coderslab.pl/en/");
    }
    @Test
    public void logInTest(){
        LogInPage userLogin = new LogInPage(driver);
        userLogin.signIn();
        Assert.assertEquals("ALREADY REGISTERED?", userLogin.registeredPageInfo());
        userLogin.userLogIn("nowak@op.com", "nowak123");
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", userLogin.loginPageInfo());
        userLogin.returnToMainPage();
        userLogin.searchHotel("Warsaw", "26-11-2021", "30-11-2021");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
