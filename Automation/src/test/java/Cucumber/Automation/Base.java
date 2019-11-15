package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop; 
	
	public static WebDriver getDriver() throws FileNotFoundException, IOException
	{
		prop=new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/java/Cucumber/Automation/global.properties"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String applicationURL = prop.getProperty("url");
		driver.get(applicationURL);
		return driver;
	}

}
