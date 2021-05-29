package resources;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

// Adding logs
// Generating html reports
// Screenshots on failure
// Jenkins integration

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver    initializeDriver() throws IOException {


        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
        prop.load(fis);
        String browser = prop.getProperty("browser");

        // If wannt to fecth browser name from maven command as system prperty variable

//        browser = System.getProperty("browser");

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/vibhavsharma/Documents/seleniumgrid/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(false);
//            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if(browser.equals("firefox")){
            // firefox code
            throw new ArithmeticException();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    // Screenshot utility

    public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testMethodName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
