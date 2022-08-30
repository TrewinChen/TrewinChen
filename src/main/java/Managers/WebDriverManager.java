package Managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	private WebDriver webdriver;
	private static String driverType;
	private static String environmentType;
	
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
//		if(webdriver == null) {
//			return webdriver = createDriver();
//		}else {
//			throw new RuntimeException("Cannot find webdriver");
//		}
		switch(environmentType) {
		case "local":
			webdriver = createDriver();
		case "remote":
			break;
		}
		
		return webdriver;
	}
	
	public WebDriver createDriver() {
		switch(driverType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
			webdriver = new ChromeDriver();
		case "edge":
			break;
		}
		
		if(FileReaderManager.getInstance().getConfigReader().getWindowSize()) {
			webdriver.manage().window().maximize();
		}
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicityWait()));
	
		return webdriver;
	}
	
	public void closeDriver() {
		webdriver.quit();
	}
	
}
