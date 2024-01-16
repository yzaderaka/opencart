package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.ConfigReader;

public class RegistrationPage extends CommonMethods {
    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    public WebElement telephone;
    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement privacyPolicyChkBox;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    public WebElement createdAccountConfirmation;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement continueBtnInAccount;

    public void registerNewCustomer() {
        sendText(registration.firstName, faker.name().firstName());
        sendText(registration.lastName, faker.name().lastName());
        sendText(registration.email,faker.internet().safeEmailAddress());
        sendText(registration.telephone,faker.phoneNumber().cellPhone());
        sendText(registration.password, ConfigReader.getPropertyValue("password"));
        sendText(registration.confirmPassword,ConfigReader.getPropertyValue("confirmPassword"));

    }
}
