package com.qa.ispeakbetter.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public static boolean highlightElement;
	/**
	 * 
	 * @return
	 */
	public WebDriver initialize_driver(){
		String browser = "chrome";
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://ispeakbetter.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}
	public Properties int_properties(){
		prop = new Properties();
		String path="/Users/marcelavinueza/eclipse-workspace/Final_Exam/"
				+ "src/main/java/com/qa/ispeakbetter/properties/config.properties";
		
		try {
			FileInputStream ip =new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
		System.out.println("some issue hapened with config properties correct the file");	
		}catch (Exception e) {
		e.printStackTrace();	
		}
		return prop;
	}
}
