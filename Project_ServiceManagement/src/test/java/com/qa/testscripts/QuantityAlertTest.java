package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.QuantityAlerts;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class QuantityAlertTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	QuantityAlerts qalert;
	
	@Test
	public void checkNoOfData() throws IOException {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		homepage.clickonQuantityAlerts();
		homepage.clickonQuantityAlertsNumber();
		qalert=new QuantityAlerts(driver);
		qalert.noOfData();
	}
}
