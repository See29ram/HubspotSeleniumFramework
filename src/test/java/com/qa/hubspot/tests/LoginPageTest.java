package com.qa.hubspot.tests;

import org.testng.annotations.Test;

import org.testng.Assert;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 2)
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is:" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Title is not matching");
	}

	@Test(priority = 1)
	public void verifySignUp() {
        System.out.println("Login test triggered....");
		Assert.assertTrue(loginPage.isSignUpDisplayed(), "SignUp Link is not displayed");
	}

	@Test(priority = 4)
	public void loginTest() {
		HomePage homePage = loginPage.doLogIn(credentials);
		String loggedInUser = homePage.getLoginUser();
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "Login Test Failed");

	}

	@Test(priority = 3, enabled = false)
	public void invalidLoginTest() {

		String invalidUserAlert = loginPage.doInvalidLogIn("test@g.com", "invalidPassword");
		Assert.assertEquals(invalidUserAlert, "That email address doesn't exist.", "Invalid Login Test Failed");

	}

}
