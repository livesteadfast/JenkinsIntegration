package livesteadfast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExampleTest {
	
	//@Test is only if you are running project using Testng framework
	@Test
	public void writeTest(String nameReceived) throws Exception{

	// Set File Source path
	File src = new File("C:\\Users\\Raksha Shah\\Documents\\Project\\Book1.xlsx");
	
	//Pass the File path as a parameter (src) as shown below
	FileInputStream fis=new FileInputStream(src);
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = wb.getSheetAt(2);
	
	// Write Into Excel
	
	sheet.getRow(1).createCell(2).setCellValue(nameReceived);
	FileOutputStream fout=new FileOutputStream(src);

	//Writing to output source path
	wb.write(fout);
	wb.close();
	
	}
	
}
