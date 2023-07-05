package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.FakerUtility;
import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitsUtility;

public class SendSms {
public WebDriver driver;
PageUtility page;
	
	public SendSms(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//h5[text()='Send SMS']")WebElement sendSMSMsg;
	@FindBy(xpath="//select[@name='client_id']")WebElement dropDown;
	@FindBy(xpath="(//textarea[@id='fastsms'])[3]")WebElement Msg;
	@FindBy(xpath="//button[@value='Submit']")WebElement submit;
	@FindBy(xpath="(//button[text()='Close'])[1]")WebElement close;
	
	
	public void verifyUserIsAbleToSelectRecepientName() {
		page.selectDropdownbyText(dropDown, "Kiran");
	}
	
	public void verifyUserIsAbleToEnterMessage() throws IOException {
		String Message=ExcelUtility.getString(1, 21, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(Msg, Message);
	}
	public void clickOnSubmit() {
		page.clickOnElement(submit);
	}
	public void clickOnClose() {
		page.clickOnElement(close);
	}
	
}
