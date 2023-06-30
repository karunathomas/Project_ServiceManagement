package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	public WebDriver driver;
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	@FindBy(xpath="(//input[@class='form-control'])[1]")WebElement email;
	@FindBy(xpath="//input[@value='Submit']")WebElement submit;
	@FindBy(xpath="//a[text()=' ← Back to login!']")WebElement backLogin;
}
