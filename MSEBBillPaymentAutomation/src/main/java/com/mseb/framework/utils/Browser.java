package com.mseb.framework.utils;

import java.io.File;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {

	//	private static Logger LOG = LoggerFactory.getLogger(Browser.class);
	private static String baseUrl = "";
	private static WebDriver webDriver = null;

	public static void initialize(String browser) {
		baseUrl = PropertyReader.readItem("baseUrl"); // utility -> PropertyReader
														
		try {
			webDriver = getWebDriver(browser);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	//		LOG.error("URI Syntax Error occurred while initializing the driver!", e);
		}

	//	LOG.info("****Initialization for {} browser with URL - {} ****", browser, baseUrl);
	}

	private static WebDriver getWebDriver(final String browserType) throws URISyntaxException {
	//	LOG.debug("{} capabilities initialized!", browserType);

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Chrome Driver
		if (BrowserType.CHROME.equalsIgnoreCase(browserType)) {
			File file = new File(Browser.class.getResource("/com/mseb/framework/drivers/chromedriver.exe").toURI());
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			capabilities = DesiredCapabilities.chrome();
		}
		// Internet Explorer Driver
		else if (BrowserType.IE.equalsIgnoreCase(browserType)) {
			File file = new File(Browser.class.getResource("/com/mseb/framework/drivers/IEDriverServer.exe").toURI());
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			capabilities = DesiredCapabilities.internetExplorer();
		}
		// Firefox Driver
		else if (BrowserType.FIREFOX.equalsIgnoreCase(browserType)) {
			//File file = new File(Browser.class.getResource("/com/mseb/framework/drivers/geckoDriver.exe").toURI());
			//System.setProperty("webdriver.firefox.driver", file.getAbsolutePath());
			capabilities = DesiredCapabilities.firefox();

		}
		
		webDriver = WebDriverFactory.createWebDriver(capabilities, browserType);
		webDriver.get(baseUrl);
		
		return webDriver;

	}

	public static String getTitle() {
		return webDriver.getTitle();
	}

	public static WebDriver getDriver() {
		return webDriver;
	}

	public static void close() {
		webDriver.close();
	}

	public static void quit() {
		webDriver.quit();
	}

}
