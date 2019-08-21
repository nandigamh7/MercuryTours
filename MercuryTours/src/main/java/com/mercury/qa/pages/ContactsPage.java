package com.mercury.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.BaseClass;

public class ContactsPage extends BaseClass{

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black' and text() = 'Contacts']")
	WebElement contactLabel;
	
	@FindBy(xpath = "//button[@class='ui linkedin button' and contains(text(), 'New')]")
	WebElement newContactBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactLabel.isDisplayed();
	}
	
	public void createNewContact(String fstName, String lstName, String eMail, String position){
		newContactBtn.click();
		
		driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys(fstName);
		driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys(lstName);
		driver.findElement(By.xpath("//div[@class='ui right corner labeled input']//input[@name = 'value']")).sendKeys(eMail);
		driver.findElement(By.xpath("//div[@class='ui input']//input[@name = 'position']")).sendKeys(position);
		driver.findElement(By.xpath("//button[@class='ui linkedin button' and contains(text(), 'Save')]")).click();
		
	}

}
