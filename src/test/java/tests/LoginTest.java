package tests;


import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTest extends Baseclass {
	
	
	
	
	@Parameters({"UserName","Password"})
	@Test
	public void Negativelogin(String UserNameval,String Passwordval) {
		
		test = report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameval,Passwordval);
        login.ErrorCheck();
        report.endTest(test);
	}
	
	@Parameters({"UserName","CorrectPassword"})
	@Test
	public void Positivelogin(String UserNameval,String Passwordval) {
		
		test = report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameval,Passwordval);
		report.endTest(test);
       
	}
	
	@Test
	public void ExcelTest() throws IOException {
		
		
		String UserNameval=sheet.getRow(1).getCell(0).getStringCellValue();
		String Passwordval=sheet.getRow(1).getCell(1).getStringCellValue();
		test = report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameval,Passwordval);
        login.ErrorCheck();
        report.endTest(test);
	}
	
	
	
	
}
