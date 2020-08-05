package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.utils.ElementsUtils;
import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Seetharaman
 *
 */
public class BasePage {

	WebDriver dr;
	public Properties prop;
	public ElementsUtils eleUtil;
	public OptionsManager opManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is used to initialize webdriver-browser and opens the respective
	 * browser
	 * 
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		opManager=new OptionsManager(prop);
		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			// dr=new ChromeDriver();
			//tlDriver.set(new ChromeDriver(opManager.getChromeOptions()));
			tlDriver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			// dr=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(opManager.getFirefoxOptions()));

		} else {
			new RuntimeException("Invalid Browser Name:" + browserName);
		}

		getDriver().manage().window().maximize();
		// dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	/**
	 * this method returns config file properties
	 * 
	 * @return Properties files config
	 */
	public Properties init_prop() {
		prop = new Properties();
		String configPath = null;
		String env = System.getProperty("env").toUpperCase();
		switch (env) {
		case "QA":
			configPath = "./src/main/java/com/qa/hubspot/config/config_qa.properties";
			break;
		case "DEV":
			configPath = "./src/main/java/com/qa/hubspot/config/config_dev.properties";
			break;
		default:
			throw new RuntimeException("Invalid Environment given:" + env);

		}

		try {
			FileInputStream fis = new FileInputStream(configPath);
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

	public String getScreenshot() {
		File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String scrPath = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		try {
			FileUtils.copyFile(file, new File(scrPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scrPath;
	}

}
