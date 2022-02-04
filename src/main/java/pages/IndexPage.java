package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuracao.DriverFactory;

public class IndexPage {
	WebDriver driver;
	private By btnLogin = By.xpath("//div[@class='login-menu']/a[text()='Log In']");
	public IndexPage() {
		driver = DriverFactory.getDriver();
	}
	public WebElement getBtnLogin() {
		return driver.findElement(btnLogin);
	}
}
