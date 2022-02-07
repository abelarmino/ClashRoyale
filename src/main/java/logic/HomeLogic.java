package logic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuracao.DriverFactory;
import pages.HomePage;

public class HomeLogic {
	private HomePage homePage;
	WebDriverWait wait;
	public HomeLogic() {
		homePage = new HomePage();
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
	}
	

	public void clickDropdownName(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(DriverFactory.getDriver().findElement(By.className("dropdown-toggle__text"))));
		homePage.getDropdownName(name).click();
	}
	public void clickMyAccount() {
		homePage.getMyAccount().click();
			
	}
	
}
