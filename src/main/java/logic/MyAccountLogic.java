package logic;

import pages.MyAccountPage;

public class MyAccountLogic {
	private MyAccountPage myAccountPage;

	public MyAccountLogic() {
		myAccountPage = new MyAccountPage();
	}

	public void clickNewKey() throws InterruptedException {
		Thread.sleep(3000);
		myAccountPage.getNewKey().click();
	}

	public void clickExistingKey(String keyName) throws InterruptedException {
		Thread.sleep(3000);
		myAccountPage.getExistingKeyName(keyName).click();
	}
}
