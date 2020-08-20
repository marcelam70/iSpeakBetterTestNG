package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.util.ElementUtil;


public class LoginPage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By emailId = By.id("_email");
	By password = By.id("_password");
	By signIn = By.id("cmdSignin");
	By Login = By.linkText("Login");
	By loginErrorText = By.id("crendentialsError");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public void  invalidCredentials() throws InterruptedException{
		elementUtil.waitForElementPresent(Login);
		driver.findElement(Login).click();
		Thread.sleep(2000);
		elementUtil.waitForElementPresent(emailId);
		driver.findElement(emailId).sendKeys("marcela@gmail.com");
		driver.findElement(password).sendKeys("test123");
		
		driver.findElement(Login).click();
	}

	public String checkLoginErrorMessage() throws InterruptedException{
		Thread.sleep(3000);
		elementUtil.waitForElementPresent(loginErrorText);
		return driver.findElement(loginErrorText).getText();
	}
}





