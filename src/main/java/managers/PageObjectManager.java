package managers;


import org.openqa.selenium.WebDriver;
import pages.BillPayLogInPage;
import pages.HomePage;
import pages.LoginMultiplePage;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private LoginMultiplePage loginMultiplePage;
    private BillPayLogInPage billPayLogInPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginMultiplePage getLoginMultiplePage() {
        return (loginMultiplePage == null) ? loginMultiplePage = new LoginMultiplePage(driver) : loginMultiplePage;
    }

    public BillPayLogInPage getBillPayLogInPage(){
        return (billPayLogInPage==null) ? billPayLogInPage = new BillPayLogInPage(driver):billPayLogInPage;
    }
}
