package interfaces;

import org.openqa.selenium.WebElement;

public interface IdropDown {
	public void selectelementbyvalue(WebElement element,String value) throws Exception;
	public void selectelementbytext(WebElement element,String txt)throws Exception;
	public void selectelementbyindex(WebElement element,int index)throws Exception;
}
