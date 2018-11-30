package implementations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import interfaces.IdropDown;

public class DropDownControls implements IdropDown {
	private Select getdropdownvalue(WebElement element) {
	Select dropdown=new Select(element);
	return dropdown;
}
	
	@Override
	public void selectelementbyvalue(WebElement element, String value) throws Exception {
	getdropdownvalue(element).selectByValue(value);
		
	}

	@Override
	public void selectelementbytext(WebElement element, String txt) throws Exception {
		getdropdownvalue(element).selectByVisibleText(txt);
		
	}

	@Override
	public void selectelementbyindex(WebElement element, int index) throws Exception {
		getdropdownvalue(element).selectByIndex(index);
		
	}

}
