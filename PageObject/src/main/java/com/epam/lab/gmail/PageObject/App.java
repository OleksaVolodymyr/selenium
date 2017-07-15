package com.epam.lab.gmail.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(){
        	{
        		manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        		get("https://mail.google.com/mail/");
        	}
        };
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.enterLoginAndSend("smtp.epam.gr3");
        GmailPasswordPage gmailPasswordPage = new GmailPasswordPage(driver);
        gmailPasswordPage.enterPasswordAndSend("taepamgr3");
        GmailInbox gmailInbox = new GmailInbox(driver);
        gmailInbox.selectThreeCheckbox();
        gmailInbox.deleteSelectedMessage();
        gmailInbox.undoDeleteOperation();
        GmailAccept accept = new GmailAccept(driver);
       System.out.println( accept.acceptUndoDelete());
    }
}
