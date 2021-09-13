package step_defs;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.LoginMultiplePage;

import java.util.List;

public class LoginMultiplePage_Steps {

    TestContext testContext;
    LoginMultiplePage loginMultiplePage;
    

    public LoginMultiplePage_Steps(TestContext testContext) {
        this.testContext = testContext;
        loginMultiplePage = testContext.getPageObjectManager().getLoginMultiplePage();
    }

    @Then("validate page title contains {string}")
    public void validate_page_title_contains(String expectedTitle) {
        Assert.assertTrue(loginMultiplePage.getTitle().contains(expectedTitle));
    }

    @Then("user can find {int} departments to login")
    public void user_can_find_departments_to_login(Integer expectedNum) {
        Assert.assertEquals(loginMultiplePage.getLoginDepartmentNames_List().size(), (int) expectedNum);
    }

    @Then("all login links are functioning")
    public void allLoginLinksAreFunctioning() {
        Assert.assertEquals(1,loginMultiplePage.getInvalidLinks().size());
    }

}
