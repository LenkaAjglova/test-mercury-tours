package com.mercurytours.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LogInPage extends Page {
	// Texts in the page
	private static final String PAGE_TITLE_BEGINING = "sign-on";

	private static Logger log = Logger.getLogger(WelcomePage.class.getName());
	
	@Override
	Logger getLogger() {
		return log;
	}
	
	@Override
	String getPageTitleBegining() {
		return PAGE_TITLE_BEGINING;
	}

	public LogInPage(WebDriver driver) {
		super(driver);
		waitAndVerifyTitleStartsWith(driver, PAGE_TITLE_BEGINING, log);
	}

}
