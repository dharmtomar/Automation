package implementations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import interfaces.Iscreenshot;

public class Capture_Screenshot implements Iscreenshot {
    WebDriver odriver;
   
	@Override
	public void takeScreenshot(String filename) throws Exception {
		File fs=((TakesScreenshot)odriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File(filename));
	}

}
