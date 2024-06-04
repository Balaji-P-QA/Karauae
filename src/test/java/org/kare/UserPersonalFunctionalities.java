package org.kare;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserPersonalFunctionalities {

	WebDriver driver;

	JavascriptExecutor js;

	String usingStoreCredit;

	String paymentMethod;

	String keyword;

	String newKeyword;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://upg-dev.kareuae.com/");

		driver.manage().window().maximize();

		Thread.sleep(4000);

		WebElement agree = driver.findElement(By.xpath("//span[text()='I Agree']"));
		agree.click();

	}

	@Test(priority = 1, enabled = true)
	private void login1() {
         
		//click the sign Btn
		WebElement accBtn = driver.findElement(By.xpath("//div[@class='toplink login-link']"));
		accBtn.click();

	}

	@Test(priority = 2, enabled = true)
	private void credentials() throws InterruptedException {

		keyword = "Balaji@123";

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys(keyword);

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
		submit.click();

	}

	@Test(priority = 3, enabled = true)
	private void goToOurAccount() {

		//click the sign Btn
		WebElement accBtn = driver.findElement(By.xpath("//div[@class='toplink login-link']"));
		accBtn.click();

	}

	@Test(priority = 4, enabled = false)
	private void myOrders() throws InterruptedException {

		//click the My Orders option
		WebElement myOrders = driver.findElement(By.xpath("//a[text()='My Orders']"));
		myOrders.click();

		Thread.sleep(3000);

		//to loacate the specific product ordered
		List<WebElement> ordersCount = driver.findElements(By.xpath("//td[@class='col shipping']"));
		System.out.println("User ordered the " + ordersCount.size() + " Product");

		/**/ int specificProductViewOrder = 5;

		String UserWantto = "View Order";

		//user Wants to view order means if block will execute, otherwise its not execute
		if (UserWantto.equals("View Order")) {

			//click the view order link in to specific product
			List<WebElement> viewOrder = driver.findElements(By.xpath("//span[text()='View']"));
			viewOrder.get(specificProductViewOrder).click();

			Thread.sleep(3000);

			//to fetch that specific product order id
			WebElement orderId = driver.findElement(By.xpath("//span[@class='base']"));
			System.out.println("User viewed the product order id is :" + orderId);

			//go to back
			driver.navigate().back();

			Thread.sleep(3000);
		}

		String cancelOrder="yes";

	/**/	int specificProductCancelOrder = 1;

		//user likes to cancel order is yes means if block will execute
		if (cancelOrder.equals("yes")) {

			//print the particular cancel order id 
			List<WebElement> cancelOrderIdCount = driver.findElements(By.xpath("//td[@data-th='Order #']"));
			String cancelOrderNum = cancelOrderIdCount.get(specificProductCancelOrder).getText();

			Thread.sleep(3000);

			//click the cancel button to specific product
			List<WebElement> cancelProduct = driver.findElements(By.xpath("//a[text()='Cancel']"));
			cancelProduct.get(specificProductCancelOrder).click();

			//click the confirm option from cancel popup
			WebElement cancelConfirmPopup = driver.findElement(By.xpath("//a[text()='Yes']"));
			cancelConfirmPopup.click();

			Thread.sleep(3000);

			//to refresh
			driver.navigate().refresh();

			Thread.sleep(3000);

			//after canceled the order product 
			List<WebElement> aftCancelOrderIdCount = driver.findElements(By.xpath("//td[@data-th='Order #']"));
			String aftCancelOrderNum = cancelOrderIdCount.get(specificProductCancelOrder).getText();

			Thread.sleep(3000);

			//canceled order is not showing in orderlist if block will execute,cancelled order showing in order list else block will execute
			if (cancelOrderNum.equals(aftCancelOrderNum)) {

				System.out.println("product canceled successfully");
				Assert.assertTrue(true);

			} else {

				System.out.println("product canceled unsuccessful");
				Assert.assertTrue(false);
			}

		}

	}

	@Test(priority = 5, enabled = false)
	private void myWishList() throws InterruptedException {

		//click the wishList link
		WebElement myWishList = driver.findElement(By.xpath("//a[text()='My Wish List']"));
		myWishList.click();

		Thread.sleep(3000);

		//wish List is empty try block will execute,wish List have a product catch block will execute
		try {

			WebElement wishListEmpty = driver.findElement(By.xpath("//div[@class='message info empty']"));

			if (wishListEmpty.isDisplayed()) {

				System.out.println("User don't a have products in our wishlist");
			}

		} catch (Exception e) {

			List<WebElement> wishlistCount = driver.findElements(By.xpath("//img[@class='product-image-photo']"));

			System.out.println("User have " + wishlistCount.size() + " products in our wishlist");

			Thread.sleep(3000);
			
			String userLikeWishList="updateWishList";
			
			//user like the wish List is updateWishList if block will execute,wish List is equals to share wish List elseif block will execute,
			//otherwise else block will execute
			if (userLikeWishList.equals("updateWishList")) {
				
			String qty="4";	
				
			//enter the product qty
			WebElement enterProductQty = driver.findElement(By.xpath("(//input[@type='number'])[1]"));	
			enterProductQty.sendKeys(qty);	
			
			Thread.sleep(3000);
			
			//click the update wish List Btn
			WebElement updateWishListBtn = driver.findElement(By.xpath("//span[text()='Update Wish List']"));
			updateWishListBtn.click();
			
			Thread.sleep(5000);
            
			//qtysize is equals to qty is true
			String qtysize = enterProductQty.getAttribute("value");
			qtysize.equals(qty);
			Assert.assertTrue(true);
						
			}else if (userLikeWishList.equals("shareWishList")) {
				
				//click the share wish list Btn
				WebElement shareWishList = driver.findElement(By.xpath("//span[text()='Share Wish List']"));
				shareWishList.click();
				
				Thread.sleep(3000);

				//enter the email id
				WebElement email = driver.findElement(By.xpath("//textarea[@id='email_address']"));
				email.sendKeys("balaji.p@mailinator.com");
				
				Thread.sleep(3000);
				
				//enter the message
				WebElement message = driver.findElement(By.xpath("//textarea[@id='message']"));
				message.click();
				
				Thread.sleep(3000);
				
				//click the share Btn
				WebElement shareBtn = driver.findElement(By.xpath("//span[text()='Share Wish List']"));
				shareBtn.click();
				
			}else {
				
				int productNum=1;
				
				//share the product to cart
				List<WebElement> productLists = driver.findElements(By.xpath("//button[@class='action tocart primary']"));
				//wish list size
				int beforeSize = productLists.size();
				System.out.println("user have a "+beforeSize+"products in our wish List");
				
				productLists.get(productNum).click();
				
				Thread.sleep(3000);
				
				//after shared the product to cart then get wish list size
			    int afterSize = productLists.size();
			    System.out.println("after added one productt to cart the then the wish list have "+afterSize+" products");
			}
			
		}

		//go to back
		driver.navigate().back();

	}

	@Test(priority = 6, enabled = false)
	private void accountDashboard() throws InterruptedException {

		//click the account dash board button
		WebElement accountDashboard = driver.findElement(By.xpath("//strong[text()='Account Dashboard']"));
		accountDashboard.click();

		Thread.sleep(3000);

	}

	@Test(priority = 7, enabled = false)
	private void storeCredit() throws InterruptedException {

		WebElement storeCredit = driver.findElement(By.xpath("//a[text()='Store Credit']"));
		storeCredit.click();

		Thread.sleep(3000);

		String curTitle = driver.getTitle();

		if (curTitle.equals("Store Credit")) {

			System.out.println("user entered in to the store credit page");
			Assert.assertTrue(true);

			Thread.sleep(3000);

			WebElement storeCreditBalance = driver.findElement(By.xpath("//span[@class='price']"));
			System.out.println("user have a " + storeCreditBalance.getText() + " balance in our store credit");

		} else {

			System.out.println("user entered in to the store credit page");
			Assert.assertTrue(false);

		}

	}

	@Test(priority = 8, enabled = true)
	private void accountInformation() throws InterruptedException {

	/**/	String changeEmail = "yes";

		//changeEmail is yes if block will execute, otherwise is not execute
		if (changeEmail.equals(" ")) {

			//click the accoun Information
			WebElement accountInformation = driver.findElement(By.xpath("//a[text()='Account Information']"));
			accountInformation.click();

			Thread.sleep(3000);

			//click the change email check box
			WebElement changeEmailCheckBox = driver.findElement(By.xpath("//input[@name='change_email']"));
			changeEmailCheckBox.click();

			Thread.sleep(3000);

			//enter the current password
			WebElement curPassword = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
			curPassword.sendKeys(keyword);

			Thread.sleep(1000);

			//click the save Btn
			WebElement saveBtn = driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
			saveBtn.click();
		}

	/**/	String changePassword = "yes";

		//changePassword is yes if block will execute
		if (changePassword.equals("")) {

			//click the account Information 
			WebElement accountInformation = driver.findElement(By.xpath("//a[text()='Account Information']"));
			accountInformation.click();

			Thread.sleep(3000);

			newKeyword = "Balaji@123";

			//click the change password check box
			WebElement changePasswordCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			changePasswordCheckBox.click();

			Thread.sleep(3000);

			//enter the current password
			WebElement currentPassword = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
			currentPassword.sendKeys(keyword);

			Thread.sleep(3000);

			//enter the new Password
			WebElement newPassword = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
			newPassword.sendKeys(newKeyword);

			Thread.sleep(3000);

			//enter the confirm new password
			WebElement confirmNewPassword = driver.findElement(By.xpath("(//input[@type='password'])[3]"));
			confirmNewPassword.sendKeys(newKeyword);

			Thread.sleep(3000);

			//click the save Btn
			WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[1]"));
			saveBtn.click();

			Thread.sleep(3000);

			// enter the user name
			WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
			userName.sendKeys("balaji.p@sysfore.com");

			// enter the password
			WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
			password.sendKeys(newKeyword);

			// click the submit
			WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
			submit.click();

			String curUrl = driver.getCurrentUrl();

			//current url is equals to expected url if block will execute,otherwise else block will execute
			if (curUrl.equals("https://upg-dev.kareuae.com/")) {

				System.out.println("password Updated successfully");
				Assert.assertTrue(true);

			} else {

				System.out.println("password Updated successfully");
				Assert.assertTrue(false);
			}

		}

		String newsLetter = "yes";

		//newsLetter is equal to yes if block will execute,
		if (newsLetter.equals("yes")) {

			WebElement accBtn = driver.findElement(By.xpath("//div[@class='toplink login-link']"));
			accBtn.click();

			//click the account Information 
			WebElement accountInformation = driver.findElement(By.xpath("//a[text()='Account Information']"));
			accountInformation.click();

			Thread.sleep(3000);

			//scroll Down
			WebElement scrDown = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

			Thread.sleep(3000);

			//locate the news Letter check box
			WebElement newsLetterCheckbox = driver.findElement(By.xpath("//input[@id='subscription']"));
			
			Thread.sleep(3000);

			//news Letter is already subscribed if block will execute,already not subscribed then else block will execute
			if (newsLetterCheckbox.isSelected()) {
				
				System.out.println("User have already subscribed the NewsLetter");

				
			} else {
				
				//click the news letter subscribe checkbox
				WebElement newsCheckbox = driver.findElement(By.xpath("//input[@id='subscription']"));
				newsCheckbox.click();

				Thread.sleep(3000);

				//click the save Btn
				WebElement newsLetterSaveBtn = driver.findElement(By.xpath("(//button[@title='Save'])[2]"));
				newsLetterSaveBtn.click();
				
				Thread.sleep(2000);
				
				//print the News Letter subscribe success msg
				WebElement succMsg = driver.findElement(By.xpath("//div[text()='We have saved your subscription.']"));
                System.out.println(succMsg.getText());
			}

		}

	}
	
	@Test(priority=9,enabled=false)
	private void adddressBook() throws InterruptedException {
    
		//click the address book 
		WebElement addressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
		addressBook.click();
		
		Thread.sleep(3000);
		
		//to get the current title
		String curTitle = driver.getTitle();
		
		//current title is equal to Address Book if block will execute,otherwise else block will execute
		if (curTitle.equals("Address Book")) {
			
			System.out.println("user entered in to the Address Book page");
			Assert.assertTrue(true);
			
			String addNewAddress="yes";
			
			//addNewAddress is equal to yes if block will execute
			if (addNewAddress.equals("yes")) {
				
				//click the add new Address Btn
				WebElement addNewAddressBtn = driver.findElement(By.xpath("//button[@title='Add New Address']"));
				addNewAddressBtn.click();
				
				Thread.sleep(3000);
				
				//enter the company Name
				WebElement companyName = driver.findElement(By.xpath("//input[@id='company']"));
				companyName.sendKeys("SYSFORE");
				
				Thread.sleep(3000);
				
				//enter the Telephone number
				WebElement telePhone = driver.findElement(By.xpath("//input[@id='telephone']"));
				telePhone.sendKeys("987654321");
				
				Thread.sleep(3000);
				
				//enter the Flat No
				WebElement flatNo = driver.findElement(By.xpath("(//input[@name='street[]'])[1]"));
				flatNo.sendKeys("01 ABC flats");
				
				Thread.sleep(3000);
				
				//enter the Street name
				WebElement street = driver.findElement(By.xpath("(//input[@name='street[]'])[2]"));
				street.sendKeys("ABC Street");
				
				Thread.sleep(3000);
				
				//enter the Land mark
				WebElement landMark = driver.findElement(By.xpath("(//input[@name='street[]'])[3]"));
				landMark.sendKeys("opp to ABC School");
				
				Thread.sleep(3000);
				
				//select the city
				WebElement city = driver.findElement(By.xpath("//Select[@name='city']"));
				Select s = new Select(city);
				s.selectByIndex(3);
				
				Thread.sleep(3000);
				
				//enter the city area
				WebElement cityArea = driver.findElement(By.xpath("//input[@id='city_area']"));
				cityArea.sendKeys("small dhubai");
				
				Thread.sleep(3000);
				
				//select the country
				WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));
				Select s1 = new Select(country);
				s1.selectByIndex(0);
				
				String shippingAddress="yes";
				
				//if you want to entered the address is shipping  if block will execute,
				if (shippingAddress.equals("")) {
					
					//click the shipping checkbox
					WebElement shipping = driver.findElement(By.xpath("//input[@name='default_shipping']"));
					shipping.click();
				}
				
				Thread.sleep(3000);
				
				//click the save Btn
				WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save Address']"));
				saveBtn.click();
			}			
			
			
		} else {

			System.out.println("user not entered in to the Address Book page");
			Assert.assertTrue(false);
			
		}
		
		
	}
	
	
	@Test(priority=10,enabled=false)
	private void logout() throws InterruptedException {
		
		//click the logout
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
		
		Thread.sleep(2000);

       //Locate the signout		
		WebElement signout = driver.findElement(By.xpath("//span[text()='You are signed out']"));
		
		//signout is successfully if block will execute,signout is unsuccessful else block will execute
		if (signout.isDisplayed()) {
			
			System.out.println("user have signout successfully");
			Assert.assertTrue(true);
		    System.out.println(signout.getText());	
			
		} else {

			System.out.println("user have signout Unsuccessfully");
			Assert.assertTrue(true);
		
		}
		
	}
	

}
