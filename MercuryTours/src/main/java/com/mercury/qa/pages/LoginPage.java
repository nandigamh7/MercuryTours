package com.mercury.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	//Page Factory or Object Repository
	@FindBy(xpath="//div[@class='collapse navbar-collapse']//a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLnk;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPage(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) throws Exception{

		Thread.sleep(3000);
		loginLink.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
