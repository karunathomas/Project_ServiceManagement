package com.qa.servicemanagementproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.utilities.ScreenshotUtility;


public class Base {

	public WebDriver driver;
	// properties to give stream of characters
	// to handle
	public Properties prop1, prop2;
	public FileInputStream fs1, fs2;
	public ScreenshotUtility screenshot;
	ChromeOptions ops = new ChromeOptions();
	EdgeOptions opt=new EdgeOptions();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intializeBrowser(String browser) throws Exception {
		prop1 = new Properties();
		prop2 = new Properties();
		try {
			fs1 = new FileInputStream(System.getProperty("user.dir") + constants.Constance.CONFIGfILE);
		} catch (Exception e) {

		}
		// to load
		try {
			prop1.load(fs1);
			;
		} catch (Exception e) {

		}
		try {
			fs1 = new FileInputStream(System.getProperty("user.dir") + constants.Constance.TESTDATAFILE);
		} catch (Exception e) {

		}
		try {
			prop2.load(fs1);
		} catch (Exception e) {

		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
			} 
		else if (browser.equalsIgnoreCase("chrome")) {
			ops.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + constants.Constance.CHROME);
			driver = (WebDriver) new ChromeDriver(ops);
			} 
		else if (browser.equalsIgnoreCase("Edge")) {
			opt.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + constants.Constance.EDGE);
			//driver = (WebDriver) new EdgeDriver(opt);
			driver = new EdgeDriver(opt);
			}
		else {
			throw new Exception("Browser is not correct");
			}
		driver.get(prop1.getProperty("url"));
		}
		@AfterMethod
	    public void browserQuit(ITestResult iTestResult) throws IOException {
	        if (iTestResult.getStatus() == ITestResult.FAILURE) {
	        	screenshot = new ScreenshotUtility();
	        	screenshot.getScreenshot(driver, iTestResult.getName());
	        }
	        driver.quit();
	        }
}
