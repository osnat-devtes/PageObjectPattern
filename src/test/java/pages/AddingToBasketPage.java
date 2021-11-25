package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingToBasketPage extends LogInPage{

    public AddingToBasketPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"cat_quantity_wanted_9\"]")
    private WebElement roomsQuantityInput;

    @FindBy(xpath = "//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a")
    private WebElement bookNowButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/a/span")
    private WebElement proceedToCheckoutButton;

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

    @FindBy(xpath = "//*[@id=\"advanced-payment\"]/div[3]/button")
    private WebElement paymentButton;

    public void roomsQuantityBook(String quantity){
        roomsQuantityInput.clear();
        roomsQuantityInput.sendKeys(quantity);

        bookNowButton.click();
    }
    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
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
    public void paymentAccept(){
        paymentButton.click();
    }
}
