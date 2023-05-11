package com.pond.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementsPondScreen {
	
	
	public List<WebElement> getFish()
	{
		List<WebElement> fish =ChromeBrowser.driver.findElements(By.cssSelector(".col.s1")); 
	
	return fish;
	}
}
