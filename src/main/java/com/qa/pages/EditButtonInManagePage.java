package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class EditButtonInManagePage extends Baseclass
{
	public EditButtonInManagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement EditButton;
	@FindBy(xpath="//input[@placeholder='Enter the Title']")
	WebElement EnterValue;
	@FindBy(xpath="//button[text()='Update']")
	WebElement UpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;




	public void editedData(String data)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);

		EditButton.click();
		EnterValue.clear();
		EnterValue.sendKeys(data);


		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",UpdateButton);
		wait.until(ExpectedConditions.visibilityOf(UpdateButton));
		wait.until(ExpectedConditions.elementToBeClickable(UpdateButton));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UpdateButton);

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
