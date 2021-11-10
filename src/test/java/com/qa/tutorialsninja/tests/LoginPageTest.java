package com.qa.tutorialsninja.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("EPIC-200:LoginPage Functionality")
@Story("US-16:Login Page features ")

public class LoginPageTest extends BaseTest{
	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("getTitleTest")
	@Test(priority=1)
	public void getTitleTest() {
		String actualTitle=loginPage.doGetLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("forgottenPasswordLinkTest")
	@Test(priority=2)
	public void forgottenPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgottenPasswordLinkExist());
		

	}
	@Severity(SeverityLevel.CRITICAL)
	@Description("doLoginTest")
	@Test(priority=3)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password") );
		
	}

}
