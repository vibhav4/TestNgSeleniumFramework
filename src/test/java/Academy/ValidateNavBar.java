package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidateNavBar extends Base {

    private static Logger log = LogManager.getLogger(Base.class.getName());

    public WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(prop.getProperty("url"));
        log.info("Navigated to home page");
    }

    @Test
    public void validateNavBar() throws IOException {
        LandingPage lp = new LandingPage(driver);
        Assert.assertTrue(lp.navBarLanding.isDisplayed(),"Nav bar not present at landing page");
//        Assert.assertTrue(false,"Nav bar not present at landing page");
        log.info("Navigation bar successfully validated");
        log.error("I am error ***************8");
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
