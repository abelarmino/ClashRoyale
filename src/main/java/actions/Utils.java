package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import configuracao.DriverFactory;

public class Utils {

	public static Boolean waitVisibility(int seconds, WebElement element) {
		for (int i=0;i<=seconds;i++) {
			try {
				Thread.sleep(i*1000);
				element.isDisplayed();
				return true;
			} catch( Exception e) {
				
			}
			
		}
		return false;
		
	}
}
