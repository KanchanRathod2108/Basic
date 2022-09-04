package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void getScreenshot(WebDriver driver ) throws IOException {
		Date date= new Date();      //date of Sceenshot
		String time = date.toString().replace(":","_"); //time of ScreenShot
		
		File s =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File d = new File("C:/Users/Aakash/Desktop/New folder/new.jpg");
		
		FileHandler.copy(s, d);
		
	}
	
	public  static  String getExcelData(int row,int cell) throws EncryptedDocumentException, IOException {
		String data;
		FileInputStream excel= new FileInputStream("C:/Users/Aakash/eclipse-workspace/new/TestingData");
		
		Sheet outdata =WorkbookFactory.create(excel).getSheet("Sheet1");
		
		try {
		
		 data = outdata.getRow(row).getCell(cell).getStringCellValue();//upar int row aur cell declare kiya hai esliye cell value nhi dali
		}
		catch(Exception e) {
		
		long a= (long) outdata.getRow(row).getCell(cell).getNumericCellValue();
		
		 data = (" "+a); // string value mai agar numeric value hogi ya string hai ye pata nhi esliye yaha pe data converstion kiya hai
		
		}
		return data;
		
	}

}
