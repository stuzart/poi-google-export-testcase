package org.stuzart.testing;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Test;

public class TestDriveExportedValidationDetection {
	
	@Test
	public void testOriginal() throws Exception {
		XSSFSheet sheet = getSheet("original.xlsx");
		assertEquals(1, sheet.getDataValidations().size());
	}
	
	@Test
	public void testExported() throws Exception {
		XSSFSheet sheet = getSheet("exported.xlsx");
		assertEquals(1, sheet.getDataValidations().size());
	}
	
	@Test
	public void testResaved() throws Exception {
		XSSFSheet sheet = getSheet("resaved.xlsx");
		assertEquals(1, sheet.getDataValidations().size());
	}
	
	private XSSFSheet getSheet(String filename) throws Exception {
		URI uri = TestDriveExportedValidationDetection.class.getResource("/" + filename).toURI();
		Workbook wb = org.apache.poi.ss.usermodel.WorkbookFactory.create(uri.toURL().openStream());
		
		return (XSSFSheet)wb.getSheet("Sheet1");			
	}

}
