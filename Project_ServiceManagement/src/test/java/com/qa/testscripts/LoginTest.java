package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;

public class LoginTest extends Base{
	LoginPage loginpage;
	
	@Test
	public void login() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
	}
	@Test
	public void checkLogout() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		loginpage.logOut();
	}

}
