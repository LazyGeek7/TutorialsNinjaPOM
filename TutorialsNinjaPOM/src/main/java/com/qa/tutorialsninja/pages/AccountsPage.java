package com.qa.tutorialsninja.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.base.BasePage;

public class AccountsPage extends BasePage {
	
	private WebDriver driver;
	
	private By YourStoreLink=By.linkText("Your Store");
	
	private By headersList=By.xpath("//div[@id='content']//h2");
	
	private By searchTextArea=By.id("search");
	
	private By searchButton=By.xpath("//span//button[@type='button']");
	
	private By productThumb =By.xpath("//div[@class='product-thumb']");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean doVerifyYourStoreLink() {
		if(driver.findElement(YourStoreLink).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public List<String> doVerifyHeaderList() {
		List<WebElement> list=driver.findElements(headersList);
		List<String> SList=new ArrayList<>();
		for(WebElement e:list) {
		String text=e.getText();
		SList.add(text);
		
		
		}
		return SList;

		
	
	}
	
	
	public boolean productSearch(String productName) {
		
		driver.findElement(searchTextArea).sendKeys(productName);
		driver.findElement(searchButton).click();
		if(driver.findElements(productThumb).size()>0) {
			return true;
		}
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	


