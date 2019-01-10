package org.Barclays.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.Barclays.Utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewTest {

	public static void main(String[] args) throws IOException {
	
	ExcelUtil excObj=new ExcelUtil();
	System.out.println(excObj.getcell("./Utility/myExcel.xlsx", "Sheet1", 0, 1));
	
	}

}
