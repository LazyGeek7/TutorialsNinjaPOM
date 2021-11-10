package com.qa.tutorialsninja.utils;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.tutorialsninja.base.BasePage;

public class ElementUtil{

	private WebDriver driver;
	private JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver){
		this.driver=driver;
		jsUtil=new JavaScriptUtil(this.driver); 
		
	}
	
	
	
	
	
	
	
	
	//******************************************************************************************
	
	public WebElement getElement(By locator){
		
		WebElement element=null;
		try {
			element=driver.findElement(locator);
			if(BasePage.highlight.equals("true")) {
				System.out.println(BasePage.highlight);
				jsUtil.flash(element);
			
			//jsUtil.flash(element);
			}
		}
		catch(Exception e) {
			System.out.println("Some exception occurred");
			System.out.println(e.getMessage());
		}
		return element;
		
	}
	
	//************************************************************************************
	
	public String doGetText(By locator) {
		try {
		return getElement(locator).getText();}
		catch(Exception e) {
			System.out.println("Some exception occurred");
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	//******************************************************************************************
	
	public void doSendKeys(By locator,String value) {
		try {
		getElement(locator).sendKeys(value);}
		catch(Exception e) {
			System.out.println("Some Excpetion occurred while doing sendkeys");
			System.out.println(e.getMessage());
		}
		
	}
	
	//********************************************************************************************
	
	public void doClick(By locator) {
		try {
		getElement(locator).click();}
		catch(Exception e) {
			System.out.println("Exception occurred while doing click operation");
			System.out.println(e.getMessage());		}
	}
	
	//*******************************************************************************************
	
	public void doExplicitWait(By locator,int timeinSeconds) {
		WebDriverWait wait=new WebDriverWait( driver, timeinSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//**********************************************************************************************
	
	public void doExplicitWaitTitle(int timeout,String title) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleContains(title));
	}
	//********************************************************************************************
	public void dropdownSelect(List<WebElement> dropdownlist, String Value ) {
		for(int i=0;i<dropdownlist.size();i++) {
			String text=dropdownlist.get(i).getText();
			//System.out.println(text);
			
			if(text.equals(Value)) {
				dropdownlist.get(i).click();
				break;
			}
		}
	}
	
	//**************************************************************************************************
	public void dropdownMultiSelect(List<WebElement> dropdownlist, String... Value ) {
		if(Value[0].equalsIgnoreCase("All")) {
			try {
			for(int all=0;all<dropdownlist.size();all++) {
				dropdownlist.get(all).click();
			}}
			catch(Exception e) {
				System.out.println("Some exception");
			}
		}
		else {
		for(int i=0;i<dropdownlist.size();i++) {
			String text=dropdownlist.get(i).getText();
			
			for(int k=0;k<Value.length;k++) {
				if(text.equals(Value[k])) {
					dropdownlist.get(i).click();
					
				}
				
			}
			
			
			
		}
		} 
	}
	//*************************************************************************************************
	
	public void actionClick(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.click(ele).build().perform();
		
	}
	
	
	
	
	
	
	
	
	
	

}
