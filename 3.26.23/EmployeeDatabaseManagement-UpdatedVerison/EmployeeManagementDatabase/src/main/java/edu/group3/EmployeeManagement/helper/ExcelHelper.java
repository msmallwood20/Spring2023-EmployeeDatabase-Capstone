package edu.group3.EmployeeManagement.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.standard.SheetCollate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.web.multipart.MultipartFile;

import edu.group3.EmployeeManagement.models.Timesheets;
//This Class Creates a download excel file to be filled in-SYSTEM USED FOR TIMESHEETS
public class ExcelHelper {

	  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Title", "Description", "Header" };
	  static String SHEET = "TimeSheets";
	  
	  //System to Download a excel file
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
		        //Columns 1-4 and through Row 0
		    	//Order of Headers: TimeSheet ID, TimeSheet Title/Name, Staff Full Name, PayPeriod, Day, StartTime, LunchStart, LunchEnd, EndTime, TotalHoursWorked
		        row.createCell(0).setCellValue(timesheet.getId());		        
		        row.createCell(1).setCellValue(timesheet.getTitle());
		        row.createCell(2).setCellValue(timesheet.getDescription());
		      }
		      //Columns 1-4 and through Row 1
		      Row secondRow = sheet.createRow(1);
		      secondRow.createCell(0).setCellValue("New Data 1");
		      secondRow.createCell(1).setCellValue("New Data 2");
		      secondRow.createCell(2).setCellValue("New Data 3");
		      secondRow.createCell(3).setCellValue("New Data 4");
		      
		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
		  }
	  //System to upload a file
	  //Checks if the file is in Excel format or not
	  public static boolean hasExcelFormat(MultipartFile file)
	  {
		  if(!TYPE.equals(file.getContentType()))
		  {
			  return false;
		  }
		  return true;
	  }
	  //Reads an InputStream, and returns a list of timesheets
	  public static List<Timesheets> excelToData(InputStream is)
	  {
		  try {
			Workbook workbook = new XSSFWorkbook(is);
			
			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();
			
			List<Timesheets> timeSheets = new ArrayList<Timesheets>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }
		        
		        Iterator<Cell> cellsInRow =currentRow.iterator();
		        
		        Timesheets timeSheet = new Timesheets();
		        
		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  timeSheet.setId((long) currentCell.getNumericCellValue());
		            break;

		          case 1:
		        	  timeSheet.setTitle(currentCell.getStringCellValue());
		            break;

		          case 2:
		        	  timeSheet.setDescription(currentCell.getStringCellValue());
		            break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        timeSheets.add(timeSheet);
		      }

		      workbook.close();

		      return timeSheets;
		        
		  } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	  }
}





/*
 * References:
 * https://www.codejava.net/frameworks/spring-boot/export-data-to-excel-example
 */