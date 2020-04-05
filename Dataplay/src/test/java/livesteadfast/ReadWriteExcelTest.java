package livesteadfast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ReadWriteExcelTest {
	
	@Test
	public void tester(int row,String stud) throws Exception{
//	ExcelDataConfigTest excel = new ExcelDataConfigTest();
	
	/*	
	File src = new File("C:\\Users\\Raksha Shah\\Documents\\Project\\Book1.xlsx");
	FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet1 = wb.getSheetAt(0);
	String data= sheet1.getRow(0).getCell(1).getStringCellValue();
	*/

	
	File src = new File("C:\\Users\\Raksha Shah\\Documents\\Project\\Book1.xlsx");
	FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet1 = wb.getSheetAt(1);
//	String data= sheet1.getRow(0).getCell(1).getStringCellValue();
//	System.out.println("Data is " + data);
	
	//Write
	sheet1.getRow(row).createCell(0).setCellValue(stud);
	FileOutputStream fout=new FileOutputStream(src);

	wb.write(fout);
	wb.close();
	
//	System.out.println("Data is " + data);
	}
	
	
//	return data;
	
	
	
	//Read Data
	
	@Test
	public void readTester(int row, int col) throws Exception{
		
	//	System.out.println("Throe");
	BacklinkTrackTest backChk= new BacklinkTrackTest();

	File src2 = new File("C:\\Users\\Raksha Shah\\Documents\\Project\\Book1.xlsx");
	FileInputStream fis2=new FileInputStream(src2);
	XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
	XSSFSheet sheet2 = wb2.getSheetAt(1);
	String data2= sheet2.getRow(row).getCell(col).getStringCellValue();
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe" );

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.get("https://neilpatel.com/backlinks/");
	
	
	if (data2!="") {
	System.out.println("Data is " + data2);
	
	//Point to method to enter backlinks etc..
	//backChk.BacklinkChk(data2);
	//*[@id='ubersuggest-form']/fieldset[1]/input
	
	//*[@id=\"popup-exit-quiz\"]/button)
	
//	Thread.sleep(8000);
	System.out.println("Test1");
	driver.findElement(By.xpath("//*[@id='ubersuggest-form']/fieldset[1]/input")).sendKeys(data2);
	System.out.println("Test2");
	
	//Click search button
	//driver.findElement(By.xpath("//*[@id=\"ubersuggest-form\"]/fieldset[3]/button")).click();
	
	
	}
	
	wb2.close();
	

	}

}
