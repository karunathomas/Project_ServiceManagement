package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.ForgotPassword;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;

public class ForgotPassWordTest extends Base{
	LoginPage loginpage;
	ForgotPassword pass;
	@Test
	public void verifyUserIsAbleToChangePassword() throws IOException {
		//loginpage=new LoginPage(driver);
		pass=new ForgotPassword(driver);
		
		pass.clickForgotPassword();
		pass.enterEmail();
		pass.clickSubmit();
	}
	
}
