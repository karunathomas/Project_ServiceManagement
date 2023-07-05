package com.qa.testscripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
public class HomePageTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	@Test(groups="Sanity")
	public void verifyNavigateToAddClient() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnAddClient();
		String expectedMessage=ExcelUtility.getString(1, 4, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=homepage.addClientMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}
	@Test(groups="Regression")
	public void verifyNavigateToAddReparation() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnReparation();
		String expectedMessage=ExcelUtility.getString(1, 5, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=homepage.addReperationMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");

	}
	@Test(groups="Sanity")
	public void verifyNavigateToSendSms() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnSendSms();
		String expectedMessage=ExcelUtility.getString(1, 6, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=homepage.sendSmsMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}
	@Test(groups="Regression")
	public void verifyNavigateToSendEmail() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnSendEmail();
		String expectedMessage=ExcelUtility.getString(1, 7, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=homepage.sendEmailMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
		
	}
	@Test(groups="Sanity")
	public void verifyNavigateToQuantityAlerts() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickonQuantityAlerts();
		homepage.clickonQuantityAlertsNumber();
		String expectedMessage=ExcelUtility.getString(1, 8, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=homepage.quantityAlertMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}
}
