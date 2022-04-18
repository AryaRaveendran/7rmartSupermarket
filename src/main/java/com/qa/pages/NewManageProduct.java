package com.qa.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.qa.base.Baseclass;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class NewManageProduct extends Baseclass
{
	public NewManageProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath="//a[@onclick='click_button(1)']") 
	WebElement NewButton;
	@FindBy(id=("title"))
	WebElement EnterTitle;
	@FindBy(xpath="//input[@value='Nonveg']") 
	WebElement ProductType;
	@FindBy(id=("cat_id"))
	WebElement Category;
	@FindBy(id=("sub_id"))
	WebElement SubCategory;
	@FindBy(id=("purpose")) 
	WebElement PriceType;
	@FindBy(id=("m_weight"))
	WebElement WeightValue;
	@FindBy(id=("w_unit"))
	WebElement WeightUnit;
	@FindBy(id=("max_weight"))
	WebElement MaximumQuatity;
	@FindBy(id=("w_price"))
	WebElement Price;
	@FindBy(id=("w_stock"))
	WebElement StockAvailability;
	@FindBy(xpath=("(//input[@value='no'])[1]"))
	WebElement Stock;
	@FindBy(xpath=("(//input[@name='featured'])[1]"))
	WebElement Featured;
	@FindBy(xpath=("(//input[@name='combo'])[1]"))
	WebElement ComboPack;
	@FindBy(xpath=("//button[@type='submit']"))
	WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement Successmsg;

	public void newProductData(String title,String weightValues,String maxQty,String prices,String stock) 
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		

		WaitUtil.visibilityOfEleLocated(driver, NewButton);
		WaitUtil.waitForEleToBeClickable(driver, NewButton);

		PageUtilities.clickButton(NewButton);
		//NewButton.click();

		PageUtilities.sendInput(EnterTitle, title);
		//EnterTitle.sendKeys(title);

		wait.until(ExpectedConditions.visibilityOf(ProductType));
		wait.until(ExpectedConditions.elementToBeClickable(ProductType));
		ProductType.click();
		Select DrpCategory=new Select(Category);
		DrpCategory.selectByVisibleText("Fruits & Vegetables");


		wait.until(ExpectedConditions.visibilityOf(SubCategory));
		wait.until(ExpectedConditions.elementToBeClickable(SubCategory));
		WebElement ele=driver.findElement(By.name("sub_id"));
		Select select=new Select(ele);
		select.selectByVisibleText("Vegetables");


		wait.until(ExpectedConditions.visibilityOf(PriceType));
		wait.until(ExpectedConditions.elementToBeClickable(PriceType));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PriceType); 

		WeightValue.clear();
		WeightValue.sendKeys(weightValues);
		Select DrpWeightUnit=new Select(WeightUnit);
		DrpWeightUnit.selectByVisibleText("kg");
		MaximumQuatity.sendKeys(maxQty);
		Price.sendKeys(prices);

		js.executeScript("arguments[0].scrollIntoView(true);",StockAvailability);
		StockAvailability.sendKeys(stock);

		wait.until(ExpectedConditions.visibilityOf(Stock));
		wait.until(ExpectedConditions.elementToBeClickable(Stock));
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Stock);

		js.executeScript("arguments[0].scrollIntoView(true);",SaveButton);
		wait.until(ExpectedConditions.visibilityOf(SaveButton));
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		//executor.executeScript("arguments[0].click();", Stock);

		wait.until(ExpectedConditions.visibilityOf(Featured));
		wait.until(ExpectedConditions.elementToBeClickable(Featured));
		executor.executeScript("arguments[0].click();", Featured);

		wait.until(ExpectedConditions.visibilityOf(ComboPack));
		wait.until(ExpectedConditions.elementToBeClickable(ComboPack));
		executor.executeScript("arguments[0].click();", ComboPack);
		//ComboPack.click();
		executor.executeScript("arguments[0].click();", SaveButton);


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



