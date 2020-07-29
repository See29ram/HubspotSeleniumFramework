package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Seetharaman
 *
 */
public class BasePage { 
	
	WebDriver dr;
	Properties prop;
	/**
	 * this method is used to initialize webdriver-browser and opens the respective browser
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
           
			WebDriverManager.chromedriver().setup();
			dr=new ChromeDriver();
			
			
		} else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			dr=new FirefoxDriver();
			
		}
		else
		{
			new RuntimeException("Invalid Browser Name:"+browserName);
		}
		
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("https://app.hubspot.com/login");
		return dr;

	}
	
	/**
	 * this method returns config file properties
	 * @return Properties files config
	 */
	public Properties init_prop()
	{
		 prop=new Properties();
		 try {
			FileInputStream fis=new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
	}

}
