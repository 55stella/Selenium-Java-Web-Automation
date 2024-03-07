package BaseClases;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BaseClases.TestBase.driver;

public class PageBase {
    public PageBase(WebDriver driver){
  PageFactory.initElements(driver, this);
 }
    public void click(WebElement  element){element.click();}
    public  void sendText(WebElement ele, String textToSend){ele.sendKeys(textToSend);}

   public void clearFields(WebElement ele){ waitForElement(ele, 10);ele.clear();}
   public void waitForElement(WebElement element, int seconds) {
    try {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
     wait.until(ExpectedConditions.visibilityOf(element));
    } catch (TimeoutException e) {
     System.out.println("Element is not visible: " + element);
    }

   }





}
