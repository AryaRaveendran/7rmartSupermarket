package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

public class Baseclass {

	public static WebDriver driver;
	
	public static Properties prop;

	@BeforeSuite
	public void initilization()
	{
		prop = new Properties();
       // File file = new File("C:\\Users\\Nikhil\\eclipse-workspace\\Page_Factory\\src\\main\\java\\com\\qa\\confi\\config.properties");
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\confi\\config.properties");

        try {
            FileInputStream inputStream = new FileInputStream(file);

            prop.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        } catch (FileNotFoundException fie) {
            fie.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil\\eclipse-workspace\\Page_Factory\\Driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("Edge"))
		{
		

		System.setProperty("webdriver.edge.driver", "C:\\Users\\Nikhil\\eclipse-workspace\\Page_Factory\\Driver\\msedgedriver.exe");
		driver=new EdgeDriver();
		}

		
	/*	if(prop.getProperty("browser").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil\\eclipse-workspace\\Page_Factory\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("Edge"))
		{
		

		System.setProperty("webdriver.edge.driver", "C:\\Users\\Nikhil\\eclipse-workspace\\Page_Factory\\Driver\\msedgedriver.exe");
		driver=new EdgeDriver();
		}*/
//webdriver gecko for firefox

		driver.get(prop.getProperty("url"));
				//System.out.println(prop.getProperty("username1"));

		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
}
