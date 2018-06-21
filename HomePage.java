package com.qa.quickstart.seleniumJava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="//*[@id=\"menu-item-142\"]/a") 
	private WebElement selectButton;
	
	@FindBy(id="menu-item-141") 
	private WebElement dragButton;

	public void clickSelect()
	{
		selectButton.click();
	}
	
	public void clickDrag()
	{
		dragButton.click();
	}
	
	
}
