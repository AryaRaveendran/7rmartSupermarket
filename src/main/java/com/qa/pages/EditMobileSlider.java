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

public class EditMobileSlider extends Baseclass
{
	public EditMobileSlider(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]") 
	WebElement EditButton;
	@FindBy(id=("cat_id"))
	WebElement Category;
	@FindBy(xpath="//button[@name='update']") 
	WebElement Update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;

	public void editMobileSlider()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);


		wait.until(ExpectedConditions.visibilityOf(EditButton));
		wait.until(ExpectedConditions.elementToBeClickable(EditButton));
		EditButton.click();
		
		Select DrpCategory=new Select(Category);
		DrpCategory.selectByVisibleText("Grocery");
		
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
