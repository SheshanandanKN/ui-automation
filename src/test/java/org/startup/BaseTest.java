package org.startup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.automationtesting.excelreport.Xl;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public abstract class BaseTest implements IAutoConst {

	public static WebDriver driver;
	//protected static WebDriver driver;
	
	
	//private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
	
	static 
	{
		System.setProperty(CHROME_KEY,CHROME_VAL);
		//System.setProperty(CHROME_KEY,"/home/qualitrix/Documents/diksha-backup_27 Dec/drivers/chromedriver");
	}

	@BeforeMethod(alwaysRun = true)
	public void openApplication() throws IOException, InterruptedException 
	{
		System.out.println("Test Execution Started : Opening the browser");
		driver = new ChromeDriver(); 
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.get(AUTO_APP_URL);MerMerged from Ajitged from Ajit
		driver.get(APP_URL);
		System.out.println("Scripts are executing on "+driver.getCurrentUrl());
		
	}

	@AfterMethod(alwaysRun = true)
	public void closeApplication() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		driver.quit();
		System.out.println("Test Execution Completed : Closing the browser");
		
	}
	
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	/*@AfterSuite(alwaysRun = true)
	public void generateExcelReportFromTestngresult() throws Exception
    {
     Xl.generateReport("excel-report.xlsx");
    }*/
}

