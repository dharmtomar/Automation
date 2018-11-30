package interfaces;

import org.openqa.selenium.WebDriver;

public interface IcommonDriver {

	public void openBrowserAndNavigatetoURL(String URL) throws Exception;
	public void navigatetoRefresh()throws Exception;
	public void navigatetoBackword()throws Exception;
	public void navigatetoForword()throws Exception;
	public String getTitle()throws Exception;
	public String getCurrentURL()throws Exception;
	public void closeBrowser();
	public void closeALlBrowsers();
	public void takeScreenshot(WebDriver odriver,String filename) throws Exception;
}
