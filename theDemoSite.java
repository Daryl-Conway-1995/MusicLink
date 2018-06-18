package com.qa.quickstart.seleniumJava;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class theDemoSite {
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
		String url = "http://thedemosite.co.uk/";
		myDriver.navigate().to(url);
		assertEquals("http://thedemosite.co.uk/", myDriver.getCurrentUrl());
	}

	@After 
	public void tearDown()
	{
		myDriver.close();
	}
	

}
