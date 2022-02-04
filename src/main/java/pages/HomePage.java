package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuracao.DriverFactory;

public class HomePage {
	private WebDriver driver;
	
	public HomePage() {
		driver = DriverFactory.getDriver();
	}
	public WebElement getDropdownName(String name) {
		return driver.findElement(By.xpath("//span[text()='"+name+"']"));
		
	}
	
	public WebElement getMyAccount() {
		return driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[@href='#/account']"));
	}
	
}
