package configuracao;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;

public class DriverFactory {
	private static WebDriver driver;
	double width;
	double height;
	public DriverFactory() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
	
		driver.manage().window().setSize(new org.openqa.selenium.Dimension((int)width, (int)height));
	
		driver.get("https://developer.clashroyale.com/#/");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
