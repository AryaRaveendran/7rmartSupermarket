package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;
//import com.qa.testcase.$missing$;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class LoginPage extends Baseclass {

	public LoginPage(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
    }
	@FindBy(name=("username"))
	WebElement userName;
	@FindBy(name=("password"))
	WebElement password;
	@FindBy(xpath=("//button[text()='Sign In']"))
	WebElement loginButton;
	@FindBy(xpath="//span[text()='7rmart supermarket']") 
	WebElement Text;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement Successmsg;
	@FindBy(xpath="//p[text()='Sign in to start your session']")
	WebElement blankmsg;
	
	
	

	public void login(String userNameTxt, String passwordTxt)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		PageUtilities.sendInput(userName, userNameTxt);
		PageUtilities.sendInput(password, passwordTxt);
		PageUtilities.clickButton(loginButton);
		
		/*userName.clear();
		userName.sendKeys(userNameTxt);
		password.clear();
		password.sendKeys(passwordTxt);
		 wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();*/
		
		
	}
	
	 public String verification()
     {
  	   String homeTxt=Text.getText();
  	  
  	   return homeTxt;
     }
	
	public void invalidLogin() throws IOException
	{
		WaitUtil.visibilityOfEleLocated(driver, userName);
		
		userName.clear();
		userName.sendKeys(PageUtilities.ExcelReadUserName());
		password.clear();
		password.sendKeys(PageUtilities.ExcelReadPassword());
		WaitUtil.visibilityOfEleLocated(driver, loginButton);
		WaitUtil.waitForEleToBeClickable(driver, loginButton);
		PageUtilities.clickButton(loginButton);
		
		
	}
	
	public String invalidLoginalertMessage()
	{
		String successMessage=Successmsg.getText();
		String trimMsg=successMessage.trim();
		String arr[]=trimMsg.split(" ",2);
		String theRest = arr[1];
		return theRest ;
		
		

	}
	
	public void blankLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		userName.clear();
		password.clear();
		//userName.sendKeys(invalidUName);
		//password.sendKeys(Invalidpwd);
		/*WaitUtil.visibilityOfEleLocated(driver, loginButton);
		WaitUtil.waitForEleToBeClickable(driver, loginButton);*/
		PageUtilities.clickButton(loginButton);
		 
		
	}
	
	public String blankLoginalertMessage()
	{
		String successMessage=blankmsg.getText();
		return successMessage;
		
		

	}
	
	public void blankUserNameLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		userName.clear();
		
		password.clear();
		PageUtilities.sendInput(password, "arya");
		//userName.sendKeys(invalidUName);
		//password.sendKeys(Invalidpwd);
		WaitUtil.visibilityOfEleLocated(driver, loginButton);
		WaitUtil.waitForEleToBeClickable(driver, loginButton);
		PageUtilities.clickButton(loginButton);
		 
		
	}
	
 
	
}
