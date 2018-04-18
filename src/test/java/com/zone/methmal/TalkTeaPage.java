package com.zone.methmal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TalkTeaPage {
  
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
	public void verifyTalkTeaPage() {
		String talkTeaTitle = "Let's Talk Tea";
		driver.findElement(By.xpath(".//*[@id='wsb-nav-00000000-0000-0000-0000-000450914915']/ul/li[4]/a")).click();
		Assert.assertEquals(driver.getTitle(), talkTeaTitle);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000450914911']/div/p[2]"))
						.getText().contains("Want to learn more about the Passion"));
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000450914909']/div/h2"))
						.getText().contains("Send us an email"));
	}
	
	@AfterTest
	public void closeWebBrowser() {
		driver.close();
	}
	
}
