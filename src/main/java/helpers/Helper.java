package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Helper {

    private static Actions actions;
    private static JavascriptExecutor js;
    private static WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    // checks if elements is clickable and visible before clicking
    public void mouseClick(WebElement element) {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
        actions.click(element).perform();
    }

    // js click
    public void javascriptClick(WebElement element) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].click();", element);
    }

    // highlighter of your demo
    public void highlightElement(WebElement element) {
        String style = "border: 4px dashed blue";
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, style);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectAllCopy() {
        // command +a
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build().perform();
        // command + c
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).build().perform();
    }

    public void selectAllCut() {
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build().perform();
        actions.keyDown(Keys.COMMAND).sendKeys("x").keyUp(Keys.COMMAND).build().perform();
    }

    public void paste() {
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyDown(Keys.COMMAND).build().perform();
    }

    public WebDriverWait waitUntil() {
        return new WebDriverWait(driver, 7);
    }

    public void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }

    public boolean isBrokenLink(String linkUrl){
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>=400){
                httpURLConnection.disconnect();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
