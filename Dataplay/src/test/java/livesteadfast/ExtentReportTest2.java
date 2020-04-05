package livesteadfast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.TestUtility;

public class ExtentReportTest2 {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	@BeforeTest
	public void setupExtent() {
		
		
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Reports/Results.html");
		
		extent = new ExtentReports();

		extent.attachReporter(reporter);
		
		
	}

	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe" );
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// registration page of an ecommerce website
		driver.get("https://www.amazon.com");
		
	}
	
	
	
	
	@Test
	public void browserTest() throws IOException {

		logger = extent.createTest("Google browserTest");
		
		String title = driver.getTitle();
		Assert.assertEquals(title , "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		System.out.println("Prints fine");
		
		
	}
	
	
	@Test
	public void browserFailTest() throws IOException {

		logger = extent.createTest("Google browser fail Test");
		
		Assert.assertTrue(false);
		
		System.out.println("Open google");	
		
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus()==ITestResult.SUCCESS) {
			
			String temp= TestUtility.getScreenshot(driver, result.getName());
			
			logger.pass(result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		else if(result.getStatus()==ITestResult.FAILURE) {
			
			String temp= TestUtility.getScreenshot(driver, result.getName());
			
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		else if(result.getStatus()==ITestResult.SKIP){
			
			String temp= TestUtility.getScreenshot(driver, result.getName());
			
			logger.skip(result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		extent.flush(); 
		driver.quit();
	}
	
}
