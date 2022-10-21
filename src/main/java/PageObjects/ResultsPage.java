package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.BaseTest;

public class ResultsPage extends BaseTest {

	WebElement price;

	public String checkPrice() {
		return driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
	}
	
	public void openProdcutPage() {
		driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Blue']")).click();
	}

	public String openProductPage() {
		String child_window = "";
		
		
		//driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Blue']")).click();

		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

			}

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.switchTo().window(child_window).getTitle();

	}
}
