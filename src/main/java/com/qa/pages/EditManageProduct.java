package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class EditManageProduct extends Baseclass
{
	public EditManageProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@role='button'])[5]")
	WebElement EditButton;
	@FindBy(xpath="//input[@placeholder='Enter the Title']")
	WebElement EnterTitle;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement Update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void editedManageProductData(String data) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
	
	EditButton.click();
	EnterTitle.clear();
	EnterTitle.sendKeys(data);
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	js.executeScript("arguments[0].scrollIntoView(true);",Update);
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(Update));
	// wait.until(ExpectedConditions.visibilityOf(Update));
	 Update.click();
	
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

