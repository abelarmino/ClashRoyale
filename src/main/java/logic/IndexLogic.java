package logic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuracao.DriverFactory;
import pages.IndexPage;

public class IndexLogic {
	IndexPage indexPage;
	WebDriverWait wait;
	
	public IndexLogic() {
		indexPage = new IndexPage();
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
	}
	
	public void clickBtnLogin() {
		//wait.until(ExpectedConditions.elementToBeClickable(indexPage.getBtnLogin()));
		indexPage.getBtnLogin().click();
	}
}
