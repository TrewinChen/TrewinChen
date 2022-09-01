package stepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ArrangeManager.ScenarioProvider;
import ArrangeManager.ScheduleManager;
import DataProvider.DataReader;
import Managers.FileReaderManager;
import PageObjectRepo.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinitions {
	ScheduleManager scheduleManager;
	LoginPage loginPage;
	ScenarioProvider getProviderData;
	
	public loginStepDefinitions(ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
		loginPage = scheduleManager.getPageObjectManager().getLoginPage();
		DataReader dataReader = new DataReader();
		getProviderData = dataReader.getConnectionResult();
	}

	@Given("The Page is displayed")
	public void the_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		loginPage.navigatePage();
		System.out.println("Login page is shown");
	}

	@When("I enter the username with {string}")
	public void i_enter_the_username_with(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Entering username");
	   // Object strName = scheduleManager.getscenarioProvider().getContext("Name");
	    Object strName = getProviderData.getContext("Name");
	    loginPage.userName().sendKeys(String.valueOf(strName));
	}

	@When("I enter the email with {string}")
	public void i_enter_the_email_with(String string) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.userEmail().sendKeys(string);
	}

	@When("I enter the website with {string}")
	public void i_enter_the_website_with(String string) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.userURL().sendKeys(string);
	}

	@When("I select the years of experience")
	public void i_select_the_years_of_experience() {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.userSelectYears().selectByIndex(1);
	}

	@When("I choose the expertise")
	public void i_choose_the_expertise() {
	    // Write code here that turns the phrase above into concrete actions
		for(WebElement eachElement: loginPage.userExpertise()) {
			if(eachElement.getAttribute("value") != null)
				eachElement.click();
		}
	}

	@When("I choose the education")
	public void i_choose_the_education() {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.scrollPageDown("250");
		
		Actions actions = loginPage.actionElement();
		for(int i =0; i < loginPage.userEducation().size(); i++) {
			System.out.println(loginPage.userEducation().get(i).getAttribute("value"));
			if(loginPage.userEducation().get(i).getAttribute("value").equalsIgnoreCase("Post Graduate")) {
				System.out.println("number?");
				
				actions.moveToElement(loginPage.userEducation().get(i)).click().perform();
				loginPage.userEducation().get(i).click();
			}
		}

	}

	@When("I enter the comments with:")
	public void i_enter_the_comments_with(String docString) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Entering comment in comments field.");
		loginPage.comments().sendKeys(docString);
	}

	@Then("I click on the submit button")
	public void i_click_on_the_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Pending for button clicking...");
		System.out.println("To click or not to click.");
	}
	
}
