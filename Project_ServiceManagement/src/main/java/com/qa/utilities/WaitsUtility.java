package com.qa.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtility {
	//giving as constants the seconds need to wait
	public static final long IMPLICIT_WAIT=20;
	public static final long PAGE_LOAD_WAIT=20;
	public static final long EXPLICIT_WAIT=60;
	//visibility of element
	public static void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//element to be clickable
	public static void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//presence of element located
	public static void waitForPresenceofElementLocated(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	//alert is present
	public static void waitForAlertisPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	//element to be selected
	public static void waitForElementTobeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	//frameToBeAvailableAndSwitchToIt
	public static void waitForFrameToBeAvailable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	//invisibilityOfElementLocated
	public static void waitForinvisibilityOfElementLocated(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	//presenceOfAllElementsLocatedBy
	public static void waitForPresenceOfAllElementsLocatedBy(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
	}
	//textToBePresentInElementLocated
	public static void waitForTextToBePresentInElementLocated(WebDriver driver, By locator, String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	//attributeToBe
	public static void waitForAttributeToBe(WebDriver driver, WebElement element, String attribute, String value) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	}
}
	
	
	
	
	
	
	

