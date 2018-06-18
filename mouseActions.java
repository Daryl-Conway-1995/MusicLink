package com.qa.quickstart.seleniumJava;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseActions {

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
		String url = "http://demoqa.com/";
		myDriver.navigate().to(url);
		assertEquals("http://demoqa.com/", myDriver.getCurrentUrl());
		WebElement dropButton = myDriver.findElementByXPath("//*[@id='menu-item-141']/a");
		dropButton.submit();
		WebElement dropBox = myDriver.findElementByXPath("//*[@id=\"draggableview\"]/p");
		
	}
	

	@After 
	public void tearDown()
	{
		myDriver.close();
	}
	
}
