package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property_Util_Bedroom {
	
	/**
	 * This method will open Header.Properties and return value associate with
	 * key
	 * 
	 * @param key
	 * @return value in form of{@code String}
	 */
	public static String get_Property(String key) {
		String value = null;
		FileInputStream fis;
		
		try {
			 fis = new FileInputStream("src\\main\\resources\\BedroomPage.properties");
			Properties prop= new Properties();
			prop.load(fis);
					value = prop.getProperty(key);
		} catch (IOException e) {
			System.out.println("Unable to load Properties File)");
			e.printStackTrace();
		}
		return value;
		}

}
