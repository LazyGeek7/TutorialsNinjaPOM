package com.qa.tutorialsninja.tests;



import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.pages.AccountsPage;

import com.qa.tutorialsninja.utils.Constants;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void doLogin() {
		accountsPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void YourStoreLinkTest() {
		Assert.assertTrue(accountsPage.doVerifyYourStoreLink());
		
	}
	
	@Test
	public void headerListTest() {
		
		Assert.assertEquals(accountsPage.doVerifyHeaderList(), Constants.headersList());
		
		
		
	}
	
	@Test
	public void productSearchTest() {
		Assert.assertTrue(accountsPage.productSearch("iMac"));
		
		
		
		
	}
	
	

}
