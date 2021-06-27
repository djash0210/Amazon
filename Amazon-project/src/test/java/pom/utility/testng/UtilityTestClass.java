package pom.utility.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import utilitypack.UtilityImport;

public class UtilityTestClass {
	@Test
	public void test() throws EncryptedDocumentException, IOException 
	{
		UtilityImport ui = new UtilityImport();
		ui.getCellData("Sheet1", 3, 0);
		ui.getTableData();
	}
}
