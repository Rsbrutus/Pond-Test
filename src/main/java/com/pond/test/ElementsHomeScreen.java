package com.pond.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsHomeScreen {
	
 static	List<WebElement> getPondElements(){
		
		List<WebElement>  PondElements = ChromeBrowser.driver.findElements(By.cssSelector(".card-content.grey-text.text-darken-3"));  
		for (WebElement pond : PondElements) {
			String values[]=pond.getText().split("ID");
			
		}
		return PondElements;
	}
 
 static WebElement getPond(String name)
 {
	 List<WebElement>  PondElements = getPondElements();
	 WebElement chosenPond=null;
	 for (WebElement pond : PondElements) {
			if (pond.getText().contains(name))
				chosenPond= pond;
		}
	 return chosenPond;
 }
	
}
	
