package pages;


import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final String homePageURL = "https://tmamerica.com/";
    private String title;
    private Helper helper;

    WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);

    }

    @FindBy(css = "div.mk-aweb-menu-img-custom.mk-aweb-menu-sprite")
    private WebElement eyeIcon;

    @FindBy(css = "li[mk-aweb-stats-id='4']>div")
    private WebElement btnColorBlind;

    @FindBy(css = "li[mk-aweb-stats-id='4']")
    private WebElement btnColorBlindAfterPressing;

    @FindBy(css = "a.btn.btn-theme-bg.btn-sm")
    private WebElement btnLogin;

    public void open_HomePage() {
        driver.get(homePageURL);
    }

    public void turnOnColorBlindMode() {
        helper.highlightElement(eyeIcon);
        eyeIcon.click();
        helper.highlightElement(btnColorBlind);
        helper.javascriptClick(btnColorBlind);
        eyeIcon.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isColorBlind() {
        String ariaPressedAtr = btnColorBlindAfterPressing.getAttribute("aria-pressed");
        if(ariaPressedAtr != null){
            return Boolean.parseBoolean(ariaPressedAtr);
        }
        return false;
    }
    public void clickLoginBtn(){
        btnLogin.click();
    }
}

