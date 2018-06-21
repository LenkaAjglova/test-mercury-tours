package com.mercurytours.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends Page {
	// Texts in the page
	private static final String PAGE_TITLE_BEGINING = "welcome";
	private static final String LOGIN_PAGE_URL = "http://newtours.demoaut.com/index.php";
	private static final String LOGIN_INPUT_ELEMENT_NAME = "userName";
	private static final String PASSWORD_INPUT_ELEMENT_NAME = "password";
	private static final String LOGIN_BUTTON_ELEMENT_NAME = "login";

	// Values for testChristmasInParis
	private static final String VALID_LOGIN_NAME = "lenka";
	private static final String VALID_USERS_PASSWORD = "lenka";
	
	// Values for testInvalidLogin
	private static final String VALID_LOGIN_NAME_FOR_LOG_IN_FAILURE = "lenka";
	private static final String INVALID_PASSWORD = "password";
	
	private static Logger log = Logger.getLogger(WelcomePage.class.getName());
	
	@Override
	Logger getLogger() {
		return log;
	}
	
	@Override
	String getPageTitleBegining() {
		return PAGE_TITLE_BEGINING;
	}

	public WelcomePage(WebDriver driver) {
		super(driver);
		driver.get(LOGIN_PAGE_URL);
		log.trace("Open page: " + LOGIN_PAGE_URL);
		waitAndVerifyTitleStartsWith(driver, PAGE_TITLE_BEGINING, log);
	}
	
	public FindAFlightPage loginValidUser() {
		fillInLoginName(VALID_LOGIN_NAME);
		fillInPassword(VALID_USERS_PASSWORD);

		pressLoginButton();
		
		return new FindAFlightPage (driver);
	}

	public void pressLoginButton() {
		WebElement loginButton = driver.findElement(By.name(LOGIN_BUTTON_ELEMENT_NAME));
		loginButton.click();
		log.trace("Click on login button");
	}

	public void fillInPassword(String password) {
		WebElement passwordInput = driver.findElement(By.name(PASSWORD_INPUT_ELEMENT_NAME));
		passwordInput.sendKeys(password);
		log.trace("Fill in password: " + password);
	}

	public void fillInLoginName(String loginName) {
		WebElement loginInput = driver.findElement(By.name(LOGIN_INPUT_ELEMENT_NAME));
		loginInput.sendKeys(loginName);
		log.trace("Fill in login name: " + loginName);
	}

	public LogInPage logInWithInvalidPassword() {
		fillInLoginName(VALID_LOGIN_NAME_FOR_LOG_IN_FAILURE);
		fillInPassword(INVALID_PASSWORD);
		pressLoginButton();
		return new LogInPage(driver);
	}
}
