package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class TestUtility {
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	static Xls_Reader reader;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Raksha Shah\\Dataplay\\src\\test\\java\\testData\\test.xlsx";

		public static Object[][] getExcelData(String sheetName) throws InvalidFormatException {
			
			
			FileInputStream file= null;
			
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				book = WorkbookFactory.create(file);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			sheet = book.getSheet(sheetName);
			Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			
			for(int i = 0; i<sheet.getLastRowNum(); i++) {
				for (int k = 0; k<sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					
				
				}
			}
			return data;
			
		}
		
		
		
		
		public static ArrayList<Object[]> getDataFromExcel() {
			
		
			
			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			try {
//				reader = new Xls_Reader(System.getProperty("user.dir")+"/Dataplay/src/test/java/testData/test.xlsx");
				
				reader = new Xls_Reader("C:\\Users\\Raksha Shah\\Dataplay\\src\\test\\java\\testData\\test.xlsx");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			for (int rowNum=2; rowNum <= reader.getRowCount("Annotations"); rowNum++) {
	
					String firstName = reader.getCellData("Annotations", "firstName", rowNum);
					String lastName = reader.getCellData("Annotations", "lastName", rowNum);
					
					String mobile = reader.getCellData("Annotations", "mobile", rowNum);
					String email = reader.getCellData("Annotations", "email", rowNum);
					
					String country = reader.getCellData("Annotations", "country", rowNum);
					String city = reader.getCellData("Annotations", "city", rowNum);
					
					String passwrd = reader.getCellData("Annotations", "password", rowNum);
					String confirmPasswrd = reader.getCellData("Annotations", "confirmPassword", rowNum);
					
					Object ob[]= {firstName,lastName,mobile,email,country,city,passwrd,confirmPasswrd};
					myData.add(ob);
				}
				return myData;

		}
		
		
		

		
		
		public static void captureScreenshot(WebDriver driver, String screenshotName) {
			
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			// Give path to folder where you choose to store screenshot.
			File destination = new File("./Screenshots/"+screenshotName+".png");
			
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Screenshot taken");
			
		}
	
		
		public static String getScreenshot(WebDriver driver, String screenshotName) {
			
			String dateScreenshot= new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
		//	String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
			String destinationPath=System.getProperty("user.dir")+"/FailedTestScreenshots/"+ screenshotName + dateScreenshot +".png";
			File destination=new File(destinationPath);

			
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				System.out.println("Capture Failed "+e.getMessage());
			}
			
			System.out.println("Screenshot taken");
			
			return destinationPath;
			
		}
	
		

}
