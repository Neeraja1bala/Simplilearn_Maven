package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class LoginPage {

	WebDriver driver= Baseclass.driver;
	ExtentTest test = Baseclass.test;


	
	
	//============================ Web Elements =======================
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	@FindBy(name="user_login")
	WebElement UserName;
	@FindBy(id="password")
	WebElement Password;
	@FindBy(name="btn_login")
	WebElement LoginButton;
	@FindBy(className="rememberMe")
	WebElement remember;
	@FindBy(id="msg_box")
	WebElement Error;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//============================= Methods ==========================
	
	public void Login(String UName,String Pwd) {
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		LoginLink.click();
		test.log(LogStatus.PASS,"click on login link","Successfully clicked the link");
		UserName.sendKeys(UName);
		test.log(LogStatus.PASS,"Enter username"+UName,"Successfully enter the name");
		Password.sendKeys(Pwd);
		test.log(LogStatus.PASS,"Enter password"+Pwd,"Successfully enter the password");
		LoginButton.click();
		test.log(LogStatus.PASS,"click login button","Successfully clicked the button");
		remember.click();
	}
	public void ErrorCheck() {
		
		 
	        String Actualmsg = Error.getText();
	        String Expmsg = "The email or password you have entered is invalid.";
	        
	       //Assert.assertEquals(Actualmsg, Expmsg);
	       SoftAssert soft = new SoftAssert();
	       soft.assertEquals(Actualmsg, Expmsg);
	       soft.assertAll();
	}
}
