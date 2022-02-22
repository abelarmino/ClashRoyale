package logic;

import actions.Utils;
import pages.MyAccountPage;

public class MyAccountLogic {
	private MyAccountPage myAccountPage;

	public MyAccountLogic() {
		myAccountPage = new MyAccountPage();
	}

	public void clickNewKey() {
		Utils.captureScreen("myAccount");
		myAccountPage.getNewKey().click();
	}

	public void clickExistingKey(String keyName) {
		myAccountPage.getExistingKeyName(keyName).click();
	}
	
}
