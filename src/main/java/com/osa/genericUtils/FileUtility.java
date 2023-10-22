package com.osa.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all the methods of properties file
 */
public class FileUtility {
	/**
	 * This method is used to fetch the value from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.propertyFilepath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
}
