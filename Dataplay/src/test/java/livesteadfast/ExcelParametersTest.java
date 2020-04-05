package livesteadfast;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExcelParametersTest {
	
	
	@Parameters({"excelLocation"})
	@Test
	public void excelTest(String excelLocation) throws Exception{
		
		//Check value you get for parameter from testng.xml file
		System.out.println("Excel location is " + excelLocation);

		//Pass the excelsheet location in code
		File src2 = new File(excelLocation);
		FileInputStream fis2=new FileInputStream(src2);
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		XSSFSheet sheet2 = wb2.getSheetAt(5);
		
		//Get username and password from your excel sheet.
		String username= sheet2.getRow(1).getCell(0).getStringCellValue();
		String password= sheet2.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println("The username is "+ username);
		System.out.println("The password is " + password);
}
	
}
