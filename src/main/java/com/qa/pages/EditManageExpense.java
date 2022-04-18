package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class EditManageExpense extends Baseclass
{
	public EditManageExpense(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement EditButton;
	@FindBy(id=("amount"))
	WebElement Amount;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement Submit;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void editAmountInManageExpense(String amount)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		EditButton.click();
		Amount.clear();
		Amount.sendKeys(amount);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Submit);
		
		wait.until(ExpectedConditions.visibilityOf(Submit));
		wait.until(ExpectedConditions.elementToBeClickable(Submit));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Submit); 
		
	
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
