package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementsUtils;

public class ContactsPage extends BasePage {
	private WebDriver dr;
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[2]");
	By eleEmailId = By.xpath("//input[@data-field='email']");
	By eleFirstName = By.xpath("//input[@data-field='firstname']");
	By eleLastName = By.xpath("//input[@data-field='lastname']");
	By eleJobTitle = By.xpath("//input[@data-field='jobtitle']");
	By eleContactPageHeader = By.xpath("//i18n-string[text()='Contacts']");
	By eleContactsBacklink = By.xpath("(//i18n-string[text()='Contacts'])[1]/../..");
	By eleContactDetails=By.xpath("//div[@data-selenium-test='contact-highlight-details']");

	private ElementsUtils eleUtil;

	public ContactsPage(WebDriver dr) {
		this.dr = dr;
		eleUtil = new ElementsUtils(this.dr);
	}

	public String getContactsPageTitle() {
		return eleUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 20);
	}

	public String getContactsPageHeader() {
		// eleUtil.waitForElementToBeVisible(eleContactPageHeader, 20);
		eleUtil.waitForElementPresentAndVisible(eleContactPageHeader, 30);
		return eleUtil.doGetText(eleContactPageHeader);

	}

	public void createContacts(String emailId, String firstName, String lastName, String jobTitle) {
		eleUtil.waitForElementPresentAndVisible(createContactPrimary, 30);
		eleUtil.clickWhenReady(createContactPrimary, 20);
		eleUtil.waitForElementPresent(eleEmailId, 20);
		eleUtil.doSendKeys(eleEmailId, emailId);
		eleUtil.doSendKeys(eleFirstName, firstName);
		eleUtil.doSendKeys(eleLastName, lastName);
		eleUtil.waitForElementToBeVisible(eleJobTitle, 20);
		eleUtil.doSendKeys(eleJobTitle, jobTitle);
		eleUtil.waitForElementPresentAndVisible(createContactSecondary, 20);
		eleUtil.doClick(createContactSecondary);
		eleUtil.waitForElementPresentAndVisible(eleContactDetails, 30);
		eleUtil.clickWhenReady(eleContactsBacklink, 20);
	}

}
