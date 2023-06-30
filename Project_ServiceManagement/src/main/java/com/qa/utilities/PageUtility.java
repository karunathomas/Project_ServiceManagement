package com.qa.utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public static void clickOnElement(WebElement element) {
		element.click();
	}
	public static String getElementText(WebElement element) {
		return element.getText();
	}
	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
		//return element;
	}
	public static void clickAndHoldOnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	public static boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	public static void selectDropdownbyText(WebElement element, String Text) {
		Select selectObj = new Select(element);
		selectObj.selectByVisibleText(Text);
	}
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	public static int getElementRowSize(List<WebElement> element) {
		return element.size();
	}
	public static int getElementColumnSize(List<WebElement> element) {
		return element.size();
	}
	public static void stopPageReferesh(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.stop();");
	}
	public static void selectElementFromListUsingGetAttribute(List<WebElement> element, String attri, String value) {
		for(WebElement i:element) {
			String attribute=i.getAttribute(attri);
			if(attribute.contentEquals(value)) {
				i.click();
			}
		}
	}
}
