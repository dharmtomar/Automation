package testcases;

import org.testng.annotations.Test;

import designpattern.Add_inventory;
import designpattern.PFerplogin;
import implementations.CommonDriver;

public class Add_Inventory_Test extends Basescenarios{

		
	@Test
	public void addinventory() {
	try {			
			Add_inventory adddevice=new Add_inventory(cdriver.getdriver());
			adddevice.addinventory(oProperties.getProperty("TID"), oProperties.getProperty("Deviceno"));
			System.out.println("Inventory added successfully");
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
