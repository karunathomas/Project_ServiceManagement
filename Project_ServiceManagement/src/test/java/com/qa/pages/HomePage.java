package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitsUtility;

public class HomePage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[text()='Logged In Successfully']")WebElement loginMessage;
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")WebElement addIcon;
	@FindBy(xpath="//span[@class='fa fa-user-plus icon']")WebElement addClient;
	@FindBy(xpath="//h4[text()='Add Client']")WebElement message;
	@FindBy(xpath="//span[@class='fa fa-list-alt icon']")WebElement addReperation;
	@FindBy(xpath="//h4[text()='Add Reparation']")WebElement addRepMsg;
	@FindBy(xpath="//span[@class='fa fa-comment icon']")WebElement sendSms;
	@FindBy(xpath="//h5[text()='Send SMS']")WebElement sendSMSMsg;
	@FindBy(xpath="//span[@class='fa fa-paper-plane icon']")WebElement sendEmail;
	@FindBy(xpath="//h5[text()='Send Email']")WebElement sendEmailMsg;
	@FindBy(xpath="//i[@class='fa fa-exclamation-triangle']")WebElement QAlertsIcon;
	@FindBy(xpath="//span[@class='label label-danger pull-right']")WebElement QAlertsIconNum;
	@FindBy(xpath="//h1[text()='Quantity Alerts']")WebElement QMsg;
	@FindBy(xpath="//label[text()='Client Name']")WebElement clientLabel;
	@FindBy(xpath="//label[text()='IMEI']")WebElement label;
	
	public void clickTheAddIconButton() {
		page.clickOnElement(addIcon);
	}
	public void clickOnAddClient() {
		page.clickOnElement(addClient);
	}
	public String addClientMessage() {
		return page.getElementText(message);
	}
	public void clickOnReparation() {
		page.clickOnElement(addReperation);
	}
	public String addReperationMessage(){
		WaitsUtility.waitForElement(driver, addRepMsg);
		return page.getElementText(addRepMsg);
	}
	public void clickOnSendSms() {
		page.clickOnElement(sendSms);
	}
	public String sendSmsMessage(){
		WaitsUtility.waitForElement(driver, sendSMSMsg);
		return page.getElementText(sendSMSMsg);
	}
	public void clickOnSendEmail() {
		page.clickOnElement(sendEmail);
	}
	public String sendEmailMessage(){
		WaitsUtility.waitForElement(driver, sendEmailMsg);
		return page.getElementText(sendEmailMsg);
	}
	public void clickonQuantityAlerts() {
		page.clickOnElement(QAlertsIcon);
	}
	public void clickonQuantityAlertsNumber() {
		page.clickOnElement(QAlertsIconNum);
	}
	public String quantityAlertMessage() {
		WaitsUtility.waitForElement(driver, QMsg);
		return page.getElementText(QMsg);
	}
//	public void verifyNavigatetoClientPage() throws IOException {
//		PageUtility.clickOnElement(addIcon);
//		WaitsUtility.waitForPresenceofElementLocated(driver, By.xpath("//i[@class='fa fa-plus-circle']"));
//		PageUtility.clickOnElement(addClient);
//		//String expectedMessage=ExcelUtility.getString(1, 4, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		//String actualMessage=PageUtility.getElementText(message);
//		//System.out.println(actualMessage);
//		PageUtility.isElementDisplayed(clientLabel);
//		//Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
//	}
//	public void verifyNavigatetoAddReperation() throws IOException {
//		PageUtility.clickOnElement(addIcon);
//		WaitsUtility.waitForPresenceofElementLocated(driver, By.xpath("//span[@class='fa fa-list-alt icon']"));
//		PageUtility.clickOnElement(addReperation);
//		//String expectedMessage=ExcelUtility.getString(1, 5, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		//String actualMessage=PageUtility.getElementText(addRepMsg);
//		//System.out.println(actualMessage);
//		PageUtility.isElementDisplayed(label);
//		//Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
//	}
//	public void verifyNavigatetoSendSms() throws IOException {
//		PageUtility.clickOnElement(addIcon);
//		PageUtility.clickOnElement(sendSms);
//		String expectedMessage=ExcelUtility.getString(1, 6, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		String actualMessage=PageUtility.getElementText(sendSMSMsg);
//		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
//	}
//	public void verifyNavigatetoSendEmail() throws IOException {
//		PageUtility.clickOnElement(addIcon);
//		PageUtility.clickOnElement(sendEmail);
//		String expectedMessage=ExcelUtility.getString(1, 7, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		String actualMessage=PageUtility.getElementText(sendEmailMsg);
//		System.out.println(actualMessage);
//		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
//	}
//	public void verifyNavigatetoQuantityAlert() throws IOException {
//		PageUtility.clickOnElement(QAlertsIcon);
//		PageUtility.clickOnElement(QAlertsIconNum);
//		String expectedMessage=ExcelUtility.getString(1, 8, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		String actualMessage=PageUtility.getElementText(QMsg);
//		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
//	}//boolean actualResult=lp.isUsernameEnabled();
}
