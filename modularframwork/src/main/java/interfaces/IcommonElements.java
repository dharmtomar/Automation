package interfaces;

import org.openqa.selenium.WebElement;

public interface IcommonElements {

	public void click(WebElement element)throws Exception;
	public String getText(WebElement element)throws Exception;
	public void takescreenshot()throws Exception;
}
