package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.BaseClass;

public class ContactsPage extends BaseClass{

	@FindBy(xpath = "//div[contains(text(), 'Contacts')]")
	WebElement contactLabel;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactLabel.isDisplayed();
	}

}
