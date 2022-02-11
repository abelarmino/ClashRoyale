package logic;

import actions.Utils;
import pages.MyAccountPage;

public class MyAccountLogic {
	private MyAccountPage myAccountPage;
	public MyAccountLogic() {
		myAccountPage = new MyAccountPage();
	}
	
	public void clickNewKey()  {
		Utils.waitVisibility(3, myAccountPage.getNewKey());
		myAccountPage.getNewKey().click();
	}
	
	public void clickExistingKey(String keyName)  {
		Utils.waitVisibility(3, myAccountPage.getNewKey());
		myAccountPage.getExistingKeyName(keyName).click();
	}
}
