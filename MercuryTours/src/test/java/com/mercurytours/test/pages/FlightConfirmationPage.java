package com.mercurytours.test.pages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class FlightConfirmationPage extends SignedInPage {
	// Texts in the page	
	private static final String PAGE_TITLE_BEGINING = "flight confirmation";
	
	// Values for testChristmasInParis
	private static final CharSequence FLIGHT_BOOKED_CONFIRMATION_TEXT = "itinerary has been booked!";

	private static Logger log = Logger.getLogger(BookAFlightPage.class.getName());

	@Override
	Logger getLogger() {
		return log;
	}
	
	@Override
	String getPageTitleBegining() {
		return PAGE_TITLE_BEGINING;
	}
	
	public FlightConfirmationPage (WebDriver driver) {
		super(driver);
	}

	public void assertSuccessfullReservation() {
		assertTrue(driver.getPageSource().contains(FLIGHT_BOOKED_CONFIRMATION_TEXT));
	}

}
