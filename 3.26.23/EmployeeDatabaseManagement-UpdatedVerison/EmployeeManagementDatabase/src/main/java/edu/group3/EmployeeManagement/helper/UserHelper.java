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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import edu.group3.EmployeeManagement.models.User;

public class UserHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "FirstName", "LastName", "UserName", "Password"};
	  static String SHEET = "User";
	  
	  //System to Download a excel file
	  public static ByteArrayInputStream dataToUser(List<User> users) {

		    try (Workbook userWorkbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		      Sheet sheet = userWorkbook.createSheet(SHEET);

		      // Header
		      Row headerRow = sheet.createRow(0);

		      for (int col = 0; col < HEADERs.length; col++) {
		        Cell cell = headerRow.createCell(col);
		        cell.setCellValue(HEADERs[col]);
		      }

		      int rowIdx = 1;
		      for (User user : users) {
		        Row row = sheet.createRow(rowIdx++);
		        //Columns 1-4 and through Row 0
		    	//Order of Headers: Id, FirstName, LastName, UserName, Paswsword
		        row.createCell(0).setCellValue(user.getId());		        
		        row.createCell(1).setCellValue(user.getFirstName());
		        row.createCell(2).setCellValue(user.getLastName());
		        row.createCell(3).setCellValue(user.getUsername());
		        row.createCell(4).setCellValue(user.getPassword());
		      }

		      userWorkbook.write(out);
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
	  //Reads an InputStream, and returns a list of User
	  public static List<User> excelToData(InputStream is)
	  {
		  try {
			Workbook userWorkbook = new XSSFWorkbook(is);
			
			Sheet sheet = userWorkbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();
			
			List<User> users = new ArrayList<User>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }
		        
		        Iterator<Cell> cellsInRow =currentRow.iterator();
		        
		        User user = new User();
		        
		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	  user.setId((int) currentCell.getNumericCellValue());
		            break;

		          case 1:
		        	  user.setFirstName(currentCell.getStringCellValue());
		            break;

		          case 2:
		        	  user.setLastName(currentCell.getStringCellValue());
		            break;

		          case 3:
		        	  user.setUsername(currentCell.getStringCellValue());
		            break;
		            
		          case 4:
			        user.setPassword(currentCell.getStringCellValue());
		        	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		      		String encodedPassword = passwordEncoder.encode(user.getPassword());
		      		user.setPassword(encodedPassword);
		            break;
		            
		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        users.add(user);
		      }

		      userWorkbook.close();

		      return users;
		        
		  } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	  }
}
