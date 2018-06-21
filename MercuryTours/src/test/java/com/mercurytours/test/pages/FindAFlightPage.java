package com.mercurytours.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindAFlightPage extends SignedInPage {
	// Texts in the page
	private static final String PAGE_TITLE_BEGINING = "find a flight";
	private static final String CONTINUE_BUTTON_ELEMENT_NAME = "findFlights";
	private static final String FROM_PORT_SELECT_ELEMENT_NAME = "fromPort";
	private static final String TO_PORT_SELECT_ELEMENT_NAME = "toPort";
	private static final String FROM_MONTH_SELECT_ELEMENT_NAME = "fromMonth";
	private static final String FROM_DAY_SELECT_ELEMENT_NAME = "fromDay";
	private static final String TO_MONTH_SELECT_ELEMENT_NAME = "toMonth";
	private static final String TO_DAY_SELECT_ELEMENT_NAME = "toDay";
	
	// Values for testChristmasInParis
	private static final String VALID_DEPARTING_PORT_VALUE = "London";
	private static final String VALID_ARRIVING_TO_VALUE = "Paris";
	private static final String VALID_DEPARTING_MONTH_VALUE = "December";
	private static final String VALID_DEPARTING_DAY_VALUE = "24";
	private static final String VALID_ARRIVING_MONTH_VALUE = "December";
	private static final String VALID_ARRIVING_DAY_VALUE = "31";
	
	private static Logger log = Logger.getLogger(FindAFlightPage.class.getName());
	
	@Override
	Logger getLogger() {
		return log;
	}
	
	@Override
	String getPageTitleBegining() {
		return PAGE_TITLE_BEGINING;
	}

	public FindAFlightPage (WebDriver driver) {
		super(driver);
	}

	public SelectAFlightPage fillInForm() {
		fillInDepartingFrom(VALID_DEPARTING_PORT_VALUE);
		fillInArrivingIn(VALID_ARRIVING_TO_VALUE);
		fillInDepartureDate(VALID_DEPARTING_MONTH_VALUE, VALID_DEPARTING_DAY_VALUE);
		fillInArrivalDate(VALID_ARRIVING_MONTH_VALUE, VALID_ARRIVING_DAY_VALUE);
		return clickOnContinue();
	}
	
	private void fillInArrivalDate(String month, String day) {
		Select toMonth = new Select(driver.findElement(By.name(TO_MONTH_SELECT_ELEMENT_NAME)));
		toMonth.selectByVisibleText(month);
		Select toDay = new Select(driver.findElement(By.name(TO_DAY_SELECT_ELEMENT_NAME)));
		toDay.selectByVisibleText(day);
	}

	private void fillInDepartureDate(String month, String day) {
		Select fromMonth = new Select(driver.findElement(By.name(FROM_MONTH_SELECT_ELEMENT_NAME)));
		fromMonth.selectByVisibleText(month);
		Select fromDay = new Select(driver.findElement(By.name(FROM_DAY_SELECT_ELEMENT_NAME)));
		fromDay.selectByVisibleText(day);
	}

	private void fillInArrivingIn(String port) {
		Select toPort = new Select(driver.findElement(By.name(TO_PORT_SELECT_ELEMENT_NAME)));
		toPort.selectByVisibleText(port);
	}

	public void fillInDepartingFrom (String port) {
		Select fromPort = new Select(driver.findElement(By.name(FROM_PORT_SELECT_ELEMENT_NAME)));
		fromPort.selectByVisibleText(port);
	}
	
	public SelectAFlightPage clickOnContinue() {
		WebElement continueButton = driver.findElement(By.name(CONTINUE_BUTTON_ELEMENT_NAME));
		continueButton.click();
		return new SelectAFlightPage (driver);
	}
}
