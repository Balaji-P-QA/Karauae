package org.kare;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	WebDriver driver;

	@BeforeClass
	private void start() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	//	WebDriverManager.chromedriver().setup();
	//	driver = new ChromeDriver();

		driver.get("https://upg-dev.kareuae.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));

	}

	@Test(priority = 1, enabled = true)
	private void login1() {

		WebElement accBtn = driver.findElement(By.xpath("//div[@class='toplink login-link']"));
		accBtn.click();

	}

	@Test(priority = 2, enabled = true)
	private void credentials() throws InterruptedException {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Balaji@123");

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
		submit.click();

		Thread.sleep(4000);

		try {

			WebElement errMsg = driver.findElement(By.xpath("//div[text()='Invalid login or password.']"));

			// error msg is showing the if block will execute, otherwise errmsg is not
			// showing else block is will execute

			if (errMsg.isDisplayed()) {

				// if error msg is showing print the error msg
				System.out.println(errMsg.getText());

			}

		} catch (Exception e) {

			// error msg is not showing this statement will execute
			System.out.println("user entered the proper username and password");

			// if user entered the proper username and password, the user name will shown
			// the under sign logo or not
			WebElement customerName = driver.findElement(By.xpath("(//span[@class='link'])[4]"));

			// actual username
			String actual = customerName.getText();

			// will expect the username
			String Expect = "BALAJI";

			// if expert result and actual both are same the assert will pass, otherwise
			// assert will fail.
			Assert.assertEquals(actual, Expect);
			System.out.println("UserName is :" + actual);

		}

	}

	@Test(priority = 3, enabled = false)
	private void withoutRule() {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Balaji123");

		// can get the username field value
		String emailId = userName.getAttribute("value");

		// click the submit button
		WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
		submit.click();

		// user name is without @ and .com if block will execute
		if (!emailId.contains("@") | !emailId.contains(".com")) {

			WebElement errmsg = driver.findElement(By.xpath("//div[@id='email-error']"));

			// error msg is showing if block will execute,
			if (errmsg.isDisplayed()) {

				System.out.println("error msg showing properly");
				System.out.println(errmsg.getText());

				// error msg is not showing else block will execute.
			} else {

				System.out.println("error msg is not showing");
			}

			// username with @ and .com else block will execute
		} else {

			System.out.println("user entered the emaild is with @ and .com");

		}

	}

	@Test(priority = 4, enabled = false)
	private void withoutEmpty() {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("");

		// can get the username field value
		String emailId = userName.getAttribute("value");

		String keyword = password.getAttribute("value");

		// click the submit button
		WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
		submit.click();

		//email field is empty if block will execute,email not empty else block will execute
		if (emailId.isEmpty()) {

			System.out.println("username  field is empty");

			WebElement emailErrMsg = driver.findElement(By.xpath("(//div[text()='This is a required field.'])[1]"));

			if (emailErrMsg.isDisplayed()) {

				System.out.println("please enter your user name");
				System.out.println(emailErrMsg.getText());
			}
		}
		else {

			System.out.println("username  field is not empty");
		}

		//password field is empty if block will execute,password not empty else block will execute
		if (keyword.isEmpty()) {

			System.out.println("password field is empty");

			WebElement passErrMsg = driver.findElement(By.xpath("(//div[text()='This is a required field.'])[1]"));

			if (passErrMsg.isDisplayed()) {

				System.out.println("please enter your user password");
				System.out.println(passErrMsg.getText());
			}
		}
		else {

			System.out.println("password field is not empty");
		}

	}

	@AfterClass
	private void end() {

		driver.quit();

	}

}
