package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Credentials;

public class BaseTest {

	public BasePage basePage;
	public LoginPage loginPage;
	public WebDriver dr;
	public Credentials credentials;
	public Properties prop;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		//System.out.println("Property will be assigned");
		prop = basePage.init_prop();
		//System.out.println("Property assigned done "+prop);
		dr = basePage.init_driver(prop);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		loginPage = new LoginPage(dr);
		
	}
	
	@AfterTest
	public void tearDown() {
		dr.quit();
	}
	
}
