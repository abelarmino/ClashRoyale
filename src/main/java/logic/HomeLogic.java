package logic;

import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Utils;
import pages.HomePage;

public class HomeLogic {
	private HomePage homePage;
	WebDriverWait wait;

	public HomeLogic() {
		homePage = new HomePage();

	}

	public void clickDropdownName(String name) throws InterruptedException {
		homePage.getDropdownName(name).click();
		Utils.captureScreen("homePage");
	}

	public void clickMyAccount() {
		homePage.getMyAccount().click();

	}

}
