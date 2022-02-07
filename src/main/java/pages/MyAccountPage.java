package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuracao.DriverFactory;

public class MyAccountPage {
	private WebDriver driver;
	private By newKey = By.xpath("//span[text()='Create New Key']");
	public MyAccountPage() {
		driver = DriverFactory.getDriver();
	}
	
	public WebElement getNewKey() {
		return driver.findElement(newKey);
	}
}
