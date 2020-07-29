package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {

	BasePage basePage;
	WebDriver dr;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_prop();
		dr = basePage.init_driver(prop);
		loginPage = new LoginPage(dr);
		homePage = loginPage.doLogIn(prop.getProperty("username"),prop.getProperty("password"));

	}

	@Test(priority=3)
	public void verifyHomePageTitle() {

		String homePgTitle=homePage.getHomePageTitle();
		System.out.println("Home Page Title is:"+homePgTitle);
		Assert.assertEquals(homePgTitle,Constants.HOME_PAGE_TITLE,"HomePage Title mismatched");
	}
	@Test(priority=1)
	public void verifyHomePageHeader()
	{
		String homeHeader=homePage.getHomeHeader();
		System.out.println("Home Page Header is:"+homeHeader);
		Assert.assertEquals(homeHeader, Constants.HOME_PAGE_HEADER,"HomePage header mismatched");
	}
	@Test(priority=2)
	public void verifyLoginUser()
	{
		String loginUserName=homePage.getLoginUser();
		System.out.println("Logged in user is:"+loginUserName);
		Assert.assertEquals(loginUserName, prop.getProperty("accountname"),"Login user name mismatched");
	}

	@AfterTest
	public void tearDown() {
		dr.quit();
	}

}
