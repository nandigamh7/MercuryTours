package com.mercury.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.BaseClass;
import com.mercury.qa.pages.ContactsPage;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class ContactsPageTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialisation();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test
	public void verifyContactsPageLabel(){
		contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the page");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
