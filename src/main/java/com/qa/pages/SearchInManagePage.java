package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class SearchInManagePage extends Baseclass
{
	public SearchInManagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement SearchButton;
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement EnterTitle;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Search;
	/*@FindBy(xpath="//button[@type='submit']")
	WebElement Successmsg;*/
	
	public void searchData(String data)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
		 SearchButton.click();
		 
	//EnterValue.clear();
		EnterTitle.sendKeys(data);
	
	
	js.executeScript("arguments[0].scrollIntoView(true);",Search);
	
	 wait.until(ExpectedConditions.elementToBeClickable(Search));
	 Search.click();
	
}
	/*public String successmsg()
	{
		String successMessage=Successmsg.getText();
		return successMessage;
	}*/
}