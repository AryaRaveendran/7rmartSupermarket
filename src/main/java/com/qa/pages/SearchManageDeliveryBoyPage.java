package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class SearchManageDeliveryBoyPage extends Baseclass
{
	public SearchManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(2)']") 
	WebElement SearchButton;
	@FindBy(id=("un"))
	WebElement Name;
	@FindBy(id=("ut"))
	WebElement Email;
	/*@FindBy(id=("ph"))
	WebElement PhoneNumber;*/
	@FindBy(xpath="//button[@type='submit']") 
	WebElement Search;
	
	
	public void searchDeliveryBoy(String name, String email)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		SearchButton.click();
		Name.sendKeys(name);
		Email.sendKeys(email);
		//PhoneNumber.sendKeys(null);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 wait.until(ExpectedConditions.elementToBeClickable(Search));
		 Search.click();
	}
}
