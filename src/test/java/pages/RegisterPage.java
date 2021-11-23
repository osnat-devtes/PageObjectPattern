package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a")
    private WebElement sign_in;

    @FindBy(xpath="//*[@id=\"email_create\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement create_account_but;

    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
    private WebElement register_information;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement firstname;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement lastname;

    @FindBy(xpath  = "//*[@id=\"passwd\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    private WebElement register_but;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]")
    private WebElement created_account;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void createAccount(String e_mail){
        sign_in.click();
        email.clear();
        email.sendKeys(e_mail);
        create_account_but.click();
    }
    public void registerAccount(String first_name, String last_name, String passwd){
        firstname.clear();
        firstname.sendKeys(first_name);

        lastname.clear();
        lastname.sendKeys(last_name);

        password.clear();
        password.sendKeys(passwd);

        register_but.click();
    }
    public String registerPageInfo(){
        return register_information.getText();
    }
    public String createdAccountInfo(){
        return created_account.getText();
    }
}