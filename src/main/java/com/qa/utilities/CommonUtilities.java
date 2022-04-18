package com.qa.utilities;

import org.openqa.selenium.WebElement;

import com.qa.base.Baseclass;

public class CommonUtilities extends Baseclass {
	
	public String alertMessage(WebElement successmsg)
	{
		String successMessage=successmsg.getText();
		String trimMsg=successMessage.trim();
		String arr[]=trimMsg.split(" ",2);
		String theRest = arr[1];
		return theRest ;
		
		

	}

}
