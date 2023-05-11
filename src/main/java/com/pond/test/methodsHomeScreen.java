package com.pond.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class methodsHomeScreen {

	
	static void CreatePond(String Name)
	{
		 
		
			 
				 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	
		 ChromeBrowser.driver.findElements(By.cssSelector(".waves-effect.waves-light.pink.btn.white-text")).get(0).click();
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 ChromeBrowser.driver.findElements(By.cssSelector("input#name")).get(0).sendKeys(Name);
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 ChromeBrowser.driver.findElements(By.cssSelector(".btn.pink.lighten-1")).get(0).click();
		 
	}
}
