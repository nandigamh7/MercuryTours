package com.mercury.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.BaseClass;
import com.mercury.qa.pages.ContactsPage;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class HomePageTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialisation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTtl();
		Assert.assertEquals(homePageTitle, "CRM", "Home page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserName(){
		Assert.assertTrue(homePage.correctUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest(){
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
