package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.Utils;
import configuracao.DriverFactory;

public class MyAccountPage {
	private WebDriver driver;
	private By newKey = By.xpath("//span[text()='Create New Key']");
	private String newKeyXpath = "//h4[@class='api-key__name' and text()='";
	private By alert = By.xpath("//ul[@class='api-keys']");
	public MyAccountPage() {
		driver = DriverFactory.getDriver();
	}
	
	public WebElement getNewKey() {
		return Utils.waitToBeClickable(newKey);
	}
	
	public WebElement getExistingKeyName(String keyName) {
		return Utils.waitToBeClickable(By.xpath(newKeyXpath+keyName+"']"));
	}
	
	
}
