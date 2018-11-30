package implementations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.IcommonElements;

public class CommonElements implements IcommonElements {
    WebDriver odriver;
	@Override
	public void click(WebElement element) throws Exception {
		element.click();
		
	}

	@Override
	public String getText(WebElement element) throws Exception {
		return element.getText();
	}

	@Override
	public void takescreenshot() throws Exception {
		TakesScreenshot ts=(TakesScreenshot)odriver;
		File fs=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("E:\\tomar.PNG"));
		
	}

	

}
