package designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import implementations.CommonElements;
import implementations.DropDownControls;
import implementations.TextBoxControls;

public class Add_inventory {
	@CacheLookup
	@FindBy(linkText="Device Inventory")
	private WebElement deviceinventorylink;
	
	@CacheLookup
	@FindBy(linkText="Add Device")
	private WebElement add_device;
	
	@CacheLookup
	@FindBy(id="modelName")
	private WebElement select_model;
	
	@CacheLookup
	@FindBy(id="serialNo")
	private WebElement sno;
	
	@CacheLookup
	@FindBy(id="tid")
	private WebElement tid;
	
	@CacheLookup
	@FindBy(name="AddMerchantDetails")
	private WebElement submit;
	
	private CommonElements celements;
	private DropDownControls dropdown;
	private TextBoxControls tbox;
	public Add_inventory(WebDriver odriver) {
		PageFactory.initElements(odriver, this);
		celements=new CommonElements();
		dropdown=new DropDownControls();
		tbox=new TextBoxControls();
	}
public void addinventory(String TID,String SNO) {
	try {
		celements.click(deviceinventorylink);
		celements.click(add_device);
		dropdown.selectelementbyindex(select_model, 2);
		tbox.setText(sno, SNO);
		tbox.setText(tid, TID);
		celements.click(submit);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
