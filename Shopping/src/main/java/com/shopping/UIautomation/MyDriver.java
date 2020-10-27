package com.shopping.UIautomation;

		import com.fasterxml.jackson.core.JsonProcessingException;
		import com.fasterxml.jackson.databind.ObjectMapper;
		import com.shopping.APIautomation.baseService.shoppingService;
		import com.shopping.APIautomation.pojos.apiPojo;
		import io.restassured.RestAssured;
		import io.restassured.specification.RequestSpecification;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;

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

