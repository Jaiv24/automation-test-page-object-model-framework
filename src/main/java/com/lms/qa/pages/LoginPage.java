package com.lms.qa.pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lms.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	// Page Factory | OR(Object Repository)
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
	@CacheLookup
    public WebElement globalError;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
	@CacheLookup
    public WebElement emailError;
	
	@FindBy(id = "PasswordTextField__errors-password")
	@CacheLookup
    public WebElement passwordError;
	
	@FindBy(xpath = "//div[@class='_1B64ZrEq6BvPwNqtqnNEiC']" )
	public WebElement scotiaHomePage;
	
	
	//Initializing oage objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void login(String username, String pass) throws InterruptedException {
		email.sendKeys(username);
		password.sendKeys(pass);
		signInButton.click();

	}
	
	public String readEmailErr() {
		String actualErr = emailError.getText();
		return actualErr;
	}
	
	public String readPasswordErr() {
		String actualErr = passwordError.getText();
		return actualErr;
	}
	
	public String readGlobalErr() {
		String actualErr = globalError.getText();
		return actualErr;
	}
	
	public void closeBrowser() {
		  driver.quit();
	}
	
	public HomePage homePage() {
		scotiaHomePage.click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		
		Iterator<String> iteratorOfSet = allWindows.iterator();
		
		String mainWindow  = iteratorOfSet.next();
		String childWindow = iteratorOfSet.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
//		driver.close();
//		
//		
//		driver.switchTo().window(mainWindow);
//		Thread.sleep(2000);
//		System.out.println(driver.getTitle());
//		driver.quit();
		return new HomePage();
	}
}
