package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.AddClient;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;

public class AddClientTest extends Base{
	AddClient addclientdata;
	HomePage homepage;
	LoginPage loginpage;
	@Test
	public void addClientDetails() throws IOException {
		
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage=new HomePage(driver);
		homepage.verifyNavigatetoClientPage();
		addclientdata=new AddClient(driver);
		addclientdata.addData();
	}
	@Test
	public void addClientDetailsWithoutClientName() throws IOException {
		
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage=new HomePage(driver);
		homepage.verifyNavigatetoClientPage();
		addclientdata=new AddClient(driver);
		addclientdata.addDataWithoutClientName();
	}
	
}
