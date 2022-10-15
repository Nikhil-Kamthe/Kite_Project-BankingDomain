package utilClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Util1 {

	
	public static String getConfigData(String key) throws IOException {
		FileInputStream file = new FileInputStream("configuration\\config.properties");
		
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
	}
	
	
	
	
}
