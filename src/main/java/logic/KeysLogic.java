package logic;

import actions.Utils;
import pages.KeysPage;

public class KeysLogic {

	private KeysPage keysPage;
	
	public KeysLogic() {
		keysPage = new KeysPage();
	}
	
	public String getTokenText() {
		Utils.waitVisibility(3, keysPage.getToken());
		return keysPage.getToken().getText();
	}
}
