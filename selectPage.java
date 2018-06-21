package com.qa.quickstart.seleniumJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class selectPage {

	@FindBy(xpath="//*[@id=\"selectable\"]/li[1]") 
	private WebElement button1;
	
	@FindBy(xpath="//*[@id=\"selectable\"]/li[5]") 
	private WebElement button5;

	public void click1()
	{
		button1.click();
	}
	
	public String isSelected(WebDriver myDrive)
	{
		return myDrive.findElement(By.className("ui-selected")).getText();
	}
	
	
	public void click5()
	{
		button5.click();
	}
}
