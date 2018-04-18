package com.zone.methmal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homepage {

	public WebDriver driver;
	String currentPageHandle;
	String driverPath = "C:\\Program Files\\chromedriver_win32\\chromedriver.exe";
	String url = "http://www.practiceselenium.com/";

	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@BeforeTest
	public void goToWelcomePage() {
		driver.navigate().to("http://www.practiceselenium.com/");
	}

	@Test
	public void assertBasics() {
		String homePageTitle = "Welcome";
		Assert.assertEquals(driver.getTitle(), homePageTitle,"Failed to assert - Home page title");
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000450914887']/div/p/span"))
						.getText().contains("For more than 25 years"));
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='wsb-button-00000000-0000-0000-0000-000450914890']/span"))
						.getText().contains("See Collection"));
	}

	@Test
	public void assertLinkTextClick() {
		currentPageHandle = driver.getWindowHandle();
		driver.findElement(By.linkText("seleniumframework.com")).click();
		for (String winHandle : driver.getWindowHandles()) {
	        System.out.println(winHandle);
	        driver.switchTo().window(winHandle);              
	    }
		//String pageTitle = "Selenium Framework | Selenium, Cucumber, Ruby, Java et al.";
		Assert.assertEquals(driver.getTitle(), "Selenium Framework | Selenium, Cucumber, Ruby, Java et al.","Failed to assert - linktext");
		driver.close();
		driver.switchTo().window(currentPageHandle);
	}

	@Test
	public void assertSeeCollection1() {
		driver.findElement(By.xpath(".//*[@id='wsb-button-00000000-0000-0000-0000-000450914890']")).click();
		Assert.assertEquals(driver.getTitle(), "Menu","Failed to assert - linktext");
		//driver.navigate().to("http://www.practiceselenium.com/");
	}

	@Test
	public void assertSeeCollection2() {
		driver.findElement(By.xpath(".//*[@id='wsb-button-00000000-0000-0000-0000-000450914897']")).click();
		Assert.assertEquals(driver.getTitle(), "Menu","Failed to assert - linktext");
		//driver.navigate().to("http://www.practiceselenium.com/");
	}

	@Test
	public void assertSeeCollection3() {
		driver.findElement(By.xpath(".//*[@id='wsb-button-00000000-0000-0000-0000-000450914899']")).click();
		Assert.assertEquals(driver.getTitle(), "Menu","Failed to assert - linktext");
		//driver.navigate().to("http://www.practiceselenium.com/");
	}

	@AfterMethod
	public void returnToHome() {
		driver.navigate().to("http://www.practiceselenium.com/");
	}

	@AfterClass
	public void closeWebBrowser() {
		driver.quit();
	}
}
