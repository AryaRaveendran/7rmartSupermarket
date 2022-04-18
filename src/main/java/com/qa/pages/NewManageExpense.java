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

public class NewManageExpense extends Baseclass
{
	public NewManageExpense(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(id=("user_id"))
	WebElement User;
	@FindBy(xpath="//input[@id='ex_date']")
	WebElement Date;
	@FindBy(id=("ex_cat"))
	WebElement Category;
	@FindBy(id=("order_id"))
	WebElement orderId;
	@FindBy(id=("purchase_id"))
	WebElement purchaseId;
	@FindBy(id=("ex_type"))
	WebElement ExpenseType;
	@FindBy(xpath="//input[@id='amount']")
	WebElement Amount;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement Save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;

	public void newManageExpenseData(String date, String amount)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		NewButton.click();
		Select DrpUser=new Select(User);
		DrpUser.selectByVisibleText("Admin(Admin)");
		Date.clear();
		Date.sendKeys(date);
		Select DrpCategory=new Select(Category);
		DrpCategory.selectByVisibleText("food123");
		Select DrpOrderId=new Select(orderId);
		DrpOrderId.selectByValue("8");
		Select DrpPurchaseId=new Select(purchaseId);
		DrpPurchaseId.selectByValue("9");
		Select DrpExpenseType=new Select(ExpenseType);
		DrpExpenseType.selectByVisibleText("Debit Bank");
		Amount.sendKeys(amount);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Save);
		wait.until(ExpectedConditions.visibilityOf(Save));
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Save); 

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
