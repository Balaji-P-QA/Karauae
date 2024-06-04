package org.kare;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductPurchase {

	static WebDriver driver;

	JavascriptExecutor js;

	String usingStoreCredit;

	String paymentMethod;

	Actions a;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://upg-dev.kareuae.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));

		// click the agree for accept cookies
		WebElement agree = driver.findElement(By.xpath("//span[text()='I Agree']"));
		agree.click();

	}

	@Test(priority = 1, enabled = true)
	private void login1() {

		// click the sign Button
		WebElement accBtn = driver.findElement(By.xpath("//div[@class='toplink login-link']"));
		accBtn.click();

	}

	@Test(priority = 2, enabled = false)
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

	}

	@Test(priority = 3, enabled = true)
	private void productSeleccting() throws InterruptedException, AWTException {

		String ParticularProduct = "";

		String ProductPagewise = "";
		
		String GeneralSearch = "yes";
		
		int i=0;

		if (ParticularProduct.equals("yes")) {

			// place the cursor for Living
			WebElement living = driver.findElement(By.xpath("(//span[text()='LIVING'])[1]"));
			a = new Actions(driver);
			a.moveToElement(living).build().perform();
			Thread.sleep(4000);

			// select the product in coffee Tables catagory
			WebElement coffeeTables = driver.findElement(By.xpath("//span[text()='COFFEE TABLES']"));
			// coffeeTables.click();
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", coffeeTables);

			/* User Favourite number of Product */

			/**/ int favouriteNo = 3; /**/

			List<WebElement> listOfProducts = driver.findElements(By.xpath("//a[@class='product-item-link']"));
			a.moveToElement(listOfProducts.get(favouriteNo)).build().perform();

			Thread.sleep(4000);

			// click the cart tooltip in to the product listing
			List<WebElement> addToCart = driver.findElements(By.xpath("//button[@title='Add to Cart']"));
			addToCart.get(favouriteNo).click();

		} else if (ProductPagewise.equals("yes")) {

			List<WebElement> Categories = driver.findElements(By.xpath("//a[@class='level-top ui-corner-all']"));
			a = new Actions(driver);
			a.moveToElement(Categories.get(2)).build().perform();

			Thread.sleep(3000);

			List<WebElement> ProductOptionList = driver.findElements(By.xpath("//li[@role='presentation']"));
			a.moveToElement(ProductOptionList.get(19)).build().perform();
			(ProductOptionList.get(19)).click();

			Thread.sleep(5000);

			// List<WebElement> ProductNames =
			// driver.findElements(By.xpath("//a[@class='product-item-link']"));

			PurchasePoj p = new PurchasePoj(driver);

			for (int k = 0; k < p.ProductNames.size(); k++) {

				String actualProductName = p.ProductNames.get(k).getText();
				
				String ExpectProductName="Gallery Glass Metallic Palms 120X180Cm";

				if (actualProductName.equals(ExpectProductName)) {

					a = new Actions(driver);
					a.moveToElement(p.ProductNames.get(k)).perform();
					Thread.sleep(2000);
					List<WebElement> specipicProduct = driver.findElements(By.xpath("//button[@title='Add to Cart']"));
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", specipicProduct.get(k));
					i=k;
					break;

				}

				if (k == p.ProductNames.size() - 1) {

					try {

						driver.findElement(By.xpath("(//a[@class='action  next'])[2]")).click();
						Thread.sleep(5000);
						k = -1;

					} catch (Exception e) {

						System.out.println("User Expected Product is not Available");
                        i=-1;
						
					}

				}

			}

		}else if (GeneralSearch.equals("yes")) {
			
		WebElement searchTextbox = driver.findElement(By.cssSelector("input#search"));
		searchTextbox.sendKeys("Money Box Bulldog Gold-Black");
		String enterdProductName = searchTextbox.getAttribute("value");
		
		Thread.sleep(2000);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		PurchasePoj p = new PurchasePoj(driver);

		for (int k = 0; k < p.ProductNames.size(); k++) {

			String actualProductName = p.ProductNames.get(k).getText();

			if (actualProductName.equals(enterdProductName)) {

				a = new Actions(driver);
				a.moveToElement(p.ProductNames.get(k)).perform();
				Thread.sleep(2000);
				List<WebElement> specipicProduct = driver.findElements(By.xpath("//button[@title='Add to Cart']"));
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", specipicProduct.get(k));
				break;

			}

			if (k == p.ProductNames.size() - 1) {

				try {

					driver.findElement(By.xpath("(//a[@class='action  next'])[2]")).click();
					Thread.sleep(5000);
					k = -1;

				} catch (Exception e) {

					System.out.println("User Expected Product is not Available");
					 i=-1;
				}

			}

		
		}
		
		}

		Thread.sleep(2000);

		if (i!=-1) {
			// product added the cart popup is showing or not
			WebElement addtoCartPopup = driver.findElement(By.xpath("(//div[text()='Item added to your cart.'])[2]"));
			// popup is showing condition is true
			boolean popup = addtoCartPopup.isDisplayed();
			Assert.assertTrue(popup, "Product is add to out cart");

			// entering in to the Cart page
			WebElement cartIcon = driver.findElement(By.xpath("(//span[text()='Shopping Cart'])[1]"));
			cartIcon.click();
		}

	}

	@Test(priority = 4, enabled = false)
	private void cartpageWorks() throws InterruptedException {

		/**/ String discoutAvailable = "yes";

		// if discount coupon is avilable if block will execute, coupon is not avilable
		// its not execute
		if (discoutAvailable.equals("no")) {

			// enter the discount code
			WebElement enterDiscountCode = driver.findElement(By.xpath("(//input[@class='input-text'])[2]"));
			enterDiscountCode.sendKeys("Test@123");

			Thread.sleep(2000);

			// click the apply discount button
			WebElement applyDiscount = driver.findElement(By.xpath("//span[text()='Apply Discount']"));
			applyDiscount.click();

			Thread.sleep(3000);
		}

		/**/ String userLikeShoppingOrCheckout = "Checkout";

		// if user likes to checkout so if will be execute,user likes to continue to
		// shopping else will be execute
		if (userLikeShoppingOrCheckout.equals("Checkout")) {

			Thread.sleep(19000);

			// once checkout Button is showing try block will execute ,otherwise checkout
			// popup is showing catch block will execute
			try {

				WebElement checkoutBtn = driver.findElement(By.xpath("(//button[@title='Proceed to Checkout'])[1]"));
				checkoutBtn.click();

			} catch (Exception e) {

				WebElement checkoutPopup = driver.findElement(By.xpath("(//button[@title='Proceed to Checkout'])[3]"));
				js.executeScript("arguments[0].click();", checkoutPopup);

			}

			Thread.sleep(13000);

		} else {

			WebElement continueToShopping = driver.findElement(By.xpath("(//a[@title='Continue Shopping'])[1]"));
			continueToShopping.click();

			Thread.sleep(3000);
		}

	}

	@Test(priority = 5, enabled = false)
	private void checkoutWorks() throws InterruptedException {

		String userNeedToCheckout = "ship to my address";

		// if user likes to checkout ship to my address if block will execute,otherwise
		// user likes to checkout kare stores else block will execute
		if (userNeedToCheckout.equals("ship to my address")) {

			// scroll Down
			WebElement scrDown = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

			Thread.sleep(4000);

			// click the next button
			WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
			js.executeScript("arguments[0].click();", next);

		} else {

			// click the KARE stores
			WebElement kareStores = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
			kareStores.click();

			Thread.sleep(3000);

			// select the specific KARE store
			WebElement selectStoreName = driver.findElement(By.xpath("//select[@id='pickup_store']"));
			Select s = new Select(selectStoreName);
			s.selectByIndex(6);

			Thread.sleep(1500);

			// click the next Button
			WebElement next = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
			next.click();

			Thread.sleep(7000);
		}

	}

	@Test(priority = 6, enabled = false)
	private void payment() throws InterruptedException {

		/* select the payment type here */ paymentMethod = "Postpay";

		Thread.sleep(3000);

		// payment type is card payment if block will execute,payment type is postpay
		// else block will execute

		if (paymentMethod.equals("Card Payment")) {

			// click the card Payment option
			WebElement cardPayment = driver.findElement(By.xpath("//input[@id='ccavenue']"));
			cardPayment.click();

			Thread.sleep(3000);

			/**/ usingStoreCredit = "yes";

			// using store credit is yes if block will execute, othrerwise its not execute
			if (usingStoreCredit.equals("No")) {

				// click the store credit option
				WebElement StoreCredit = driver.findElement(By.xpath("//span[@class='action action-toggle']"));
				StoreCredit.click();

				Thread.sleep(2000);

				// enter the using store credit amount
				WebElement StoreCreditAmount = driver.findElement(By.xpath("//input[@id='credit-amount']"));
				StoreCreditAmount.sendKeys("");

				Thread.sleep(2000);

				// submit the store credit amount
				WebElement submitStoreCredit = driver.findElement(By.xpath("//button[@id='apply-credit']"));
				submitStoreCredit.click();

				Thread.sleep(2000);

			}

			// scroll Down
			WebElement scrDown = driver.findElement(By.xpath("//div[text()='Payment Method']"));
			js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

			Thread.sleep(2000);

			// click the place order Button
			WebElement placeOrderBtn = driver.findElement(By.xpath("(//span[text()='Place Order'])[3]"));
			placeOrderBtn.click();

		} else {

			Thread.sleep(3000);

			// click the Postpay Option
			WebElement postPayRadioBtn = driver.findElement(By.xpath("(//input[@name='payment[method]'])[1]"));
			postPayRadioBtn.click();

			Thread.sleep(3000);

			usingStoreCredit = "yes";

			// using store credit is equals to yes if block will execute otherwise its not
			// execute
			if (usingStoreCredit.equals("No")) {

				// click the store credit option
				WebElement StoreCredit = driver.findElement(By.xpath("//span[@class='action action-toggle']"));
				StoreCredit.click();

				Thread.sleep(2000);

				// enter the store credit amount
				WebElement StoreCreditAmount = driver.findElement(By.xpath("//input[@id='credit-amount']"));
				StoreCreditAmount.sendKeys("");

				Thread.sleep(2000);

				// submit the store credit
				WebElement submitStoreCredit = driver.findElement(By.xpath("//button[@id='apply-credit']"));
				submitStoreCredit.click();

				Thread.sleep(2000);

			}

			// click the Continue to postpay Btn
			WebElement continuePostpayBtn = driver.findElement(By.xpath("//span[text()='Continue to Postpay']"));
			continuePostpayBtn.click();

		}

		Thread.sleep(5000);

	}

	@Test(priority = 7, enabled = false)
	private void ccAvenue() throws InterruptedException {

		// payment type is card payment means if block will execute,payment type is
		// Postpay means else block will execute
		if (paymentMethod.equals("Card Payment")) {

			// scroll Down
			WebElement scrollDown = driver.findElement(By.xpath("(//div[@class='span6'])[2]"));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);

			Thread.sleep(3000);

			// entered the card number
			WebElement creditCardNumber = driver.findElement(By.xpath("//input[@id='creditCardNumber']"));
			creditCardNumber.sendKeys("5123450000000008");

			Thread.sleep(2000);

			// entered the expire month
			WebElement expireMonth = driver.findElement(By.xpath("//select[@id='expiryMonthCreditCard']"));
			Select s = new Select(expireMonth);
			s.selectByIndex(1);

			// enter the expire year
			WebElement expireYear = driver.findElement(By.xpath("//select[@id='expiryYearCreditCard']"));
			Select s1 = new Select(expireYear);
			s1.selectByVisibleText("2039");

			// enter the CCV number
			WebElement ccvNumber = driver.findElement(By.xpath("//input[@id='CVVNumberCreditCard']"));
			ccvNumber.sendKeys("100");

			// click the submit button
			WebElement submit = driver.findElement(By.xpath("(//span[text()='Make Payment'])[1]"));
			submit.click();

			Thread.sleep(6000);

			// click the send Any way from submit button
			WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Submit']"));
			submitBtn.click();

		} else {

			// WebElement phoneNumberForPostpay =
			// driver.findElement(By.xpath("//div[@class='sc-bRBYWo iiJnbV']"));
			// phoneNumberForPostpay.sendKeys("987654321");

			List<WebElement> phoneNumberForPostpay = driver.findElements(By.xpath("//div[@tabindex='0']"));

			for (int i = 0; i < phoneNumberForPostpay.size(); i++) {

				// ((WebElement) phoneNumberForPostpay).sendKeys("987654321");

				for (int j = 0; j > 9; j--) {

					int j1 = j;

					String s = Integer.toString(j1);

					((WebElement) phoneNumberForPostpay.get(j1)).sendKeys(s);
				}
			}

			Thread.sleep(3000);

			// click the send code Btn
			WebElement sendCode = driver.findElement(By.xpath("//button[text()='Send Code']"));
			sendCode.click();

		}

	}

}
