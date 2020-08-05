package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementsUtils;


public class HomePage extends BasePage {

	WebDriver dr;
	
	By appHeader = By.cssSelector("h1.dashboard-selector__title");
	By loginUser = By.cssSelector("span.account-name ");
	By eleContactsPrimary=By.id("nav-primary-contacts-branch");
	By eleContactsSecondary=By.id("nav-secondary-contacts");

	public HomePage(WebDriver dr) {
		this.dr = dr;
		eleUtil = new ElementsUtils(dr);
	}

	public String getHomePageTitle() {
		return eleUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 20);

	}

	public String getHomeHeader() {
		if ((eleUtil.doIsDisplayed(appHeader)))

		{
			return eleUtil.doGetText(appHeader);
		}
		return null;

	}

	public String getLoginUser() {
		if ((eleUtil.doIsDisplayed(loginUser))) {
			return eleUtil.doGetText(loginUser);
		}
		return null;
	}
	private void clickContacts()
	{
		eleUtil.doClick(eleContactsPrimary);
		eleUtil.doClick(eleContactsSecondary);
	}
	public ContactsPage goToContacts()
	{
		clickContacts();
		return new ContactsPage(dr);
	}

}
