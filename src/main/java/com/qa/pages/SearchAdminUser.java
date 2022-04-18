package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Baseclass;

public class SearchAdminUser extends Baseclass
{
	public SearchAdminUser(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButton;
	@FindBy(id=("un"))
	WebElement UserName;
	@FindBy(id=("ut"))
	WebElement UserType;
	@FindBy(xpath="//button[@name='Search']")
	WebElement Search;

	 public void searchUser(String uname)
	 {
		 SearchButton.click(); 
		 UserName.clear();
		 UserName.sendKeys(uname);
		 Select DrpUserType=new Select(UserType);
		 DrpUserType.selectByVisibleText("Admin");
		 Search.click();
		 
	 }
}


