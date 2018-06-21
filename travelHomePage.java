package com.qa.quickstart.seleniumJava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class travelHomePage {
	
	@FindBy(xpath="(//input[@type='text'])[33]")
	private WebElement location;
	
//	@FindBy(id="dpd1") 
//	private WebElement checkIn;
//	
//	@FindBy(id="dpd2") 
//	private WebElement checkOut;
//	
//	@FindBy(id="travellersInput") 
//	private WebElement people;
//	
	public void clickLocation()
	{
		location.click();
	}
	
	public void locationInput(String input)
	{
		location.sendKeys(input);
	}
	
//	public void clickcheckIn()
//	{
//		checkIn.click();
//	}
//	
//	public void clickcheckOut()
//	{
//		checkOut.click();
//	}
//	
//	public void clickpeople()
//	{
//		people.click();
//	}
//
}
