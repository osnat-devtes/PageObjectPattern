package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddingToBasketPage;

import java.util.concurrent.TimeUnit;

public class AddingToBasketTest {
    public static WebDriver driver;

    @Before
    public void setUp(){
            System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get(" https://hotel-testlab.coderslab.pl/en/");
    }
    @Test
    public void addingToBasketTest(){
        AddingToBasketPage addingToBasketPage = new AddingToBasketPage(driver);
        addingToBasketPage.signIn();
        Assert.assertEquals("ALREADY REGISTERED?", addingToBasketPage.registeredPageInfo());
        addingToBasketPage.userLogIn("nowak@op.com", "nowak123");
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
                              addingToBasketPage.loginPageInfo());
        addingToBasketPage.clickAddresses();
        addingToBasketPage.addNewAddress();
        addingToBasketPage.setClientInfo("ul.Kwiatowa, 12/3", "60000", "Gdansk",
               "123456789", "Address1");
        Assert.assertEquals("Your addresses are listed below.", addingToBasketPage.yourAddressesInfo());
        addingToBasketPage.returnToMainPage();
        addingToBasketPage.searchHotel("Warsaw", "26-11-2021", "30-11-2021");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addingToBasketPage.roomsQuantityBook("2");
        addingToBasketPage.proceedToCheckout();
        addingToBasketPage.termsOfService();
        addingToBasketPage.paymentChoice();
        addingToBasketPage.confirmOrder();
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
}
