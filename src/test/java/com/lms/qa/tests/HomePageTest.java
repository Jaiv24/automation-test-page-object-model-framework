package com.lms.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lms.qa.base.TestBase;
import com.lms.qa.pages.HomePage;
import com.lms.qa.pages.LoginPage;
import com.lms.qa.pages.SmallBusinessPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage; 
	SmallBusinessPage businessPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.homePage();
		businessPage = new SmallBusinessPage();
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Personal Banking | Scotiabank Canada", "HomePage Title Doesn't match.");
	}
	
	@Test(priority = 2)
	public void clickOnSmallBusinessLink() {
		businessPage = homePage.clickOnSmallBusinessLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
