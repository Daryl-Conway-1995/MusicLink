package com.qa.quickstart.seleniumJava;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoPractice {

ChromeDriver myDriver;
	
	@BeforeClass 
	public static void init()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\chromedriver.exe");
	}
	
	@Before
	public void setUp()
	{
		myDriver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		myDriver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		myDriver.navigate().to(url);
		assertEquals("http://automationpractice.com/index.php", myDriver.getCurrentUrl());
		WebElement search = myDriver.findElementById("search_query_top");
		search.sendKeys("shirt");
		WebElement searchB = myDriver.findElementByName("submit_search");
		searchB.submit();
		WebElement result = myDriver.findElementByXPath("//*[@id='center_column']/ul/li/div/div[2]/h5/a");
		assertEquals("Faded Short Sleeve T-shirts",result.getText());
	}


	@After 
	public void tearDown()
	{
		myDriver.close();
	}
	

}
