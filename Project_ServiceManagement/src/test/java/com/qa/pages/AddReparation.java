package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitsUtility;

public class AddReparation {
	public WebDriver driver;
	PageUtility page = new PageUtility();

	public AddReparation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h4[text()='Add Reparation']")WebElement addRepMsg;
	@FindBy(xpath = "//input[@id='imei']")
	WebElement imeino;
	@FindBy(xpath = "(//span[@class='select2-selection__placeholder'])[1]")
	WebElement click;
	@FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
	WebElement clienttextbox;
	@FindBy(xpath = "//ul[@id='select2-client_name-results']")
	WebElement clientselect;
	@FindBy(xpath = "//li[@id='select2-client_name-result-50yr-74']")
	WebElement client;
	@FindBy(xpath = "//span[@id='select2-assigned_to-container']")
	WebElement asigneeclick;
	@FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
	WebElement asigneetextbox;
	@FindBy(xpath = "//ul[@id='select2-assigned_to-results']")
	WebElement selectasignee;
	@FindBy(xpath = "//li[@id='select2-assigned_to-result-eeiu-1']")
	WebElement asignee;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//span[@id='select2-potax2-container']")
	WebElement taxrate;
	@FindBy(xpath = "(//span[text()='Please Select' and @class='select2-selection__placeholder'])[2]")
	WebElement assignedto;
	@FindBy(xpath = "//input[@id='reparation_manufacturer']")
	WebElement manufacturer;
	@FindBy(xpath = "//input[@id='reparation_model']")
	WebElement model;
	@FindBy(xpath = "//input[@id='add_item']")
	WebElement addItem;
	@FindBy(xpath = "//input[@id='defect']")
	WebElement defect;
	@FindBy(xpath = "//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']")
	WebElement errorcode;
	@FindBy(xpath = "//input[@id='service_charges']")
	WebElement servicecharge;
	@FindBy(xpath = "//input[@id='expected_close_date']")
	WebElement closedate;
	@FindBy(xpath = "//input[@id='date_of_purchase']")
	WebElement datepurchase;
	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[4]")
	WebElement warranty;
	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[5]")
	WebElement warrantymonth;
	@FindBy(xpath = "(//input[@id='warranty_card_number']")
	WebElement warrantynumber;
	@FindBy(xpath = "//input[@id='repair_type']")
	WebElement repairtype;
	@FindBy(xpath = "//input[@id='client_date']")
	WebElement clntdate;
	@FindBy(xpath = "//textarea[@id='accessories']")
	WebElement accessories;
	@FindBy(xpath = "//textarea[@id='comment']")
	WebElement comment;
	@FindBy(xpath = "//textarea[@id='diagnostics']")
	WebElement dgn;
	@FindBy(xpath = "//span[@id='select2-status_edit-container']")
	WebElement status;
	@FindBy(xpath = "//input[@id='code']")
	WebElement code;
	@FindBy(xpath = "//button[@id='upload_modal_btn']")
	WebElement buttonupload;
	@FindBy(xpath = "//input[@id='repair_sms']")
	WebElement repairsms;
	@FindBy(xpath = "//input[@id='repair_email']")
	WebElement repairmail;
	@FindBy(xpath = "//button[@id='sign_repair']")
	WebElement sgnrepair;
	@FindBy(xpath = "//button[@id='repair_submit']")
	WebElement repairsubmit;

	public void enterImei() throws IOException {
		WaitsUtility.waitForElement(driver, imeino);
		String Imei = ExcelUtility.getString(1, 25, System.getProperty("user.dir") + constants.Constance.TESTDATAFILE,
				"testSheet");
		page.enterText(imeino, Imei);
	}

	public void selectClient() {
		page.clickOnElement(click);
		page.enterText(clienttextbox, "Name1 abcd - ");
		page.clickOnElement(clientselect);
		// page.clickOnElement(client);
	}

	public void selectAsignee() {
		page.clickOnElement(asigneeclick);
		page.enterText(asigneetextbox, "Joe Jacobs");
		page.clickOnElement(selectasignee);
		// page.selectDropdownbyText(assignedto, "Joe Jacobs");
	}

	public void enterManufacturer() throws IOException {
		String manufact = ExcelUtility.getString(1, 26,
				System.getProperty("user.dir") + constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(manufacturer, manufact);
	}

	public void enterServiceCharge() throws IOException {
		String charge = ExcelUtility.getNumeric(1, 27,
				System.getProperty("user.dir") + constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(servicecharge, charge);
	}

	public void enterModel() throws IOException {
		String modelName = ExcelUtility.getString(1, 28,
				System.getProperty("user.dir") + constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(model, modelName);
	}

	public void enterDefect() throws IOException {
		String defectname = ExcelUtility.getString(1, 29,
				System.getProperty("user.dir") + constants.Constance.TESTDATAFILE, "testSheet");
		page.enterText(defect, defectname);
	}

	public void clickAddReperationButton() {
		page.clickOnElement(repairsubmit);
	}
	public String getAddReperationHead() {
		return page.getElementText(addRepMsg);
	}
//	public void fileUpload(WebDriver driver, WebElement element, String location) throws AWTException {
//		Robot obj = new Robot();
//		Actions obj1 = new Actions(driver);
//		obj1.moveToElement(element).click().perform();
//		StringSelection ss = new StringSelection(location);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		obj.delay(500);
//		obj.keyPress(KeyEvent.VK_CONTROL);
//		obj.keyPress(KeyEvent.VK_V);
//		obj.delay(500);
//		obj.keyRelease(KeyEvent.VK_CONTROL);
//		obj.keyRelease(KeyEvent.VK_V);
//		obj.delay(500);
//		obj.keyPress(KeyEvent.VK_ENTER);
//		obj.keyRelease(KeyEvent.VK_ENTER);
//		obj.delay(500);
//	}
}
