package com.zone.methmal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MenuPage {
  
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
	public void verifyMenuPage() {
		String menuTitle = "Menu";
		driver.findElement(By.xpath(".//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[3]/a")).click();
		Assert.assertEquals(driver.getTitle(), menuTitle);
		Assert.assertTrue(driver.findElement(
						By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000453230000']/div/p/span/span/strong"))
						.getText().contains("Green Tea"));
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wsb-button-00000000-0000-0000-0000-000451961556']/span"))
						.getText().contains("Check Out"));
	}
	
	@AfterTest
	public void closeWebBrowser() {
		driver.close();
	}
	
}
