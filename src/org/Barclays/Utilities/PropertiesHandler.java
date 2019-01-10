package org.Barclays.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

	// Accept file location and gives that properties
	// Accept file location, key and provide value
	// Write into properties, accepts file location, key, value
	public Properties getProperties(String filelocation) throws IOException
	{		
		FileInputStream file=new FileInputStream(filelocation);
		Properties prop=new Properties();
		prop.load(file);	
		return prop;
		
	}
	
	public String getValue(String filelocation,String key) throws IOException
	{
		FileInputStream file=new FileInputStream(filelocation);
		Properties prop=new Properties();
		prop.load(file);		
		return prop.getProperty(key);
		
	}
	public Boolean writePropFile(String filelocation,String key,String value) throws IOException
	{
		Properties prop=new Properties();
		prop.setProperty(key, value);
		FileOutputStream fOut=new FileOutputStream(filelocation);
		prop.store(fOut, "Shashi modified");
		return true;
	}
	
	
	
}
