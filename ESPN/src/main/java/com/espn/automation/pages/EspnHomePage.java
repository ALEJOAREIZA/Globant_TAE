package com.espn.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EspnHomePage extends BasePage{

	public EspnHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.espn.com/?src=com&_adblock=true\"");
	}

	@FindBy(id="global-user-trigger")
	public static WebElement userIcon;

	public void login(){
		try {
			wait.until(ExpectedConditions.visibilityOf(userIcon));
			userIcon.click();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
