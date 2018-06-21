package com.qa.quickstart.seleniumJava;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class phptravelsTest {
	ChromeDriver myDriver;
	static ExtentReports processReport;
	ExtentTest test;
	
	public void pushButton(String button)
	{
		//takes a xpath and pushes the related button
		try {
			myDriver.findElementByXPath(button).click();
			test.log(LogStatus.PASS, "button found.");
			myDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, "button not found.");
		}
	}
	
	public void pushButtonClass(String button)
	{
		//takes a xpath and pushes the related button
		try {
			myDriver.findElementByClassName(button).click();
			test.log(LogStatus.PASS, "button found.");
			myDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, "button not found.");
		}
	}
	
	public void pushButtonID(String button)
	{
		//takes a xpath and pushes the related button
		try {
			myDriver.findElementById(button).click();
			test.log(LogStatus.PASS, "button found.");
			myDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, "button not found.");
		}
	}
	
	public void testAttrId(String id, String wanted, String Attr) {
		//checks colour of given element
		try {
			if(Attr.equals("text"))
			{
				assertEquals(wanted,myDriver.findElementById(id).getText());
			}else
			{
				assertEquals(wanted,myDriver.findElementById(id).getAttribute(Attr));
			}
			test.log(LogStatus.PASS, "value of "+wanted+" was a match");
		}catch(Error e)
		{
			if(Attr.equals("text"))
			{
				test.log(LogStatus.FAIL, "the result was: "+ myDriver.findElementById(id).getText());
			}else
			{
				test.log(LogStatus.FAIL, "the result was: "+ myDriver.findElementById(id).getAttribute(Attr));
			}
		}
	}
	
	public void textInsert(String location, String input)
	{
		myDriver.findElementByClassName(location).sendKeys(input);
	}
	
	@BeforeClass 
	public static void init()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\chromedriver.exe");
		processReport = new ExtentReports("C:\\Users\\Admin\\Desktop\\TravelReport.html",true);
	}
	
	@Before
	public void setUp()
	{
		myDriver = new ChromeDriver();
	}

//	@Test
//	public void POMtest() {
//		test = processReport.startTest("start of travel test.");
//		myDriver.manage().window().maximize();
//		String url = "https://www.phptravels.net/";
//		myDriver.navigate().to(url);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			assertEquals(url, myDriver.getCurrentUrl());
//			test.log(LogStatus.PASS, "url was a match");
//		}catch(Error e)
//		{
//			test.log(LogStatus.FAIL, "url was incorrect");
//		}
//		travelHomePage THP = PageFactory.initElements(myDriver, travelHomePage.class);
//		THP.clickLocation();
//		THP.locationInput("London");
//	}

		@Test
		public void test() {
			test = processReport.startTest("start of travel test.");
			myDriver.manage().window().maximize();
			String url = "https://www.phptravels.net/";
			myDriver.navigate().to(url);
			try {
				assertEquals(url, myDriver.getCurrentUrl());
				test.log(LogStatus.PASS, "url was a match");
			}catch(Error e)
			{
				test.log(LogStatus.FAIL, "url was incorrect");
			}
			pushButtonClass("select2-choice");
			textInsert("select2-choice","London");
			ArrayList<WebElement> autoSuggest = new ArrayList<WebElement> (myDriver.findElements(By.className("select2-result-selectable")));
			test.log(LogStatus.INFO, "length of autocorrect list is "+autoSuggest.size());
			for (int i =0;i<autoSuggest.size();i++)
			{
				if(autoSuggest.get(i).getText().equals("London, United Kingdom"))
				{
				autoSuggest.get(i).click(); 
				test.log(LogStatus.INFO, "Found london and clicked");
				i=autoSuggest.size();
				}
				else
				{
					test.log(LogStatus.INFO, "element in "+ i+" = "+autoSuggest.get(i).getText());
				}
			}
			pushButtonClass("dpd1");
			pushButton("/html/body/div[8]/div[1]/table/tbody/tr[5]/td[4]");
			pushButton("/html/body/div[9]/div[1]/table/tbody/tr[5]/td[6]");
			pushButtonID("travellersInput");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pushButtonID("input-group-btn");
			testAttrId("travellersInput","2 Adult 1 Child","value");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
	
	@After 
	public void tearDown()
	{
		processReport.endTest(test);
		myDriver.quit();
		processReport.flush();
	}
	
}
