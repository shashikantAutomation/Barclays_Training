package org.Barclays.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {

	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(how=How.ID ,using="email")
	WebElement email1;
	
	
	@FindBy(id="pass")
	WebElement pass;
	@FindBy(name="send")
	WebElement send;
	
	@FindAll(@FindBy(tagName="a"))
	List<WebElement> links;
	
	WebDriver driver;
	public CustomerLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void enteremail(String emailcontent)
	{
		(email).sendKeys(emailcontent);
	}
	public void enterpwd(String pwdContent)
	{
		pass.sendKeys(pwdContent);
	}
	public void clickLogin()
	{
		send.click();
	}
	public int getlinks()
	{
		return links.size();
	}
}
