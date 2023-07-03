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

public class QuickSmsPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public QuickSmsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(id="phone_number")WebElement number;
	@FindBy(id="fastsms")WebElement sms;
	@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[2]")WebElement button;
	@FindBy(xpath="//h3[text()='Quick SMS']")WebElement head;
	
	public void enterPhoneNum() {
	String phone=FakerUtility.phoneNum();
	page.enterText(number, phone);
	}
	public void enterMessage() throws IOException {
	String Message=ExcelUtility.getString(1, 21, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
	page.enterText(sms, Message);
	}
	public void clickSubmit() {
		page.clickOnElement(button);
	}
	public String checkhead() {
		WaitsUtility.waitForElement(driver, head);
		return page.getElementText(head);
	}
	public boolean isHeadPresent() {
		return head.isDisplayed();
	}
	
}
