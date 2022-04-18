package com.qa.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Baseclass;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class StatusManageLocation extends Baseclass
{
	public StatusManageLocation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[text()='Active'])[1]")
	WebElement StatusActive;
	@FindBy(xpath="(//span[text()='Inactive'])[1]")
	WebElement StatusInactive;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;
	
	public void status()
	{
		//if()
		//{
		
		WaitUtil.visibilityOfEleLocated(driver, StatusActive);
		WaitUtil.waitForEleToBeClickable(driver, StatusActive);
		PageUtilities.clickButton(StatusActive);
		//Status.click();
		//}else
//		{
//			WaitUtil.visibilityOfEleLocated(driver, StatusInactive);
//			WaitUtil.waitForEleToBeClickable(driver, StatusInactive);
//			PageUtilities.clickButton(StatusInactive);
//		}
		
File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	
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
