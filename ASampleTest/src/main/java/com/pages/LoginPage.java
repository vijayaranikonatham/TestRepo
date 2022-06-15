package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By menu=By.id("nav-link-accountList-nav-line-1");
	private By emailId = By.name("email");
	private By continueButton=By.id("continue");
	private By password = By.name("password");
	private By signInButton = By.id("signInSubmit");
	private By search = By.id("twotabsearchtextbox");
	private By productCost=By.xpath(".//*[@class='sg-col-inner']//div[@class='a-section a-spacing-small a-spacing-top-small']//*[@class='sg-row']//child::div[@class='a-row a-size-base a-color-base']");

		public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
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
	public void search(String searchText) {
		driver.findElement(search).sendKeys(searchText);
		driver.findElement(search).sendKeys(Keys.ENTER);
	}
	public  List<WebElement> productCost() {
		List<WebElement> Li=driver.findElements(productCost);
		return Li;
	}
	

}
