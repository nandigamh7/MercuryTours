package com.mercury.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercury.qa.Util.TestUtil;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public BaseClass(){
		
		try{
			prop = new Properties();
			FileInputStream ip;
			ip = new FileInputStream("C:\\Users\\nandigam.kumar\\git\\MercuryTours\\MercuryTours\\src\\main\\java\\com\\mercury\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(Exception e){
			e.getMessage();
		}
		
	}
	
	public static void initialisation(){
		String browser = prop.getProperty("browser");
//		System.out.println("Browser: "+browser);
//		System.out.println("URL: "+prop.getProperty("url"));
//		System.out.println("URL: "+prop.getProperty("username"));
//		System.out.println("URL: "+prop.getProperty("password"));
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		
		driver.get(prop.getProperty("url"));
	}
	
}
