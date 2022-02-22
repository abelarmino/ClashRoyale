package actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuracao.DriverFactory;

public class Utils {
	private static  String folder;

	public static WebElement waitToBeVisible(WebElement element) {
		return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20L))
				.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement waitToBeClickable(By locator) {
		return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10L))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void createFolder(String folderName) throws IOException {
		folder = folderName;
		Path path = Paths.get("./target/screenshots/"+folderName);
		Files.createDirectories(path);
	}
	

	public static String captureScreen(String name) {
	    String path;

	    try {
	        WebDriver webDriver = new Augmenter().augment(DriverFactory.getDriver());
	        File source = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
	 
	        File newName= new File("./target/screenshots/"+folder+"/"+dtf.format(LocalDateTime.now())+"-"+name+".png");
	        source.renameTo(newName);
	        path = "./target/screenshots/" + source.getName();
	        FileUtils.copyFile(source, new File(path));
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    return path;
	}
}
