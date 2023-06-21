package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class AddClient {
public WebDriver driver;
	
	public AddClient (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='name1']") WebElement cname;
	@FindBy(xpath="//input[@id='company1']") WebElement compname;
	@FindBy(xpath="//input[@id='autocomplete']") WebElement location;
	@FindBy(xpath="//input[@id='route']") WebElement address;
	@FindBy(xpath="//input[@id='locality']") WebElement city;
	@FindBy(xpath="//input[@id='postal_code']") WebElement pincode;
	@FindBy(xpath="//input[@id='telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='email1']") WebElement email;
	@FindBy(xpath="//input[@id='vat1']") WebElement vatno;
	@FindBy(xpath="//input[@id='cf1']") WebElement ssnno;
	@FindBy(xpath="//input[@id='image']") WebElement file;
	@FindBy(xpath="//textarea[@id='comment1']") WebElement comment;
	@FindBy(xpath="//button[@id='submit']")WebElement button;
	@FindBy(xpath="//li[text()='This value is required.']")WebElement warning;
	
	public void addData() throws IOException {
		String clientname=ExcelUtility.getString(1, 9, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String companyname=ExcelUtility.getString(1, 10, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String locate=ExcelUtility.getString(1, 11, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String adrs=ExcelUtility.getString(1, 12, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String City=ExcelUtility.getString(1, 13, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String pcode=ExcelUtility.getString(1, 14, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String phone=ExcelUtility.getString(1, 15, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String Email=ExcelUtility.getString(1, 16, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String vatNo=ExcelUtility.getString(1, 17, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String SSNo=ExcelUtility.getString(1, 18, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String cmnt=ExcelUtility.getString(1, 19, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		PageUtility.enterText(cname, clientname);
		PageUtility.enterText(compname, companyname);
		PageUtility.enterText(location, locate);
		PageUtility.enterText(address, adrs);
		PageUtility.enterText(city, City);
		PageUtility.enterText(pincode, pcode);
		PageUtility.enterText(telephone, phone);
		PageUtility.enterText(email, Email);
		PageUtility.enterText(vatno, vatNo);
		PageUtility.enterText(ssnno, SSNo);
		PageUtility.enterText(button, "D:\\code.jpg");
		PageUtility.enterText(comment, cmnt);
		PageUtility.clickOnElement(button);
	}
	
	public void addDataWithoutClientName() throws IOException {
		String companyname=ExcelUtility.getString(1, 10, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String locate=ExcelUtility.getString(1, 11, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String adrs=ExcelUtility.getString(1, 12, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String City=ExcelUtility.getString(1, 13, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String pcode=ExcelUtility.getString(1, 14, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String phone=ExcelUtility.getString(1, 15, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String Email=ExcelUtility.getString(1, 16, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String vatNo=ExcelUtility.getString(1, 17, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String SSNo=ExcelUtility.getString(1, 18, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String cmnt=ExcelUtility.getString(1, 19, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		PageUtility.enterText(compname, companyname);
		PageUtility.enterText(location, locate);
		PageUtility.enterText(address, adrs);
		PageUtility.enterText(city, City);
		PageUtility.enterText(pincode, pcode);
		PageUtility.enterText(telephone, phone);
		PageUtility.enterText(email, Email);
		PageUtility.enterText(vatno, vatNo);
		PageUtility.enterText(ssnno, SSNo);
		PageUtility.enterText(button, "D:\\code.jpg");
		PageUtility.enterText(comment, cmnt);
		PageUtility.clickOnElement(button);
		String expectedMessage=ExcelUtility.getString(1, 20, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		String actualMessage=PageUtility.getElementText(warning);
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
		
	}
}
