package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomePage extends Base {

    private static Logger log = LogManager.getLogger(Base.class.getName());

    public WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(prop.getProperty("url"));
        log.info("Navigated to home page");
    }


    @Test(dataProvider = "getData")
    public void basePageNavigation(Map<String, String> testData) throws IOException {
        LandingPage lp = new LandingPage(driver);
        lp.signInButton.click();
        LoginPage lop = new LoginPage(driver);
        lop.emailInput.sendKeys(testData.get("userName"));
        lop.passwordInput.sendKeys(testData.get("password"));
        lop.submitButton.click();
        log.info("username password added sucessfully");
    }

    @DataProvider
    public Object[][] getData(){
        //Rows stand for how many times test will run
        // column stands for how many values for each test
        Object[][] dat = new Object[2][1];

        Map<String, String> map1 = Stream.of(new Object[][] {
                { "userName", "vibhav" },
                { "password", "vibhav" },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

        Map<String, String> map2 = Stream.of(new Object[][] {
                { "userName", "sharma" },
                { "password", "sharma" },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

        dat[0][0] = map1;
        dat[1][0] = map2;
        return dat;
    }

    @Test
    public void assertionExample() throws IOException {
//        String ss = System.getProperty("user.dir");
        LandingPage lp = new LandingPage(driver);
        Assert.assertEquals(lp.featuredCorses.getText(),"FEATURED COURSES123");
        lp.signInButton.click();
        log.info("Assertion test successfully passed");
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
