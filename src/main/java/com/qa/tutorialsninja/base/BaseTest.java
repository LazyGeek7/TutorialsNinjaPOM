package com.qa.tutorialsninja.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.tutorialsninja.pages.AccountsPage;

import com.qa.tutorialsninja.pages.LoginPage;
import com.qa.tutorialsninja.pages.RegistrationPage;

public class BaseTest {
	//This is basetest
	//Sample line
	
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public RegistrationPage registrationPage;
	
	public AccountsPage	 accountsPage;
	
	@BeforeTest
	public void setUp() {
		
		 basePage=new BasePage();
		  prop=basePage.init_prop();
		driver=basePage.init_driver(prop.getProperty("browser"));
		loginPage=new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		
		
			
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
