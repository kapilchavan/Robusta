package com.urbanladder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.config.Constants;

public class BedsPage {
	
	@FindBy(css="#topnav_wrapper>ul>li:nth-child(3)")
	private WebElement HoverOnBedroom;
	
	@FindBy(xpath="//a[@class='inverted'][contains(text(),'Beds')]")
	private WebElement HoverOn_Beds;
	
	@FindBy(xpath="//div[@class='subnavlist lt']//a[@class='inverted'][contains(text(),'Mattresses')]")
	private WebElement HoverOn_Mattress;
	
	// This is to Initializing the page Objects
	public BedsPage() {		
		
		PageFactory.initElements(Constants.driver, this);
		
	}
	
	// This method is to check visibility of 'Bedroom' menu title
	public boolean isvisible_BedroomMenuItems() {
		
		Constants.isDisplay = HoverOnBedroom.isDisplayed();
		return Constants.isDisplay;
		
	}
	
	// This method is to check visibility of 'Beds' sub-menu title
	public boolean isvisible_Beds_SubMenu() {
		
		Constants.isDisplay = HoverOn_Beds.isDisplayed();
		return Constants.isDisplay;
		
	}
	
	//This method is to check Text of 'Beds' sub-menu items
	public String getBeds_subMenu_Items() {
		
		return HoverOn_Beds.getText();
		
	}
	
	// This method is to check visibility of 'Mattress' sub-menu title
	public boolean isvisible_Mattress_SubMenu() {
		
		Constants.isDisplay = HoverOn_Mattress.isDisplayed();
		return Constants.isDisplay;

	}
	
	//This method is to check Text of 'Mattress' sub-menu items
	public String getMattresses_subMenu_Items() {
		
		return HoverOn_Mattress.getText();

	}
}
