package logic;

import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;

public class HomeLogic {
	private HomePage homePage;
	WebDriverWait wait;

	public HomeLogic() {
		homePage = new HomePage();

	}

	public void clickDropdownName(String name) throws InterruptedException {
		Thread.sleep(3000);
		homePage.getDropdownName(name).click();

	}

	public void clickMyAccount() {
		homePage.getMyAccount().click();

	}

}
