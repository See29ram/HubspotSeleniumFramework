package com.qa.hubspot.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;

import org.testng.annotations.DataProvider;


import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.Excelutils;

public class ContactsPageTest extends BaseTest {

	HomePage homePage;
	ContactsPage contactPage;
	

	@BeforeClass
	public void contactsPageSetup() {

		homePage = loginPage.doLogIn(credentials);
		contactPage = homePage.goToContacts();

	}

	@Test(priority=1)
	public void verifyContactsPageTitle() {

		String contactsTitle = contactPage.getContactsPageTitle();
		System.out.println("Contact Page title is:" + contactsTitle);
		Assert.assertEquals(contactsTitle, Constants.CONTACTS_PAGE_TITLE);
	}

	@Test(priority=2)
	public void verifyHeader() {
		String strHeader = contactPage.getContactsPageHeader();
		System.out.println("Contact Page Header is:" + strHeader);
		Assert.assertEquals(strHeader, Constants.CONTACTS_PAGE_HEADER);
	}
	
	@DataProvider
	public Object[][] getContactsTestData()
	{
		return Excelutils.getDataFromExce(Constants.CONTACT_SHEET_NAME);
	}
	
	
	@Test(priority=3,dataProvider="getContactsTestData")
	public void verifyCreateContacts(String email,String firstName,String lastName,String jobTitle) {
		contactPage.createContacts(email,firstName,lastName,jobTitle);
	}

}
