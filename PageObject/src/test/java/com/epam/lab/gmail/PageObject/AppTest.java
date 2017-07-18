package com.epam.lab.gmail.PageObject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest {
	private WebDriver driver;
	private final String login = "smtp.epam.gr3";
	private final String password = "taepamgr3";

	@BeforeClass
	public void beforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver() {
			{
				manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				get("https://mail.google.com/mail/");
			}
		};
	}

	@Test(priority = 1)
	public void loginTest() throws Exception {
		GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
		gmailLoginPage.enterLoginAndSend(login);
		GmailPasswordPage gmailPasswordPage = new GmailPasswordPage(driver);
		gmailPasswordPage.enterPasswordAndSend(password);
		GmailAccept accept = new GmailAccept(driver);
		Assert.assertEquals(accept.acceptLogin(), login + "@gmail.com");
	}

	@Test(priority = 2)
	public void deleteTest() throws Exception {
		GmailInbox gmailInbox = new GmailInbox(driver);
		gmailInbox.selectThreeCheckbox();
		gmailInbox.deleteSelectedMessage();
		gmailInbox.undoDeleteOperation();
		GmailAccept accept = new GmailAccept(driver);
		Assert.assertTrue(accept.acceptUndoDelete());
	}
}
