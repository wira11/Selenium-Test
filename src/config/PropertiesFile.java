package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.SeleniumTestingModular;

public class PropertiesFile {
	static Properties prop= new Properties();
	
	public static void main(String[] args) {
		readPropertiesFile();
		writePropertiesFile();
	}
	
	public static void readPropertiesFile() {
		
		try {
			
			InputStream input = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\Selenium Testing\\src\\config\\config.properties");
			prop.load(input);
			SeleniumTestingModular.browser=prop.getProperty("browser");
			System.out.println(SeleniumTestingModular.browser);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writePropertiesFile() {
		try {	
			OutputStream output = new FileOutputStream("C:\\Users\\Asus\\eclipse-workspace\\Selenium Testing\\src\\config\\config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
