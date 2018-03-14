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

public class ContactsPageTest extends TestBase{
	TestUtil testUtil;
	 ContactsPage contactsPage;
	 LoginPage loginPage;
	 HomePage  homePage;
	  

	public ContactsPageTest(){
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
			contactsPage=homePage.clickOnContactsLinks();
	}
	@Test(priority = 1)
	public void varifyConcactsPageLable(){
		AssertJUnit.assertEquals(contactsPage.varifyContactsLable(),"contacts lable is missing on the page");
	}
	@Test(priority = 2)
	public void selectContactsPage(){
		contactsPage.selectContactsByName("Test1 Test1");
	}
	//if we give same priority then testng will decide which to execute 1st.
	@Test(priority = 3)
	public void selectMultipleContactsPage(){
		contactsPage.selectContactsByName("Test1 Test1");
		contactsPage.selectContactsByName("UiUi UI");
	}
		
		@AfterMethod
		@AfterMethod
		public void tearDown(){
		driver.quit();	 

	}
}