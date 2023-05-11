package com.pond.test;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	
	public static  ChromeDriver driver = new ChromeDriver();
	
	static {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}


}
