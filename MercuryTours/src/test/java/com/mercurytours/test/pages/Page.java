package com.mercurytours.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	protected WebDriver driver = null;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	abstract Logger getLogger();

	abstract String getPageTitleBegining();

	protected void waitAndVerifyTitleStartsWith(WebDriver driver, final String pageTitleBegining, Logger log) {
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(pageTitleBegining);
			}
		});
		log.debug("Loaded page: "+ driver.getTitle());
	}

}