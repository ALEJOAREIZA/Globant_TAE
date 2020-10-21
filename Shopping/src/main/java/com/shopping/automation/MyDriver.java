package com.shopping.automation;

		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;

		import java.util.concurrent.TimeUnit;

public class MyDriver {

	private WebDriver driver;

	public MyDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://34.205.174.166/product/alejandro-areiza/");
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
	public void getPage(String url){
		driver.get(url);
	}
}

