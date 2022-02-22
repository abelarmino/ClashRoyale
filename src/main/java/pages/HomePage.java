package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Utils;
import configuracao.DriverFactory;

public class HomePage {
	private WebDriver driver;
	private By myAccount = By.xpath("//ul[@class='dropdown-menu']/li/a[@href='#/account']");
	
	public HomePage() {
		driver = DriverFactory.getDriver();
	}
	
	public  WebElement getDropdownName(String name) {
		return Utils.waitToBeClickable(By.xpath("//span[text()='"+name+"']"));
		}
	
	public WebElement getMyAccount() {
		return Utils.waitToBeClickable(myAccount);
	}
	
}
