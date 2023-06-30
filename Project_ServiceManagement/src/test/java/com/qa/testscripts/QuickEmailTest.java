package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.QuickEmailPages;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class QuickEmailTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	QuickEmailPages qemailpage;
	
	@Test
	public void verifyUserIsAbleToSendQuickEmail() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		qemailpage=new QuickEmailPages(driver);
		qemailpage.enterEmail();
		qemailpage.enterSubject();
		qemailpage.enterMessage();
		String expectedMessage=ExcelUtility.getString(1, 24, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=qemailpage.getHead();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}
}
