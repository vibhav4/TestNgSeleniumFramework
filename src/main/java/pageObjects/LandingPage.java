package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()=\"Login\"]")
    public WebElement signInButton;

    @FindBy(xpath = "//*[text()='Featured Courses']")
    public WebElement featuredCorses;

    @FindBy(css = ".navbar-right")
    public WebElement navBarLanding;
}
