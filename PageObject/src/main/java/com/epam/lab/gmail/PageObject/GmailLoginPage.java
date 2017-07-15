package com.epam.lab.gmail.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
	@FindBy(xpath="//input[@name='identifier']")
	private WebElement inputLogin;
	
	@FindBy(xpath="//div[@id='identifierNext']")
	private WebElement buttonNext;
	
	public GmailLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterLoginAndSend(String login){
		inputLogin.sendKeys(login);
		buttonNext.click();
	}
}
