package TestNGDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.Test;

public class VerifyTitle

{

	// Here we have to specify the class – In our case class name is Retry

	@Test(retryAnalyzer = Retry.class)

	public void verifySeleniumTitle()

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aurph\\Desktop\\Workspace\\selenium-java-3.0.0-beta4\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.learn-automation.com");

		// Here we are verifying that title contains QTP or not. This test will
		// fail because title does not contain QTP

		Assert.assertTrue(driver.getTitle().contains("QTP"));
		driver.quit();

	}

}