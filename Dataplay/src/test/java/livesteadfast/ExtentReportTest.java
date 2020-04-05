package livesteadfast;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTest {
	
	@Test
	public void browserTest() throws IOException {
		
		System.out.println("Open google");
		
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Reports/Results.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("Google browserTest");
		
		logger.log(Status.INFO, "Logging in test");
		
		logger.log(Status.PASS, "Logged in successfully");
		
		ExtentTest logger2 = extent.createTest("Google browser logout Test");
		
		logger2.log(Status.FAIL, "Logging out test");
		
		logger2.fail("Failed because of some issues" , MediaEntityBuilder.createScreenCaptureFromPath("/Users/Raksha Shah/Pictures/Screenshots/Screenshot1.png").build());
		
		logger2.pass("this one passed", MediaEntityBuilder.createScreenCaptureFromPath("/Users/Raksha Shah/Pictures/Screenshots/Screenshot1.png").build());
		
		extent.flush();
		
	}
}


//test with snapshots
//logger2.addScreenCaptureFromPath("/Users/Raksha Shah/Pictures/Screenshots/Screenshot1.png");