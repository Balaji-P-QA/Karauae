package org.kare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {

	WebDriver driver;

	@BeforeClass
	private void start() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.kareuae.ae/");

		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = true)
	private void login1() {

		WebElement accBtn = driver.findElement(By.xpath("//div[@class='toplink login-link']"));
		accBtn.click();

	}

	@Test(priority = 1, enabled = true)
	private void registerLink() {
        
		
		WebElement signUp = driver.findElement(By.xpath("//span[text()='Sign Up']"));
		signUp.click();
		
	}
	
	
	@Test
	private void registerDetails() {
        
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
		
		
		int pos = radioButtons.size();
		System.out.println(pos);
		//pos.click();
		
		
	}
	
	
	
	
}
