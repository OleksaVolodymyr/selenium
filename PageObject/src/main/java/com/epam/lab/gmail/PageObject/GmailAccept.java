package com.epam.lab.gmail.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailAccept {
	@FindBy(xpath = "//a[@class='gb_b gb_db gb_R']")
	private WebElement userInfo;
	
	@FindBy(xpath = "//span[@class='bofITb']")
	private WebElement undoDelete;
	
	public GmailAccept(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public String acceptLogin(){
		return userInfo.getAttribute("title");
	}
	
	public boolean acceptUndoDelete(){
		return undoDelete.isDisplayed();
	}
}
