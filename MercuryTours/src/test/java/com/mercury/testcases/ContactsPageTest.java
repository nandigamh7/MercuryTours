package com.mercury.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.qa.Util.TestUtil;
import com.mercury.qa.base.BaseClass;
import com.mercury.qa.pages.ContactsPage;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class ContactsPageTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";
	
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
	
	@Test(priority = 1)
	public void verifyContactsPageLabel(){
		contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the page");
	}
	
	
	@DataProvider
	public Object[][] getContactTestData() throws Exception{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getContactTestData")
	public void validateCreateNewContact(String fstName, String lstName, String eMail, String position){
		contactsPage.createNewContact(fstName, lstName, eMail, position);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
