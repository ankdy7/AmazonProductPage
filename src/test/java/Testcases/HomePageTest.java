package Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class HomePageTest extends BaseTest {

	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();

	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void testStartup() throws InterruptedException {
		setupDriver();
		loginpage.clickSignInButton();
		loginpage.enterUsername();
		loginpage.enterPassword();

	}

	@AfterTest
	public void testTeardown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void checkSelectTextTest() {

		Assert.assertEquals(homepage.checkSelectText(), "Apps for Android");

	}

	@Test(priority = 1)
	public void enterItemNameTest() {
		homepage.enterItemName();

	}
}
