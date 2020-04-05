package livesteadfast;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtility;;

public class SignUpPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setProperties() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe" );

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// registration page of an ecommerce website
		driver.get("https://www.ejohri.com/customer/account/login/referer/aHR0cHM6Ly93d3cuZWpvaHJpLmNvbS8%2C/");
		
	
	}
	
	
	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException {
		Object data [][] = TestUtility.getExcelData("Annotations");
		return data;
	}
	
	
	@Test(dataProvider = "getTestData")
	public void signUpPage(String firstName, String lastName, String mobileNo, String emailAddress, 
			String countryName, String cityName, String passwordIs, String confirmPassword) {
		
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//*[@id='lastname']")).clear();
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastName);
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='country']")));
		select.selectByVisibleText(countryName);
		

		
	}
		
	
	
	@AfterMethod
	public void closeDown() {
		driver.quit();
	}
	

	
	@DataProvider
	public Iterator<Object[]> getDataArray() {
		ArrayList<Object[]> testData = TestUtility.getDataFromExcel();
		return testData.iterator();
	}
}


/*		driver.findElement(By.xpath("//*[@id='mobileee']")).clear();
driver.findElement(By.xpath("//*[@id='mobileee']")).sendKeys(mobileNo);

driver.findElement(By.xpath("//*[@id='email']")).clear();
driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailAddress);

driver.findElement(By.xpath("//*[@id='country']")).clear();
driver.findElement(By.xpath("//*[@id='country']")).sendKeys(countryName);

driver.findElement(By.xpath("//*[@id='customcity']")).clear();
driver.findElement(By.xpath("//*[@id='customcity']")).sendKeys(cityName);

driver.findElement(By.xpath("//*[@id='password']")).clear();
driver.findElement(By.xpath("//*[@id='password']")).sendKeys(passwordIs);

driver.findElement(By.xpath("//*[@id='password-confirmation']")).clear();
driver.findElement(By.xpath("//*[@id='password-confirmation']")).sendKeys(confirmPassword);
*/
