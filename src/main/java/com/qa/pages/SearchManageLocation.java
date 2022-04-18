package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class SearchManageLocation extends Baseclass
{
	public SearchManageLocation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(2)']") 
	WebElement SearchButton;
	@FindBy(id=("country_id"))
	WebElement Country;
	@FindBy(name=("state_id"))
	WebElement State;
	@FindBy(id=("location"))
	WebElement Location;
	@FindBy(xpath="//button[@name='Search']") 
	WebElement Search;
	
	
	public void searchLocation(String location)
	{


		WaitUtil.visibilityOfEleLocated(driver, SearchButton);
		WaitUtil.waitForEleToBeClickable(driver, SearchButton);
		PageUtilities.clickButton(SearchButton);
		//SearchButton.click();
		
		WaitUtil.visibilityOfEleLocated(driver, Country);
		WaitUtil.waitForEleToBeClickable(driver, Country);
		Select DrpCountry=new Select(Country);
		//DrpCountry.selectByVisibleText("United Kingdom");
		DrpCountry.selectByValue("230");
		//Select DrpState=new Select(State);
		/*WaitUtil.visibilityOfEleLocated(driver, driver.findElement(By.name("state_id")));
		WaitUtil.waitForEleToBeClickable(driver, driver.findElement(By.name("state_id")));*/
//		WebElement ele=driver.findElement(By.name("state_id"));
//		Select DrpState=new Select(ele);
//		DrpState.selectByValue("3868");
		
		WaitUtil.visibilityOfEleLocated(driver, Location);
		WaitUtil.waitForEleToBeClickable(driver, Location);
		PageUtilities.sendInput(Location, location);
		//Location.sendKeys(location);
		
		
		WaitUtil.visibilityOfEleLocated(driver, Search);
		WaitUtil.waitForEleToBeClickable(driver, Search);
		PageUtilities.clickButton(Search);
	}
}
