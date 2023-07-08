package com.qa.dataproviderutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name = "getDataFromDataProvider")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { { "admin@admin.com", "password" } };
	}

	@DataProvider(name = "getInvalidLoginData")
	public Object[][] getInvalidLoginData() {
		return new Object[][] { new Object[] { "admine@admin.com", "password" },
				new Object[] { "admin@admin.com", "passsword" }, new Object[] { "admin1@admin.com", "password1" } };

	}

}
