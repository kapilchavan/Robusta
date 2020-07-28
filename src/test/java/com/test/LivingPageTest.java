package com.test;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.Constants;
import com.config.Keywords;
import com.utility.PropertyUtility;


public class LivingPageTest {
@BeforeTest
public void openBrowser() {
	Keywords.openBrowser("Chrome");
	Keywords.launchURL(PropertyUtility.getProperty("ApplicationURL"));
	String expectedUrl= Constants.driver.getCurrentUrl();
	Assert.assertEquals(expectedUrl, "https://www.urbanladder.com/");
	//Keywords.maximizeBrowser();
	Keywords.loggerInfo("Open browser ,Entering appliction url and maximizing browser");
	Keywords.sleep();
	Keywords.clickOnElement("CSS", PropertyUtility.getProperty("StrtingPop_up"));
	
}
@Test
public void getLivingItems() {
	Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("LivingMenu"));
	
}
}
