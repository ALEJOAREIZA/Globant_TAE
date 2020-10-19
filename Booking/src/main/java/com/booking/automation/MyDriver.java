package com.booking.automation;

		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;

		import java.util.concurrent.TimeUnit;

public class MyDriver {

	private WebDriver driver;

	public MyDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.booking.com/index.es.html");
		driver.manage().window().maximize();
	}
	public WebDriver getDriver() {
		return this.driver;
	}
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}
	public String getTitle(){
		return driver.getTitle();
	}
}

