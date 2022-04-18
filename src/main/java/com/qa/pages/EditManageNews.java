package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class EditManageNews extends Baseclass
{
	public EditManageNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]") 
	WebElement EditButton;
	@FindBy(xpath="//textarea[@id='news']") 
	WebElement EditedNews;
	@FindBy(xpath="//button[@name='update']") 
	WebElement Update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void editManageNewsData(String editedNews)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		
		
		wait.until(ExpectedConditions.visibilityOf(EditButton));
		wait.until(ExpectedConditions.elementToBeClickable(EditButton));
		EditButton.click();
		EditedNews.clear();
		EditedNews.sendKeys(editedNews);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",Update);
        wait.until(ExpectedConditions.elementToBeClickable(Update));
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
