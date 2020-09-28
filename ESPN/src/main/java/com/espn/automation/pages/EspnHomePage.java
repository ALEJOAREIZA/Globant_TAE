package com.espn.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EspnHomePage extends BasePage{
	
	 
	public EspnHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.espn.com/?src=com&_adblock=true");
	}
	@FindBy(css="title")
	public WebElement pageTitle;


	public String getPageTitle() {
		return pageTitle.getText();
	}

}
