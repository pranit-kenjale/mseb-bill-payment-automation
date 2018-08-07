package com.mseb.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility for reading properties/config file
 * 
 * @author Horus
 *
 */
public class PropertyReader {
	
	private static Properties properties = null;
//	private static Logger LOG = LoggerFactory.getLogger(PropertyReader.class);
	
	static{
		loadAllProperties();
	}
	
	/**
	 * Load properties/config file
	 *
	 */
	private static void loadAllProperties(){
	//	LOG.info("Loading config.properties!");
		properties = new Properties();
		try{
			properties.load(new FileInputStream(new File(PropertyReader.class.getResource("/com/mseb/framework/config/config.properties").toURI())));
	//		LOG.info("Loaded config.properties successfully!");
		}catch(IOException e){
	//		LOG.error("Exception occurred while loading config.properties file!", e);
		}catch(URISyntaxException e){
	//		LOG.error("URISyntaxException occurred while loading config.properties file!", e);
		}		
		
	}
	
	
	/**
	 *Return the value of the requested property name
	 * 
	 */
	public static String readItem(String propertyName){
		return properties.getProperty(propertyName);
	}
	

}
