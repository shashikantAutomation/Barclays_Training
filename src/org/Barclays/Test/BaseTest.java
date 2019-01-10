package org.Barclays.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.Barclays.Pages.CustomerLoginPage;
import org.Barclays.Pages.HomePage;
import org.Barclays.Utilities.PropertiesHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
	static WebDriver driver=null;
	static WebDriverWait wait=null;
	public static JavascriptExecutor js=null;
	static String filelocation="./Utility/data.properties";
	PropertiesHandler prophandle;
	Properties prop;
	/*@Test
	public void test() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.121.1:4441/wd/hub"),cap);
		driver.get("hhtp://google.com");
		
	}*/
	
	public  void seleniumLoginMagento() throws IOException
	{	
		prophandle.getProperties(filelocation);
		driver.get(prophandle.getValue(filelocation, "url"));
		System.out.println(driver.getTitle());		
	}
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Resources\\geckodriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("-disable-notifications");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		js=(JavascriptExecutor)driver;
		prophandle=new PropertiesHandler();
	}
	@Test(priority=1)
	public void positiveCredChek() throws IOException {
		// TODO Auto-generated method stub
		PropertiesHandler prophandle=new PropertiesHandler();
		prop=prophandle.getProperties(filelocation);		
		seleniumLoginMagento();
		HomePage homobj=new HomePage(driver,wait);
		CustomerLoginPage custlogin=new CustomerLoginPage(driver);
		homobj.clickOnMyAccount(driver);
		custlogin.enteremail(prop.getProperty("username"));
		custlogin.enterpwd(prop.getProperty("password"));
		custlogin.clickLogin();
	}

}
