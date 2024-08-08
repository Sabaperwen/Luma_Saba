package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	public String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("path");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		String value = sheet.getRow(row).getCell(cell).toString();
		return value;
	}
	

	
	public String[][] readMultipledata(String path,String SheetName) throws EncryptedDocumentException, IOException  
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
		int allRows=sheet.getLastRowNum();
		int allcell=sheet.getRow(0).getLastCellNum();
		String[][] value=new String [allRows][allcell];
		for(int i=0;i<allRows;i++)
		{ 
			for(int j=0;j<allcell;j++)
			{
				value[i][j] = sheet.getRow(i).getCell(j).toString();
				
			}
		}
		return value;
	}
}
