package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;



public class AccountPage extends CommonMethods {
    public AccountPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement confirmLogout;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Edit Account']")
    public WebElement editAccount;

    @FindBy(xpath = "//a[normalize-space()='Password']")
    public WebElement changePassword;

    @FindBy(xpath = "//a[normalize-space()='Address Book']")
    public WebElement addressBook;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Wish List']")
    public WebElement wishList;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Order History']")
    public WebElement orderHistory;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Downloads']")
    public WebElement downloads;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Recurring payments']")
    public WebElement recurringPayments;

    @FindBy(xpath = "//a[normalize-space()='Reward Points']")
    public WebElement rewardPoints;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Returns']")
    public WebElement returns;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Transactions']")
    public WebElement transactions;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Newsletter']")
    public WebElement newsletter;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    public WebElement logoutConfirmationMessage;

    @FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
    public WebElement forgotPasswordLogo;

    @FindBy(xpath = "//legend[normalize-space()='Your E-Mail Address']")
    public WebElement enterYourEmailLogo;

}
