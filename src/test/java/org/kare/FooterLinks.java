package org.kare;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	WebDriver driver;

	JavascriptExecutor js;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://upg-dev.kareuae.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		
	}

	// in this test case is use for handle the cookies
	@Test(priority = 1, enabled = true)
	private void cookiesAccept() throws InterruptedException {

		Thread.sleep(10000);

		WebElement agree = driver.findElement(By.xpath("//span[text()='I Agree']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", agree);

	}

	@Test(priority = 2, enabled = true)
	private void contactUs() throws InterruptedException {

		// Locate the contactUs link and click the contactUs Link
		WebElement contactUS = driver.findElement(By.xpath("//a[text()='Contact us']"));
		contactUS.click();

		Thread.sleep(5000);

		// to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
		// block will execute,testcase is false else block will execute
		if (title.equals("KARE | Contact Us")) {

			System.out.println("user clicked the ContactUS link, its redirecting to Contact US page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the ContactUS link, its redirecting to Contact US page");

		} else {

			System.out.println("user clicked the ContactUS link, its not redirecting to Contact US page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the ContactUS link, its not redirecting to Contact US page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 3, enabled = true)
	private void customerService() throws InterruptedException {

		// Locate the customerService link and click the customerService Link
		WebElement customerService = driver.findElement(By.xpath("//a[text()='Customer Service']"));
		customerService.click();

		Thread.sleep(5000);

		//to get the title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Customer Service | KARE UAE")) {

			System.out.println("user clicked the Customer Service link, its redirecting to Customer Service page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Customer Service link, its redirecting to Customer Service page");

		} else {

			System.out.println("user clicked the Customer Service link, its not redirecting to Customer Service page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Customer Service link, its not redirecting to Customer Service page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 4, enabled = true)
	private void storeLocator() throws InterruptedException {

		// Locate the storeLocator link and click the storeLocator Link
		WebElement storLoc = driver.findElement(By.xpath("//a[text()='Store Locator']"));
		storLoc.click();

		Thread.sleep(5000);

		//to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("KARE UAE: OUR STORES")) {

			System.out.println("user clicked the store locator link, its redirecting to store locator page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the store locator link, its redirecting to store locator page");

		} else {

			System.out.println("user clicked the store locator link, its not redirecting to store locator page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the store locator link, its not redirecting to store locator page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 5, enabled = true)
	private void roomPlanner() throws InterruptedException {

		// Locate the roomPlanner link and click the roomPlanner Link
		WebElement roomPlaner = driver.findElement(By.xpath("//a[text()='Room Planner']"));
		roomPlaner.click();

		Thread.sleep(5000);

		//to get current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Room Planner")) {

			System.out.println("user clicked the Room Planner link, its redirecting to Room Planner page");
			Assert.assertTrue(true);
			Reporter.log("user clicked theRoom Planner link, its redirecting to Room Planner page");

		} else {

			System.out.println("user clicked the Room Planner link, its not redirecting to Room Planner page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Room Plannerr link, its not redirecting to Room Planner page");

		}

		// refresh the page
		WebElement refresh = driver.findElement(By.xpath("//img[@class='main-logo']"));
		refresh.click();

		Thread.sleep(4000);

	}

	@Test(priority = 6, enabled = true)
	private void termsAndCondition() throws InterruptedException {

		// Locate the Terms And Condition link and click the Terms And Condition Link
		WebElement roomPlaner = driver.findElement(By.xpath("//a[text()='Terms and Conditions']"));
		roomPlaner.click();

		Thread.sleep(5000);

		//to get current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Terms And Conditions")) {

			System.out.println(
					"user clicked the Terms and Conditions link, its redirecting to Terms and Conditions page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Terms and Conditions link, its redirecting to Terms and Conditionsr page");

		} else {

			System.out.println(
					"user clicked the Terms and Conditions link, its not redirecting to Terms and Conditions page");
			Assert.assertTrue(false);
			Reporter.log(
					"user clicked the Terms and Conditions link, its not redirecting to Terms and Conditions page");

		}

		Thread.sleep(4000);
	}

	@Test(priority = 7, enabled = true)
	private void payment() throws InterruptedException {

		// Locate the payment link and click the payment Link
		WebElement payment = driver.findElement(By.xpath("//a[text()='Payment']"));
		payment.click();

		Thread.sleep(5000);

		//to get current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Terms And Conditions")) {

			System.out.println("user clicked the Payment link, its redirecting to Payment page");
			WebElement pripay = driver.findElement(By.xpath("//a[text()='Price and Payment']"));
			pripay.isDisplayed();
			Assert.assertTrue(true);
			Reporter.log("user clicked the Payment link, its redirecting to Payment page");

		} else {

			System.out.println("user clicked the Payment link, its not redirecting to Payment page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Payment link, its not redirecting to Payment page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 8, enabled = true)
	private void delivery() throws InterruptedException {

		// Locate the Delivery link and click the Delivery Link
		WebElement delivery = driver.findElement(By.xpath("//a[text()='Delivery']"));
		delivery.click();

		Thread.sleep(5000);

		//to get current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Terms And Conditions")) {

			System.out.println("user clicked the Payment link, its redirecting to Payment page");
			WebElement pripay = driver.findElement(By.xpath("//a[text()='Terms of Delivery']"));
			pripay.isDisplayed();
			Assert.assertTrue(true);
			Reporter.log("user clicked the Delivery link, its redirecting to Delivery page");

		} else {

			System.out.println("user clicked the Delivery link, its not redirecting to Delivery page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Delivery link, its not redirecting to Delivery page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 9, enabled = true)
	private void refundAndReturnPolicy() throws InterruptedException {

		// Locate the Refund And Return Policy link and click the Refund And Return
		// Policy Link
		WebElement refundAndReturn = driver.findElement(By.xpath("(//a[text()='Refund and Return Policy'])[2]"));
		refundAndReturn.click();

		Thread.sleep(5000);

		//to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Terms And Conditions")) {

			System.out.println(
					"user clicked the Refund and Return plicy link, its redirecting to Refund and Return plicy page");
			WebElement rarp = driver.findElement(By.xpath("(//a[text()='Refund and Return Policy'])[1]"));
			rarp.isDisplayed();
			Assert.assertTrue(true);
			Reporter.log(
					"user clicked the Refund and Return policy link, its redirecting to Refund and Return policy page");

		} else {

			System.out.println(
					"user clicked the Refund and Return policy link, its not redirecting to Refund and Return policy page");
			Assert.assertTrue(false);
			Reporter.log(
					"user clicked the Refund and Return policy link, its not redirecting to Refund and Return policy page");

		}

		Thread.sleep(4000);
	}

	@Test(priority = 10, enabled = true)
	private void warranty() throws InterruptedException {

		// Locate the warranty link and click the warranty Link
		WebElement waranty = driver.findElement(By.xpath("(//a[text()='Warranty'])[2]"));
		waranty.click();

		Thread.sleep(5000);

		//to get the current Title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Terms And Conditions")) {

			System.out.println("user clicked the warranty link, its redirecting to warranty page");
			WebElement warnty = driver.findElement(By.xpath("(//a[text()='Warranty'])[1]"));
			warnty.isDisplayed();
			Assert.assertTrue(true);
			Reporter.log("user clicked the warranty link, its redirecting to warranty page");

		} else {

			System.out.println("user clicked the warranty link, its not redirecting to warranty page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the warranty link, its not redirecting to warranty page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 11, enabled = true)
	private void dataProtection() throws InterruptedException {

		// Locate the DataProtection link and click the DataProtection Link
		WebElement dataProtection = driver.findElement(By.xpath("//a[text()='Data Protection']"));
		dataProtection.click();

		Thread.sleep(5000);

		// to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Data Protection")) {

			System.out.println("user clicked the Data protection link, its redirecting to Data protection page");
			WebElement datapro = driver.findElement(By.xpath("//h3[text()='Data Protection']"));
			datapro.isDisplayed();
			Assert.assertTrue(true);
			Reporter.log("user clicked the Data protection link, its redirecting to Data protection page");

		} else {

			System.out.println("user clicked the Data protection link, its not redirecting to Data protection page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Data protection link, its not redirecting to Data protection page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 12, enabled = true)
	private void aboutUs() throws InterruptedException {

		// Locate the About Us link and click the About Us Link
		WebElement aboutUs = driver.findElement(By.xpath("//a[text()='About us']"));
		aboutUs.click();

		Thread.sleep(5000);

		// to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("KARE UAE | About us")) {

			System.out.println("user clicked the About Us link, its redirecting to About Us page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the About Us link, its redirecting to About Us page");

		} else {

			System.out.println("user clicked the About Us link, its not redirecting to About Us page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the About Us link, its not redirecting to About Us page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 12, enabled = true, dependsOnMethods = { "accountInformation" })
	private void kareDesign() throws InterruptedException {

		// Locate the kare Design link and click the kare Design Link
		WebElement kareDesign = driver.findElement(By.xpath("//a[text()='KARE Design']"));
		kareDesign.click();

		Thread.sleep(5000);

		//to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("KARE Design - International")) {

			System.out.println("user clicked the KARE Design link, its redirecting to KARE Design page");
			driver.switchTo().frame(0);

			Thread.sleep(2000);

			Assert.assertTrue(true);
			driver.navigate().back();

			Thread.sleep(6000);

			Reporter.log("user clicked the KARE Design link, its redirecting to KARE Design page");

		} else {

			System.out.println("user clicked the KARE Design link, its not redirecting to KARE Design page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the KARE Design link, its not redirecting to KARE Design page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 13)
	private void blog() throws InterruptedException {

		// Locate the Blog link and click the Blog Link
		WebElement blog = driver.findElement(By.xpath("//a[text()='Blog']"));
		blog.click();

		Thread.sleep(5000);

		// to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Blog")) {

			System.out.println("user clicked the Blog link, its redirecting to Blog page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Blog link, its redirecting to Blog page");

		} else {

			System.out.println("user clicked the Blogn link, its not redirecting to Blog page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Blog link, its not redirecting to Blog page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 14)
	private void siteMap() throws InterruptedException {

		// Locate the siteMap link and click the siteMap Link
		WebElement siteMap = driver.findElement(By.xpath("//a[text()='Sitemap']"));
		siteMap.click();

		Thread.sleep(5000);

		//to get the current title
		String url = driver.getCurrentUrl();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (url.equals("https://upg-dev.kareuae.com/sitemap.html")) {

			System.out.println("user clicked the siteMap link, its redirecting to siteMap page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the siteMap link, its redirecting to siteMap page");

		} else {

			System.out.println("user clicked the siteMap link, its not redirecting to siteMap page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the siteMap link, its not redirecting to siteMap page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 15)
	private void jobs() throws InterruptedException {

		// Locate the Jobs link and click the Jobs Link
		WebElement jobs = driver.findElement(By.xpath("//a[text()='Jobs']"));
		jobs.click();

		Thread.sleep(5000);

		//to get the Current title
		String url = driver.getCurrentUrl();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (url.equals("http://careers.algurg.com/")) {

			System.out.println("user clicked the Jobs link, its redirecting to Jobs page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Jobs link, its redirecting to Jobs page");
			driver.navigate().back();

		} else {

			System.out.println("user clicked the Jobs link, its not redirecting to Jobs page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Jobs link, its not redirecting to Jobs page");

		}

		driver.navigate().back();

		Thread.sleep(10000);
	}

	@Test(priority = 16)
	private void register() throws InterruptedException {

		// Locate the Register link and click the Register Link
		WebElement register = driver.findElement(By.xpath("//a[text()='Regster']"));
		register.click();

		Thread.sleep(5000);

		//to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Create New Customer Account")) {

			System.out.println("user clicked the Register link, its redirecting to Register page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Register link, its redirecting to Register page");

		} else {

			System.out.println("user clicked the Register link, its not redirecting to Register page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Register link, its not redirecting to Register page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 17)
	private void login() throws InterruptedException {

		// Locate the Login link and click the Login Link
		WebElement login = driver.findElement(By.xpath("//a[text()='Log In']"));
		login.click();

		Thread.sleep(5000);

		//to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Customer Login")) {

			System.out.println("user clicked the Login link, its redirecting to Login page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Login link, its redirecting to Login page");

			// enter the user name
			WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
			userName.sendKeys("balaji.p@sysfore.com");

			// enter the password
			WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
			password.sendKeys("Balaji@123");

			// click the submit
			WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
			submit.click();

		} else {

			System.out.println("user clicked the Login link, its not redirecting to Login page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Login link, its not redirecting to Login page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 18)
	private void shoppingCart() throws InterruptedException {

		// Locate the Shopping Cart link and click the Shopping Cart Link
		WebElement shopingCart = driver.findElement(By.xpath("//a[text()='Shopping cart']"));
		shopingCart.click();

		Thread.sleep(5000);

		//to get the current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("Shopping Cart")) {

			System.out.println("user clicked the Shopping cart link, its redirecting to Shopping cart page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Shopping cart link, its redirecting to Shopping cart page");

		} else {

			System.out.println("user clicked the Shopping cart link, its not redirecting to Shopping cart page");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Shopping cart link, its not redirecting to Shopping cart page");

		}

		Thread.sleep(4000);

	}

	@Test(priority = 19)
	private void accountInformation() throws InterruptedException {

		// Locate the Account Information link and click the Account Information Link
		WebElement shopingCart = driver.findElement(By.xpath("//a[text()='Account information']"));
		shopingCart.click();

		Thread.sleep(5000);

		//to get current title
		String title = driver.getTitle();

		// title is equals to our expected, is it test case is true,test case is true if
				// block will execute,testcase is false else block will execute
		if (title.equals("My Account")) {

			System.out
					.println("user clicked the Account information link, its redirecting to Account information page");
			Assert.assertTrue(true);
			Reporter.log("user clicked the Account information link, its redirecting to Account information page");

		} else {

			System.out.println(
					"user clicked the Account information link, its not redirecting to Account information page,may be user has not logged in");
			Assert.assertTrue(false);
			Reporter.log("user clicked the Account information link, its not redirecting to Account information page");

		}

		Thread.sleep(4000);

	}

	@AfterClass
	private void end() {

		// close the Browser
		driver.quit();
	}

}
