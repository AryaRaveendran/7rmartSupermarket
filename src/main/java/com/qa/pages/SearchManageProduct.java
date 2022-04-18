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

public class SearchManageProduct extends Baseclass
{
	public SearchManageProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement SearchButton;
	@FindBy(id=("cat_id"))
	WebElement Category;
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement Search;
	
	
	


	public void searchDropDownData()  {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		SearchButton.click();
		
		
		Select DrpCategory=new Select(Category);
		DrpCategory.selectByVisibleText("Fruits & Vegetables");
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	js.executeScript("arguments[0].scrollIntoView(true);",Search);
	
	 wait.until(ExpectedConditions.elementToBeClickable(Search));
	 Search.click();
	}
}

