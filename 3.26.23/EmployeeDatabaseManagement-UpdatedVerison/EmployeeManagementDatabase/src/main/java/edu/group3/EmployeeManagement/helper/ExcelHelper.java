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
	  static String[] HEADERs = { "Id", "FirstName", "PayPeriod-Week#" };
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
		        //Columns 1-9 and through Row 0
		        //A1-H1
		    	//Order of Headers: TimeSheet ID, Username, PayPeriod-Week#, Monday-Start, Monday-StartLunch, Monday-EndLunch, Monday-End, Total For Week

		        row.createCell(0).setCellValue(timesheet.getId());		        
		        row.createCell(1).setCellValue(timesheet.getFirstName());
		        row.createCell(2).setCellValue(timesheet.getpayperiod_week());
				/*
				 * row.createCell(3).setCellValue(timesheet.getDay_1_start());
				 * row.createCell(4).setCellValue(timesheet.getDay_1_lunchstart());
				 * row.createCell(5).setCellValue(timesheet.getDay_1_lunchend());
				 * row.createCell(6).setCellValue(timesheet.getDay_1_end());
				 * row.createCell(7).setCellValue(timesheet.getDay_1_total());
				 */
		      }
		      //Columns 1-9 and through Row 1
		      //A2-H2
		      Row secondRow = sheet.createRow(1);
		      secondRow.createCell(7).setCellValue("=MOD(G2-D2,1)*24-MOD(F2-E2,1)*24 ");
		      
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
		        	  timeSheet.setFirstName(currentCell.getStringCellValue());
		            break;

		          case 2:
		        	  timeSheet.setpayperiod_week(currentCell.getStringCellValue());
		            break;

				/*
				 * case 3: timeSheet.setDay_1_start(currentCell.getStringCellValue()); break;
				 * 
				 * case 4: timeSheet.setDay_1_lunchstart(currentCell.getStringCellValue());
				 * break;
				 * 
				 * case 5: timeSheet.setDay_1_lunchend(currentCell.getStringCellValue()); break;
				 * 
				 * case 6: timeSheet.setDay_1_end(currentCell.getStringCellValue()); break;
				 * 
				 * case 7: timeSheet.setDay_1_total(currentCell.getStringCellValue()); break;
				 */
		            
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