package PageObjectRepo;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Managers.FileReaderManager;


public class LoginPage {

		public WebDriver loginPageDriver;
		
		public LoginPage(WebDriver inputWebDriver) {
			this.loginPageDriver= inputWebDriver;
			PageFactory.initElements(inputWebDriver, this);
		}
		
		@FindBy(how=How.XPATH, using="//input[@name='g2599-name']")
		WebElement userName;
	
		@FindBy(how=How.CSS, using="input[name='g2599-email']")
		WebElement userEmail;
		
		@FindBy(how=How.ID, using="g2599-website")
		WebElement userURL;
		
		@FindBy(how=How.CSS, using="#g2599-experienceinyears")
		WebElement userSelectYears;
		
		@FindBy(how=How.CLASS_NAME, using="checkbox-multiple")
		private List<WebElement> userExpertise;
		
		@FindBy(how=How.CSS, using="input[name='g2599-education']")
		List<WebElement> userEducation;
		
		@FindBy(how=How.CSS, using="textarea[name='g2599-comment']")
		WebElement userComment;
		
		public WebElement userName() {
			return userName;
		}
		
		public WebElement userEmail() {
			return userEmail;
		}
		
		public WebElement userURL() {
			return userURL;
		}
		
		public Select userSelectYears() {
			Select Years = new Select(userSelectYears);
			//Years.selectByVisibleText(in);
			//Years.selectByIndex(Integer.parseInt(in));
			
			return Years;
		}
		
		public List<WebElement> userExpertise() {
			return userExpertise;
		}
		
		public List<WebElement> userEducation() {
			return userEducation;
		}
		
		public WebElement comments() {
			return userComment;
		}
		
		public void navigatePage() {
			loginPageDriver.get(FileReaderManager.getInstance().getConfigReader().getApplicationURL());
		}
		
		public Actions actionElement() {
			Actions action = new Actions(loginPageDriver);
			return action;
		}
		
		public void scrollPageDown(String pixelY) {
			JavascriptExecutor js = (JavascriptExecutor) loginPageDriver;
			js.executeScript("window.scrollBy(0," + pixelY + " )", "");
		}
}
