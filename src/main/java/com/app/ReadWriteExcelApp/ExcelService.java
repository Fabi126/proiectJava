package com.app.ReadWriteExcelApp;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelService {
	
	
    
	public static void writeToExcelSheet() {
    	
		  String[] row_heading = {"Nume","Prenume","Adresa","Email"};

		  List<User> users = createUserData();

    	 XSSFWorkbook workbook = new XSSFWorkbook();
         
         XSSFSheet spreadsheet = workbook.createSheet( "Detalii User ");
			Row headerRow = spreadsheet.createRow(0);

         // creare header
	        for (int i = 0; i < row_heading.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(row_heading[i]);
			}

	        for(int i = 0; i < users.size(); i++) {
	        	Row dataRow = spreadsheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(users.get(i).getNume());
	        	dataRow.createCell(1).setCellValue(users.get(i).getPrenume());
	        	dataRow.createCell(2).setCellValue(users.get(i).getAdresa());
	        	dataRow.createCell(3).setCellValue(users.get(i).getEmail());
	        } 
	        

	        FileOutputStream out;
			try {
				out = new FileOutputStream( new File("C:\\Users\\Lorena\\OneDrive - Total Business Land\\Desktop\\proiectJava\\user.xlsx"));
				 
		        workbook.write(out);
		        out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


    }
    
    
	public static  List<User> createUserData() {
		Scanner scanner=new Scanner(System.in);


		List<User> users = new ArrayList<User>();
		users.add(new User("Lidia", "Pater", "Oradea","lidi@gmail.com" ));
		users.add(new User("Razvan", "Stiop", "Bucuresti","razvi@gmail.com"));
		users.add(new User("Julia", "Pop",  "Alba","julia@gmail.com"));
		users.add(new User("Magda", "Mihuc", "Margita","magda@gmail.com"));
		users.add(new User("Marius", "Hodorog",  "Bihor","marius@gmail.com"));
		users.add(new User("Ana","Maria",  "Oradea","anamaria@gmail.com"));
		for(int i =0;i<2;i++){
			users.add(new User(scanner.next(),scanner.next(),scanner.next(),scanner.next()));
		}

    	return users;
	}
	
	
  
	public List<User> ReadDataFromExcel(String path) {

		List<User> userList = new ArrayList<User>();
		
		try {
            XSSFWorkbook workbook = new XSSFWorkbook(path);

			// Retrieving the number of sheets in the Workbook
	        System.out.println("Workbookul are " + workbook.getNumberOfSheets() + " Sheets : ");
	        for(Sheet sheet: workbook) {
	        	
	        	
	        	int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	        	System.out.println("rowCount: "  +  rowCount);
	        	 for (int i=1; i<=rowCount; i++) {
	        		 Row row = sheet.getRow(i);
	        		 System.out.println("nr rows: "  +  row.getRowNum() );
	        		 String nume = row.getCell(0).getStringCellValue();
	        		 String prenume = row.getCell(1).getStringCellValue();
	        		 String email = row.getCell(2).getStringCellValue();
	        		 String adresa = row.getCell(3).getStringCellValue();
	             	
	                 System.out.println("Numele: "  + nume);
	                 System.out.println("Prenumele: "  + prenume);
	                 System.out.println("Email: "  + email);
	                 System.out.println("Adresa: "  + adresa);
	                 
	              User user = new User();
	              user.setNume(nume);
	              user.setPrenume(prenume);
	              user.setAdresa(adresa);
	              user.setEmail(email);
	              
	              userList.add(user);   
	        	 }
	        	
	        }
		}catch (IOException e) {
			e.printStackTrace();
		}


		return userList;
	
		
		
	}
	
	

}
