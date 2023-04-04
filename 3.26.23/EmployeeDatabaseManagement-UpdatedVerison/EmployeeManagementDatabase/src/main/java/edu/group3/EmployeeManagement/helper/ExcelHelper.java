package edu.group3.EmployeeManagement.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.SheetCollate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.jdbc.core.RowCallbackHandler;


import edu.group3.EmployeeManagement.models.Timesheets;

public class ExcelHelper {

	  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Title", "Description", "Type" };
	  static String SHEET = "TimeSheets";
	
	  public static ByteArrayInputStream dataToExcel(List<Timesheets> timeSheets) {

		    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		      Sheet sheet = workbook.createSheet(SHEET);

		      // Header
		      Row headerRow = sheet.createRow(0);

		      for (int col = 0; col < HEADERs.length; col++) {
		        Cell cell = headerRow.createCell(col);
		        cell.setCellValue(HEADERs[col]);
		      }

		      int rowIdx = 1;
		      for (Timesheets timesheet : timeSheets) {
		        Row row = sheet.createRow(rowIdx++);

		        row.createCell(0).setCellValue(timesheet.getId());
		        row.createCell(1).setCellValue(timesheet.getTitle());
		        row.createCell(2).setCellValue(timesheet.getDescription());
		        row.createCell(3).setCellValue(timesheet.getType());
		      }

		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
		  }
}