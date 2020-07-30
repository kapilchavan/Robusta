package com.urbanladder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.config.Constants;

public class LivingPage {
	@FindBy(css = "#topnav_wrapper>ul>li:nth-child(2)")
	private WebElement hoverOnLiving;

	@FindBy(xpath = "//a[text()='Sofa Set']")
	private WebElement hoverOnSofa_Set;

	// This is to Initializing the page Objects
	public LivingPage() {
		PageFactory.initElements(Constants.driver, this);
	}
  
	// This method is to check visibility of 'Living' menu title
	public boolean visibility_LivingMenuTitle() {
		Constants.isDisplay = hoverOnLiving.isDisplayed();
		return Constants.isDisplay;
	}

	// This method is to check visibility of 'Sofa Set' sub-menu title
	public boolean visibility_Sofa_SetSubMenuTitle() {
		Constants.isDisplay = hoverOnSofa_Set.isDisplayed();
		return Constants.isDisplay;
	}
	
   //This method is to check Text of 'Sofa Set' sub-menu title
	public String  getSofa_SetSubMenuText() {
		return hoverOnSofa_Set.getText();

}
}