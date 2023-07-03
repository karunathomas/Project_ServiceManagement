package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.FakerUtility;
import com.qa.utilities.PageUtility;

public class ForgotPassword {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	@FindBy(xpath="(//input[@class='form-control'])[1]")WebElement email;
	@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")WebElement submit;
	@FindBy(xpath="//a[text()=' ← Back to login!']")WebElement backlogin;
	@FindBy(xpath="//a[text()='Forgot your password?']")WebElement forgotlink;
	@FindBy(xpath="//p[text()='The Email Address field must contain a valid email address.']")WebElement mailMsg;
	
	public void enterEmail() throws IOException {
		String mail=ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(email, mail);
	}
	public void clickForgotPassword() {
		page.clickOnElement(forgotlink);
	}
	public void clickSubmit() {
		page.clickOnElement(submit);
	}
}
