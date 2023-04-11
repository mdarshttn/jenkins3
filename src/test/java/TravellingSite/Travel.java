package TravellingSite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Travel {
WebDriver driver;
Actions action;

@BeforeMethod
public void beforeMethod() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Md Arsh\\Downloads\\chromedriver_win32\\chromedriver.exe");



driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

driver.get("https://www.path2usa.com/travel-companion/");
Thread.sleep(2000);
}


@Test
public void formfill()throws InterruptedException, AWTException {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");

	Thread.sleep(3000);
	driver.findElement(By.name("form_fields[travel_from]")).sendKeys("DELHI");
	driver.findElement(By.name("form_fields[travel_to]")).sendKeys("MUMBAI");
	driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("//span[text()='29']")).click();

	Robot r = new Robot();
	driver.findElement(By.name("form_fields[travel_comp_date_between]")).click();
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_ENTER);

	Thread.sleep(3000);
	driver.findElement(By.name("form_fields[travel_comp_airline]")).click();

	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_ENTER);

	Thread.sleep(2000);
	driver.findElement(By.name("form_fields[travel_comp_language]")).click();
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
	r.keyPress(KeyEvent.VK_ENTER);

	driver.findElement(By.xpath("//button[@class=\"elementor-button elementor-size-sm\"]")).click();

	Thread.sleep(3500);
	Assert.assertTrue(driver.findElement(By.xpath("//section[@data-id=\"fffcfcb\"]")).isDisplayed());

	Thread.sleep(3500);
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	try {

	FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Md Arsh\\Downloads\\Screenshot.png"));
	} catch (IOException e) {
	System.out.println(e.getMessage());




	}
}

@AfterMethod

public void afterMethod() {
driver.close();
}

}