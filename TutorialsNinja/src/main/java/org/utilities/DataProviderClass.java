package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	static FileInputStream fis;
	static XSSFWorkbook workBook;

	@DataProvider(name = "credentials")
	public static Object[][] testData() {
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx");
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workBook.getSheetAt(0);
		int rowsCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row1 = sheet.getRow(0);
		int colcount = row1.getPhysicalNumberOfCells();
		Object[][] data = new Object[rowsCount - 1][colcount];
		for (int i = 1; i < rowsCount; i++) {
			for (int j = 0; j < colcount; j++) {
				XSSFRow row = sheet.getRow(i);
				DataFormatter formater = new DataFormatter();
				String formatCellValue = formater.formatCellValue(row.getCell(j));
				data[i - 1][j] = formatCellValue;
			}
		}
		return data;
	}

}
