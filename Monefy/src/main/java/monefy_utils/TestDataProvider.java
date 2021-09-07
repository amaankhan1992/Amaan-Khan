package monefy_utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

	public static String DATA_FILE_PATH = PropertyUtils.getProperty("datafilepath");
	private static Logger log = LogManager.getLogger(TestDataProvider.class);
	
	@DataProvider(name = "getDataFromExcel")
	public static Object[][] getDataForTestCase(Method m) throws IOException {

		String testCaseName = m.getName();

		ArrayList<String> testDataObject = getDatafromExcel(testCaseName);
		
		testDataObject.remove(0);
		log.info("Removing testname from test data and copying to new data object");
		
		Object[] finalData=testDataObject.toArray();
	
		log.info("Passing ["+finalData+ "] to test -"+testCaseName );
		return new Object[][] { finalData };
	

	}

	public static ArrayList<String> getDatafromExcel(String testCaseName) throws IOException {
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream(DATA_FILE_PATH);
		log.info("Reading test data from : " +DATA_FILE_PATH);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Get First Row
		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();

		// Cell Iterator for first row
		Iterator<Cell> ce = firstRow.cellIterator();

		// FindColumn for testCase Names
		int column = 0;
		int k = 0;
		while (ce.hasNext()) {
			Cell value = ce.next();
			if (value.getStringCellValue().equalsIgnoreCase("TesCase")) {
				column = k;
			}
			k++;
		}

		// Use Column index to get data of that row

		while (rows.hasNext()) {
			Row r = rows.next();

			if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
				Iterator<Cell> cv = r.cellIterator();
				while (cv.hasNext()) {
					Cell c = cv.next();
					if (c.getCellType() == CellType.STRING) {
						a.add(c.getStringCellValue());
					} else {
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
				}
			}
		}
		log.info("Test Data loaded for  : ["+testCaseName +"] as " +a);

		return a;

	}

}
