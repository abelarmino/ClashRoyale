package logic;

import org.openqa.selenium.interactions.Actions;

import actions.Utils;
import configuracao.DriverFactory;
import pages.KeysPage;
import pages.MyAccountPage;

public class KeysLogic {

	private KeysPage keysPage;
	private MyAccountPage myAccountPage;
	
	public KeysLogic() {
		keysPage = new KeysPage();
		
		myAccountPage = new MyAccountPage();
	}
	
	public String getTokenText() {	
		Utils.captureScreen("token");
		return keysPage.getToken().getText();
	}
	
	public void clickBtnGotIt() {
		keysPage.getBtnGotIt().click();
	}
	public void clickBtnDelete() {
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement(keysPage.getBtnDelete()).perform();
		keysPage.getBtnDelete().click();
		Utils.captureScreen("keyDeleted");
	
		
	}
}
