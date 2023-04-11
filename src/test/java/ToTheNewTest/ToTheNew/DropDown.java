package ToTheNewTest.ToTheNew;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DropDown {
WebDriver driver;
Actions action;

@BeforeMethod
public void beforeMethod() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Md Arsh\\Downloads\\chromedriver_win32\\chromedriver.exe");



driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("https://www.tothenew.com/");
}


@Test
public void assertDropdown() throws InterruptedException {
action = new Actions(driver);
WebElement services =driver.findElement(By.xpath("(//*[@id='h-Services'])[2]"));
action.moveToElement(services).perform();

String li = driver.findElement(By.xpath("(//*[@id='menu']/ul/li[2]/ul)[2]")).getText();



Thread.sleep(2000);

Assert.assertTrue(li.contains("Digital Engineering"));
Assert.assertTrue(li.contains("Cloud & DevOps"));
Assert.assertTrue(li.contains("OTT Solutions & Services"));
Assert.assertTrue(li.contains("Data & Analytics"));
Assert.assertTrue(li.contains("CX, Content & Commerce"));
Assert.assertTrue(li.contains("Digital Marketing"));

}

@AfterMethod

public void afterMethod() {
driver.close();
}

}