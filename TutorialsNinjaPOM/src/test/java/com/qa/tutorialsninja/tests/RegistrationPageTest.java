package com.qa.tutorialsninja.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{

	@BeforeClass
	public void registrationPageSetUp() {
		registrationPage=loginPage.clickRegisterLink();
	}

	
	
	
	@DataProvider
	public Object[][] getRegisterData() {
		
		Object data[][]=ExcelUtil.getTestData("Registration");
		
		
		return data;
		
		
		
	}
	
	
	
	@Test
	(dataProvider="getRegisterData")
	public void userRegTest(String FirstName, String LastName, String Email, String Telephone, String Password, String Subscription) {
		registrationPage.accountRegistration(FirstName,LastName,Email,Telephone,Password,Subscription);
	}
	
	
	
}
