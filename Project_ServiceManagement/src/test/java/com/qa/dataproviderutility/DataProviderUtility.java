package com.qa.dataproviderutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="getDataFromDataProvider") 
	public Object[][] getDataFromDataProvider() {
		return new Object[][] {{"admin@admin.com","password"}};
	}

}
