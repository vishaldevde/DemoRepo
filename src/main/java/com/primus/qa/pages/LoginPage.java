package com.primus.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primus.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory - OR
	@FindBy(name="txtuId")
	WebElement userName;
	
	@FindBy(name="txtPword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pwd)
	{
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	

}
