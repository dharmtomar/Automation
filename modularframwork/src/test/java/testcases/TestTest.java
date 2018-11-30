package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestTest {
	public static WebDriver odriver;
			@Test
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
  
}
