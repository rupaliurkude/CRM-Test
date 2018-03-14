package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
//testcases should be independent between each other
//before each testcase ----launch the browser and login
//@test-----execute test case
//after each test case ----  close the browser.
public class HomePageTest extends TestBase {
	TestUtil testUtil;
	 ContactsPage contactsPage;
	 LoginPage loginPage;
	 HomePage  homePage;
	  

	public HomePageTest(){
		super();
	}
	@Test
	@BeforeMethod
	public void testSetUp()throws IOException{
		initialising();
		contactsPage = new ContactsPage();
		 testUtil = new TestUtil();
		 loginPage  = new LoginPage ();	
		homePage= loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		 
	}
	
	@Test(priority=1)
	public void varifyHomePageTitle(){
		String homePageTitle = homePage.validHomePageTitel();
		AssertJUnit.assertEquals(homePageTitle," CRMPRO","Home Page Not Matched");
	}
	@Test(priority =2)
	public void varifyUserNameTest(){
		homePage.varifyCorrectUserName();
		testUtil.switchToFrames();
		AssertJUnit.assertTrue(homePage.varifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void varifyContactsLinkTest(){
		testUtil.switchToFrames();
		contactsPage=homePage.clickOnContactsLinks();
	}
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	
	
}
