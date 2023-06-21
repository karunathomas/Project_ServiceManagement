package com.qa.testscripts;
import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
public class HomePageTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	@Test
	public void addClient() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage.verifyNavigatetoClientPage();
	}
	@Test
	public void addReparation() throws IOException {
		
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage=new HomePage(driver);
		homepage.verifyNavigatetoAddReperation();
	}
	@Test
	public void sendSms() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage.verifyNavigatetoSendSms();
	}
	@Test
	public void sendEmail() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage.verifyNavigatetoSendEmail();
	}
	@Test
	public void quantityAlerts() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.validLogin();
		homepage.verifyNavigatetoQuantityAlert();
	}
}
