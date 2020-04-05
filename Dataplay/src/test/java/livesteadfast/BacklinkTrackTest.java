package livesteadfast;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BacklinkTrackTest{

	
	@Test
	public void Backlink() throws Exception{
//	ReadWriteExcelTest tst= new ReadWriteExcelTest();
/*	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe" );

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	*/
	
//	driver.get("https://neilpatel.com/backlinks/");
	
	ReadWriteExcelTest tt= new ReadWriteExcelTest();
//	int noOfLinks = number;
//	System.out.println("The passed number is " + noOfLinks);
//	for (int i=1;i<100; i++)
//	{
		tt.readTester(1,0);
		
		
//	}
	
		}
	
	
	

	
}
			
		



