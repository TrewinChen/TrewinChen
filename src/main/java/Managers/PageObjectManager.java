package Managers;

import org.openqa.selenium.WebDriver;

import PageObjectRepo.LoginPage;

public class PageObjectManager {
	private WebDriver webdriver;
	private LoginPage loginPage;
	
	public PageObjectManager(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public LoginPage getLoginPage() {
		if(loginPage == null) {
			return new LoginPage(webdriver);
		}else {
			return loginPage;
		}
			
	}
}
