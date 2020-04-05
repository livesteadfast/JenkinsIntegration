package livesteadfast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class GoogleTest {
	
	@Test
	public void BrowserAutomation() throws Exception
	{
		
		ReadWriteExcelTest tst= new ReadWriteExcelTest();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe" );

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://google.com");
		

//		String data= sheet1.getRow(0).getCell(1).getStringCellValue();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Best Wood For Furniture in India", Keys.ENTER);   
		
		Thread.sleep(2000); 
		System.out.println("done");
		
		List<WebElement> heading = driver.findElements(By.tagName("a"));
		
		int headCount = heading.size();
		
		System.out.println("No of links "+ headCount);

		int n = 0;
		int m = 0;

		
		 for (int i=0; i<headCount; i++ )
		 {
			 
			String sti= heading.get(i).getText();
	//		System.out.println("title is " + sti);
			
			String stu = heading.get(i).getAttribute("href");
	//		System.out.println("url is "+ stu);
		
			try {
			if (stu.equals(null) || stu.contains("google"))
			{
				System.out.println("avoid");
			}
			else {
				n++;
				m++;
				System.out.println("Count is " +n);
				
				System.out.println("url is " + stu);
				
				tst.tester(m,stu);
				
		/*		File src = new File("C:\\Users\\Raksha Shah\\Documents\\Project\\Book1.xlsx");
				FileInputStream fis=new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet1 = wb.getSheetAt(1);

				System.out.println("row np "+n);
				//Write
				sheet1.getRow(n).createCell(5).setCellValue("huh "+stu);
				FileOutputStream fout=new FileOutputStream(src);

				wb.write(fout);
				wb.close();
				
				*/
			}
				
			}catch(Exception e) {
			}
			
			 
			
		 }
		 
			System.out.println("So Final Count is " +n);
		 
//		 BacklinkTrackTest btt= new BacklinkTrackTest();
//		 btt.Backlink(n);
	}
				
			
}

