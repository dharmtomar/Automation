package testcases;

import utils.ExcelDriver;

public class DemoExcelDriver {
public static void main(String[] args) {
	try {
		ExcelDriver edriver=new ExcelDriver();
		String eFile="C:\\Users\\Hp Pc\\eclipse-workspace\\modularframwork\\output\\dharm.xlsx";
		String sheetname="Testdata";
		edriver.createNewExcelWorkbook(eFile);
		edriver.openWorkbook(eFile);
		//edriver.save();
		edriver.createSheet("Test1");
		edriver.setCellData(sheetname, 2, 5, "dharm");
		edriver.save();
		edriver.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
