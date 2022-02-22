package logic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import actions.Utils;
import pages.NewKeyPage;

public class NewKeyLogic {
	private NewKeyPage newKeyPage;
	
	public NewKeyLogic() {
		newKeyPage = new NewKeyPage();
	}
	
	public void setName(String name) {		
		newKeyPage.getName().sendKeys(name);
	}
	
	public void setDescription(String description) {
		newKeyPage.getDescription().sendKeys(description);
	}
	public void setIp(String ip) {
		newKeyPage.getIp().sendKeys(ip);
	}
	public void clickBtnSubmit() {
		Utils.captureScreen("newKey");
		newKeyPage.getBtnSubmit().click();
	}
	
}
