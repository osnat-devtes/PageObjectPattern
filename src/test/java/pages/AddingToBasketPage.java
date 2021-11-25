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

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a/span")
    private WebElement paymentByBankButton;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement termsOfServiceCheck;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    private WebElement orderConfirmationButton;

    public void roomsQuantityBook(String quantity){
        roomsQuantityInput.clear();
        roomsQuantityInput.sendKeys(quantity);

        bookNowButton.click();
    }
    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }
    public void paymentChoice(){
        paymentByBankButton.click();
    }
    public void termsOfService(){
        termsOfServiceCheck.click();
    }
    public void confirmOrder(){
        orderConfirmationButton.click();
    }
}
