package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private String email;
	private String password;
	private String name;
	private String keyName;
	private String description;
	private IndexLogic indexLogic;
	private LoginLogic loginLogic;
	private HomeLogic homeLogic;
	private MyAccountLogic myAccountLogic;
	private NewKeyLogic newKeyLogic;
	private KeysLogic keysLogic;
	private static final String fileName = "C:/Projects/ClashRoyale/src/resources/massa.xls";

	public GenerateKey() throws IOException {
		indexLogic = new IndexLogic();
		loginLogic = new LoginLogic();
		homeLogic = new HomeLogic();
		myAccountLogic = new MyAccountLogic();
		newKeyLogic = new NewKeyLogic();
		keysLogic = new KeysLogic();
		
	}

	public void login() throws InterruptedException, IOException {
		getUsersInfo();
		indexLogic.clickBtnLogin();
		loginLogic.setEmail(email);
		loginLogic.setPassword(password);
		loginLogic.clickBtnSubmit();	
	}
	
	public void generateKey() throws InterruptedException, IOException {
		homeLogic.clickDropdownName(name);
		homeLogic.clickMyAccount();
		myAccountLogic.clickNewKey();
		getKeyInfo();
		newKeyLogic.setName(keyName);
		newKeyLogic.setDescription(description);
		newKeyLogic.setIp(GenerateIp.getIp());
		newKeyLogic.clickBtnSubmit();
	}
	public String getToken() throws InterruptedException {
		myAccountLogic.clickExistingKey(keyName);
		return keysLogic.getTokenText();
	}
	
	public void deleteKey() throws InterruptedException {
		keysLogic.clickBtnGotIt();
		keysLogic.clickBtnDelete();	
	}
	public void getUsersInfo() throws IOException {
		FileInputStream file = new FileInputStream(new File (fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheetUsers = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheetUsers.iterator();
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch(cell.getColumnIndex()) {
					case 0:
						email = cell.getStringCellValue();
					break;
					case 1:
						password = cell.getStringCellValue();
					break;
					case 2:
						name = cell.getStringCellValue();
					break;
				}
			}
		}
	}
	public void getKeyInfo() throws IOException {
		FileInputStream file = new FileInputStream(new File (fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheetKey = workbook.getSheetAt(1);
		Iterator<Row> rowIterator = sheetKey.iterator();
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch(cell.getColumnIndex()) {
					case 0:
						keyName = cell.getStringCellValue();
					break;
					case 1:
						description = cell.getStringCellValue();
					break;
				}
			}
		}
	}
	
}
