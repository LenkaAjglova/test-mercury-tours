package com.mercurytours.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class SignedInPage extends Page {
	// Texts in the page
	private static final String SIGN_OUT_LINK_TEXT = "SIGN-OFF";

	public SignedInPage(WebDriver driver) {
		super(driver);
		waitAndVerifyTitleStartsWith(driver, getPageTitleBegining(), getLogger());
	}
	
	public LogInPage signOut() {
		driver.findElement(By.linkText(SIGN_OUT_LINK_TEXT)).click();
		return new LogInPage(driver);
	}

}