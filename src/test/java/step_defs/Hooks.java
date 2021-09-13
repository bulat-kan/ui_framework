package step_defs;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }
    @Before
    public void beforeSteps(){

    }

    @After
    public void afterSteps(){
        testContext.getDriverManager().quitDriver();
    }
}
