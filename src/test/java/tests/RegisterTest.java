package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    private static WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get(" https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void createNewAccountTest(){
        RegisterPage userRegister = new RegisterPage(driver);
        userRegister.signIn();
        userRegister.createAccount("nowak25@op.com");
        Assert.assertEquals("YOUR PERSONAL INFORMATION",userRegister.registerPageInfo());
        userRegister.registerAccount("Nata", "Nowak", "nowak123");
        Assert.assertEquals("Your account has been created.", userRegister.createdAccountInfo());

        userRegister.clickAddresses();
        userRegister.addNewAddress();
        userRegister.setClientInfo("ul.Kwiatowa, 12/3", "60000", "Gdansk",
                "123456789", "Address1");
        Assert.assertEquals("Your addresses are listed below.", userRegister.yourAddressesInfo());
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
}
