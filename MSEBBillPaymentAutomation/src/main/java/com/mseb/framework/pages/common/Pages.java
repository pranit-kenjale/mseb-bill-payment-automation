package com.mseb.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.mseb.framework.utils.Browser;

/**
 * Contains all the pages present on the site. It acts like a Page Factory
 * 
 * @author Horus
 *
 */
public class Pages{
	private static List<Object> pages = new ArrayList<Object>();
	

	/**
	 *Method will return the requested page
	 * 
	 */
	public static <T> T getPage(Class<T> clazz){
		for(Object page : pages){
			if(page.getClass() == clazz){
				return (T) page;
			}
		}		
		T page = PageFactory.initElements(Browser.getDriver(), clazz);
		pages.add(page);
		return page;
	}
	
	/**
	 *Clear the list Object holding all the Pages
	 * 
	 */	
	public static void destroy(){
		pages.clear();
	}
	
	/**
	 *Return login page
	 * 
	 */
	public static LoginPage getLoginPage(){
		return getPage(LoginPage.class);
	}

}

