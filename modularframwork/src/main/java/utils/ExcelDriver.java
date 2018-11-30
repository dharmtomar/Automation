package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	private InputStream oFileReader;
	private OutputStream oFileWriter;
	private Workbook oExcelworkbook;
	private String  sExcelFileName;
	
	private void setNull() {
		oFileReader=null;
		oFileWriter=null;
		oExcelworkbook=null;
		sExcelFileName="";
	}
	public ExcelDriver() {
		this.setNull();
	}
	public void createNewExcelWorkbook(String sFileName) {
		try{
			sFileName = sFileName.trim();
			if(sFileName.isEmpty()){
				throw new Exception("No file name specified...");
			}
			if(new File(sFileName).exists()){
				throw new Exception("File already exist");
			}
			if(sFileName.toLowerCase().endsWith(".xlsx")){
				oExcelworkbook=new XSSFWorkbook();
			}
			if(sFileName.toLowerCase().endsWith(".xls")){
				oExcelworkbook=new HSSFWorkbook();
			}
			else {
				throw new Exception("Invalid File Extention");
			}
			oFileWriter=new FileOutputStream(sFileName);
			oExcelworkbook.write(oFileWriter);
			oFileWriter.close();
			oExcelworkbook.close();
			this.setNull();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void openWorkbook(String sFileName) {
		try {
			sFileName=sFileName.trim();
			if(sFileName.isEmpty()) {
				throw new Exception("File name not specified");
			}
			if(!(new File(sFileName)).exists()) {
				throw new Exception("File does not exist");
			}
			oFileReader=new FileInputStream(sFileName);
			sExcelFileName=sFileName;
			oExcelworkbook=WorkbookFactory.create(oFileReader);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public void save() {
		try {
			oFileWriter=new FileOutputStream(sExcelFileName);
			oExcelworkbook.write(oFileWriter);
			oFileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void saveAs(String sFileName) {
		try {
			sFileName=sFileName.trim();
			if(sFileName.isEmpty()) {
				throw new Exception("File name not specified");
			}
			if(new File(sFileName).exists()) {
				throw new Exception("File alredy exist");
			}
			oFileWriter=new FileOutputStream(sFileName);
			oExcelworkbook.write(oFileWriter);
			oFileWriter.close();
		} catch (Exception e) {
	
		}
	}
	public void close() {
		try {
			oExcelworkbook.close();
			oFileReader.close();
			setNull();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void createSheet(String sSheetName) {
		try{
			sSheetName = sSheetName.trim();
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified");
			}
			Sheet oSheet;
			oSheet = oExcelworkbook.getSheet(sSheetName);
			if(oSheet != null){
				throw new Exception("Sheet already Exist");
			}
			oExcelworkbook.createSheet(sSheetName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public int getRowCountOfSheet(String sSheetName) {
		try {
			sSheetName = sSheetName.trim();
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified");
				
			} 
			
			Sheet oSheet;
			
			oSheet = oExcelworkbook.getSheet(sSheetName);
			if(oSheet == null){
				throw new Exception("Sheet already Exist");
			}
			
			return oSheet.getLastRowNum();
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public int getCellCount(String sSheetName,int iRow) {
		try {
			sSheetName = sSheetName.trim();
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified");
				
			} 
			Sheet oSheet;
			oSheet = oExcelworkbook.getSheet(sSheetName);
			if(oSheet == null){
				throw new Exception("Sheet doesnot Exist");
			}
			
			if(iRow<1){
				throw new Exception("ROw Index start from 1");
			}
			
			Row oRow;
			
			oRow = oSheet.getRow(iRow -1);
			
			if(oRow == null){
				return 0;
			} else {
				return oRow.getLastCellNum() + 1;
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*public String getCellData(String sSheetName,int iRow,int iCell) {
		try {
			sSheetName = sSheetName.trim();
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified");
				
			} 
			Sheet oSheet;
			oSheet = oExcelworkbook.getSheet(sSheetName);
			if(oSheet == null){
				throw new Exception("Sheet already Exist");
			}
			
			if(iRow<1 || iCell<1){
				throw new Exception("Row & Cell Index start from 1");
			}
			Row oRow;
			oRow = oSheet.getRow(iRow -1);
			
			if(oRow == null){
				return "";
			}
		
			Cell oCell;
			oCell = oRow.getCell(iCell -1);
			if(oCell == null){
				return "";
			} else {
				
				if(oCell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					return String.valueOf((int) oCell.getNumericCellValue());
				} else {
					
					return oCell.getStringCellValue();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}*/
	public void setCellData(String sSheetName,int iRow,int iCell,String sValue) {
		try {
			sSheetName = sSheetName.trim();
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified");
				
			} 
			
			Sheet oSheet;
			oSheet = oExcelworkbook.getSheet(sSheetName);
			if(oSheet == null){
				throw new Exception("Sheet doesnot  Exist");
			}
			
			if(iRow<1 || iCell<1){
				throw new Exception("Row & Cell Index start from 1");
			}
						
			Row oRow;
			oRow = oSheet.getRow(iRow -1);
			
			if(oRow == null){
				oSheet.createRow(iRow-1);
				oRow = oSheet.getRow(iRow-1);
			}
		
			Cell oCell;
			oCell = oRow.getCell(iCell -1);
			if(oCell == null){
				oRow.createCell(iCell -1);
				oCell = oRow.getCell(iCell-1);
			} 
			
			oCell.setCellValue(sValue);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	}
