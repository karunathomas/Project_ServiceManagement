package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitsUtility;

public class QuantityAlerts {
public WebDriver driver;
PageUtility page=new PageUtility();
	
	public QuantityAlerts(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//h1[text()='Quantity Alerts']")WebElement QMsg;
	@FindBy(xpath="//table[@id='dynamic-table']")WebElement table;
	@FindBy(id="dynamic-table_info")WebElement text;
	
	public void noOfData() {
		String data=page.getElementText(text);
		String count=data.substring(data.indexOf("f")+2,data.indexOf("e")-1);
		System.out.println(count.replaceAll(",",""));
	System.out.println("No: of entries:"+count);
	}
	public String getHead() {
		return page.getElementText(QMsg);
	}

	
	
}
