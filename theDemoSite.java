package com.qa.quickstart.seleniumJava;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
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
		String url = "http://thedemosite.co.uk/index.php";
		myDriver.navigate().to(url);
		assertEquals("http://thedemosite.co.uk/index.php", myDriver.getCurrentUrl());
		WebElement linkElem = myDriver.findElementByLinkText("3. Add a User");
		linkElem.click();
		assertEquals("http://thedemosite.co.uk/addauser.php", myDriver.getCurrentUrl());
		WebElement nameInput = myDriver.findElementByName("username");
		nameInput.sendKeys("simpleLogin");
		WebElement passInput =  myDriver.findElementByName("password");
		passInput.sendKeys("simpleLogin");
		WebElement buttonAdd =  myDriver.findElementByName("FormsButton2");
		buttonAdd.submit();
		WebElement linkElem2 = myDriver.findElementByLinkText("4. Login");
		linkElem2.click();
		assertEquals("http://thedemosite.co.uk/login.php", myDriver.getCurrentUrl());
		WebElement nameInput2 = myDriver.findElementByName("username");
		nameInput2.sendKeys("simpleLogin");
		WebElement passInput2 =  myDriver.findElementByName("password");
		passInput2.sendKeys("simpleLogin");
		WebElement buttonAdd2 =  myDriver.findElementByName("FormsButton2");
		buttonAdd2.submit();
		String message = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b";
		assertEquals("**Successful Login**",myDriver.findElementByXPath(message).getText());
		
		
	}

	@After 
	public void tearDown()
	{
		myDriver.close();
	}
	

}
