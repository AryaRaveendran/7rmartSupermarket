package com.qa.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class NewManageLocation extends Baseclass
{
	public NewManageLocation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 

	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") 
	WebElement NewButton;
	@FindBy(id=("country_id"))
	WebElement Country;
	@FindBy(id=("st_id"))
	WebElement State;
	@FindBy(id=("location"))
	WebElement Location;
	@FindBy(id=("delivery"))
	WebElement DeliveryCharge;
	@FindBy(xpath="//button[text()='Save']") 
	WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void newPageData(String location,String charge)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		NewButton.click();
		Select DrpCountry=new Select(Country);
		//DrpCountry.selectByVisibleText("United Kingdom");
		DrpCountry.selectByValue("230");
		Select DrpState=new Select(State);
		DrpState.selectByVisibleText("Bedfordshire");
		Location.sendKeys(location);
		DeliveryCharge.sendKeys(charge);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		 SaveButton.click();
		 
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		
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

