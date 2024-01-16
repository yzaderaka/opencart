package stepDefenitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Header;
import pages.RegistrationPage;
import utils.CommonMethods;



public class RegistrationSteps extends CommonMethods {

    @When("User click on MyAccount then Register button")
    public void user_click_on_my_account_then_register_button() {
        doClick(header.myAccount);
        doClick(header.register);
    }

    @Then("User enter his registration data")
    public void user_enter_his_registration_data() {
        registration.registerNewCustomer();
    }

    @Then("Click checkbox to agree with Privacy Policy")
    public void click_checkbox_to_agree_with_privacy_policy() {
        doClick(registration.privacyPolicyChkBox);
    }

    @Then("Click registration button")
    public void click_registration_button() {
        doClick(registration.continueBtn);
    }

    @Then("Account has been created confirmation")
    public void account_has_been_created_confirmation() {
        Assert.assertEquals("Your Account Has Been Created!",registration.createdAccountConfirmation.getText());
    }

}
