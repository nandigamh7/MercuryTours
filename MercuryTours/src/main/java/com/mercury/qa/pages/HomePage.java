package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.BaseClass;

public class HomePage extends BaseClass{

	//Page Factory or Object Repository
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//span[contains(text(),'Hemanth Nandigam')]")
	WebElement userNameLbl;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean correctUserName(){
		return userNameLbl.isDisplayed();
	}
	
	public String verifyHomePageTtl(){
		String homePageTtl = driver.getTitle();
		return homePageTtl;
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
}
