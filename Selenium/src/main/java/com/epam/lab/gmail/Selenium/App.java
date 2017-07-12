package com.epam.lab.gmail.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(gmailSelenium());
	}

	public static String gmailSelenium() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/mail/");
		driver.findElement(By.name("identifier")).sendKeys("smtp.epam.gr3");
		driver.findElement(By.id("identifierNext")).click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("taepamgr3");
		driver.findElement(By.id("passwordNext")).click();
		List<WebElement> checkbox = (List<WebElement>) driver.findElements(By.className("T-Jo-auh"));
		for (int i = 1; i <= 3; i++) {
			if (!checkbox.get(i).isSelected()) {
				checkbox.get(i).click();
			}
		}
		driver.findElement(By.xpath("//div[@class='ar9 T-I-J3 J-J5-Ji']")).click();
		driver.findElement(By.id("link_undo")).click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ts:last-child")));
		WebElement succes = driver.findElement(By.className("bofITb"));
		return (succes.isDisplayed() ? succes.getText() : "Fail");
	}
}
