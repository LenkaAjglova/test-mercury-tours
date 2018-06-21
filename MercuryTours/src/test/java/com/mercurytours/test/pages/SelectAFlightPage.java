package com.mercurytours.test.pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mercurytours.test.pages.SignedInPage;

public class SelectAFlightPage extends SignedInPage {
	// Texts in the page
	private static final String PAGE_TITLE_BEGINING = "select a flight";
	private static final String OUT_FLIGHTS_ELEMENTS_NAME = "outFlight";
	private static final String IN_FLIGHTS_ELEMENTS_NAME = "inFlight";
	private static final String CONTINUE_BUTTON_ELEMENT_NAME = "reserveFlights";

	// Values for testChristmasInParis
	private static final long EXPECTED_NUMBER_OF_OUT_FLIGHTS = 4;
	private static final int NUMBER_OF_SELECTED_OUT_FLIGHT = 2;
	private static final long EXPECTED_NUMBER_OF_IN_FLIGHTS = 4;
	private static final int NUMBER_OF_SELECTED_IN_FLIGHT = 2;
	
	private static Logger log = Logger.getLogger(SelectAFlightPage.class.getName());

	@Override
	Logger getLogger() {
		return log;
	}
	
	@Override
	String getPageTitleBegining() {
		return PAGE_TITLE_BEGINING;
	}

	public SelectAFlightPage(WebDriver driver) {
		super(driver);
	}
	
	public BookAFlightPage selectFlights() {
		selectFlightTo(NUMBER_OF_SELECTED_OUT_FLIGHT, EXPECTED_NUMBER_OF_OUT_FLIGHTS);
		selectFlightBack(NUMBER_OF_SELECTED_IN_FLIGHT, EXPECTED_NUMBER_OF_IN_FLIGHTS);
		return clickOnContinue();
	}

	private BookAFlightPage clickOnContinue() {
		WebElement continueButton = driver.findElement(By.name(CONTINUE_BUTTON_ELEMENT_NAME));
		continueButton.click();
		return new BookAFlightPage (driver);
	}

	private void selectFlightBack(int selectedFlight, long totalNumber) {
		List<WebElement> flights = driver.findElements(By.name(IN_FLIGHTS_ELEMENTS_NAME)); 
		assertEquals(totalNumber, flights.size());
		log.trace("Verified that number of out flights is: " + totalNumber);
		flights.get(selectedFlight-1).click(); // selectedFlight-1, because List is counted by 0, but human being counts flights in the table by 1
		log.trace("Clicked on out flight number: " + selectedFlight);
	}

	private void selectFlightTo(int selectedFlight, long totalNumber) {
		List<WebElement> flights = driver.findElements(By.name(OUT_FLIGHTS_ELEMENTS_NAME)); 
		assertEquals(totalNumber, flights.size());
		log.trace("Verified that number of out flights is: " + totalNumber);
		flights.get(selectedFlight-1).click(); // selectedFlight-1, because List is counted by 0, but human being counts flights in the table by 1
		log.trace("Clicked on out flight number: " + selectedFlight);
	}

}
