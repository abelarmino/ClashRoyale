import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuracao.DriverFactory;
import logic.HomeLogic;
import logic.IndexLogic;
import logic.LoginLogic;

public class main {

	public static void main(String[] args) throws InterruptedException{
		
		DriverFactory driver = new DriverFactory();
		IndexLogic indexLogic = new IndexLogic();
		LoginLogic loginLogic = new LoginLogic();
		HomeLogic homeLogic = new HomeLogic();
		Thread.sleep(3000);		
		indexLogic.clickBtnLogin();
		loginLogic.writeEmail("");
		loginLogic.writePassword("");
		loginLogic.clickBtnSubmit();
		homeLogic.clickDropdownName("Amanda");
		homeLogic.clickMyAccount();
		
	}

}
