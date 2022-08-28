package com.lms.qa.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lms.qa.base.TestBase;
import com.lms.qa.pages.HomePage;
import com.lms.qa.pages.LoginPage;
import com.lms.qa.testdata.DataFile;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	DataFile df = new DataFile();
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("launching broswer");
		initialization();
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		log.info("*************** starting test case-1 *************");
		log.info("*************** scotiaBankTitleTest **************");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Sign in | Scotiabank");
		log.info("*************** Ending test case-1 ***************");
		log.info("*************** scotiaBankTitleTest **************");
	}
	
	@Test(priority = 2)
	  public void LoginEmailWithSpecialChar() throws InterruptedException {	  
			loginPage.login(df.specialCharEmail, df.wrongPass);
			String actualErr = loginPage.readEmailErr();
			Assert.assertEquals(actualErr, df.expectedErrForSpecialChar);
		  
	  }
	  
	  @Test(priority = 3)
	  public void LoginWithEmptyEmail() throws InterruptedException {
		  
		  	loginPage.login("", df.wrongPass);
			
			String actualErr = loginPage.readEmailErr();
			Assert.assertEquals(actualErr, df.expectedErrForEmptyEmail);
		  
	  }
	  @Test(priority = 4)
	  public void LoginWithEmptyPassword() throws InterruptedException {
		  
			loginPage.login(df.wrongEmail,"");
			
			String actualErr = loginPage.readPasswordErr();
			Assert.assertEquals(actualErr, df.expectedErrForEmptyPass);
		  
	  }
	  @Test(priority = 5, groups = "smoke")
	  public void clickOnScotiaLogo() throws InterruptedException {
		  
		  homePage = loginPage.homePage();
			
		  
	  }
	  
	  //@Test(priority = 6)
	  public void LoginWithWrongEmailPassword() throws InterruptedException {
		  	
		  loginPage.login(df.wrongEmail, df.wrongPass);
			String actualErr = loginPage.readGlobalErr();
			Assert.assertEquals(actualErr, df.expectedErrWithWrongEmailPass);
		  
	  }
	
	
	@AfterMethod
	public void tearDown() {
		loginPage.closeBrowser();
	}
	
	
	  
}
