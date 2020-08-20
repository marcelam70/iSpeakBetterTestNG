package com.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.LoginPage;

public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void setUp(){
	basePage = new BasePage();
	prop = basePage.int_properties();
	driver= basePage.initialize_driver();
	driver.get(prop.getProperty("url"));
	loginPage = new LoginPage(driver);


}
	@Test(priority=1)
	public void verifyInvalidCredentials() throws InterruptedException{
		loginPage.invalidCredentials();
		
		
	}
	@Test(priority=2)
	public void verifyErrorMessage() throws InterruptedException {
		loginPage.checkLoginErrorMessage();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
