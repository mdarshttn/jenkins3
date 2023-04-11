package AmazonTest.AmazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomePage {
	WebDriver driver;

	@Test
	public void checklogo() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Md Arsh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	Thread.sleep(2000);
	WebElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
	Assert.assertTrue(logo.isDisplayed());
	
	}
	
	
    @AfterTest
    public void close() {
    	driver.close();
    }
    
}
