package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class NewManageSlider extends Baseclass
{
	public  NewManageSlider(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(id="main_img")
	WebElement ImageUpload;
	@FindBy(id="link")
	WebElement Link;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement Save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void newManageSlider()
	{  
		WebDriverWait wait = new WebDriverWait(driver,10);
		NewButton.click();
		wait.until(ExpectedConditions.visibilityOf(ImageUpload));
		wait.until(ExpectedConditions.elementToBeClickable(ImageUpload));
		ImageUpload.sendKeys("C:\\Users\\Nikhil\\OneDrive\\Desktop\\shoppingcenter.jpg");
		Link.sendKeys("https://groceryapp.uniqassosiates.com/admin/");
		wait.until(ExpectedConditions.visibilityOf(Save));
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		Save.click();
		
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
