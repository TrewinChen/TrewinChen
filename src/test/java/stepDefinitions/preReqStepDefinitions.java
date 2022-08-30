package stepDefinitions;

import org.openqa.selenium.WebDriver;

import ArrangeManager.ScheduleManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class preReqStepDefinitions {
	ScheduleManager scheduleManager;
	
	public preReqStepDefinitions(ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
	}
	
	@Before
	public void beforeScenario() {
		System.out.println("Starting up...");
	}
	
	@After
	public void afterScenario() {
		scheduleManager.getWebDriverManager().closeDriver();
	}
}
