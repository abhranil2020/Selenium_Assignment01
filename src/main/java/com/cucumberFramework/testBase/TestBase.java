package com.cucumberFramework.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

	public  static WebDriver driver;
	public static Properties prop;
	
public TestBase( ) {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Propertyfile/config.properties");
			prop.load(ip);		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
				
	public void initialization(){
		String Browser= prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");			
			driver = new ChromeDriver(); 
					
		}
		else if(Browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
		driver.manage().deleteAllCookies();
		
	}	
}
