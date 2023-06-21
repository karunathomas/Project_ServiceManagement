package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class SendSms {
public WebDriver driver;
	
	public SendSms(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//select[@name='client_id']")WebElement dropDown;
	@FindBy(xpath="(//textarea[@id='fastsms'])[3]")WebElement Msg;
	@FindBy(xpath="//button[@value='Submit']")WebElement submit;
	@FindBy(xpath="(//button[text()='Close'])[1]")WebElement close;
	
	public void sendMessage() throws IOException {
		Select selectObj=new Select(dropDown);
		selectObj.selectByIndex(2);
		String Message=ExcelUtility.getString(1, 21, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		PageUtility.enterText(Msg, Message);
		PageUtility.clickOnElement(submit);
		PageUtility.clickOnElement(close);
	}
}
