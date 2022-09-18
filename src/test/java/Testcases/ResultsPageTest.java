package Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ResultsPage;

public class ResultsPageTest extends BaseTest {

	public ResultsPageTest() {
		super();
	}

	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	ResultsPage resultspage = new ResultsPage();

	@BeforeTest
	public void testStartup() throws InterruptedException {
		setupDriver();
		loginpage.clickSignInButton();
		loginpage.enterUsername();
		loginpage.enterPassword();
		homepage.enterItemName();

	}

	@AfterTest
	public void testTeardown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void getLinkHeadersTest() {
		System.out.println("Fetched Price: " + resultspage.checkPrice());
		Assert.assertEquals(resultspage.checkPrice(), "65,900");
		resultspage.openProdcutPage();

	}

	@Test(priority = 1)
	public void openProductPageTest() {
		String str = prop.getProperty("itemName");
		if (!resultspage.openProductPage().contains(str))
			Assert.fail();

	}
}
