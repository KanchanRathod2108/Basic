package com.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.base.Base;
import com.pom.LoginPage;
import com.utility.Utility;
import com.pom.HomePage;

public class Testclass extends Base{
	
	WebDriver driver;
	LoginPage pageLogin;
	
	@BeforeClass
	
	@Parameters("browser")
	public void lunchBrower(String browser) throws InterruptedException {
		
		if(browser.equals("chrome")) {
		
	       driver=Base.openChromeBrowser();  //base class madhe ahe code mahun Base. aapan base class madhun call kart aho
		}
		
		else if(browser.equals("edge"))
		{
			driver=Base.openEdgeBrowser();
		}
		
		
	driver.get("https://www.saucedemo.com/");
	
	driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@BeforeMethod 
	 
	public void verifyLoginPage() throws InterruptedException, EncryptedDocumentException, IOException {
		LoginPage pageLogin=new LoginPage(driver);
		
		String username =Utility.getExcelData(1, 1); //our data is store in excel at row=1 and column=1
		pageLogin.clickOnUserName(username);
		
		
		String password =Utility.getExcelData(2, 1);
		pageLogin.clickOnpassword(password);
		
		pageLogin.clickOnlogin();
		Thread.sleep(2000);
		
	}
	@Test
	public void  verifyTheaddtocart() throws InterruptedException, IOException {//testcase 
	
		HomePage homepage=new HomePage(driver);
		homepage.clickOnaddtocart();
		String url =driver.getCurrentUrl();
		
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
		Thread.sleep(2000);
		
		//Utility.getScreenshot(driver);
		
	}
	@AfterTest
	public void verifySignout(ITestResult result) throws IOException  {
		
		if(ITestResult.FAILURE==result.getStatus()){
			
			Utility.getScreenshot(driver);	
			
		}
		
		
		driver.close();
		
		 
	}
	
	

}
