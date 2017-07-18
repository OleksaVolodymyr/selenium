package com.epam.lab.gmail.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailAccept {
	@FindBy(xpath = "//div[@class='gb_wb']")
	private WebElement userInfo;
	
	@FindBy(xpath = "//span[@class='gb_8a gbii']")
	private WebElement picture;
	
	@FindBy(xpath = "//span[@class='bofITb']")
	private WebElement undoDelete;
	
	public GmailAccept(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public String acceptLogin(){
		picture.click();
		return userInfo.getText();
	}
	
	public boolean acceptUndoDelete(){
		return undoDelete.isDisplayed();
	}
}
