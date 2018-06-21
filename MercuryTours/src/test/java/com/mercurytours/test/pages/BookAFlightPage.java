package com.mercurytours.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookAFlightPage extends SignedInPage {
	// Texts in the page	
	private static final String PAGE_TITLE_BEGINING = "book a flight";
	private static final String SECURE_PURCHASE_BUTTON_NAME = "buyFlights";
	private static final String FIRST_NAME_INPUT_ELEMENT_NAME = "passFirst0";
	private static final String LAST_NAME_INPUT_ELEMENT_NAME = "passLast0";
	private static final String PREFERRED_MEAL_SELECT_ELEMENT_NAME = "pass.0.meal";
	private static final String CARD_COMPANY_SELECT_ELEMENT_NAME = "creditCard";
	private static final String CARD_NUMBER_INPUT_ELEMENT_NAME = "creditnumber";
	private static final String CARD_EXPIRATION_MONTH_SELECT_ELEMENT_NAME = "cc_exp_dt_mn";
	private static final String CARD_EXPIRATION_YEAR_SELECT_ELEMENT_NAME = "cc_exp_dt_yr";
	
	// Values for testChristmasInParis
	private static final String FIRST_NAME_VALUE = "Lenka";
	private static final String LAST_NAME_VALUE = "Ajglova";
	private static final String PREFERED_MEAL_VALUE = "Vegetarian";
	private static final String CARD_COMPANY_VALUE = "Visa";
	private static final String CARD_NUMBER_VALUE = "111";
	private static final String CARD_EXPIRATION_MONTH_VALUE = "10";
	private static final String CARD_EXPIRATION_YEAR_VALUE = "2010";

	private static Logger log = Logger.getLogger(BookAFlightPage.class.getName());

	@Override
	Logger getLogger() {
		return log;
	}
	
	@Override
	String getPageTitleBegining() {
		return PAGE_TITLE_BEGINING;
	}

	public BookAFlightPage (WebDriver driver) {
		super(driver);
	}
	
	public FlightConfirmationPage fillInCreditCardValues() {
		fillInFirstName(FIRST_NAME_VALUE);
		fillInLastName(LAST_NAME_VALUE);
		fillInPreferredMeal(PREFERED_MEAL_VALUE);
		fillInPaymentCardCompany(CARD_COMPANY_VALUE);
		fillInCardNumber(CARD_NUMBER_VALUE);
		fillInCardValidity(CARD_EXPIRATION_MONTH_VALUE, CARD_EXPIRATION_YEAR_VALUE);
		return clickOnSecurePurchase();
	}

	private void fillInCardValidity(String cardExpirationMonthValue, String cardExpirationYearValue) {
		Select expirationMonth = new Select(driver.findElement(By.name(CARD_EXPIRATION_MONTH_SELECT_ELEMENT_NAME)));
		expirationMonth.selectByVisibleText(cardExpirationMonthValue);
		Select expirationYear = new Select(driver.findElement(By.name(CARD_EXPIRATION_YEAR_SELECT_ELEMENT_NAME)));
		expirationYear.selectByVisibleText(cardExpirationYearValue);
	}

	private void fillInCardNumber(String cardNumberValue) {
		WebElement cardNumber = driver.findElement(By.name(CARD_NUMBER_INPUT_ELEMENT_NAME));
		cardNumber.sendKeys(cardNumberValue);
	}

	private void fillInPaymentCardCompany(String cardCompanyValue) {
		Select card = new Select(driver.findElement(By.name(CARD_COMPANY_SELECT_ELEMENT_NAME)));
		card.selectByVisibleText(cardCompanyValue);
	}

	private void fillInPreferredMeal(String preferedMealValue) {
		Select meal = new Select(driver.findElement(By.name(PREFERRED_MEAL_SELECT_ELEMENT_NAME)));
		meal.selectByVisibleText(preferedMealValue);
	}

	private void fillInLastName(String lastNameValue) {
		WebElement lastNameInput = driver.findElement(By.name(LAST_NAME_INPUT_ELEMENT_NAME));
		lastNameInput.sendKeys(lastNameValue);
	}

	private void fillInFirstName(String firstNameValue) {
		WebElement firstNameInput = driver.findElement(By.name(FIRST_NAME_INPUT_ELEMENT_NAME));
		firstNameInput.sendKeys(firstNameValue);
	}

	private FlightConfirmationPage clickOnSecurePurchase() {
		driver.findElement(By.name(SECURE_PURCHASE_BUTTON_NAME)).click();
		return new FlightConfirmationPage(driver);
	}
}
