package com.epam.lab.gmail.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPasswordPage {
	@FindBy(xpath = "//input[@type='password']")
	private WebElement inputPassword;

	@FindBy(xpath = "//div[@id='passwordNext']")
	private WebElement passwordNext;

	public GmailPasswordPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
	}

	public void enterPasswordAndSend(String login) {
		
		inputPassword.sendKeys(login);
		passwordNext.click();
	}
}
