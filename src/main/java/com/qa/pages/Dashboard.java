package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Baseclass;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class Dashboard extends Baseclass
{
	public Dashboard(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*@FindBy(xpath="//i[@class='nav-icon fas fa-th-large']") 
	WebElement DashBoard;*/
	
	@FindBy(xpath="//p[text()='Dashboard']") 
	WebElement DashBoard;
	
	@FindBy(xpath="//img[@class='img-circle']") 
	WebElement Admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") 
	WebElement Logout ;
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]") 
	WebElement MoreInfo;
	@FindBy(xpath="(//a[text()='More info '])[4]") 
	WebElement MoreInfoManageProduct;
	@FindBy(xpath="(//a[text()='More info '])[2]") 
	WebElement MoreInfoAdminUser;
	@FindBy(xpath="(//a[text()='More info '])[13]") 
	WebElement MoreInfomanageNews;
	@FindBy(xpath="(//a[text()='More info '])[11]") 
	WebElement MoreInfomanageLocation;
	@FindBy(xpath="//span[text()='7rmart supermarket']") 
	WebElement Text;
	@FindBy(xpath="//div[@class='float-right d-none d-sm-inline-block']") 
	WebElement FooterText;
	@FindBy(xpath="(//a[text()='More info '])[14]") 
	WebElement MoreInfomanageExpense;
	@FindBy(xpath="(//a[text()='More info '])[8]") 
	WebElement MoreInfomanageDeliveryBoy;
	@FindBy(xpath="(//a[@class='small-box-footer'])[6]") 
	WebElement MoreInfomanageCOD;
	@FindBy(xpath="(//a[text()='More info '])[7]") 
	WebElement MoreInfomanageslider;
	@FindBy(xpath="(//a[@class='small-box-footer'])[5]") 
	WebElement MoreInfomanageoffercode;
	@FindBy(xpath="//p[text()='Push Notifications']") 
	WebElement PushNotificationClick;
	@FindBy(xpath="(//p[text()='Mobile Slider'])[1]")
	WebElement MobileSlider;
	
	



	public void logout()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		/*wait.until(ExpectedConditions.visibilityOf(DashBoard));
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click();*/
		
		WaitUtil.visibilityOfEleLocated(driver,DashBoard);
		WaitUtil.waitForEleToBeClickable(driver, DashBoard);
		PageUtilities.clickButton(DashBoard);
		Admin.click();
		wait.until(ExpectedConditions.visibilityOf(Logout));
		wait.until(ExpectedConditions.elementToBeClickable(Logout));
		
		Logout.click();

	}

	public void managePagesClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click();
		wait.until(ExpectedConditions.visibilityOf(MoreInfo));
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfo));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MoreInfo);
	}

	public void manageProductClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click();
		MoreInfoManageProduct.click();
	}
	public void adminUserClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click();
		MoreInfoAdminUser.click();

	}
	public void manageNewsClick() 
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		/* wait.until(ExpectedConditions.elementToBeClickable(DashBoard));*/
		//DashBoard.click(); 
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",MoreInfomanageNews);
		wait.until(ExpectedConditions.visibilityOf(MoreInfomanageNews));
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfomanageNews));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MoreInfomanageNews);

		//MoreInfomanageNews.click();
	}
	public void manageLocationClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(DashBoard));
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click(); 
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",MoreInfomanageLocation);
		wait.until(ExpectedConditions.visibilityOf(MoreInfomanageLocation));
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfomanageLocation));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MoreInfomanageLocation);
	}
	public String verification()
	{
		String txt=Text.getText();
		return txt;
	}
	public boolean verification2()
	{
		boolean footerTxt=FooterText.isDisplayed();
		return footerTxt;
	}

	public void manageExpenseClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		DashBoard.click(); 
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",MoreInfomanageExpense);
		wait.until(ExpectedConditions.visibilityOf(MoreInfomanageExpense));
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfomanageExpense));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MoreInfomanageExpense); 
	}

	public void manageDeliveryBoyClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		DashBoard.click(); 
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",MoreInfomanageDeliveryBoy);
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfomanageDeliveryBoy));
		MoreInfomanageDeliveryBoy.click(); 
	}
	public void manageCODclick()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		DashBoard.click(); 
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",MoreInfomanageCOD);
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfomanageCOD));
		MoreInfomanageCOD.click(); 
	}
	
	public void manageSliderClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		DashBoard.click(); 
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",MoreInfomanageslider);
		wait.until(ExpectedConditions.visibilityOf(MoreInfomanageslider));
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfomanageslider));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MoreInfomanageslider); 
	}
	
	public void manageOfferCodeClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click();
		wait.until(ExpectedConditions.visibilityOf(MoreInfomanageoffercode));
		wait.until(ExpectedConditions.elementToBeClickable(MoreInfomanageoffercode));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MoreInfomanageoffercode);
	}
	public void pushNotificationClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click();
		wait.until(ExpectedConditions.visibilityOf(PushNotificationClick));
		wait.until(ExpectedConditions.elementToBeClickable(PushNotificationClick));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PushNotificationClick);
	}
	
	public void mobileSliderClick()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(DashBoard));
		DashBoard.click();
		wait.until(ExpectedConditions.visibilityOf(MobileSlider));
		wait.until(ExpectedConditions.elementToBeClickable(MobileSlider));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MobileSlider);
	}
	
}

