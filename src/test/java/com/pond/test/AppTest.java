package com.pond.test;

import org.testng.Assert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
	String pondName = "Pond 1";
	String fishDetails[]= {"fish 1","green","12"};
	String fishDetailsUpdate[]={"update fish 1","update green","99"};
    HashMap<String,String> pondList;
	
	@BeforeClass
	public void countAndstorePonds()
	{
		ChromeBrowser.driver.get("http://localhost:3000/");
		System.out.println("counting ponds");
		List<WebElement> ponds = ElementsHomeScreen.getPondElements();
		pondList = new HashMap<>();
		for (WebElement pond : ponds) {
			String values[]=pond.getText().split("ID");
		    pondList.put(values[1],values[0]);
		
		}
		System.out.println("printing ponds");
		System.out.println(pondList);

	}
	@AfterClass
	public void quitDriver() {
		 ChromeBrowser.driver.quit();
	}
	@BeforeMethod
	public void  backToHomeScreen()
	{
		ChromeBrowser.driver.get("http://localhost:3000/");
	}
	@Test
    public void CreatePondDisplayTest() throws Exception {

		pondName=pondName+random();
		methodsHomeScreen.CreatePond(pondName);
		Assert.assertTrue(ElementsHomeScreen.getPondElements().size() >pondList.size(),"pond created and displayed");
		Assert.assertTrue(ElementsHomeScreen.getPond(pondName)!=null);
	 
	  }
	 @Test
	 public void updatePond()
	 {
		
		 String updatePondName="updated pond name";
	     methodsHomeScreen.CreatePond(pondName);
		 ElementsHomeScreen.getPond(pondName).click();
		 String updatedPondId=MethodsPondScreen.updatePond(updatePondName);
		 System.out.println(ElementsHomeScreen.getPond(updatedPondId).findElement(By.cssSelector(".card-title")).getText());
	     Assert.assertEquals(ElementsHomeScreen.getPond(updatedPondId).findElement(By.cssSelector(".card-title")).getText(),updatePondName);

	 }
	 @Test
	 public void createFish() throws InterruptedException
	 {
		String rand = random(); 
		 methodsHomeScreen.CreatePond(pondName+rand);
		String pondID= ElementsHomeScreen.getPond(pondName+rand).getText().split("ID")[1];
		 ElementsHomeScreen.getPond(pondName).click();
		
		 Boolean correctPond=MethodsPondScreen.createFish(fishDetails[0], fishDetails[1], fishDetails[2],pondID);
		 int fishCount= MethodsPondScreen.getFish().size();
		 System.out.println("before "+fishCount);
		 MethodsPondScreen.createFish(fishDetails[0], fishDetails[1], fishDetails[2]);
		 System.out.println("after "+MethodsPondScreen.getFish().size());
		 Assert.assertTrue(MethodsPondScreen.getFish().size()>fishCount);
		 Assert.assertTrue(correctPond);
	 }
	 @Test
	 public void updateFish()
	 {
		 String fishdName="original fish";
		 pondName=pondName+random();
		 methodsHomeScreen.CreatePond(pondName);
		 ElementsHomeScreen.getPond(pondName).click();
		 MethodsPondScreen.createFish(fishDetails[0], fishDetails[1], fishDetails[2]);
		 MethodsPondScreen.findFish(fishDetails[0], fishDetails[1], fishDetails[2]).click();
		 MethodsFishScreen.updateFish(fishDetailsUpdate[0], fishDetailsUpdate[1], fishDetailsUpdate[2]);
		 Assert.assertTrue(MethodsPondScreen.findFish(fishDetailsUpdate[0], fishDetailsUpdate[1], fishDetailsUpdate[2]) != null);
	 }
	 
@Test
 public void deletePond()
 {
	
	methodsHomeScreen.CreatePond(pondName);
	ElementsHomeScreen.getPond(pondName).click();
	String deletedPondId= MethodsPondScreen.deletePond();
	Assert.assertTrue(ElementsHomeScreen.getPond(deletedPondId)==null);
 }


 

 
@Test
 public void deleteFish() throws InterruptedException
 {
	 pondName=pondName+random();
	 methodsHomeScreen.CreatePond(pondName);
	 ElementsHomeScreen.getPond(pondName).click();
	 MethodsPondScreen.createFish(fishDetails[0], fishDetails[1], fishDetails[2]);	
	 int fishCount= MethodsPondScreen.getFish().size();
	 MethodsPondScreen.findFish(fishDetails[0], fishDetails[1], fishDetails[2]).click();
	 MethodsFishScreen.deleteFish();
	 System.out.println("after "+MethodsPondScreen.getFish().size());
	 Assert.assertTrue(MethodsPondScreen.getFish().size()<fishCount);
	 
 }
 public String random()
 {
	 Random rand = new Random();
	 int num=rand.nextInt(555);
	 return String.valueOf(num);
 }
 



   

}
