package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.config.Constants;
import com.config.Keywords;
import com.urbanladder.pages.LivingPage;
import com.utility.PropertyUtility;

public class LivingPageTest {
	LivingPage livingpage;

	@BeforeTest
	public void openBrowser() {
		Keywords.openBrowser("Chrome");
		Keywords.launchURL(PropertyUtility.getProperty("ApplicationURL"));
		String expectedUrl = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, "https://www.urbanladder.com/");
		// Keywords.maximizeBrowser();
		Keywords.loggerInfo("Open browser ,Entering appliction url and maximizing browser");
		Keywords.sleep();
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("StatingPop_up"));
		livingpage = new LivingPage();

	}

	@Test(priority=1)
	public void livingMenuDisplay() {
		livingpage.visibility_LivingMenuTitle();
		Assert.assertTrue(true);
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("LivingMenu"));
		Keywords.loggerInfo("Verify 'Living' Menu is visible or not");

	}

	@Test(priority=2)
	public void sofa_setSubmenu_Display() {
		livingpage.visibility_Sofa_SetSubMenuTitle();
		Assert.assertTrue(true);
		Keywords.loggerInfo("Verify 'Sofa Set' subMenu visible or not");
	}

	@Test(priority=3)
	public void getSofa_set_SubmenuText() {
		Constants.actual=livingpage.getSofa_SetSubMenuText();
		Constants.expected="Sofa Set";
		Assert.assertEquals(Constants.actual,Constants.expected);
		Keywords.loggerInfo("Verify 'Sofa Set' text");
	}

	@Test(priority=4)
	public void getSofasetItems() {
		List<WebElement> list = Constants.driver.findElements(By.cssSelector(PropertyUtility.getProperty("Sofa_Set_SubMenu")));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual List:-"+Constants.actualList);
		Keywords.readJsonFile("src/main/resources/LivingPageItems.json", "Sofa Set");
		Assert.assertEquals(Constants.actualList,Constants.expectedList);
		
				// Keyword.loggerInfo("verifing in 'Your Lists' items from Account & Lists
		// tool");
		// test = extent.createTest("tc_60 verifying items present in 'Your Lists");
		// test.log(Status.INFO, "verifing in 'Your Lists' items as per expected");

	}
	
	@AfterTest
	public void close_Window_And_quiteDriver() {
		Keywords.closeBrowser();
		Keywords.quiteDriver();
	}
}
