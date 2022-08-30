package ArrangeManager;

import DataProvider.DataReader;
import Managers.PageObjectManager;
import Managers.WebDriverManager;

public class ScheduleManager {
	private WebDriverManager webdrivermanager;
	private PageObjectManager pageobjectmanager;
	//private ScenarioProvider scenarioprovider;
	
	public ScheduleManager() {
		webdrivermanager = new WebDriverManager();
		pageobjectmanager = new PageObjectManager(webdrivermanager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager() {
		return webdrivermanager; 
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageobjectmanager;
	}
	
//	public ScenarioProvider getscenarioProvider() {
//		return scenarioprovider;
//	}
	
}
