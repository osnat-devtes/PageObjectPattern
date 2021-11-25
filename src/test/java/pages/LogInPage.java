package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends RegisterPage{
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a")
    private WebElement sign_in;

    @FindBy(xpath = "//*[@id=\"login_form\"]/h3")
    private WebElement already_registered;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailLogin;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement passwordLogin;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    private WebElement signin_but;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement logged_in;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[2]/button")
    private WebElement menu;

    @FindBy(xpath = "//*[@id=\"menu_cont\"]/div/div/div[2]/ul[1]/li[1]/a")
    private WebElement returning_main_page;

    @FindBy(xpath = "//*[@id=\"hotel_location\"]")
    private WebElement hotel_location ;

    @FindBy(xpath = "//*[@id=\"check_in_time\"]")
    private WebElement check_in;

    @FindBy(xpath = "//*[@id=\"check_out_time\"]")
    private WebElement check_out;

    @FindBy(xpath = "//*[@id=\"search_hotel_block_form\"]/div[2]/div/button")
    private WebElement select_hotel;

    @FindBy(xpath = "//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li")
    private WebElement hotel_prime;

    @FindBy(xpath = "//*[@id=\"search_room_submit\"]")
    private WebElement search_hotel;

    public LogInPage(WebDriver driver){
        super(driver);
    }
    public void signIn() {
        sign_in.click();
    }

    public String registeredPageInfo(){
        return already_registered.getText();
    }

    public void userLogIn(String email_login, String password_login){
        emailLogin.clear();
        emailLogin.sendKeys(email_login);

        passwordLogin.clear();
        passwordLogin.sendKeys(password_login);

        signin_but.click();
    }
    public String loginPageInfo(){
        return logged_in.getText();
    }
    public void returnToMainPage(){
        menu.click();
        returning_main_page.click();
    }

    public void searchHotel(String location, String checkin, String checkout){
        hotel_location.clear();
        hotel_location.sendKeys(location);
        select_hotel.click();
        hotel_prime.click();
        //format daty: 26-11-2021
        check_in.sendKeys(checkin);
        check_out.sendKeys(checkout);
        search_hotel.click();
    }
}

