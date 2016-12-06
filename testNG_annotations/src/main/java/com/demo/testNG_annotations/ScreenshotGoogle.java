package com.demo.testNG_annotations;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class ScreenshotGoogle {

	WebDriver driver;
 
 @Test
 public void TestJavaS1(ITestResult result)
{
// Open Firefox
	 System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\aurph\\Desktop\\Workspace\\selenium-java-3.0.0-beta4\\geckodriver.exe");
		driver = new FirefoxDriver();
 
// Maximize the window
driver.manage().window().maximize();
 
// Pass the url
driver.get("http://www.google.com");
 
// Take screenshot and store as a file format
File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
 // now copy the  screenshot to desired location using copyFile //method
FileUtils.copyFile(src, new File("./Screenshots.png"));
}
 
catch (IOException e)
 {
  System.out.println(e.getMessage());
 
 }
 }
 
 public static void captureScreenShot(WebDriver driver){
	 
	  // Take screenshot and store as a file format
	  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	  // now copy the  screenshot to desired location using copyFile method
	 
	 FileUtils.copyFile(src, new File("./Screenshots.png"));
	       }
	 
	catch (IOException e)
	 
	{
	 
	System.out.println(e.getMessage());
	 
	    }
	 
	}
 
}
 
  
  
 