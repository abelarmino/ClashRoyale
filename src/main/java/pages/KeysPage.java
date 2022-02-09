package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuracao.DriverFactory;

public class KeysPage {
	private WebDriver driver;
	private By token = By.xpath("//div[@class='api-key__token form-group']/div/samp");
	
	public KeysPage() {
		driver = DriverFactory.getDriver();
		
	}
	
	public WebElement getToken() {
		return driver.findElement(token);
	}

}
