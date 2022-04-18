package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class AddNewsInManageNews extends Baseclass
{
	public AddNewsInManageNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") 
	WebElement NewButton;
	@FindBy(xpath="//textarea[@placeholder='Enter the news']") 
	WebElement EnterNews;
	
	@FindBy(xpath="//button[text()='Save']") 
	WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void ManageNewsData(String news)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		
		NewButton.click();
		EnterNews.sendKeys(news);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",SaveButton);
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        SaveButton.click();
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
