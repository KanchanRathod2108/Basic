package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement addtocart;
	//here we can add other webelements
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	public void clickOnaddtocart() {
		addtocart.click();
		//just declare which webelement you have add
	}

}
