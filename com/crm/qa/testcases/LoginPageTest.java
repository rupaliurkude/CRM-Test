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
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase  {
	LoginPage loginPage;
	HomePage homePage;
		
	public LoginPageTest(){
		super();
		
	}
	
	@Test
	@BeforeMethod
	public void testSetUp()throws IOException{
		initialising();

	}
	
	@Test(priority =1)
	public void validLoginPageTitel(){
		String title=  loginPage.validLoginPageTitel();
		AssertJUnit.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority =2)
	public void validCrmImage(){
		boolean flag =loginPage.validCrmImage();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void loginTest(){
		loginPage  = new LoginPage ();
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}



