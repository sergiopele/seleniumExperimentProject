package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

abstract class ConfigReader {
	private static Properties prop;
	
	public static Properties readProperties(String filepath) {
		try {
			
			FileInputStream file = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(file);
			
		} catch (IOException f) {
			f.printStackTrace();
		}
		return prop;
	}
	
	public static String getProperty(String target) {
		return prop.getProperty(target);
	}
}
