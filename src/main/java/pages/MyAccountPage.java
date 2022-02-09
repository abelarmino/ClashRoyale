package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuracao.DriverFactory;

public class MyAccountPage {
	private WebDriver driver;
	private By newKey = By.xpath("//span[text()='Create New Key']");
	private String newKeyXpath = "//h4[@class='api-key__name' and text()='";
	public MyAccountPage() {
		driver = DriverFactory.getDriver();
	}
	
	public WebElement getNewKey() {
		return driver.findElement(newKey);
	}
	
	public WebElement getExistingKeyName(String keyName) {
		return driver.findElement(By.xpath(newKeyXpath+keyName+"']"));
	}
}
