package com.mseb.framework.billpay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mseb.framework.TestBase;

/**
 * MSEB login & bill payment
 * 
 * @author Horus
 *
 */
public class TestMSEBBillPayment extends TestBase {

	@Test
	public void foo() throws InterruptedException {

		// System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver",
		//		"E:\\Java Workspace\\MSEBBillPaymentAutomation\\mseb\\resources\\com\\mseb\\framework\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","src/main/resources/com/mseb/framework/drivers/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");

		//final String propFile = System.getProperty("user.dir") + "\\mseb\\resources\\config.properties";
		File file = new File("E:\\Java Workspace\\MSEBBillPaymentAutomation\\mseb\\resources\\config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//WebDriver webDriver = new InternetExplorerDriver();
		WebDriver webDriver = new ChromeDriver();

		// launch Fire fox and direct it to the Base URL
		// webDriver.get("https://wss.mahadiscom.in/wss/wss?uiActionName=getCustAccountLogin");
		webDriver.get(prop.getProperty("baseUrl"));

		// maximize the browser window
		webDriver.manage().window().maximize();

		Thread.sleep(2000);

		WebElement loginName = webDriver.findElement(By.name("loginId"));
		WebElement password = webDriver.findElement(By.name("password"));
		WebElement loginButton = webDriver.findElement(By.id("lblLoginButton"));


		
		
		loginName.sendKeys(prop.getProperty("loginName"));	//getting values from config.properties
		password.sendKeys(prop.getProperty("password"));

		loginButton.click();

		Thread.sleep(2000);

		WebElement selectBillRadioButton = webDriver.findElement(By.id("radCustList"));
		WebElement paymentButton = webDriver.findElement(By.xpath("//*[@id='Label1']"));
		selectBillRadioButton.click();
		paymentButton.click();
		
		WebElement selectAgreeCheckbox = webDriver.findElement(By.id("agree"));
		WebElement payNowButton = webDriver.findElement(By.id("paynowbutton"));
		selectAgreeCheckbox.click();
		payNowButton.click();

		Thread.sleep(2000);
		
        String alertMessage = webDriver.switchTo().alert().getText();
        webDriver.switchTo().alert().accept();
        
        System.out.println("Alert says: " + alertMessage);
       
        payNowButton.sendKeys(Keys.CONTROL + "\t");
        
        Thread.sleep(2000);
        
        
/*        String currentTab = webDriver.getWindowHandle();
        for (String tab : webDriver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                webDriver.switchTo().window(tab); 
            }       
        }*/
        
        //code to handle links opening in a New Tab
      /*  ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        System.out.println(webDriver.getTitle());*/
        
        
        
        
        
        
        
        
        System.out.println("New Tab Opened!!!");
        WebElement selectInternetBankingRadioButton = webDriver.findElement(By.id("radio3")); 	//*[@id="radio3"]
        selectInternetBankingRadioButton.click();
        
		WebElement selectICICIBankRadioButton = webDriver.findElement(By.xpath("//input[@value='BILLD_ICI']")); //*[@id='netbanking']/div[49]/input
		WebElement finalPayNowButton = webDriver.findElement(By.id("submitbutton"));	//*[@id="submitbutton"]

        
        String finalPayNowButtonText = finalPayNowButton.getText();
        System.out.println("Final Pay Now Button Text = " + finalPayNowButtonText);
        
      //  Assert.assertEquals(finalPayNowButtonText, "Pay Now", "Test Case Failed!");
        
        
        selectICICIBankRadioButton.click();
        finalPayNowButton.click();
        
        System.out.println("\nFinal 'Pay Now' Button is clicked!!!");
        
        Thread.sleep(2000);
		
        
      //  webDriver.close();
      //  webDriver.switchTo().window(currentTab);
        

	}
}
