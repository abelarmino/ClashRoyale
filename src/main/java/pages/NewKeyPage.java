package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuracao.DriverFactory;

public class NewKeyPage {
	private WebDriver driver;
	private By name = By.id("name");
	private By description = By.id("description");
	private By ip = By.id("range-0");
	private By btnSubmit = By.xpath("//button[@type='submit']");
	
	public NewKeyPage() {
		driver = DriverFactory.getDriver();
	}
	
	public WebElement getName() {
		return driver.findElement(name);
	}
	public WebElement getDescription() {
		return driver.findElement(description);
	}
	public WebElement getIp() {
		return driver.findElement(ip);
	}
	public WebElement getBtnSubmit() {
		return driver.findElement(btnSubmit);
	}
	
}
