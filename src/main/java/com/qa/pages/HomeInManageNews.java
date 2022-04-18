package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class HomeInManageNews extends Baseclass
{
	public HomeInManageNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement Home;
	
	public void homeInManageNews() 
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(Home));
		wait.until(ExpectedConditions.elementToBeClickable(Home));
		Home.click();
	}
	
	 public String verification()
     {
  	   String homeTxt=Home.getText();
  	  
  	   return homeTxt;
     }
}
