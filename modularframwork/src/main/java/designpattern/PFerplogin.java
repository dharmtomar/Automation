package designpattern;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import implementations.Capture_Screenshot;
import implementations.CommonElements;
import implementations.TextBoxControls;
import utils.ConfigFileReader;

public class PFerplogin {
	public static String sPropertyFile = "Configuration/config.properties";	
	public static Properties oProperty;
	
	
	@FindBy(id="username")
    public WebElement loginid;
	@FindBy(name="password")
    public WebElement password;
    @FindBy(name="submit")
    public WebElement submitbutton;
   
   public CommonElements celement;
   public TextBoxControls txtbox;
   public Capture_Screenshot sshot;
   
   public PFerplogin(WebDriver odriver) {
	   PageFactory.initElements(odriver, this);
	   celement=new CommonElements();
	   txtbox=new TextBoxControls();
	   sshot=new Capture_Screenshot();
	   oProperty=ConfigFileReader.getProperties(sPropertyFile);
   }
   public void loginERP(String loginID,String Password) {
	   try {
		   System.out.println(oProperty.getProperty("baseurl"));
		txtbox.setText(loginid, loginID);
		txtbox.setText(password, Password);
		celement.click(submitbutton);
		//celement.takescreenshot();
		
		//sshot.takeScreenshot("Screenshots\\dscreen.PNG");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
   }
   @CacheLookup
   @FindBy(linkText="Beneficiary File")
   public WebElement benelink;
   public void benetest() {
	   try {
		celement.click(benelink);
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
}
