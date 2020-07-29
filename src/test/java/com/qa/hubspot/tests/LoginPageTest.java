package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest {

	BasePage basePage;
	LoginPage loginPage;
	WebDriver dr;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
	    prop=basePage.init_prop();
		dr = basePage.init_driver(prop);
		loginPage = new LoginPage(dr);
	}

	@Test(priority=2)
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is:" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Title is not matching");
	}

	@Test(priority=1)
	public void verifySignUp() {

		Assert.assertTrue(loginPage.isSignUpDisplayed(), "SignUp Link is not displayed");
	}

	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogIn(prop.getProperty("username"),prop.getProperty("password"));
		

	}

	@AfterTest
	public void tearDown() {
		dr.quit();
	}

}
