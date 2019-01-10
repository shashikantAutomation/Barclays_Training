package org.Barclays.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
	//Shashi changed
	WebDriver driver; 
	WebDriverWait wait;
	@FindBy(linkText=("My Account"))
	public WebElement myAccLoc;
	
	public HomePage(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnMyAccount(WebDriver driver)
	{
		
		(myAccLoc).click();
		
	}
	
	
}
