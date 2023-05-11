package com.pond.test;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MethodsPondScreen {

	
	
	
	public static List<WebElement> getFish()
	{
		List<WebElement> fish =ChromeBrowser.driver.findElements(By.cssSelector(".card-content>div.row"));
	
	return fish;
	}
	
	public static void createFish(String name,String color,String weight) 
	{

		ChromeBrowser.driver.findElements(By.cssSelector(".waves-effect.waves-light.pink.btn.white-text")).get(1).click();
		
		ChromeBrowser.driver.findElements(By.cssSelector("input#color")).get(0).sendKeys(color);
		ChromeBrowser.driver.findElements(By.cssSelector("input#weight")).get(0).sendKeys(weight);
		ChromeBrowser.driver.findElements(By.cssSelector("input#name")).get(0).sendKeys(name);
		ChromeBrowser.driver.findElements(By.cssSelector(".btn.pink.lighten-1")).get(0).click();
		
		
	}
	public static boolean createFish(String name,String color,String weight,String id) 
	{
		String pondId=ChromeBrowser.driver.findElements(By.cssSelector(".col.s4")).get(2).getText().split("ID:")[1];
		
		ChromeBrowser.driver.findElements(By.cssSelector(".waves-effect.waves-light.pink.btn.white-text")).get(1).click();
		
		ChromeBrowser.driver.findElements(By.cssSelector("input#color")).get(0).sendKeys(color);
		ChromeBrowser.driver.findElements(By.cssSelector("input#weight")).get(0).sendKeys(weight);
		ChromeBrowser.driver.findElements(By.cssSelector("input#name")).get(0).sendKeys(name);
		ChromeBrowser.driver.findElements(By.cssSelector(".btn.pink.lighten-1")).get(0).click();
		return  id.equals(pondId);
		
	}
	public static  String deletePond()
	{
		WebElement pondId= ChromeBrowser.driver.findElements(By.cssSelector(".col.s4")).get(2);
		String pondID=pondId.getText().split("ID:")[1];
		ChromeBrowser.driver.findElements(By.cssSelector(".waves-effect.waves-light.blue.btn.white-text")).get(0).click();
		ChromeBrowser.driver.findElements(By.cssSelector(".btn.blue.lighten-1")).get(0).click();
		
		return pondID;
	
	}
	public static String updatePond(String name)
	{
		String pondId=ChromeBrowser.driver.findElements(By.cssSelector(".col.s4")).get(2).getText().split("ID:")[1];
		System.out.println(pondId);
		ChromeBrowser.driver.findElements(By.cssSelector(".waves-effect.waves-light.blue.btn.white-text")).get(0).click();
		ChromeBrowser.driver.findElements(By.cssSelector("input#name")).get(0).clear();
		ChromeBrowser.driver.findElements(By.cssSelector("input#name")).get(0).sendKeys(name);
		ChromeBrowser.driver.findElements(By.cssSelector(".btn.pink.lighten-1")).get(0).click();
		
		
		return pondId;

	
	}
	public static WebElement findFish(String name,String color,String weight)   
	{
		 
		
		
		WebElement foundfish=null;
		WebElement fishDetails=null;
		String values=null;
		String regex= "^.*"+name+".*"+color+".*"+weight+".*";
		List<WebElement> fishRows =ChromeBrowser.driver.findElements(By.cssSelector(".card-content>div.row")); 
		System.out.println(fishRows.size());
		for (WebElement fishRow : fishRows) {
			if(fishRow.findElements(By.cssSelector(".col.s11")).size()>0)
			{	values=fishRow.findElement(By.cssSelector(".col.s11")).getText();
			   
			}
			
				if (Pattern.matches(regex,values))
				{	System.out.println("match - fish - found");
					fishDetails = fishRow.findElement(By.cssSelector(".col.s11+a"));
					 //System.out.println(fishDetails.getText()); prints out more linkk
					 				 
					
				}
			
		}
		return fishDetails;
	}
	

}
