package edu.group3.EmployeeManagement.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.SheetCollate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
		    	  //Setting the heading row-0
		        Row rowC = sheet.createRow(rowIdx++);

		        
		        //Sets into Row index 0 as Headers
		        rowC.createCell(0).setCellValue(timesheet.getId());
		        rowC.createCell(1).setCellValue(timesheet.getTitle());
		        rowC.createCell(2).setCellValue(timesheet.getDescription());
		        rowC.createCell(3).setCellValue(timesheet.getType());

		      }
		      
		      //Add Data to the second row (index 1)
		      Row rowD = sheet.createRow(1);
		      rowD.createCell(0).setCellValue("Test");

		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
		  }
}