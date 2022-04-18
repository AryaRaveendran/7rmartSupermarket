package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;
import com.qa.utilities.PageUtilities;

public class PushNotificationPage extends Baseclass
{
	public PushNotificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(id=("title"))
	WebElement EnterTitle;
	@FindBy(id=("description"))
	WebElement Description;
	@FindBy(xpath=("//button[@name='create']"))
	WebElement Send;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void pushNotification(String title, String descpt)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		PageUtilities.sendInput(EnterTitle, title);
		PageUtilities.sendInput(Description, descpt);
		wait.until(ExpectedConditions.visibilityOf(Send));
		wait.until(ExpectedConditions.elementToBeClickable(Send));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Send);
		
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
