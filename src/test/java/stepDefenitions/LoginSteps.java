package stepDefenitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("User click on MyAccount then Login Button")
    public void user_click_on_my_account_then_login_button() {
        doClick(header.myAccount);
        doClick(header.login);
    }

    @When("User enter valid login and password")
    public void user_enter_valid_login_and_password() {
        sendText(login.email, ConfigReader.getPropertyValue("username"));
        sendText(login.password, ConfigReader.getPropertyValue("password"));

    }

    @When("Click on login button")
    public void click_on_login_button() {
        doClick(login.loginBtn);
    }

    @Then("User enter into account")
    public void user_enter_into_account() {
        Assert.assertEquals("My Account", login.myAccount.getText());
    }

    @When("User enter {string} and {string}")
    public void user_enter_and(String username, String password) {
        sendText(login.email, username);
        sendText(login.password, password);
    }

    @Then("User see error message")
    public void user_see_error_message() {
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", login.invalidCredentialsMessage.getText());
    }

    @Then("User click on logout button")
    public void user_click_on_logout_button() {
        doClick(account.logout);
    }

    @Then("User see logout confirmation message")
    public void user_see_logout_confirmation_message() {
        Assert.assertEquals("Account Logout", account.logoutConfirmationMessage.getText());
    }

    @When("User click on Forgotten Password link")
    public void user_click_on_forgotten_password_link() {
        doClick(login.forgotPassword);
    }

    @Then("User should be taken to Forgotten Password page")
    public void user_should_be_taken_to_forgotten_password_page() {
        Assert.assertEquals("Forgot Your Password?", account.forgotPasswordLogo.getText());
        Assert.assertEquals("Your E-Mail Address", account.enterYourEmailLogo.getText());
    }


}
