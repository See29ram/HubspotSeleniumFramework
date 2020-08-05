package com.qa.hubspot.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	Properties prop;
	ChromeOptions copt;
	FirefoxOptions fopt;

	public OptionsManager(Properties prop) {
		// TODO Auto-generated constructor stub

		this.prop = prop;
		

	}

	public ChromeOptions getChromeOptions() {

		copt=new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			System.out.println("In Chrome method headless value "+prop.getProperty("headless"));
		
			copt.addArguments("--headless");
			System.out.println("Headless added....");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			System.out.println("In Chrome method incognito value is "+prop.getProperty("incognito"));
			copt.addArguments("--incognito");
			System.out.println("incognito added....");
		System.out.println("final chrome options:"+copt);	
		return copt;
	}
	public FirefoxOptions getFirefoxOptions() {
		fopt=new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			fopt.addArguments("--headless");
		return fopt;
	}
}
