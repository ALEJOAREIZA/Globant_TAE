package com.espn.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppPage extends BasePage{
	
	public AppPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="firstHeading")
	private WebElement pageTitle;

	@FindBy(linkText="Privacy policy")
	private WebElement privacyLink;
	
	public String getPageTitle() {
		return pageTitle.getText();
	}
	
}
