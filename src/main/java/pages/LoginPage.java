package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.Utils;
import configuracao.DriverFactory;

public class LoginPage {
	WebDriver driver;
	private By inputLogin = By.id("email");
	private By inputPassword = By.id("password");
	private By btnSubmit = By.xpath("//button[@type='submit']");
	public LoginPage() {
		driver = DriverFactory.getDriver();
	}
	
	public WebElement getInputLogin() {
		return driver.findElement(inputLogin);
	}
	
	public WebElement getInputPassword() {
		return driver.findElement(inputPassword);
	}
	
	public WebElement getBtnSubmit() {
		return Utils.waitToBeClickable(btnSubmit);
	}
}
