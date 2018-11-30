package designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import implementations.CommonElements;
import implementations.TextBoxControls;

public class FilterTxns {
	@CacheLookup
	@FindBy(linkText="Transaction List")
	public WebElement txnlistlink;
	
	@CacheLookup
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[1]/button")
	public WebElement txnfilter;
	
	@CacheLookup
	@FindBy(id="loginId")
	public WebElement loginid;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"modal-body2\"]/button[1]")
	public WebElement search;
	public CommonElements celement;
	   public TextBoxControls txtbox;
	   public FilterTxns(WebDriver odDriver) {
		   PageFactory.initElements(odDriver, this);
		   celement=new CommonElements();
		   txtbox=new TextBoxControls();
	   }
	   public void filtertxn(String loginID) {
		   try {
			celement.click(txnlistlink);
			celement.click(txnfilter);
			txtbox.setText(loginid, loginID);
			celement.click(search);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

}
