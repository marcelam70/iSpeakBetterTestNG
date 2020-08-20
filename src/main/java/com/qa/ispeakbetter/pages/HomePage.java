package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ispeakbetter.util.ElementUtil;



public class HomePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.xpath("//h1[@class='rsp']");
	//By chatBox = By.id("zsiq_agtpic");
	By chatBoxHeader = By.xpath("//*[@id='window-ribbon']/header/div");
	//By chatBox = By.cssSelector("div[class='win_close sqico-larrow']");
	By chatBox = By.xpath("//em[@id='zsiq_agtpic']");
	By frame = By.id("siqiframe");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

	public String getHeader() {
		elementUtil.waitForElementPresent(header);
		return elementUtil.doGetText(header);

	}

	public void openChatIcon() throws InterruptedException {

		elementUtil.waitForElementPresent(chatBox);
		driver.findElement(chatBox).click();
	//	elementUtil.doClick(chatBox);
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.id("siqiframe")));
	       WebElement header = driver.findElement(chatBoxHeader);
		   System.out.println("Header of the Icon is : "+header.getText());
		   driver.findElement(chatBox).click();	
			
	}
	
}
