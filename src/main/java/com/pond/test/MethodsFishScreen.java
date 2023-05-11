package com.pond.test;

import org.openqa.selenium.By;

public class MethodsFishScreen {

	
	public static void deleteFish()
	{
		System.out.println(ChromeBrowser.driver.findElements(By.cssSelector("button.btn.blue.lighten-1")).size());
		ChromeBrowser.driver.findElements(By.cssSelector("button.btn.blue.lighten-1")).get(0).click();
		
	}
	public static void updateFish(String name,String color,String weight)
	{
		ChromeBrowser.driver.findElements(By.cssSelector("input#color")).get(0).clear();		
		ChromeBrowser.driver.findElements(By.cssSelector("input#color")).get(0).sendKeys(color);
		
		ChromeBrowser.driver.findElements(By.cssSelector("input#weight")).get(0).clear();;
		ChromeBrowser.driver.findElements(By.cssSelector("input#weight")).get(0).sendKeys(weight);
		
		ChromeBrowser.driver.findElements(By.cssSelector("input#name")).get(0).clear();
		ChromeBrowser.driver.findElements(By.cssSelector("input#name")).get(0).sendKeys(name);
		
		ChromeBrowser.driver.findElements(By.cssSelector("button.btn.pink.lighten-1")).get(0).click();
		
		try {
			System.out.println("testing"+ChromeBrowser.driver.findElements(By.cssSelector("button.btn.pink.lighten-1")).size());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
