package com.config;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	/**
	 * This method is used to open specific browser. Browser name should be as
	 * follow :<br>
	 * <ol>
	 * <li>Chrome</li>
	 * <li>Firefox</li>
	 * <li>IE</li> only above mention browsers can be open using this method
	 * 
	 * @param browserName
	 * @author Sujit Kolhe
	 * 
	 */
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			Constants.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			Constants.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			Constants.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			break;
		default:
			System.out.println("Invalid browser name : " + browserName);

		}
	}

	/**
	 * This method is used to launched the url in the browser is looking at. .
	 * 
	 * @param url
	 * @author Sujit Kolhe
	 * 
	 */
	public static void launchURL(String url) {
		Constants.driver.get(url);
	}

	/**
	 * This method is used to maximizes the current window which recently launched
	 * url.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();
	}

	/**
	 * This method is used to get the matching web element on the current page
	 * follow :<br>
	 * <ol>
	 * <li>XPATH</li>
	 * <li>ID</li>
	 * <li>CSS</li>
	 * <li>NAME</li>
	 * <li>CLASS</li>only above mention locators type can be select using this
	 * method
	 * 
	 * @return WebElement
	 * @author Sujit Kolhe
	 * 
	 */
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		Constants.element = null;
		switch (locatorType) {
		case "XPATH":
			Constants.element = Constants.driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			Constants.element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			Constants.element = Constants.driver.findElement(By.id(locatorValue));
			break;
		case "NAME":
			Constants.element = Constants.driver.findElement(By.name(locatorValue));
			break;
		case "CLASSNAME":
			Constants.element = Constants.driver.findElement(By.className(locatorValue));
			break;
		case "LINKTEXT":
			Constants.element = Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIALINKTEXT":
			Constants.element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "TAGNAME":
			Constants.element = Constants.driver.findElement(By.tagName(locatorValue));
			break;
		default:
			System.err.println("Invalid Locator Type");
		}
		return Constants.element;
	}

	/**
	 * This method is used to click on target web element on current page.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void clickOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	/**
	 * This method is used to hover on target element to move to on current window.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void hoverOnElement(String locatorType, String locatorValue) {
		Constants.element = getWebElement(locatorType, locatorValue);
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(Constants.element).perform();
	}

	/**
	 * This method is used to typing the text in the target element.
	 *
	 * @param keysToSend character sequence to send to the element
	 * @author Sujit Kolhe
	 * 
	 */
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	/**
	 * This method is used to switch to a different frame or window.
	 *
	 * @return A TargetLocator which can be used to select a frame or window
	 * @author Sujit Kolhe
	 * 
	 */
	public static void switchToWindow(int windowIndex) {
		Set<String> windows = Constants.driver.getWindowHandles();
		ArrayList<String> list = new ArrayList(windows);
		Constants.driver.switchTo().window(list.get(windowIndex));
	}

	/**
	 * This method is used to create logging operations, except configuration and *
	 * See {@getLogger(String)} detailed information.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void loggerInfo(String message) {
		Logger logger = Logger.getLogger(Keywords.class);
		logger.info(message);
	}

	/*
	 * This method is used to delete cookies
	 *
	 * @author Sujit Kolhe
	 *
	 */
	public static void deleteAllCookies() {
		Constants.driver.manage().deleteAllCookies();
	}

	/*
	 * This method is used to sleep methods
	 * 
	 */
	public static void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Timeout: "+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to Close the current window, quitting the browser if it's
	 * the last window currently open.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void closeBrowser() {
		Constants.driver.close();
	}

	/**
	 * This method is used to quits this driver, closing every associated window.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void closeAllBrowser() {
		Constants.driver.quit();
	}
}
