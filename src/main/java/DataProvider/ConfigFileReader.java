package DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties prop;
	private final String propertyFilePath = "Configs//Configuration.properties";
	
	public ConfigFileReader() {
		
		try {
			FileReader fReader = new FileReader(propertyFilePath); 
			prop = new Properties();
			prop.load(fReader);
			
		}catch(FileNotFoundException fn) {
			fn.printStackTrace();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getDriverPath() {
		String driverPath = prop.getProperty("driverPath");
		if(driverPath != null) {
			return driverPath;
		}else {
			throw new RuntimeException("DriverPath is not specified in the configuration file");
		}
	}
	
	public String getApplicationURL() {
		String appURL = prop.getProperty("URL");
		if(appURL != null) {
			return appURL;
		}else {
			throw new RuntimeException("URL is not specified in the configuration file");
		}
	}
	
	public String getEnvironment() {
		String environment = prop.getProperty("environment");
		if(environment != null) {
			return environment;
		}else {
			throw new RuntimeException("environment is not specified in the configuration file");
		}
	}
	
	public String getBrowser() {
		String browser = prop.getProperty("browser");
		if(browser != null) {
			return browser;
		}else {
			throw new RuntimeException("browser is not specified in the configuration file");
		}
	}
	
	public Boolean getWindowSize() {
		String windowSize = prop.getProperty("WindowMax");
		if(windowSize != null) {
			return Boolean.valueOf(windowSize);
		}else
			return true;
	}
	
	public long getImplicityWait() {
		String implWait = prop.getProperty("implicityWait");
		if(implWait != null) {
			return Long.parseLong(implWait);
		}else {
			throw new RuntimeException("implicityWait is not specified in the configuration file");
		}	
	}
	
	public String getDBUrl() {
		String dbURL = prop.getProperty("sqldataURL");
		if(dbURL != null) {
			return dbURL;
		}else {
			throw new RuntimeException("sqldataURL is not specified in the configuration file");
		}
	}
	
	public String getDBUserName() {
		String dbUser = prop.getProperty("sqlUserName");
		if(dbUser != null) {
			return dbUser;
		}else {
			throw new RuntimeException("sqlUserName is not specified in the configuration file");
		}
	}
	
	public String getDBPassword() {
		String dbPassword = prop.getProperty("sqlPassword");
		if(dbPassword != null) {
			return dbPassword;
		}else {
			throw new RuntimeException("sqlPassword is not specified in the configuration file");
		}
	}
	
	public String getRecordSet() {
		String recordSet = prop.getProperty("RecordSet");
		if(recordSet != null) {
			return recordSet;
		}else {
			throw new RuntimeException("RecordSet is not specified in the configuration file");
		}
	}
}
