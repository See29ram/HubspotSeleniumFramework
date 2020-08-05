package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsUtils_Old {

	private WebDriver dr;

	public ElementsUtils_Old(WebDriver dr) {
		this.dr = dr;
	}

	/**
	 * This method takes By locator and using findElement, it returns WebElement
	 * 
	 * @param locator
	 * @return returning WebElement
	 */
	public WebElement getElement(By locator) {
		WebElement ele = null;
		try {

			ele = dr.findElement(locator);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					"Exception Occured while identifying Element with locator:" + locator + " " + e.getMessage());
		}
		return ele;
	}

	public void doClick(By locator) {

		try {
			WebElement ele = getElement(locator);
			ele.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					"Exception occured while clicking on Element with locator of:" + locator + " " + e.getMessage());
		}

	}

	/**
	 * This method Clear and Enter value in Textbox
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			WebElement ele = getElement(locator);
			ele.click();
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Occured while Entering Value at the Element with locator of:" + locator + " "
					+ e.getMessage());
		}
	}

	/**
	 * This method checks whether element is displayed or not
	 * 
	 * @param locator
	 * @return True or False
	 */
	public boolean doIsDisplayed(By locator) {

		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					"Exception occured in doIsDisplayed method for the locator of:" + locator + " " + e.getMessage());
		}
		return false;

	}

	/**
	 * This method will return text from given element else null
	 * 
	 * @param locator
	 * @return getting text from Element
	 */
	public String doGetText(By locator) {

		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					"Exception occured in doGetText method for the locator of:" + locator + " " + e.getMessage());
		}
		return null;

	}

	/**
	 * This method will return Title of the Browser
	 * 
	 * @return Title of the Browser
	 */
	public String doGetTitle() {
		try {

			return dr.getTitle();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occured during getting Title in doGetTitle method:" + e.getMessage());
		}
		return null;
	}

	/**
	 * This method will return Atrribute property for the given element else null
	 * @param locator
	 * @param attributeName
	 * @return Attribute Property
	 */
	public String doGetAttribute(By locator, String attributeName) {

		try {

			return getElement(locator).getAttribute(attributeName);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					"Exception occured in while getting Attribute for locator:" + locator + " " + e.getMessage());
		}
		return null;

	}

}
