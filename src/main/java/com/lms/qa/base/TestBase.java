package com.lms.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.lms.qa.util.TestUtil;
import com.lms.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop; 
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("/Users/jaiv/Desktop/Selenium_WorkSpace/MavenTest/src/main/java/com/lms/qa/config/config.properties");
			prop.load(f);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/jaiv/Desktop/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/jaiv/Desktop/SeleniumJars/chromedriver");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "/Users/jaiv/Desktop/SeleniumJars/safaridriver");
			driver = new SafariDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		/* Create Obj of eventListenerHandler tto register with EventFiringWebdriver */
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
}
