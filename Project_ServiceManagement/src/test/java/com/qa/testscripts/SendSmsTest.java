package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SendSms;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class SendSmsTest extends Base {
	SendSms sendmsg;
	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void sendingSms() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnSendSms();
		sendmsg=new SendSms(driver);
		sendmsg.verifyUserIsAbleToSelectRecepientName();
		sendmsg.verifyUserIsAbleToEnterMessage();
		sendmsg.clickOnSubmit();
		sendmsg.clickOnClose();
	}

}
