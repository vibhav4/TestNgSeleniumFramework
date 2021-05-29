package Academy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ToolsQAPrac extends Base {



    public WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = initializeDriver();
//        log.info("Driver is initialized");

//        driver.get("https://demoqa.com/browser-windows");
//        log.info("Navigated to home page");
    }


    @Test
    public void newWindowTestCase(){
        driver.get("https://demoqa.com/browser-windows");
        WebElement newWindow = driver.findElement(By.cssSelector("[id='windowButton']"));
//        newWindow.se
        newWindow.click();

        String parentWindow = driver.getWindowHandle();
        Set<String> windoHandles = driver.getWindowHandles();

        ArrayList<String> aa = new ArrayList<String>(windoHandles);

//        driver.switchTo().window(aa.get(1));
//        driver.switchTo().

        Iterator<String> iterator = aa.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }

        WebElement headingloc = driver.findElement(By.cssSelector("[id='sampleHeading']"));

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(headingloc));

        System.out.println(headingloc.getText());

//        driver.

        Actions actions = new Actions(driver);

        actions.keyDown(headingloc, Keys.SHIFT).sendKeys("sdasdxas").keyUp(Keys.SHIFT);

        actions.build().perform();

//        wait.until(ExpectedConditions.visi);
    }


    @Test
    public void newActionClassTest() throws InterruptedException {
        driver.get("http://demoqa.com/auto-complete/");
        WebElement elem = driver.findElement(By.cssSelector("input[id='autoCompleteMultipleInput']"));

        Thread.sleep(5000);
//        elem.sendKeys("test");

        Actions actions = new Actions(driver);
//        actions.keyDown(elem,Keys.SHIFT).sendKeys("vibhav").keyUp(Keys.SHIFT);
//       Action action =  actions.build();
//        action.perform();


        actions.keyDown(elem,Keys.SHIFT).sendKeys("vibhav").keyUp(Keys.SHIFT).perform();
        System.out.println("here");

    }

    @Test
    public void newRightCLick() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        WebElement btnElement = driver.findElement(By.id("rightClickBtn"));
        WebElement btnElement1 = driver.findElement(By.id("doubleClickBtn"));

        Thread.sleep(5000);
//        elem.sendKeys("test");

        Actions actions = new Actions(driver);
        actions.contextClick(btnElement).perform();

        actions.doubleClick(btnElement1).perform();
//        actions.keyDown(elem,Keys.SHIFT).sendKeys("vibhav").keyUp(Keys.SHIFT);
//       Action action =  actions.build();
//        action.perform();


//        actions.keyDown(elem,Keys.SHIFT).sendKeys("vibhav").keyUp(Keys.SHIFT).perform();
        System.out.println("here");

    }

    @Test
    public void newDragAndDrop() throws InterruptedException {
        driver.get("https://demoqa.com/droppable/");

        Thread.sleep(3000);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));

        Actions builder = new Actions(driver);

        //Here, getting x and y offset to drop source object on target object location
        //First, get x and y offset for from object
        int xOffset1 = from.getLocation().getX();

        int yOffset1 =  from.getLocation().getY();

        System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);

        //Secondly, get x and y offset for to object
        int xOffset = to.getLocation().getX();

        int yOffset =  to.getLocation().getY();

        System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);

        //Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
        xOffset =(xOffset-xOffset1);
        yOffset=(yOffset-yOffset1);

        builder.dragAndDropBy(from, xOffset,yOffset).perform();
//        builder.dragAndDrop(from, to).perform();
        System.out.println("here");



    }

    @Test
    public void newMouseHover() throws InterruptedException {
        driver.get("https://demoqa.com/menu/");

        Thread.sleep(3000);

        WebElement menuOption = driver.findElement(By.xpath("//*[text()='Main Item 2']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(menuOption).perform();

        WebElement SubmenuOption = driver.findElement(By.xpath("//*[text()='SUB SUB LIST »']"));
        builder.moveToElement(SubmenuOption).perform();

        WebElement SubSubmenuOption = driver.findElement(By.xpath("//*[text()='Sub Sub Item 1']"));
        SubSubmenuOption.click();

        System.out.println("here");

    }


    @Test
    public void handleSSL() throws InterruptedException {
        driver.get("https://expired.badssl.com/");

        System.out.println("The page title is : " +driver.getTitle());
//        driver.quit();

        System.out.println("here");

    }

}
