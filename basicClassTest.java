package com.qa.quickstart.seleniumJava;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class basicClassTest {
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
		String url = "http://www.google.com";
		myDriver.navigate().to(url);
		assertEquals("https://www.google.com/?gws_rd=ssl", myDriver.getCurrentUrl());
	}

	@After 
	public void tearDown()
	{
		myDriver.close();
	}
	

}
