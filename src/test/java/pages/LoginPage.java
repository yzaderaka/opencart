package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement password;

    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement invalidCredentialsMessage;
}
