package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SendSms;
import com.qa.servicemanagementproject.Base;

public class SendSmsTest extends Base {
	SendSms sendmsg;
	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void sendingSms() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage=new HomePage(driver);
		homepage.verifyNavigatetoSendSms();
		sendmsg=new SendSms(driver);
		sendmsg.sendMessage();
	}

}
