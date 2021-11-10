package com.qa.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

public class RegistrationPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By firstNameText=By.name("firstname");
	private By lastNameText=By.name("lastname");
	private By emailText=By.name("email");
	private By telephoneText=By.name("telephone");
	private By passwordText=By.name("password");
	private By passwordConfirmText=By.name("confirm");
	private By subscribeYesButton=By.xpath("//input[@name='newsletter' and @value='1']");
	private By subscribeNoButton=By.xpath("//input[@name='newsletter' and @value='0']");
	private By privacyPolicyCheck=By.name("agree");
	private By continueButton=By.xpath("//input[@type='submit']");
	
	private By successMsg=By.cssSelector("#content h1");
	
	
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		
		elementUtil=new ElementUtil(this.driver);
	}
	
	public boolean accountRegistration(String firstName,String lastName,String email,String telephone,String password,String subscribe) {
		
		elementUtil.doSendKeys(firstNameText, firstName);
		elementUtil.doSendKeys(lastNameText, lastName);
		elementUtil.doSendKeys(emailText, email);
		elementUtil.doSendKeys(telephoneText, telephone);
		elementUtil.doSendKeys(passwordText, password);
		elementUtil.doSendKeys(passwordConfirmText, password);
		if(subscribe.equalsIgnoreCase("yes")) {
		elementUtil.doClick(subscribeYesButton);
		}
		else
		{
			elementUtil.doClick(subscribeNoButton);
		}
		
		elementUtil.doClick(privacyPolicyCheck);
		
		elementUtil.doClick(continueButton);
		
		String successText=elementUtil.doGetText(successMsg);
		if(successText.contains("Your Account Has Been Created!")) {
			
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			
			return true;
		}
		else {
			return false;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
