package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import BaseClass.BaseTest;

public class HomePage extends BaseTest {

	public void enterItemName() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(prop.getProperty("itemName"));
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	}

	StringBuilder sb = new StringBuilder();

	public String checkSelectText() {

		Select all = new Select(driver.findElement(By.cssSelector("select#searchDropdownBox")));
		all.selectByVisibleText("Apps & Games");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		String text = driver
				.findElement(By
						.xpath("//span[@class='a-size-base a-color-base apb-browse-refinements-indent-1 a-text-bold']"))
				.getText();
		return text;

	}

}
