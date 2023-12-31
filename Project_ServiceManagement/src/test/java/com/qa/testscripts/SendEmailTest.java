package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SendEmail;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class SendEmailTest extends Base{
	SendEmail sendmail;
	HomePage homepage;
	LoginPage loginpage;

	@Test
	public void verifyUserIsAbleToSendingEmail() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnSendEmail();
		sendmail=new SendEmail(driver);
		sendmail.selectRecepient();
		sendmail.verifyUserIsAbleToEnterSubject();
		sendmail.verifyUserIsAbleToEnterMessage();
		sendmail.clickOnSubmit();
		//sendmail.clickOnClose();
	}
}
