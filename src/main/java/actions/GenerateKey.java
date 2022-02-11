package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import logic.HomeLogic;
import logic.IndexLogic;
import logic.KeysLogic;
import logic.LoginLogic;
import logic.MyAccountLogic;
import logic.NewKeyLogic;

public class GenerateKey {
	private String email = "";
	private String password = "";
	private String name = "Amanda";
	private String keyName = "Key 2";
	private String description = "Descri��o";
	private IndexLogic indexLogic;
	private LoginLogic loginLogic;
	private HomeLogic homeLogic;
	private MyAccountLogic myAccountLogic;
	private NewKeyLogic newKeyLogic;
	private KeysLogic keysLogic;
	
	public GenerateKey() {
		indexLogic = new IndexLogic();
		loginLogic = new LoginLogic();
		homeLogic = new HomeLogic();
		myAccountLogic = new MyAccountLogic();
		newKeyLogic = new NewKeyLogic();
		keysLogic = new KeysLogic();
	}
	public void login() throws InterruptedException, IOException {
		indexLogic.clickBtnLogin();
		loginLogic.setEmail(email);
		loginLogic.setPassword(password);
		loginLogic.clickBtnSubmit();	
	}
	public void generateKey() throws InterruptedException {
		homeLogic.clickDropdownName(name);
		homeLogic.clickMyAccount();
		myAccountLogic.clickNewKey();
		newKeyLogic.setName(keyName);
		newKeyLogic.setDescription(description);
		newKeyLogic.setIp(GenerateIp.getIp());
		newKeyLogic.clickBtnSubmit();
	}
	public String getToken() throws InterruptedException {
		myAccountLogic.clickExistingKey(keyName);
		return keysLogic.getTokenText();
	}
	
}
