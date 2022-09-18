package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseTest;

public class LoginPage extends BaseTest {
	
	public WebElement userName=null, passWord=null, usernameContinue=null, passwordSignin=null;

	@FindBy(xpath = "(//a[@data-nav-role='signin'])[1]")
	WebElement helloSignin;

	@FindBy(xpath = "(//span[@class='nav-action-inner'])[2]")
	WebElement signInButton;

	WebElement signInSecurely = null;

	@FindBy(css = "input#twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(css = "//a[@data-csa-c-slot-id='nav_cs_0']")
	WebElement bestSellers;

	@FindBy(css = "input#ap_email")
	public WebElement username;

	@FindBy(css = "input#continue")
	public WebElement continueButton;

	@FindBy(xpath = "//div[@class='a-row a-spacing-base']//span")
	WebElement enteredUsername;

	@FindBy(css = "input#ap_password")
	WebElement password;

	@FindBy(css = "input#signInSubmit")
	WebElement signInPass;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}

	public String checkHomePageName() {
		return driver.getTitle();
	}

	public WebElement checkSignInButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Sign in securely']"))));

		return driver.findElement(By.xpath("//a[text()='Sign in securely']"));
	}

	public void clickSignInButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Sign in securely']"))));
		driver.findElement(By.xpath("//a[text()='Sign in securely']")).click();

	}

	public String checkPageHeaders() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='a-spacing-small']"))));

		return driver.getTitle();
	}

	public WebElement checkSignInHeader() {
		return driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
	}

	public void enterUsername() {

		userName = driver.findElement(By.cssSelector("input#ap_email"));
		userName.sendKeys(prop.getProperty("username"));
		usernameContinue = driver.findElement(By.cssSelector("input#continue"));
		usernameContinue.click();
		
		
	}
	
	public WebElement checkEnteredUsername() {
		return driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']//span"));
	}

	public void enterPassword() {

		passWord = driver.findElement(By.cssSelector("input#ap_password"));
		passWord.sendKeys(prop.getProperty("password"));
		passwordSignin = driver.findElement(By.cssSelector("input#signInSubmit"));
		passwordSignin.click();
		
		
	}
	
	public String invalidUsernameText() {
		
		userName = driver.findElement(By.cssSelector("input#ap_email"));
		userName.sendKeys(prop.getProperty("invalidUsername"));
		usernameContinue = driver.findElement(By.cssSelector("input#continue"));
		usernameContinue.click();
		
		String s1 = driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText();
		String s2 = driver.findElement(By.cssSelector("span.a-list-item")).getText();
		
		
		return s1.concat(" "+s2);
	}
	
	public String invalidPasswordText() {
		userName = driver.findElement(By.cssSelector("input#ap_email"));
		usernameContinue = driver.findElement(By.cssSelector("input#continue"));
		userName.clear();
		userName.sendKeys(prop.getProperty("username"));
		usernameContinue.click();
		
		passWord = driver.findElement(By.cssSelector("input#ap_password"));
		passWord.sendKeys(prop.getProperty("invalidPassword"));
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#signInSubmit"))));
		
		passwordSignin = driver.findElement(By.cssSelector("input#signInSubmit"));
		passwordSignin.click();
		
		String s1=driver.findElement(By.cssSelector("h4.a-alert-heading")).getText();
		String s2=driver.findElement(By.cssSelector("span.a-list-item")).getText();
		
		return s1.concat(" "+s2);
	}
	

}
