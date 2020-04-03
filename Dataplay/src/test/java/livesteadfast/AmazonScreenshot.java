package livesteadfast;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;

import utility.TestUtility;

public class AmazonScreenshot {
	
	WebDriver driver;
	
	@Test
	public void captureScreenshot() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe" );
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// registration page of an ecommerce website
		driver.get("https://www.amazon.com");
		
		//Screenshot after opening browser
		TestUtility.captureScreenshot(driver, "browserOpen");
		
		//Providing incorrect xpath to observe failure screenshot
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextboxs\"]")).sendKeys("will take screenshot here");
		
		//Screenshot after passing data in search field
		TestUtility.captureScreenshot(driver, "sendData");
	}
	

	@AfterMethod
	public void tearDown(ITestResult result) {
	
		if(ITestResult.FAILURE==result.getStatus()) {
		
		TestUtility.captureScreenshot(driver, result.getName());
	}
	
	driver.quit();
	
	}

}

/*

		//Screenshot after passing data in search field
		//TestUtility.captureScreenshot(driver, "sendData");
		 * 
		//Screenshot after opening browser
		//TestUtility.captureScreenshot(driver, "browserOpen");
		 * 
		driver.quit();

		//Code for simple screenshots
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		// Give path to folder where you choose to store screenshot.
		File destination = new File("./Screenshots/tookShot.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.quit();
		
		import java.io.File;
		
		import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
		

	*/

