package com.lms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lms.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath = "//a[contains(text(),'Small Business')]")
	public WebElement smallBusiness;
	
	/*
	 * @FindBy(xpath = "//a[contains(text(),'Commercial')]") public WebElement
	 * commercial;
	 */
	
	@FindBy(xpath = "//a[@class='btn btn-signin btn-primary desktop']")
	@CacheLookup
	public WebElement signInButton;
	
	//Initializing oage objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
		
	// Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
		
	public LoginPage clickOnSignInButton() {
		signInButton.click();
		
		return new LoginPage();
	}
	
	public SmallBusinessPage clickOnSmallBusinessLink() {
		smallBusiness.click();
		return new SmallBusinessPage();
	}
}
