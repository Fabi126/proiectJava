package com.app.ReadWriteExcelApp;

import java.util.List;

import static com.app.ReadWriteExcelApp.ExcelService.createUserData;
import static com.app.ReadWriteExcelApp.ExcelService.writeToExcelSheet;

public class App 
{
    public static void main( String[] args )
    {
        ExcelService servie = new ExcelService();
        writeToExcelSheet();
        List<User> userList = servie.ReadDataFromExcel("C:\\Users\\Lorena\\OneDrive - Total Business Land\\Desktop\\proiectJava\\user.xlsx");


         
    }



}
