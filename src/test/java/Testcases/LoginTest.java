package Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseTest;

import PageObjects.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginpage = new LoginPage();

	public LoginTest() {
		super();
	}

	@BeforeTest
	public void testStartup() {
		setupDriver();

	}

	@AfterTest
	public void testTeardown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void checkHomePageNameTest() {
		Assert.assertEquals(loginpage.checkHomePageName(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

	}

	@Test(priority = 1)
	public void checkSignInButtonTest() throws InterruptedException {

		Assert.assertEquals(loginpage.checkSignInButton().getText(), "Sign in securely");
		// System.out.println(loginpage.checkSignInButton());
		loginpage.clickSignInButton();

	}

	@Test(priority = 2)
	public void checkSignInPageTest() throws InterruptedException {
		Assert.assertEquals(loginpage.checkPageHeaders(), "Amazon Sign In");
	}

	@Test(priority = 3)
	public void checkSignInHeaderTest() {
		Assert.assertEquals(loginpage.checkSignInHeader().getText(), "Sign in");
	}
	
	@Test(priority = 4)
	public void enterInavlidUsernameTest() {
		Assert.assertEquals(loginpage.invalidUsernameText(), "There was a problem We cannot find an account with that email address");
		
	}
	
	@Test(priority = 5)
	public void enterInavlidPasswordTest() {
		Assert.assertEquals(loginpage.invalidPasswordText(), "There was a problem Your password is incorrect");
		
	}
	
	
	
	//@Test(priority = 6)
	public void enterUsernameTest() {
		loginpage.enterUsername();
	}
	
	
	
	//@Test(priority = 7)
	public void checkEnteredUsernameTest() {
		Assert.assertEquals(loginpage.checkEnteredUsername().getText(), prop.getProperty("username"));
		
	}
	
	//@Test(priority = 8)
	public void enterPasswordTest() {
		loginpage.enterPassword();
	}
	
	
	
	
}
