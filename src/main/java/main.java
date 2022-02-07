import java.net.UnknownHostException;

import org.openqa.selenium.By;

import actions.GenerateIp;
import configuracao.DriverFactory;
import logic.HomeLogic;
import logic.IndexLogic;
import logic.LoginLogic;
import logic.MyAccountLogic;
import logic.NewKeyLogic;

public class main {

	public static void main(String[] args) throws InterruptedException, UnknownHostException{		
		
		
		DriverFactory driver = new DriverFactory();
		driver.setDriver("https://developer.clashroyale.com/#/");
		IndexLogic indexLogic = new IndexLogic();
		LoginLogic loginLogic = new LoginLogic();
		HomeLogic homeLogic = new HomeLogic();
		MyAccountLogic myAccountLogic = new MyAccountLogic();
		NewKeyLogic newKeyLogic = new NewKeyLogic();
		Thread.sleep(3000);		
		indexLogic.clickBtnLogin();
		loginLogic.setEmail("");
		loginLogic.setPassword("");
		loginLogic.clickBtnSubmit();
		Thread.sleep(3000);		
		homeLogic.clickDropdownName("Amanda");
		homeLogic.clickMyAccount();
		Thread.sleep(3000);
		myAccountLogic.clickNewKey();
		Thread.sleep(3000);
		newKeyLogic.setName("Key 1");
		newKeyLogic.setDescription("Descrição");
		newKeyLogic.setIp(GenerateIp.getIp());
		newKeyLogic.clickBtnSubmit();
		
		
		
	}

}
