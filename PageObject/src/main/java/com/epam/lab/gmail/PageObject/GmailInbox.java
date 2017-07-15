package com.epam.lab.gmail.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailInbox {
	@FindBy(xpath = "//div[@class='T-Jo-auh']")
	private List<WebElement> checkbox;
	
	@FindBy(xpath = "//div[@class='ar9 T-I-J3 J-J5-Ji']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//span[@id='link_undo']")
	private WebElement undoButtron;

	public GmailInbox(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectThreeCheckbox(){
		for (int i = 1; i <= 3; i++) {
			if (!checkbox.get(i).isSelected()) {
				checkbox.get(i).click();
			}
		}
	}
	
	public void deleteSelectedMessage(){
		deleteButton.click();
	}
	
	public void undoDeleteOperation(){
		undoButtron.click();
	}
}
