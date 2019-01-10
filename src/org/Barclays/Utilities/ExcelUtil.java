package org.Barclays.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	//for gtting file location, sheet name, return sheet
	//for returning row level
	//return cell value
	
	public XSSFSheet getSheet(String fileloc, String sheetname) throws IOException
	{
		FileInputStream fin=new FileInputStream(fileloc);
		XSSFWorkbook wbook=new XSSFWorkbook(fin); 
		XSSFSheet sheet= wbook.getSheet(sheetname);
		return sheet;
	}
	public XSSFRow getrow(String fileloc, String sheetname, int rowno) throws IOException
	{
		FileInputStream fin=new FileInputStream(fileloc);
		XSSFWorkbook wbook=new XSSFWorkbook(fin); 
		XSSFSheet sheet= wbook.getSheet(sheetname);
		XSSFRow row=sheet.getRow(rowno);
		return row;
	}	
	public String getcell(String fileloc, String sheetname, int rowno, int cellno) throws IOException
	{
		FileInputStream fin=new FileInputStream(fileloc);
		XSSFWorkbook wbook=new XSSFWorkbook(fin); 
		XSSFSheet sheet= wbook.getSheet(sheetname);
		XSSFRow row=sheet.getRow(rowno);
		XSSFCell cell=row.getCell(cellno);
		DataFormatter formatter=new DataFormatter();
		String val=formatter.formatCellValue(cell);
		return val;
	}
}