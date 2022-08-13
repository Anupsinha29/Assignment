package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class Contains reusable method for excel
 * 
 * @author Anup Sinha
 *
 */
public final class ExcelUtility {

	private Workbook workbook;

	public void initiallizeExcelFile(String excelPath) {

		FileInputStream fisExcel = null;

		try {
			fisExcel = new FileInputStream(excelPath);
			workbook = WorkbookFactory.create(fisExcel);
		} catch (IOException | EncryptedDocumentException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method is used to fetch the data from Excel
	 * 
	 * @param rowNumber
	 * @param cellNumber
	 * @param sheetName
	 * @return
	 */
	public String getDataFormatExcel(int rowNumber, int cellNumber, String sheetName) {

		Sheet sheet = workbook.getSheet(sheetName);
		return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));

	}
	
	/**
	 * This method is used to close The ExcelWorkbook
	 */
	public void closeWorkbook() {
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
