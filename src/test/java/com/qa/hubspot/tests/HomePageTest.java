package com.qa.hubspot.tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homePage;

	@BeforeClass
	public void homePageSetUp() {

		homePage = loginPage.doLogIn(credentials);

	}

	@Test(priority = 3)
	public void verifyHomePageTitle() {

		String homePgTitle = homePage.getHomePageTitle();
		System.out.println("Home Page Title is:" + homePgTitle);
		Assert.assertEquals(homePgTitle, Constants.HOME_PAGE_TITLE, "HomePage Title mismatched");
	}

	@Test(priority = 1)
	public void verifyHomePageHeader() {
		String homeHeader = homePage.getHomeHeader();
		System.out.println("Home Page Header is:" + homeHeader);
		Assert.assertEquals(homeHeader, Constants.HOME_PAGE_HEADER, "HomePage header mismatched");
	}

	@Test(priority = 2)
	public void verifyLoginUser() {
		String loginUserName = homePage.getLoginUser();
		System.out.println("Logged in user is:" + loginUserName);
		Assert.assertEquals(loginUserName, prop.getProperty("accountname"), "Login user name mismatched");
	}

	

}
