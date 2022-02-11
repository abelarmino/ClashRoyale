package logic;

import actions.Utils;
import pages.KeysPage;

public class KeysLogic {

	private KeysPage keysPage;
	
	public KeysLogic() {
		keysPage = new KeysPage();
	}
	
	public String getTokenText() throws InterruptedException {
		Thread.sleep(3000);
		return keysPage.getToken().getText();
	}
}
