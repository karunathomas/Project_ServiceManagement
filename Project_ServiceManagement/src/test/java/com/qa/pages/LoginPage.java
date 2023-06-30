package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitsUtility;

public class LoginPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='identity']")WebElement userName;
	@FindBy(xpath="//input[@name='password']")WebElement passWord;
	@FindBy(xpath="//input[@name='submit']")WebElement button;
	@FindBy(name="remember")WebElement remeberMeCheckBox;
	@FindBy(linkText="Forgot your password?")WebElement forgotPasswordLink;
	@FindBy(linkText="Back to home page")WebElement backToHomePageLink;
	@FindBy(xpath="//p[text()='Logged In Successfully']")WebElement alertMessage;
	@FindBy(xpath="(//span[text()='Joe Jacobs'])[1]")WebElement name;
	@FindBy(xpath="//a[text()='Sign out']")WebElement signOut;
	@FindBy(xpath="//p[text()='Logged Out Successfully']")WebElement logoutMsg;
	
	public void enterUserName(String username) {
		page.enterText(userName, username);
	}
	public void enterPassword(String password) {
		page.enterText(passWord, password);
	}
	public void clickSubmit() {
		page.clickOnElement(button);
	}
	public String getAlertMessage() {
		return page.getElementText(alertMessage);
	}
	public void clickUserName() {
		page.clickOnElement(name);
	}
	public void logOut() {
		page.clickOnElement(signOut);
	}
	public String getLogoutMessage() {
		WaitsUtility.waitForElement(driver, logoutMsg);
		return page.getElementText(logoutMsg);
	}
//	public void validLogin() throws IOException {
//		String username=ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		String password=ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		String expectedMessage=ExcelUtility.getString(1, 2, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		PageUtility.enterText(userName, username);
//		PageUtility.enterText(passWord, password);
//		PageUtility.isElementDisplayed(button);
//		PageUtility.clickOnElement(button);
//		String actualmessage=PageUtility.getElementText(alertMessage);
//		Assert.assertEquals(actualmessage, expectedMessage, "Login Failed");
//	}
	
//	public void logOut() throws IOException {
//		PageUtility.clickOnElement(name);
//		PageUtility.clickOnElement(signOut);
//		PageUtility.isElementDisplayed(button);
//		String expectedMessage=ExcelUtility.getString(1, 3, System.getProperty("user.dir")+constants.Constance.TESTDATAFILE, "testSheet");
//		String actualMessage=PageUtility.getElementText(logoutMsg);
//		Assert.assertEquals(actualMessage, expectedMessage,"Logout Failed");
//	}

	
}
