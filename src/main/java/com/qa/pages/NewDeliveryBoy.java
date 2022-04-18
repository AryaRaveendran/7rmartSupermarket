package com.qa.pages;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class NewDeliveryBoy extends Baseclass
{
	public NewDeliveryBoy(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement NewButton;
	@FindBy(id=("name"))
	WebElement Name;
	@FindBy(id=("email"))
	WebElement Email;
	@FindBy(id=("phone"))
	WebElement PhoneNumber;
	@FindBy(xpath="//textarea[@id='address']")
	WebElement Address;
	@FindBy(id=("username"))
	WebElement UserName;
	@FindBy(id=("password"))
	WebElement Password;
	@FindBy(xpath="//button[@name='create']")
	WebElement Save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void newDeliveryBoyData()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		NewButton.click();
		Name.sendKeys("Arya");
		Email.sendKeys("arya123@gmail.com");
		PhoneNumber.sendKeys("12345678");
		Address.sendKeys("xyz street");
		UserName.sendKeys(getRandomUserName());
		Password.sendKeys("admin");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		wait.until(ExpectedConditions.visibilityOf(Save));
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		js.executeScript("arguments[0].click();", Save);;
	}
	
	public String getRandomUserName() 
	{
	
		Random r = new Random();
		int low = 10, high = 1000;
		int result = r.nextInt(high-low)+low;
		//System.out.println("new user=arya"+result);
		return "arya"+result;
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
