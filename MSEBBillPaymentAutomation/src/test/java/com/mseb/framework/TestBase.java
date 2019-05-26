package com.mseb.framework;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.mseb.framework.pages.Pages;
import com.mseb.framework.utils.Browser;
import com.mseb.framework.utils.PropertyReader;

/**
 * Base class for all MSEB pages
 * 
 * @author Horus
 * 
 */
public class TestBase {	
	/**
	 *Method to initialize webdriver based on the parameter 'browser'. This parameter will be set in 'testng.xml'.
	 * 
	 */
//	@Parameters("browser")
	@BeforeSuite
	protected void setUp(){						//(@Optional("chrome") String browser) {

		String browser="chrome";
		Browser.initialize(browser);
		Pages.getLoginPage().logIn("test", "test"); // MSEB credentials

	}

	@AfterMethod
	protected void tearDown(ITestResult result) throws Exception {
		captureScreenShotInCaseOfFailure(result);
	}

	
	/**
	 * Method to capture screenshot in case of failure
	 *
	 */
	private void captureScreenShotInCaseOfFailure(ITestResult result) {
		if(result.isSuccess()){
			return;			
		}
		
		if(Boolean.parseBoolean(PropertyReader.readItem("isScreenCaptureAllowed"))){
			//code to capture screenshot of failed test case
		}
		
	}

	@AfterSuite
	protected void browserExit() {

		Browser.getDriver().quit();
		Pages.destroy(); // pages.clear();
		Browser.close(); // webDriver.close();
		Browser.quit(); // webDriver.quit();
	}

}
