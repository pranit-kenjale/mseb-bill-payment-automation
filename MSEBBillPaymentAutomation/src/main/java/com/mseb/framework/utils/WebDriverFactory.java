package com.mseb.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Webdriver Factory - Returns webdriver based on the requested browser type
 * 
 * @author Horus
 *
 */
public class WebDriverFactory {

	// private static Logger LOG = LoggerFactory.getLogger(WebDriverFactory.class);

	/**
	 * Method to set the Webdriver
	 * 
	 */
	public static WebDriver createWebDriver(DesiredCapabilities capabilities, String browser) {

		//LOG.info("Initializing webdriver for browser {}", browser);
		
		WebDriver webDriver = null;

		if (BrowserType.CHROME.equalsIgnoreCase(browser)) {
			webDriver = new ChromeDriver(capabilities);
		} else if (BrowserType.FIREFOX.equalsIgnoreCase(browser)) {
			webDriver = new FirefoxDriver(capabilities);
		} else if (BrowserType.IE.equalsIgnoreCase(browser)) {
			webDriver = new InternetExplorerDriver(capabilities);
		}

		return webDriver;
	}

}
