package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
public class Test {
	public static WebDriver odriver;
	@BeforeTest
	public void screenshot() throws IOException {
	System.setProperty("webdriver.chrome.driver", "E:\\Study meterial\\Selenium drivers\\chromedriver.exe");
	odriver=new ChromeDriver();
	odriver.manage().window().maximize();
	odriver.get("https://www.google.com/");
	TakesScreenshot ts=(TakesScreenshot)odriver;
	File fs=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(fs, new File("E:\\tomar.PNG"));
	
	
	System.out.println("Screen captured");
	
	}
	@org.testng.annotations.Test
	public void test() {
		
	}
	
}
 