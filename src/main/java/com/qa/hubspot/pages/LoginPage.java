package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver dr;
	// 1st Create By locators
	By userName = By.id("username");
	By passWord = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUp = By.linkText("Sign up");

	// 2nd Create Constructor for this Page Class
	public LoginPage(WebDriver dr) {

		this.dr = dr;

	}

	// 3rd Actions
	public String getLoginPageTitle() {
		return dr.getTitle();
	}

	public boolean isSignUpDisplayed() {
		return dr.findElement(signUp).isDisplayed();
	}

	public HomePage doLogIn(String username, String password) {
		dr.findElement(userName).sendKeys(username);
		dr.findElement(passWord).sendKeys(password);
		dr.findElement(loginBtn).click();
		return new HomePage(dr);
	}
}
