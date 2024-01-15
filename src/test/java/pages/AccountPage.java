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
    WebElement confirmLogout;
}
