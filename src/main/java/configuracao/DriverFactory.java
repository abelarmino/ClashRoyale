package configuracao;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;

public class DriverFactory {
	private static WebDriver driver;
	public DriverFactory() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.manage().window().maximize();
		
	}
	public void setDriver(String url) {
		
		driver.get(url);
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public void killDriver() {
		driver.quit();
	}
}
