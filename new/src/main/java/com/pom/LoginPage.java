package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement passWord;
	
	@FindBy(id="login-button")
	private WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUserName(String username) {
		userName.sendKeys(username);
		
	}
	
	public void clickOnpassword(String password) {
		passWord.sendKeys(password);
		
	}
	public void clickOnlogin() {
		login.click();
		
	}
	
	

}
