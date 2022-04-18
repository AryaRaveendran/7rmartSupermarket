package com.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;

public class NewAdminUser extends Baseclass 
{
	public NewAdminUser(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath="//a[@onclick='click_button(1)']") 
	WebElement NewButton;
	@FindBy(id=("username"))
	WebElement UserName;
	@FindBy(id=("password"))
	WebElement Password;
	@FindBy(id=("user_type"))
	WebElement UserType;
	@FindBy(xpath="//button[@name='Create']") 
	WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void newAdminUser()
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		NewButton.click();
		UserName.clear();
		UserName.sendKeys(getRandomUserName());
		Password.clear();
		Password.sendKeys("1246");
		Select DrpUserType=new Select(UserType);
		DrpUserType.selectByVisibleText("Admin");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",SaveButton);
		 wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		 SaveButton.click();
		 
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        
		
	}
	
	public String getRandomUserName() 
	{
	
		Random r = new Random();
		int low = 10, high = 1000;
		int result = r.nextInt(high-low)+low;
		System.out.println("new user=arya"+result);
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
	

