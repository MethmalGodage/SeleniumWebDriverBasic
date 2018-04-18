package com.zone.methmal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OurPassionPage {
  
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
	public void verifyOurPassionPage() {
		String ourPassionTitle = "Our Passion";
		driver.findElement(By.xpath(".//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[2]/a")).click();
		Assert.assertEquals(driver.getTitle(), ourPassionTitle);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000450914902']/div/p[2]"))
						.getText().contains("We believe the calming sensation"));
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000450914920']/div/p"))
						.getText().contains("The Passion Tea Company team"));
	}
	
	@AfterTest
	public void closeWebBrowser() {
		driver.close();
	}
	
}
