package com.lms.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lms.qa.base.TestBase;
import com.lms.qa.pages.HomePage;
import com.lms.qa.pages.LoginPage;
import com.lms.qa.pages.SmallBusinessPage;

public class BusinessPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage; 
	SmallBusinessPage businessPage;
	
	
	public BusinessPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		businessPage = new SmallBusinessPage();
		homePage = loginPage.homePage();
		homePage.clickOnSmallBusinessLink();
		
	}
	
	@Test(priority = 1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyBusinessPageTitleTest() {
		String title = businessPage.validateBusinessPageTitle();
		Assert.assertEquals(title, "Small Business Banking Services | Scotiabank Canada", "Business Title Doesn't match.");
	}
	
	@Test(priority = 2)
	public void validateSizeOfList() {
		int actual = businessPage.validateSizeOfList();
		Assert.assertEquals(actual, 4, "size of list Doesn't match.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
