package com.qa.quickstart.seleniumJava;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import org.junit.Test;

public class MouseMovements {
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
		
		public void openWindow(String url)
		{
			//opens a window of given url
			myDriver.manage().window().maximize();
			myDriver.navigate().to(url);
			testWeb(url);
		}
		
		public void testWeb(String url)throws AssertionError
		{
			//tests for url change
			try {
				assertEquals(url, myDriver.getCurrentUrl());
				test.log(LogStatus.PASS, "url was a match");
			}catch(Error e)
			{
				test.log(LogStatus.FAIL, "url was incorrect");
			}
		}
		public void testCSS(String location, String wanted, String Attr) {
			//checks colour of given element
			try {
				assertEquals(wanted,myDriver.findElementByXPath(location).getCssValue(Attr));
				test.log(LogStatus.PASS, "value of "+wanted+" was a match");
			}catch(Error e)
			{
				test.log(LogStatus.FAIL, "value of "+wanted+" was incorrect");
			}
		}
		
		public void testAttr(String location, String wanted, String Attr) {
			//checks colour of given element
			try {
				if(Attr.equals("text"))
				{
					assertEquals(wanted,myDriver.findElementByXPath(location).getText());
				}else
				{
					assertEquals(wanted,myDriver.findElementByXPath(location).getAttribute(Attr));
				}
				test.log(LogStatus.PASS, "value of "+wanted+" was a match");
			}catch(Error e)
			{
				if(Attr.equals("text"))
				{
					test.log(LogStatus.FAIL, "the result was: "+ myDriver.findElementByXPath(location).getText());
				}else
				{
					test.log(LogStatus.FAIL, "the result was: "+ myDriver.findElementByXPath(location).getAttribute(Attr));
				}
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
		
		public void testClass(String classInput, String wanted, String Attr) {
			//checks colour of given element
			try {
				if(Attr.equals("text"))
				{
					assertEquals(wanted,myDriver.findElementByClassName(classInput).getText());
				}else
				{
					assertEquals(wanted,myDriver.findElementByClassName(classInput).getAttribute(Attr));
				}
				test.log(LogStatus.PASS, "value of "+wanted+" was a match");
			}catch(Error e)
			{
				if(Attr.equals("text"))
				{
					test.log(LogStatus.FAIL, "the result was: "+ myDriver.findElementByClassName(classInput).getText());
				}else
				{
					test.log(LogStatus.FAIL, "the result was: "+ myDriver.findElementByClassName(classInput).getAttribute(Attr));
				}
			}
		}
		
		public void textInsert(String location, String input)
		{
			myDriver.findElementByXPath(location).sendKeys(input);
		}
		
		@BeforeClass 
		public static void init()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\chromedriver.exe");
			processReport = new ExtentReports("C:\\Users\\Admin\\Desktop\\webReport.html",true);
		}
		
		@Before
		public void setUp()
		{
			myDriver = new ChromeDriver();
		}
	
		
		
		
		@Test
		public void dragTest() {
			test = processReport.startTest("start of drag test.");
			openWindow("http://demoqa.com/");
			pushButtonID("menu-item-141");
			Actions builder = new Actions(myDriver);
			WebElement from = myDriver.findElementByXPath("//*[@id='draggableview']/p");
			WebElement to = myDriver.findElementByXPath("//*[@id='droppableview']");
			try {
				Action dragNDrop = builder.clickAndHold(from).moveToElement(to).release(from).build();
				dragNDrop.perform();
				myDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
			}catch(Exception e)
			{System.out.println(e);}
			assertEquals("Dropped!",to.getText());
		}
		
		
		
		@Test 
		public void POMTest()
		{
			test = processReport.startTest("start of POM test.");
			openWindow("http://demoqa.com/");
			HomePage homePage= PageFactory.initElements(myDriver, HomePage.class);
			homePage.clickSelect();
			selectPage selectPage = PageFactory.initElements(myDriver, selectPage.class);
			selectPage.click1();
			try {
				assertEquals(true,selectPage.isSelected1());
				test.log(LogStatus.PASS, "element 1 was selected");
			}catch(Error e) {
				test.log(LogStatus.FAIL, "element 1 was not selected");
			}
			selectPage.isSelected5();
			try {
				assertEquals(false,selectPage.isSelected1());
				test.log(LogStatus.PASS, "element 5 was not selected");
			}catch(Error e) {
				test.log(LogStatus.FAIL, "element 5 was selected");
			}
		}
		
		
		@Test
		public void selectTest() {
			test = processReport.startTest("start of select test.");
			openWindow("http://demoqa.com/");
			pushButtonID("menu-item-142");
			pushButton("//*[@id=\"selectable\"]/li[1]"); 
			testClass("ui-selected","Item 1","text");
			pushButton("//*[@id=\"selectable\"]/li[5]");
			testClass("ui-selected","Item 5","text");
			test.log(LogStatus.INFO, "numbers above use the class of ui-selected. it changes with the value changes with each selected item.");
			
		}	
		
		@Test 
		public void acordTest()
		{
			test = processReport.startTest("start of accord test.");
			openWindow("http://demoqa.com/");
			pushButtonID("menu-item-144");
			testWeb("http://demoqa.com/accordion/");
			pushButton("//*[@id=\"ui-id-4\"]");
			testAttr("//*[@id=\"ui-id-5\"]","false","aria-hidden");  
			testAttr("//*[@id=\"ui-id-7\"]","true","aria-hidden");
			pushButton("//*[@id=\"ui-id-6\"]");
			testAttr("//*[@id=\"ui-id-5\"]","true","aria-hidden");
			testAttr("//*[@id=\"ui-id-7\"]","false","aria-hidden");
		}
		@Test
		public void autoCTest()
		{
			test = processReport.startTest("start of autocorrect test.");
			openWindow("http://demoqa.com/");
			pushButtonID("menu-item-145");
			testWeb("http://demoqa.com/autocomplete/");
			pushButton("//*[@id=\"tagss\"]");
			textInsert("//*[@id=\"tagss\"]","a");
			try{
				Thread.sleep(500);
			}catch(Exception e){
				e.printStackTrace();
			}
			String found = "display: block; width: 205px; top: 423px; left: 586px;";
			testAttr("//*[@id=\"ui-id-1\"]",found,"style");
			ArrayList<WebElement> autoSuggest = new ArrayList<WebElement> (myDriver.findElements(By.className("ui-menu-item")));
			for (int i =0;i<autoSuggest.size();i++)
			{
				if(autoSuggest.get(i).getText().equals("Haskell"))
				{
				autoSuggest.get(i).click(); 
				testAttr("//*[@id=\"tagss\"]","Haskell","value");
				}
			}
			test.log(LogStatus.INFO, "length of autocorrect list is "+autoSuggest.size());
		}
		@Test
		public void sliderTest()
		{
			test = processReport.startTest("start of slider test.");
			openWindow("http://demoqa.com/");
			pushButtonID("menu-item-97");
			testWeb("http://demoqa.com/slider/");
			Actions builder = new Actions(myDriver);
			WebElement handle = myDriver.findElementByClassName("ui-slider-handle");
			try {
				Action dragNDrop = builder.clickAndHold(handle).moveByOffset(500, 0).release(handle).build();
				dragNDrop.perform();
			}catch(Exception e)
			{System.out.println(e);}
			testAttrId("amount1","9","value");
			try {
				Action dragNDrop2 = builder.clickAndHold(handle).moveByOffset(-400, 0).release(handle).build();
				dragNDrop2.perform();
			}catch(Exception e) {}
			testAttrId("amount1","4","value");
		}
		@Test
		public void tabsTest()
		{
			test = processReport.startTest("start of tab test.");
			openWindow("http://demoqa.com/");
			pushButtonID("menu-item-98");
			testWeb("http://demoqa.com/tabs/");
			pushButtonID("ui-id-1");
			testAttr("//*[@id=\"tabs222\"]/ul/li[1]","true","aria-selected");
			testAttr("//*[@id=\"tabs222\"]/ul/li[2]","false","aria-selected");
			pushButtonID("ui-id-2");
			testAttr("//*[@id=\"tabs222\"]/ul/li[1]","false","aria-selected");
			testAttr("//*[@id=\"tabs222\"]/ul/li[2]","true","aria-selected");
		}
		
		@After 
		public void tearDown()
		{
			processReport.endTest(test);
			myDriver.quit();
			processReport.flush();
		}
		
}