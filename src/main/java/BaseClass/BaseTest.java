package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest() {
		prop = new Properties();
		try {
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
			prop.load(input);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	public void setupDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//a[@aria-label='Amazon']")).click();
		
	}
	
	public String getScreenshot(String testCase) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//Screenshots//"+testCase+".png");
		FileHandler.copy(source, file);
		return System.getProperty("user.dir")+"//Screenshots//"+testCase+".png";
		
	}
	
	
	
	

}
