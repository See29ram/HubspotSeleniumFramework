package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	WebDriver dr;
	By appHeader = By.xpath("//i18n-string[@data-key='app.header']");
	By loginUser = By.cssSelector("span.account-name ");

	public HomePage(WebDriver dr) {
		this.dr = dr;
	}

	public String getHomePageTitle() {
		return dr.getTitle();

	}

	public String getHomeHeader() {
		if ((dr.findElement(appHeader)).isDisplayed())

		{
			return dr.findElement(appHeader).getText();
		}
		return null;

	}

	public String getLoginUser() {
		if ((dr.findElement(loginUser)).isDisplayed()) {
			return dr.findElement(loginUser).getText();
		}
		return null;
	}

}
