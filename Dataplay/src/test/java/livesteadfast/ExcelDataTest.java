package livesteadfast;

import java.util.Scanner;

import org.testng.annotations.Test;

public class ExcelDataTest {
	
	@Test
	public void ExcelData() throws Exception{


		
		
		//Get user input
		Scanner sc= new Scanner(System.in);
		
		//enter user prompted data
		System.out.print("Enter Name: ");
		String name=sc.next();
		
		
		// Creating instance of class
		WriteExampleTest ret= new WriteExampleTest();

		// Passing user entered name to save into excel
		ret.writeTest(name);

	}
}
