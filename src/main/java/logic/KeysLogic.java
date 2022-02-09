package logic;

import pages.KeysPage;

public class KeysLogic {

	private KeysPage keysPage;
	
	public KeysLogic() {
		keysPage = new KeysPage();
	}
	
	public String getTokenText() throws InterruptedException {
		Thread.sleep(2000);
		return keysPage.getToken().getText();
	}
}
