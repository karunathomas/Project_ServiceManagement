package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitsUtility;

public class InventoryProductsPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
		
		public InventoryProductsPage (WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(xpath="(//a[text()='More Info '])[3]")WebElement moreInfo;
		@FindBy(xpath="//input[@class='form-control input-sm input-xs']")WebElement searchBox;
		@FindBy(xpath="//span[text()='Delete']")WebElement delete;
		@FindBy(xpath="//a[@class='btn btn-danger']")WebElement confirm;
		@FindBy(xpath="//tr[@class='product_link']")List<WebElement> rowNo;
		@FindBy(xpath="//p[text()='Inventory Products']//preceding-sibling::h3") WebElement inventoryCount;
		
		public void clickMoreInfo() {
			page.clickOnElement(moreInfo);
		}
		public void enterTextOnSearchBox(String code) {
			page.enterText(searchBox, code);
		}
		public String getAttribute(String attribute) {
			return attribute;
		}
		public void getData(String attribute, String values) {
			page.selectElementFromListUsingGetAttribute(rowNo, attribute, values);
		}
		public void clickOnDelete() {
			WaitsUtility.waitForElement(driver, delete);
			page.clickOnElement(delete);
			System.out.println("Deleted");
		}
		public void clickOnConfirmation() {
			page.clickOnElement(confirm);
			System.out.println("Item Deleted");
		}
		public String getInventoryCount() {
			return page.getElementText(inventoryCount);
		}
		public int getExpectedInventoryCount() {
			WaitsUtility.waitForElement(driver, inventoryCount);
			String count=page.getElementText(inventoryCount);
			int value=Integer.parseInt(count);
			int expectedcount=value-1;
			return expectedcount;
		}
		public int getAfterDeletionCount() {
			String count=page.getElementText(inventoryCount);
			int value=Integer.parseInt(count);
			int afterDeleteCount=value-1;
			return afterDeleteCount;
		}
		
}
