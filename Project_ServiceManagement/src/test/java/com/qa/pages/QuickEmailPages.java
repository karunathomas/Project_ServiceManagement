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

public class QuickEmailPages {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public QuickEmailPages(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='emailto_']")WebElement recepient;
	@FindBy(xpath="//input[@id='subject_']")WebElement subjectemail;
	@FindBy(xpath="//textarea[@id='body_']")WebElement body;
	@FindBy(xpath="//h3[text()='Quick Email']")WebElement qemailtext;
	
	public void enterEmail() {
		WaitsUtility.waitForElement(driver, recepient);
		String mail=FakerUtility.fakeValuesServiceEmail();
		page.enterText(recepient, mail);
	}
	public void enterSubject() throws IOException {
		String subject=ExcelUtility.getString(1, 22, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(subjectemail, subject);
	}
	public void enterMessage() throws IOException {
		String emailBody=ExcelUtility.getString(1, 23, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(body, emailBody);
	}
	public String getHead() {
		return page.getElementText(qemailtext);
	}
}
