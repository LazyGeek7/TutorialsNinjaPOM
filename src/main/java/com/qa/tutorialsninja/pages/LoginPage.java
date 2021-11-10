package com.qa.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By emailId= By.id("input-email");
	private By password=By.id("input-password");
	private By login=By.xpath("*//input[@value='Login']");
	private By forgottenpasswordlink=By.linkText("Forgotten Password");
	private By registerLink=By.linkText("Register");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		 elementUtil=new ElementUtil(this.driver);
	}
	
	@Step("doGetLoginPageTitle")
	public String doGetLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	@Step("isForgottenPasswordLinkExist")
	public boolean isForgottenPasswordLinkExist() {
		return elementUtil.getElement(forgottenpasswordlink).isDisplayed();
		//return driver.findElement(forgottenpasswordlink).isDisplayed();
	}
	
	@Step("Login with username:{0} and password:{1}")
	public AccountsPage doLogin(String un,String pwd) {
		System.out.println("Login with :"+un+"--and--"+pwd);
		elementUtil.doSendKeys(emailId, un);
		//driver.findElement(emailId).sendKeys(un);
		elementUtil.doSendKeys(password, pwd);
		//driver.findElement(password).sendKeys(pwd);
		elementUtil.doClick(login);
		//driver.findElement(login).click();
		return new AccountsPage(driver);
	}
	
	@Step("clickRegisterLink")
	public RegistrationPage clickRegisterLink() {
		 elementUtil.doClick(registerLink);
		 return new RegistrationPage(driver);
	}
	
	
	
	
	
	
	
	

}
