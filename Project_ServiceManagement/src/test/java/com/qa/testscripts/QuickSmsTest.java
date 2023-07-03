package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.QuickSmsPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class QuickSmsTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	QuickSmsPage qsms;
	
	public void verifyUserIsAbleToSendQuickSms() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		qsms=new QuickSmsPage(driver);
		qsms.enterPhoneNum();
		qsms.enterMessage();
		qsms.clickSubmit();
		boolean smsHead=qsms.isHeadPresent();
		Assert.assertTrue(smsHead);
	}
}
