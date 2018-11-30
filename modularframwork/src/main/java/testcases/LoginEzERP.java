package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import org.apache.http.util.Asserts;
//import org.testng.Assert;

//import designpattern.FilterTxns;
import designpattern.PFerplogin;
import implementations.CommonDriver;
import utils.ConfigFileReader;

import org.testng.annotations.Test;

public class LoginEzERP {
	private static String sPropertyFile = "Configuration/config.properties";	
	private static Properties oProperties;
	//Test commit for git
	//CommonElements celements=new CommonElements();
	//public static WebDriver odriver;

	/*public void takescreenshot() throws IOException {
		File fs=((TakesScreenshot)odriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("E://screen.PNG"));	
	}*/
	//private Capture_Screenshot screenshot;
	//public static void main(String[] args) {
		@Test
		public void erplogin() throws IOException {
	try {
		oProperties=ConfigFileReader.getProperties(sPropertyFile);
		CommonDriver cdriver=new CommonDriver(oProperties.getProperty("Browser"));
		
		//live erp
		//String url="https://www.ezswype.in/ERPEzSwype/";
		//local erp
		//String url="https://52.66.104.100/ERPEzSwype/";
		cdriver.openBrowserAndNavigatetoURL(oProperties.getProperty("baseurl"));
		PFerplogin plogin=new PFerplogin(cdriver.getdriver());
		plogin.loginERP(oProperties.getProperty("loginid"), oProperties.getProperty("password"));

		System.out.println("driver is:   "+cdriver.getdriver());
		//WebDriver odriver=cdriver.getdriver();
		File fs=((TakesScreenshot)(cdriver.getdriver())).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("Screenshots//dscreen.PNG"));	
		//Thread.sleep(2000);
		//cdriver.takeScreenshot(odriver, "E://dhsrms.PNG");
		//plogin.sshot.takeScreenshot("E://screenshot.JPG");
		//FilterTxns filter=new FilterTxns(cdriver.getdriver());
		//filter.filtertxn("7503450533");
		
		//Assert.assertEquals(oProperties.getProperty("homepagetitle"), cdriver.getTitle());
		//System.out.println("Login success");
		//System.out.println("ERP Home Page assertion Success");
		//celements.takescreenshot();
		//plogin.benetest();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	}
	
}
