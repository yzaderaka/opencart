package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class Header extends CommonMethods {
    public Header() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    public WebElement myAccount;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement register;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    public WebElement login;

    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    public WebElement currencySelector;

    @FindBy(xpath = "//button[contains(text(),'€ Euro')]")
    public WebElement euros;

    @FindBy(xpath = "//button[normalize-space()='£ Pound Sterling']")
    public WebElement pounds;

    @FindBy(xpath = "//button[normalize-space()='$ US Dollar']")
    public WebElement dollars;

    @FindBy(xpath = "//i[@class='fa fa-heart']")
    public WebElement wishList;

    @FindBy(xpath = "//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//i[@class='fa fa-share']")
    public WebElement checkout;
}
