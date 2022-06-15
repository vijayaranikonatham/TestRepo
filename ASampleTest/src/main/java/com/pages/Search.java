package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {

	private WebDriver driver;

	// 1. By Locators: OR
	private By menu=By.id("nav-link-accountList-nav-line-1");
	private By emailId = By.name("email");
	private By continueButton=By.id("continue");
	private By password = By.name("password");
	private By signInButton = By.id("signInSubmit");
	private By forgotPwdLink = By.linkText("Forgot your password?111");

	// 2. Constructor of the page class:
	public Search(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public void clickOnMenu() {
		driver.findElement(menu).click();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	public void clickOnContinue() {
		driver.findElement(continueButton).click();
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	

}
