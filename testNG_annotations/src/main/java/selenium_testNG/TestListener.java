package selenium_testNG;


import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class TestListener implements ITestListener {
	WebDriver driver;


	
	String filePath = "./Screenshots/";
	
//    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName);
//    	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }
    
//    @Override
   	public void onFinish(ITestContext context) {
   		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
   		for (ITestResult temp : failedTests) {
   			ITestNGMethod method = temp.getMethod();
   			if (context.getFailedTests().getResults(method).size() > 1) {
   				failedTests.remove(temp);
   			} else {
   				if (context.getPassedTests().getResults(method).size() > 0) {
   					failedTests.remove(temp);
   				}
   			}
   		}
   	}
    @Test
    public void takeScreenShot(String methodName) {
    	//get the driver
//    	driver=TestBase.getDriver();
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }

}
