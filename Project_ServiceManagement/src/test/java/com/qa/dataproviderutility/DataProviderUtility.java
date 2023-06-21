package com.qa.dataproviderutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="getDataFromDataProvider") 
	public Object[][] getDataFromDataProvider() {
		return new Object[][] {{"test123"},{"test2"},{"test3"}};
	}

}
