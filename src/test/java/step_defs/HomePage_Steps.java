package step_defs;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;

public class HomePage_Steps {
    TestContext testContext;
    HomePage homePage;

    public HomePage_Steps(TestContext testContext) {
        this.testContext = testContext;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        homePage.open_HomePage();
    }

    @Then("validate title contains {string}")
    public void validate_title_contains(String expectedTitle) {
        Assert.assertTrue(homePage.getTitle().contains(expectedTitle));
    }

    @When("user turns on color blind mode")
    public void user_turns_on_color_blind_mode() {
        homePage.turnOnColorBlindMode();
    }

    @Then("page becomes black and white")
    public void page_becomes_black_and_white() {
        Assert.assertEquals(true, homePage.isColorBlind());
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        homePage.clickLoginBtn();
    }
}
