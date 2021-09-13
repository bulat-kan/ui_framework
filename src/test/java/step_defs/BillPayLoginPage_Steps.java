package step_defs;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BillPayLogInPage;

public class BillPayLoginPage_Steps {

    TestContext testContext;
    BillPayLogInPage logInPage;


    public BillPayLoginPage_Steps(TestContext context) {
        this.testContext = context;
        logInPage= context.getPageObjectManager().getBillPayLogInPage();

    }

    @Given("user is on billpay log in page")
    public void user_is_on_billpay_log_in_page() {
        logInPage.openLoginPage();
    }
    @When("user attempts to login with username {string} password {string}")
    public void user_attempts_to_login_with_username_password(String username, String password) {
        logInPage.Login(username,password);
    }
    @Then("user can see following error message {string}")
    public void user_can_see_following_error_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,logInPage.getErrorMessage());
    }
}
