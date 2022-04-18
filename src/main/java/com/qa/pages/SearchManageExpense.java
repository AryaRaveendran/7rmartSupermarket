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

public class SearchManageExpense extends Baseclass
{
	public SearchManageExpense(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButton;
	@FindBy(id=("um"))
	WebElement User;
	@FindBy(id=("ty"))
	WebElement ExpenseType;
	@FindBy(xpath="//button[@name='Search']")
	WebElement Search;
	


	public void searchExpense()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		SearchButton.click();
		Select DrpUser=new Select(User);
		DrpUser.selectByVisibleText("Admin(Admin)");
		Select DrpExpenseType=new Select(ExpenseType);
		DrpExpenseType.selectByVisibleText("Debit Bank");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Search);
		wait.until(ExpectedConditions.visibilityOf(Search));
		wait.until(ExpectedConditions.elementToBeClickable(Search));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Search); 
	}
	
	
}