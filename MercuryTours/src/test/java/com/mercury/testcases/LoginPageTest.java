package com.mercury.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercury.qa.base.BaseClass;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialisation();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1, groups="Group1")
	public void loginPageTitleTest(){
		String loginPageTitle = loginPage.validateLoginPage();
		Assert.assertEquals(loginPageTitle, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority = 2, groups="Group2")
	public void loginTest() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
////TestNG annotations and other advantages Practice 
//	@Test(priority = 2, groups="Group2", dependsOnMethods="test4")
//	public void test3() throws Exception{
//		System.out.println("Test 3");
//	}

//	@Test(priority = 2, groups="Group3", invocationCount=10)
//	public void test4() throws Exception{
////		int i = 0;
////		int j = 1;
////		j=j/i;
////		System.out.println(j);
//		System.out.println("Test 4");
//	}
	

//	@BeforeClass
//	public void beforeClass(){
//		System.out.println("Before Class");
//	}
//	
//	@AfterClass
//	public void afterClass(){
//		System.out.println("After Class");
//	}
//	
//	@BeforeGroups
//	public void beforeGroup(){
//		System.out.println("Before Groups");
//	}
//	
//	@AfterGroups
//	public void afterGroups(){
//		System.out.println("After Groups");
//	}
//	
//	@BeforeSuite
//	public void beforeSuite(){
//		System.out.println("Before Suite");
//	}
//	
//	@AfterSuite
//	public void afterSuite(){
//		System.out.println("After Suite");
//		
//	}
//
//	@BeforeTest
//	public void beforeTest(){
//		System.out.println("Before Test");
//	}
//	
//	@AfterTest
//	public void afterTest(){
//		System.out.println("After Test");
//	}
}