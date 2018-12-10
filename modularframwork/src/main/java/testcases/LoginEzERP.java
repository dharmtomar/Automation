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
		File fs=((TakesScreenshot)(cdriver.getdriver())).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("Screenshots//dscreen.PNG"));	
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	}
	
}
