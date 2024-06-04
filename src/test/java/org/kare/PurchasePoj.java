package org.kare;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePoj {

	WebDriver driver;
	
	public PurchasePoj(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//a[@class='product-item-link']")
	List<WebElement> ProductNames;

	public WebDriver getDriver() {
		return driver;
	}


	public List<WebElement> getProductNames() {
		return ProductNames;
	}

	
	
	
}
