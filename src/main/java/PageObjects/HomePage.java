package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseTest;

public class HomePage extends BaseTest {

	public void enterItemName() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(prop.getProperty("itemName"));
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	}

	StringBuilder sb = new StringBuilder();

	public void getLinkHeaders() {

		List<WebElement> linkText = driver.findElements(By.xpath("//a[@data-csa-c-type='link']"));
		String[] linkTextArray = { "" };
		System.out.println(linkText.size());
		for (int i = 1; i < 8; i++) {
			String x = linkText.get(i).getText() + " ";
			System.out.print(x);
			sb.append(x);

		}

		System.out.println();
		String newStr = sb.toString().substring(0, sb.toString().length() - 1);
		System.out.println(newStr);

	}

}
