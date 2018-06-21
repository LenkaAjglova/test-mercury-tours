package com.mercurytours.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.mercurytours.test.pages.WelcomePage;
import com.mercurytours.test.pages.SelectAFlightPage;
import com.mercurytours.test.pages.BookAFlightPage;
import com.mercurytours.test.pages.FindAFlightPage;
import com.mercurytours.test.pages.FlightConfirmationPage;
import com.mercurytours.test.pages.LogInPage;

public class MercuryToursTest {
	
	private static Logger log = Logger.getLogger(MercuryToursTest.class.getName());
	private WebDriver driver = null;
	
	@Before
	public void setupDriverForTest() {
		driver = new FirefoxDriver();
		log.trace("Driver created");		
	}
	
	@After
	public void quitDriver() {
		try {
			driver.quit();
			log.trace("Driver quit");
		} catch (Exception e) {
			log.debug("Cannot quit driver at the end of test:");
			log.debug(e.getStackTrace());
			// fails if no driver created at the beginning of the test, no action needed
		}
	}

	@Test
	public void testChristmasInParis () {
		WelcomePage lp = new WelcomePage (driver);
		FindAFlightPage ffp = lp.loginValidUser();
		SelectAFlightPage sfp = ffp.fillInForm();
		BookAFlightPage bfp = sfp.selectFlights();
		FlightConfirmationPage fcp = bfp.fillInCreditCardValues();
		fcp.assertSuccessfullReservation();
		fcp.signOut();
		//TODO: remove static sleep and useless assert when working
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(true);
		log.trace("Assert done");
	}
	
	@Test
	public void testInvalidLogin() {
		WelcomePage wp = new WelcomePage(driver);
		LogInPage lp = wp.logInWithInvalidPassword();
		// When log in doesn't succeed, user is redirected to login page (without any warning). There is assert, that it is really a login page in the constructor.
	}
}
