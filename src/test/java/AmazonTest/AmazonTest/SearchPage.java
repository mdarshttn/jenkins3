package AmazonTest.AmazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchPage {
	
	WebDriver driver;
	WebElement searchbar;
	WebElement searchbutton;
	
	@BeforeTest
	public void openpage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Md Arsh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(1000);
		
	}
	
	@Test(priority=1)
	public void searchbar() throws InterruptedException {
		
        searchbar= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchbar.isDisplayed());
        Thread.sleep(1000);
		
	}
	
	@Test(priority=2)
	public void search() throws InterruptedException {
		searchbar.sendKeys("Mobile");
		searchbutton= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		Thread.sleep(1000);
		searchbutton.click();
		WebElement firstsearch= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
	    Assert.assertTrue(firstsearch.isDisplayed());
	    Thread.sleep(2000);
	}
	
	@AfterTest
	
	public void close() {
		driver.close();
	}
	

}
