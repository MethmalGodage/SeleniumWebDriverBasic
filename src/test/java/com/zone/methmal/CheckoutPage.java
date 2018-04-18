package com.zone.methmal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutPage {
  
	public WebDriver driver;
	String driverPath = "C:\\Program Files\\chromedriver_win32\\chromedriver.exe";
	String url = "http://www.practiceselenium.com/";
	
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void verifyCheckoutPage() {
		String checkoutTitle = "Check Out";
		driver.findElement(By.xpath(".//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[5]/a")).click();
		Assert.assertEquals(driver.getTitle(), checkoutTitle);
		Assert.assertTrue(driver.findElement(
						By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000451990420']/div/pre/strong/span"))
						.getText().contains("Enter your billing information"));
		Assert.assertTrue(driver.findElement(By
						.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000452010925']/div/div/form/div/button"))
						.getText().contains("Place Order"));
	}
	
	@AfterTest
	public void closeWebBrowser() {
		driver.close();
	}
}
