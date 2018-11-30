package designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import implementations.CommonElements;
import implementations.TextBoxControls;

public class Flipcartlogin {
	@FindBy(linkText="Login & Signup")
	public WebElement loginsignup;
	@FindBy(className="_2zrpKA")
    public WebElement loginid;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
    public WebElement password;
    @FindBy(name="submit")
    public WebElement submitbutton;
   
   public CommonElements celement;
   public TextBoxControls txtbox;
   public Flipcartlogin(WebDriver odDriver) {
	   PageFactory.initElements(odDriver, this);
	   celement=new CommonElements();
	   txtbox=new TextBoxControls();
   }
   public void loginfcart(String loginID,String Password) {
	   try {
		txtbox.setText(loginid, loginID);
		txtbox.setText(password, Password);
		
				
	} catch (Exception e) {
		
		e.printStackTrace();
	}
   }
}
