package cucumber;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
    private PageObjectManager pageObjectManager;
    private DriverManager driverManager;

    public TestContext() {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager(){
        return driverManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }
}
