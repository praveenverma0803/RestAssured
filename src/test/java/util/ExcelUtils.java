package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFCell cell;
		public static XSSFRow row;
		
	public static int getrowcount(String xlFile, String xlSheet) throws IOException {
		
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return  rowcount;
	}
	
	public static int getcellcount(String xlFile, String xlSheet, int rowcount) throws IOException {
		
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rowcount);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return  cellcount;
	}
	
	public static String getCelldata(String xlFile, String xlSheet, int rownum, int cellnum) throws IOException {
		
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(cellnum);
		String Data;
		try {
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			return celldata;
		} 
		catch (Exception e)
		{
			Data = " ";
		}
		
		return Data;
	}
	
	public static void setCelldata(String xlFile, String xlSheet, int rownum, int cellnum, String Data) throws IOException {
	
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.createCell(cellnum);
		cell.setCellValue(Data);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}

}
