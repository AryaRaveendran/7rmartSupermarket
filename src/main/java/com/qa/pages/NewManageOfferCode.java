package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Baseclass;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class NewManageOfferCode extends Baseclass
{
	public NewManageOfferCode(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") 
	WebElement NewButton;
	@FindBy(id=("offer_code"))
	WebElement OfferCode;
	@FindBy(xpath=("//input[@value='no']"))
	WebElement OrderUser;
	@FindBy(id=("offer_per"))
	WebElement Percentage;
	@FindBy(id=("offer_price"))
	WebElement Amount;
	@FindBy(xpath=("//button[@type='submit']"))
	WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void newManageOfferCode(String offercode, String percentage, String amount)
	{
		WaitUtil.visibilityOfEleLocated(driver, NewButton);
		WaitUtil.waitForEleToBeClickable(driver, NewButton);
		PageUtilities.clickButton(NewButton);
		
		
		PageUtilities.sendInput(OfferCode, offercode);
		
		WaitUtil.visibilityOfEleLocated(driver, OrderUser);
		WaitUtil.waitForEleToBeClickable(driver, OrderUser);
		PageUtilities.clickButton(OrderUser);
		
		PageUtilities.sendInput(Percentage, percentage);
		
		PageUtilities.sendInput(Amount, amount);
		
		
		WaitUtil.visibilityOfEleLocated(driver, SaveButton);
		WaitUtil.waitForEleToBeClickable(driver, SaveButton);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SaveButton);
		//PageUtilities.clickButton(SaveButton);
		
		
		
	}
	
	public String alertMessage()
	{
			String successMessage=Successmsg.getText();
			String trimMsg=successMessage.trim();
			String arr[]=trimMsg.split(" ",2); 
			String theRest = arr[1];
			
			return theRest ;
	}
	
}
