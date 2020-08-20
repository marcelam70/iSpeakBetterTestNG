package com.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.util.constants;

public class HomePageTest {
	WebDriver driver;
	BasePage  basePage;
	Properties prop;
	HomePage homePage;
	
	
	@BeforeTest
	public void setUp(){
	basePage = new BasePage();
	prop = basePage.int_properties();
	driver= basePage.initialize_driver();
	driver.get(prop.getProperty("url"));
	homePage = new HomePage(driver);

}
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is...." + title);
		Assert.assertEquals(title,constants.HOMEPAGE_TITLE);
		
	}
	

	@Test(priority = 2)
	public void HeaderTextTest() throws InterruptedException {
		Thread.sleep(5000);
		String header = homePage.getHeader();
		System.out.println("Header text is: " + header);
		Assert.assertEquals(header,constants.HEADERHOME_TITLE);

	}

	@Test(priority = 3)
	public void ChatIconTest() throws InterruptedException {

		homePage.openChatIcon();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
