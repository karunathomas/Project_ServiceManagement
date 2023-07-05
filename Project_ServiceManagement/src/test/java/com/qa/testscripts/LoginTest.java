package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dataproviderutility.DataProviderUtility;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class LoginTest extends Base{
	LoginPage loginpage;
	
	
	@Test(dataProvider="getDataFromDataProvider", dataProviderClass=DataProviderUtility.class)
	public void verifyLoginCredentials(String uName, String pw) throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(uName);
		loginpage.enterPassword(pw);
		loginpage.clickSubmit();
		String expectedMessage=ExcelUtility.getString(1, 2, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=loginpage.getAlertMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Login Failed");
	}
	@Test
	public void verifyUserisAbletoLogout() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		loginpage.clickUserName();
		loginpage.logOut();
		String expectedMessage=ExcelUtility.getString(1, 3, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=loginpage.getLogoutMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Logout Failed");
	
	}
//	public void login() throws IOException {
//		loginpage=new LoginPage(driver);
//		loginpage.validLogin();
//	}
//	@Test
//	public void checkLogout() throws IOException {
//		loginpage=new LoginPage(driver);
//		loginpage.validLogin();
//		loginpage.logOut();
//	}

}
