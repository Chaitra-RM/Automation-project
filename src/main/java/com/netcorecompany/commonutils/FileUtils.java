package com.netcorecompany.commonutils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class FileUtils {
	public String getPropertyKeyValue(String key) throws Throwable  {
		  
		FileInputStream fis = new FileInputStream("./TestData/CommonData.properties");
		 Properties pObj = new Properties();
		 pObj.load(fis);
		 String value = pObj.getProperty(key);
	
	return value;
}
}
