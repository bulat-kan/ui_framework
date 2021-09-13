package pages;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayLogInPage {
    WebDriver driver;
    Helper helper;
    final String baseUrl = "https://onlinebillpay.tokiomarine.us/";

    public BillPayLogInPage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "txtUserName")
    private WebElement txtBxUsername;

    @FindBy(id = "txtPassword")
    private WebElement txtBxPassword;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @FindBy(css = "span[data-valmsg-for]")
    private WebElement invCredentialsMsg;


    public void openLoginPage(){
        driver.get(baseUrl);
    }

    public void Login(String username, String password) {
        helper.highlightElement(txtBxUsername);
        txtBxUsername.sendKeys(username);

        helper.highlightElement(txtBxPassword);
        txtBxPassword.sendKeys(password);
        helper.highlightElement(btnLogin);
        btnLogin.submit();
    }

    public String getErrorMessage() {
        helper.highlightElement(invCredentialsMsg);
        return invCredentialsMsg.getText();
    }


}
