package testcases;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import designpattern.PFerplogin;
import implementations.CommonDriver;
import utils.ConfigFileReader;

public class Basescenarios {
	CommonDriver cdriver;
	Properties oProperties;
	private static String sPropertyFile;
	PFerplogin erplogin;
	
	public Basescenarios() {
	try {
		sPropertyFile = "Configuration/config.properties";	
		oProperties=ConfigFileReader.getProperties(sPropertyFile);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@BeforeTest(alwaysRun=true)
	public void setup() {
		
		try {
			cdriver=new CommonDriver(oProperties.getProperty("Browser"));
			erplogin=new PFerplogin(cdriver.getdriver());
			cdriver.openBrowserAndNavigatetoURL(oProperties.getProperty("baseurl"));
			PFerplogin plogin=new PFerplogin(cdriver.getdriver());
			plogin.loginERP(oProperties.getProperty("loginid"), oProperties.getProperty("password"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@AfterClass(alwaysRun=true)
	public void teardown() {
		cdriver.closeBrowser();
	}
	
}
