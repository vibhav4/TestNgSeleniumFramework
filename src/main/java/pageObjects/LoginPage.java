package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@type='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;


}
