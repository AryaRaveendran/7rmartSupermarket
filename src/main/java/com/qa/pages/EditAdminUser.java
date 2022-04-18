package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class EditAdminUser extends Baseclass
{
	public EditAdminUser(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement EditButton;
	@FindBy(id=("user_type"))
	WebElement UserType;
	@FindBy(xpath="//button[@name='Update']") 
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void editUserData() 
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		EditButton.click();
		Select DrpUserType=new Select(UserType);
		DrpUserType.selectByVisibleText("Partner");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",updateButton);
		 wait.until(ExpectedConditions.elementToBeClickable(updateButton));
		 updateButton.click();
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
