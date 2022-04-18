package com.qa.utilities;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Baseclass;

import excel.Excelfile;

public class PageUtilities extends Baseclass

{
	static Excelfile excelfile;
	public static void sendInput(WebElement ele,String input)
	{
		WaitUtil.visibilityOfEleLocated(driver, ele);
		ele.clear();
		ele.sendKeys(input);
	}
	public static void clickButton(WebElement ele)
	{
		WaitUtil.visibilityOfEleLocated(driver, ele);
		WaitUtil.waitForEleToBeClickable(driver, ele);
		ele.click();
		
	}
	
	public void dropDown(WebElement ele, String text)
	{
		Select drp = new Select(ele);
		drp.selectByVisibleText(text);

	}
	public static String getRandomUserName() 
	{
	
		Random r = new Random();
		int low = 10, high = 1000;
		int result = r.nextInt(high-low)+low;
		System.out.println("new user=arya"+result);
		return "arya"+result;
	}
	
	public static String ExcelReadUserName() throws IOException
	{
		excelfile = new Excelfile();
	String readData	= excelfile.readstringdata(2, 0, "Sheet1","C:\\Users\\Nikhil\\Downloads\\MavenExcelFile.xlsx");
	//System.out.println("Data= "+readData);
	return readData;
	}
	
	public static String ExcelReadPassword() throws IOException
	{
		excelfile = new Excelfile();
	String readData	= excelfile.readstringdata(2, 1, "Sheet1","C:\\Users\\Nikhil\\Downloads\\MavenExcelFile.xlsx");
	//System.out.println("Data= "+readData);
	return readData;
	}

}
