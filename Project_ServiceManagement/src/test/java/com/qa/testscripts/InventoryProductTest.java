package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.InventoryProductsPage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class InventoryProductTest extends Base {
	InventoryProductsPage inventory;
	LoginPage loginpage;
	@Test
	public void deleteInventoryProducts() throws IOException {
		loginpage=new LoginPage(driver);
		inventory=new InventoryProductsPage(driver);
		loginpage.enterUserName(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.enterPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		loginpage.clickSubmit();
		int expectedCountAfterDelete=inventory.getExpectedInventoryCount();
		inventory.clickMoreInfo();
		inventory.getData(ExcelUtility.getString(5, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, 
				"testSheet"), ExcelUtility.getNumeric(5,1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet"));
		inventory.clickOnDelete();
		inventory.clickOnConfirmation();
		String countAfterDeletion=inventory.getInventoryCount();
		//int count=inventory.getAfterDeletionCount();
		//String actualCount=String.valueOf(count);
		Assert.assertEquals(countAfterDeletion, expectedCountAfterDelete,"Test Failed");
	}
}
