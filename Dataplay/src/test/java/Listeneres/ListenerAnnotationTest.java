package Listeneres;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;



public class ListenerAnnotationTest {
	
	WebDriver driver;

	@Test
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe" );

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
	}
	
	@Test
	public void verifyTitle() {
		
		//Purposely failing this case
		System.out.println("Failing this Test case");
		
		Assert.assertTrue(false);
	}
}
