package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a")
    private WebElement sign_in;

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement create_account_but;

    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
    private WebElement register_information;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement firstname;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement lastname;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    private WebElement register_but;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]")
    private WebElement created_account;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/ul/li[4]/a/span")
    private WebElement myAddressesButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/a/span")
    private WebElement addNewAddressButton;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement addressInput;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement postCodeInput;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobileInput;

    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement addressReferenceInput;

    @FindBy(xpath = "//*[@id=\"submitAddress\"]/span")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/p[1]/strong")
    private WebElement checkingPhraseAddresses;

    public void signIn() {
        sign_in.click();
    }
    public void createAccount(String e_mail) {
        email.clear();
        email.sendKeys(e_mail);
        create_account_but.click();
    }
    public void registerAccount(String first_name, String last_name, String passwd) {
        firstname.clear();
        firstname.sendKeys(first_name);

        lastname.clear();
        lastname.sendKeys(last_name);

        password.clear();
        password.sendKeys(passwd);

        register_but.click();
    }
    public String registerPageInfo() {
        return register_information.getText();
    }
    public String createdAccountInfo() {
        return created_account.getText();
    }
    public void clickAddresses(){
        myAddressesButton.click();
    }
    public void addNewAddress(){
        addNewAddressButton.click();
    }
    public void setClientInfo(String address, String postcode, String city, String mobile, String addressReference){
        addressInput.clear();
        addressInput.sendKeys(address);

        postCodeInput.clear();
        postCodeInput.sendKeys(postcode);

        cityInput.clear();
        cityInput.sendKeys(city);

        mobileInput.clear();
        mobileInput.sendKeys(mobile);

        addressReferenceInput.clear();
        addressReferenceInput.sendKeys(addressReference);

        saveButton.click();
    }
    public String yourAddressesInfo(){
        return checkingPhraseAddresses.getText();
    }
}
