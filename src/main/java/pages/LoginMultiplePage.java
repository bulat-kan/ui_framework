package pages;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginMultiplePage {
    WebDriver driver;

    private Helper helper;

    public LoginMultiplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);
    }

    @FindBy(css = "div.service-box>h4")
    private List<WebElement> loginDepartmentNames_List;

    @FindBy(css = "a.btn.btn-primary")
    private List<WebElement> loginLink_list;

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getLoginDepartmentNames_List(){
        return loginDepartmentNames_List;
    }

    private List<WebElement> getLoginLink_list(){
        return loginLink_list;
    }

    public List<String> getInvalidLinks(){
        List<String> invalid_URLs = new ArrayList<>();
        for (WebElement link: getLoginLink_list()){
            String url = link.getAttribute("href");
            if(helper.isBrokenLink(url)){
                invalid_URLs.add(url);
            }
        }
        return invalid_URLs;
    }
}
