package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.Credentials;
import com.qa.hubspot.utils.ElementsUtils;


public class LoginPage extends BasePage {

	private WebDriver dr;

	// 1st Create By locators
	By userName = By.id("username");
	By passWord = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By invlaidUserAlert=By.xpath("//div[@data-error-type='INVALID_USER']//h5");

	// 2nd Create Constructor for this Page Class
	public LoginPage(WebDriver dr) {

		this.dr = dr;
		eleUtil=new ElementsUtils(dr);
		

	}

	// 3rd Actions
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	public boolean isSignUpDisplayed() {
		return eleUtil.doIsDisplayed(signUp);
	}

	public HomePage doLogIn(Credentials credentials) {

		eleUtil.doSendKeys(userName, credentials.getAppUserName());
		eleUtil.doSendKeys(passWord, credentials.getAppUserPassWord());
		eleUtil.doClick(loginBtn);
		return new HomePage(dr);
	}
	public String doInvalidLogIn(String username, String password) {

		eleUtil.waitForElementToBeVisible(userName, 20);
		eleUtil.doSendKeys(userName, username);
		eleUtil.doSendKeys(passWord, password);
		eleUtil.doClick(loginBtn);
		//return eleUtil.doGetAttribute(invlaidUserAlert, "innerText");
		return "";
	}
}
