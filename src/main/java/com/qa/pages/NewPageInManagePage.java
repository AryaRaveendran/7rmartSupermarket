package com.qa.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class NewPageInManagePage extends Baseclass
{
	public NewPageInManagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); //pageFactory

	}
	
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") 
	WebElement NewButton;
	@FindBy(id=("title"))
	WebElement EnterTitle;
	@FindBy(xpath="//input[@id='page']") 
	WebElement EnterPage;
	@FindBy(xpath="//button[text()='Save']") 
	WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	

	
	public void newPageData() 
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		
	
		NewButton.click();
		EnterTitle.sendKeys(getRandomUserName());
		EnterPage.sendKeys(getRandomPageName());
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(SaveButton));
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SaveButton);
	}
	
	public String getRandomUserName() 
	{
	
		Random r = new Random();
		int low = 10, high = 1000;
		int result = r.nextInt(high-low)+low;
		//System.out.println("new user=arya"+result);
		return "arya"+result;
	}
	
	public String getRandomPageName() 
	{
	
		Random r = new Random();
		int low = 10, high = 1000;
		int result = r.nextInt(high-low)+low;
		//System.out.println("new user=arya"+result);
		return "FirstPage"+result;
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

