package logic;

import pages.MyAccountPage;

public class MyAccountLogic {
	private MyAccountPage myAccountPage;
	public MyAccountLogic() {
		myAccountPage = new MyAccountPage();
	}
	
	public void clickNewKey() {
		myAccountPage.getNewKey().click();
	}
}
