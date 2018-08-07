package com.mseb.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mseb.framework.utils.Browser;
import com.mseb.framework.utils.PropertyReader;

/**
 * This class represents the login page and all its events
 * 
 * @author Horus
 *
 */
public class LoginPage {
	
	@FindBy(how = How.NAME, name="loginID")
	private WebElement usernameTextField;
	
	//WebElement usernameTextField = Browser.getDriver().findElement(By.id("loginId"));
	WebElement passwordTextField = Browser.getDriver().findElement(By.id("password"));	//*[@id='loginButton']
	WebElement logInButton = Browser.getDriver().findElement(By.id("loginButton"));
	
	
	public void logIn(String uName, String pwd){
		usernameTextField.sendKeys(uName);
		passwordTextField.sendKeys(pwd);
		logInButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Maximize the window
		Browser.getDriver().manage().window().maximize();
	}
	
	

}
