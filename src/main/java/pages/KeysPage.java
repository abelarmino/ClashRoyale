package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.Utils;
import configuracao.DriverFactory;

public class KeysPage {
	private WebDriver driver;
	private By token = By.xpath("//div[@class='api-key__token form-group']/div/samp");
	private By btnDelete = By.xpath("//button[@type='submit']");
	private By btnGotIt = By.xpath("//a[@role='button' and text()='Got it!']");
	public KeysPage() {
		driver = DriverFactory.getDriver();
		
	}
	
	public WebElement getToken() {
		return Utils.waitToBeVisible(driver.findElement(token));
	}
	
	public WebElement getBtnDelete() {
		return Utils.waitToBeClickable(btnDelete);
	}
	public WebElement getBtnGotIt() {
		return driver.findElement(btnGotIt);
	}
	
}
