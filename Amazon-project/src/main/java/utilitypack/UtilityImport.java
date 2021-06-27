package utilitypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityImport  {
	
	private String T;
	static  int rvalue, cvalue;
	static private String path;
	private Sheet Sheet;
	private Row row;
	private String data;
	public String getCellData(String a, int b, int c) throws EncryptedDocumentException, IOException 
	{
		String path = "C:\\Users\\Tushar\\Desktop\\Testdata.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook f = WorkbookFactory.create(file);
		Sheet s = f.getSheet(a);
		Row r = s.getRow(b);
		Cell d = r.getCell(c);
		T = d.getStringCellValue();
		System.out.println(T );
		return T;
		
	}
	
	public String getTableData() throws EncryptedDocumentException, IOException 
	{
		String path = "C:\\Users\\Tushar\\Desktop\\Testdata.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook f = WorkbookFactory.create(file);
		Sheet s = f.getSheet("Sheet1");
		for(int i=0; i<=s.getLastRowNum(); i++) 
		{
			Row r = s.getRow(i);
			for(int j=0; j<r.getLastCellNum(); j++) 
			{
				Cell d = r.getCell(j);
				T = d.getStringCellValue();
				System.out.println(T );
				
			}
			System.out.println();
		}
		return T;
	}
	
	public void takeScreenshot(WebDriver driver ) throws IOException
	{
		 SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");  
		  Date date = new Date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Velocity\\AutomatedSS\\AutoScreenShot "+dtf.format(date)+".jpeg");
		FileHandler.copy(source, dest);
	}
	
	public void sendExcelPath(String P)
	{
		path=P;
		
	}
	public String excelData(int s, int r, int c) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(path);
		Workbook w =WorkbookFactory.create(file);
		Sheet =w.getSheetAt(s);
		row = Sheet.getRow(r);
		Cell cell = row.getCell(c);
		try {
		data = cell.getStringCellValue();
		}
		catch(IllegalStateException e)
		{
		long numericVal = (long) cell.getNumericCellValue();
		System.out.println(numericVal);
		data=String.valueOf(numericVal); 
		}
		return T;
	}
}
