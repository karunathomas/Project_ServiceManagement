package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class SendEmail {
public WebDriver driver;
PageUtility page;
	
	public SendEmail(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	//@FindBy(xpath="//select[@id='client_id_sms']")WebElement clientId;
	@FindBy(xpath="(//option[@value='119'])[3]")WebElement recepient;
	//@FindBy(xpath="//option[text()='kiran1']")WebElement clientName;
	@FindBy(xpath="//input[@id='subject']")WebElement emailSubject;
	@FindBy(xpath="//textarea[@id='sms_body']")WebElement emailMsg;
	@FindBy(xpath="(//button[text()='Send'])[2]")WebElement submitEmail;
	//@FindBy(xpath="(//button[@class='btn btn-secondary'])[2])")WebElement close;
	
	public void selectRecepient() {
		page.clickOnElement(recepient);
	}
	public void verifyUserIsAbleToEnterSubject() throws IOException {
		String subject=ExcelUtility.getString(1, 22, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(emailSubject, subject);
	}
	public void verifyUserIsAbleToEnterMessage() throws IOException {
		String mail=ExcelUtility.getString(1, 23, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(emailMsg, mail);
	}
	public void clickOnSubmit() {
		page.clickOnElement(submitEmail);
	}
//	public void clickOnClose() {
//		page.clickOnElement(close);
//	}
	
//	public void sendEmails() throws IOException {
//		Select selectObj=new Select(clientId);
//		selectObj.selectByVisibleText("kiran1");
//		String subject=ExcelUtility.getString(1, 22, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		PageUtility.enterText(emailSubject, subject);
//		String mail=ExcelUtility.getString(1, 23, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		PageUtility.enterText(emailMsg, mail);
//		PageUtility.clickOnElement(submitEmail);
//	}
}
