package com.lms.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lms.qa.base.TestBase;

public class SmallBusinessPage extends TestBase {
	
	
	@FindBy(xpath = "//ul[@class='cv-nav nav--lg nav--desktop']/li")
	public List<WebElement> listOfElements;
	
	public SmallBusinessPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public String validateBusinessPageTitle() {
		return driver.getTitle();
	}
	
	public int validateSizeOfList() {
		return listOfElements.size();
	}
}
