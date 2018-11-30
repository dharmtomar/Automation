package testcases;

import org.testng.annotations.Test;

import designpattern.Add_inventory;
import designpattern.PFerplogin;
import implementations.CommonDriver;

public class Add_Inventory_Test extends Basescenarios{

	//public static void main(String[] args) {
		
	@Test
	public void addinventory() {
	try {
			/*CommonDriver cdriver=new CommonDriver("chrome");
			//live erp
			//String url="https://www.ezswype.in/ERPEzSwype/";
			//local erp
			String url="https://52.66.104.100/ERPEzSwype/";
			cdriver.openBrowserAndNavigatetoURL(url);
			PFerplogin plogin=new PFerplogin(cdriver.getdriver());
			plogin.loginERP("admin@ezswype.com", "Ezswype@321");*/
			
			Add_inventory adddevice=new Add_inventory(cdriver.getdriver());
			adddevice.addinventory("AS334422", "BP6655555567");
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
