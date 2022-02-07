package logic;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class LoginLogic {
	LoginPage loginPage;
	
	public LoginLogic() {
		loginPage = new LoginPage();
	}
	
	public void setEmail(String email) {
		loginPage.getInputLogin().sendKeys(email);
	}
	
	public void setPassword(String password) {
		loginPage.getInputPassword().sendKeys(password);
	}
	public void clickBtnSubmit() {
		loginPage.getBtnSubmit().click();
	}

}
