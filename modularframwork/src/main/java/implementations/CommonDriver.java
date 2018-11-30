package implementations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import interfaces.IcommonDriver;

public class CommonDriver implements IcommonDriver{
	public WebDriver odriver;
	
	public CommonDriver(String browsertype) throws Exception {
		browsertype=browsertype.trim();
		switch (browsertype.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "E:\\Study meterial\\Selenium drivers\\chromedriver.exe");
			odriver=new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "E:\\Study meterial\\Selenium drivers\\geckodriver.exe");
			odriver=new FirefoxDriver();
			break;
		default:
			throw new Exception("invalid browsertypr: "+browsertype);
		
		}
		odriver.manage().deleteAllCookies();
		odriver.manage().window().maximize();
	}
	public WebDriver getdriver() {
	return odriver;	
	}
    @Override
	public void openBrowserAndNavigatetoURL(String URL) throws Exception {
		URL=URL.trim();
    	odriver.get(URL);
		
	}
    @Override
	public void navigatetoRefresh() throws Exception {
		odriver.navigate().refresh();
		
	}
    @Override
	public void navigatetoBackword() throws Exception {
		odriver.navigate().back();
		
	}
    @Override
	public void navigatetoForword() throws Exception {
		odriver.navigate().forward();
		
	}
    @Override
	public String getTitle() throws Exception {
		return odriver.getTitle();
	}
    @Override
	public String getCurrentURL() throws Exception {
		return odriver.getCurrentUrl();
	}
    @Override
	public void closeBrowser() {
		odriver.quit();
		
	}
    @Override
	public void closeALlBrowsers() {
		odriver.close();
		
	}
    @Override
	public void takeScreenshot(WebDriver odriver,String filename) throws Exception {
		File fs=((TakesScreenshot)odriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File(filename));
	}

}
