package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AddClient;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class AddClientTest extends Base{
	AddClient addclientdata;
	HomePage homepage;
	LoginPage loginpage;
	@Test
	public void verifyUserAbletoAddClientDetails() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnAddClient();
		addclientdata=new AddClient(driver);
		addclientdata.addClientName();
		addclientdata.addCompanyName();
		addclientdata.addLocation();
		addclientdata.addAddress();
		addclientdata.addCity();
		addclientdata.addPincode();
		addclientdata.addPhoneNumber();
		addclientdata.addEmail();
		addclientdata.addVatNo();
		addclientdata.addSsnNo();
		addclientdata.uploadFile();
		addclientdata.addComment();
		addclientdata.clickSubmit();
		
		String expectedMessage=ExcelUtility.getString(1, 4, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=addclientdata.getAddClientTitle();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}
	@Test
	public void addClientDetailsWithoutClientName() throws IOException {
		
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickTheAddIconButton();
		homepage.clickOnAddClient();
		addclientdata=new AddClient(driver);
		addclientdata.addLocation();
		addclientdata.addAddress();
		addclientdata.addCity();
		addclientdata.addPincode();
		addclientdata.addPhoneNumber();
		addclientdata.addEmail();
		addclientdata.addVatNo();
		addclientdata.addSsnNo();
		addclientdata.uploadFile();
		addclientdata.addComment();
		addclientdata.clickSubmit();
		
		String expectedMessage=ExcelUtility.getString(1, 20, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=addclientdata.getWarningMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}
	
}
