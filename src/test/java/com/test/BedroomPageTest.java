package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.Constants;
import com.config.Keywords;
import com.urbanladder.pages.BedsPage;
import com.utility.Property_Util_Bedroom;

public class BedroomPageTest {
	
		BedsPage bedspage;
	
	@BeforeTest
	public void tc_openBrowser() {
		
		Keywords.openBrowser("Chrome");
		Keywords.launchURL(Property_Util_Bedroom.get_Property("ApplicationURL"));
		Keywords.maximizeBrowser();
		String expectedurl = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedurl, "https://www.urbanladder.com/");
		Keywords.loggerInfo("Open browser ,Entering appliction url and maximizing browser");
		Keywords.sleep();
		Keywords.clickOnElement("CSS", Property_Util_Bedroom.get_Property("StatingPop_up"));
		bedspage = new BedsPage();
		
	}
	
	@Test(priority=1)
	public void tc_BedroomMenuDisplay() {
		
		bedspage.isvisible_BedroomMenuItems();
		Assert.assertTrue(true);
		Keywords.hoverOnElement("CSS", Property_Util_Bedroom.get_Property("BedroomMenu"));
		Keywords.loggerInfo("Verify 'Bedroom' Menu is visible or not");
		
	}
	
	@Test(priority=2)
	public void tc_Beds_SubMenuDisplay() {
		
		bedspage.isvisible_Beds_SubMenu();
		Assert.assertTrue(true);
		Keywords.loggerInfo("Verify 'Beds' subMenu visible or not");
		
	}
	
	@Test(priority=3)
	public void tc_getBeds_subMenu_Items() {
		
		Constants.actual = bedspage.getBeds_subMenu_Items();
		Constants.expected = "Beds";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify 'Beds' text");	
		
	}
	
	@Test(priority=4)
	public void tc_BedsSubMenuItems() {
		
		List<WebElement> list = Constants.driver.findElements(By.cssSelector(Property_Util_Bedroom.get_Property("Beds_SubMenu")));	
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = list.iterator();		
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual List:-" +Constants.actualList);
		Keywords.readJsonFile("src/main/resources/BedsPageItems.json", "Beds");		
		Assert.assertEquals(Constants.actualList,Constants.expectedList);

	}
	
	@Test(priority=5)
	public void tc_Mattress_subMenu() {
		
		bedspage.isvisible_Mattress_SubMenu();
		Assert.assertTrue(true);
		Keywords.loggerInfo("Verify 'Mattresses' subMenu visible or not");
		
	}
	
	@Test(priority=6)
	public void tc_getMattress_subMenu_Items() {
		
		Constants.actual = bedspage.getMattresses_subMenu_Items();
		Constants.expected = "Mattresses";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify 'Mattresses' text");

	}
	
	//@Test(priority=7)
	public void tc_MattressSubMenuItems() {			
		
		List<WebElement> list = Constants.driver.findElements(By.cssSelector(Property_Util_Bedroom.get_Property("Mattresses_SubMenu")));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}		
		System.out.println("Actual List:-" + Constants.actualList);
		Keywords.readJsonFile("src/main/resources/BedsPageItems.json", "Mattresses");
		Assert.assertEquals(Constants.actualList,Constants.expectedList);

	}
	
	@Test(priority=8)
	public void tc_Beds_with_Storage() {		
		
		Keywords.clickOnElement("CSS", Property_Util_Bedroom.get_Property("Beds_with_Storage"));
		String expectedURL = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, "https://www.urbanladder.com/beds-with-storage?src=g_topnav_bedroom_beds_beds-with-storage");
		Constants.driver.navigate().back();
		
	}
	
	@Test(priority=9)
	public void tc_Beds_without_Storage() {
		
		Keywords.hoverOnElement("CSS", Property_Util_Bedroom.get_Property("BedroomMenu"));
		Keywords.clickOnElement("CSS", Property_Util_Bedroom.get_Property("Beds_without_Storage"));
		String expectedURL = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, "https://www.urbanladder.com/beds-without-storage?src=g_topnav_bedroom_beds_beds-without-storage");
		Constants.driver.navigate().back();
		
	}
	
	@Test(priority=10)
	public void tc_Double_Beds() {
		
		Keywords.hoverOnElement("CSS", Property_Util_Bedroom.get_Property("BedroomMenu"));
		Keywords.clickOnElement("CSS", Property_Util_Bedroom.get_Property("Double_Beds"));
		String expectedURL = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, "https://www.urbanladder.com/double-beds?src=g_topnav_bedroom_beds_double-beds");
		Constants.driver.navigate().back();		

	}
	
	@Test(priority=11)
	public void tc_King_Size_Beds() {
		
		Keywords.hoverOnElement("CSS", Property_Util_Bedroom.get_Property("BedroomMenu"));
		Keywords.clickOnElement("CSS", Property_Util_Bedroom.get_Property("King_Size_Beds"));
		String expectedURL = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, "https://www.urbanladder.com/king-size-bed?src=g_topnav_bedroom_beds_king-size-beds");
		Constants.driver.navigate().back();		

	}

}
