package implementations;

import org.openqa.selenium.WebElement;

import interfaces.ItextBox;

public class TextBoxControls implements ItextBox {

	@Override
	public void setText(WebElement element,String txtToset) throws Exception {
		element.sendKeys(txtToset);
	}
	

}
