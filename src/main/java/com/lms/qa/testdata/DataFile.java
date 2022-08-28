package com.lms.qa.testdata;

import com.lms.qa.util.Xls_Reader;

public class DataFile {
	Xls_Reader d = new Xls_Reader("/Users/jaiv/Desktop/Selenium_WorkSpace/MavenTest/src/main/java/com/lms/qa/testdata/NikulTest.xlsx");
	
	
	public String specialCharEmail = d.getCellData("Data1", "UserName", 4);
	public String wrongPass = d.getCellData("Data1", "Password", 2);
	public String expectedErrForSpecialChar = d.getCellData("Data1", "Email Error", 5);
	public String expectedErrForEmptyEmail =  d.getCellData("Data1", "Email Error", 4);
	public String expectedErrForEmptyPass = d.getCellData("Data1", "Password Error", 3);
	public String wrongEmail = d.getCellData("Data1", "UserName", 3);
	public String expectedErrWithWrongEmailPass = d.getCellData("Data1", "Global Error", 2);
	
	
   
}
