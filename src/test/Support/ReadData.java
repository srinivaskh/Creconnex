package test.Support;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import test.pages.LoginRealConnexPage;
import test.pages.WaitUtil;
import test.steps.VerificationStatements;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created with IntelliJ IDEA.
 * User: Himanth
 * Date: 8/8/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.*/



public class ReadData  {
/**
     * This function is used to read data from the Excel file
     * @throws Exception
     */


    public static String readDataExcel(String SheetName, int intRowIndex, String pStrColumnName) throws Exception {
        String strCellContent = "";
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new File("D:\\RealConnex\\src\\test\\Resources\\UserDetails.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheet(SheetName);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(cell.getStringCellValue().trim().equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            Row rowData = sheet.getRow(intRowIndex);
            Cell cellData = rowData.getCell(intCoulmnIndex);
            strCellContent = cellData.getStringCellValue();

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strCellContent;
    }

    public static String readTestDataExcel(String SheetName, int intRowIndex, String pStrColumnName) throws Exception {
        String strCellContent = "";
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new File("D:\\RealConnex\\out\\production\\RealConnex\\test\\Resources\\TestData.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(cell.getStringCellValue().trim().equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            Row rowData = sheet.getRow(intRowIndex);
            Cell cellData = rowData.getCell(intCoulmnIndex);
            double dlbCellData = 0;
            if(cellData.getCellType()==0){
                dlbCellData = cellData.getNumericCellValue();
                strCellContent = String.format("%.0f", dlbCellData);

            }else if(cellData.getCellType()==1){
                strCellContent = cellData.getStringCellValue();

            }else if(cellData.getCellType()==2){
                strCellContent = cellData.getCellFormula();

            }
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strCellContent;
    }



/*public static int getUnusedRecordRowNumber_DelinquencyReport(String SheetName, String pStrColumnName) throws Exception {
        int intRowNumber = 0;
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new
                    File("C:\\workspace\\IPMSC\\src\\test\\TestData\\DelinquencyReport.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheet(SheetName);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> Iterator = row.cellIterator();
            while(Iterator.hasNext()) {
                Cell cell = Iterator.next();
                if(cell.getStringCellValue().equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            int intTotalRows = sheet.getLastRowNum();
            for(int intCnt=0;intCnt<=intTotalRows;intCnt++){
                Row rowData = sheet.getRow(intCnt);
                Cell cellData = rowData.getCell(intCoulmnIndex);
                String strCellContent = cellData.getStringCellValue();
                if(strCellContent.equals("Not Used")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;
                }
            }

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return intRowNumber;
    }*/

    /*public static int getAddressNullRecordRowNumber_DelinquencyReport(String SheetName, String pStrColumnName) throws Exception {
        int intRowNumber = 0;
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new
                    File("C:\\workspace\\IPMSC\\src\\test\\TestData\\DelinquencyReport.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheet(SheetName);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> Iterator = row.cellIterator();
            while(Iterator.hasNext()) {
                Cell cell = Iterator.next();
                if(cell.getStringCellValue().equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            int intTotalRows = sheet.getLastRowNum();
            for(int intCnt=0;intCnt<=intTotalRows;intCnt++){
                Row rowData = sheet.getRow(intCnt);
                Cell cellData = rowData.getCell(intCoulmnIndex);
                String strCellContent = cellData.getStringCellValue();
                if(strCellContent.equals("N/A")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;

                }else if(strCellContent.equals("NO ADDRESS FOUND")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;

                }else if(strCellContent.equals("NO ADDRESS LISTED")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;

                }else if(strCellContent.equals("NO ADDRESS ASSIGNED BY CITY")){
                    //get the row number here
                    intRowNumber = intCnt;

                }else if(strCellContent.equals("ADDRESS UNKNOWN")){
                    //get the row number here
                    intRowNumber = intCnt;

                }else if(cellData.getCellType()==3){
                    intRowNumber = intCnt;
                    break;
                }
            }

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return intRowNumber;
    }
*/
   /* public static String readDelinquencyExcel(String SheetName, int intRowIndex, String pStrColumnName) throws Exception {
        String strCellContent = "";
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new
                    File("C:\\workspace\\IPMSC\\src\\test\\TestData\\DelinquencyReport.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            int intSheetIndex= workbook.getSheetIndex(SheetName);
            workbook.setActiveSheet(intSheetIndex);
            HSSFSheet sheet =  workbook.getSheetAt(intSheetIndex);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String pStrColName = cell.getStringCellValue().toString().trim();
                if(pStrColName.equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            Row rowData = sheet.getRow(intRowIndex);
            Cell cellData = rowData.getCell(intCoulmnIndex);
            double dlbCellData = 0;
            if(cellData.getCellType()==0){
                dlbCellData = cellData.getNumericCellValue();
                strCellContent = String.format("%.0f", dlbCellData);

            }else if(cellData.getCellType()==1){
                strCellContent = cellData.getStringCellValue();

            }else if(cellData.getCellType()==2){
                strCellContent = cellData.getCellFormula();

            }else if(cellData.getCellType()==3){
                strCellContent = "";
            }

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strCellContent;
    }*/

/*    public static int getAddressNullRecordRowNumber_EscrowReport(String SheetName, String pStrColumnName) throws Exception {
        int intRowNumber = 0;
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new
                    File("C:\\workspace\\IPMSC\\src\\test\\TestData\\EscrowReport.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheet(SheetName);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> Iterator = row.cellIterator();
            while(Iterator.hasNext()) {
                Cell cell = Iterator.next();
                if(cell.getStringCellValue().equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            int intTotalRows = sheet.getLastRowNum();
            for(int intCnt=0;intCnt<=intTotalRows;intCnt++){
                Row rowData = sheet.getRow(intCnt);
                Cell cellData = rowData.getCell(intCoulmnIndex);
                String strCellContent = cellData.getStringCellValue();
                if(strCellContent.equals("N/A")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;

                }else if(strCellContent.equals("NO ADDRESS FOUND")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;

                }else if(strCellContent.equals("NO ADDRESS LISTED")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;

                }else if(strCellContent.equals("NO ADDRESS ASSIGNED BY CITY")){
                    //get the row number here
                    intRowNumber = intCnt;

                }else if(strCellContent.equals("ADDRESS UNKNOWN")){
                    //get the row number here
                    intRowNumber = intCnt;

                }else if(cellData.getCellType()==3){
                    intRowNumber = intCnt;
                    break;
                }
            }

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return intRowNumber;
    }*/

/*    public static String readEscrowExcel(String SheetName, int intRowIndex, String pStrColumnName) throws Exception {
        String strCellContent = "";
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new
                    File("C:\\workspace\\IPMSC\\src\\test\\TestData\\EscrowReport.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            int intSheetIndex= workbook.getSheetIndex(SheetName);
            workbook.setActiveSheet(intSheetIndex);
            HSSFSheet sheet =  workbook.getSheetAt(intSheetIndex);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String pStrColName = cell.getStringCellValue().toString().trim();
                if(pStrColName.equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            Row rowData = sheet.getRow(intRowIndex);
            Cell cellData = rowData.getCell(intCoulmnIndex);
            double dlbCellData = 0;
            if(cellData.getCellType()==0){
                dlbCellData = cellData.getNumericCellValue();
                strCellContent = String.format("%.0f", dlbCellData);

            }else if(cellData.getCellType()==1){
                strCellContent = cellData.getStringCellValue();

            }else if(cellData.getCellType()==2){
                strCellContent = cellData.getCellFormula();

            }else if(cellData.getCellType()==3){
                strCellContent = "";
            }

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strCellContent;
    }*/




 /* public static int getUnusedRecordRowNumber_EscrowReport(String SheetName, String pStrColumnName) throws Exception {
        int intRowNumber = 0;
        try {
            int intCoulmnIndex = 0;
            FileInputStream file = new FileInputStream(new
                    File("C:\\workspace\\IPMSC\\src\\test\\TestData\\EscrowReport.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheet(SheetName);

            Row row = sheet.getRow(0);
            //For each row, iterate through each columns
            Iterator<Cell> Iterator = row.cellIterator();
            while(Iterator.hasNext()) {
                Cell cell = Iterator.next();
                if(cell.getStringCellValue().equalsIgnoreCase(pStrColumnName)) {
                    intCoulmnIndex= cell.getColumnIndex();
                    break;
                }
            }

            int intTotalRows = sheet.getLastRowNum();
            for(int intCnt=0;intCnt<=intTotalRows;intCnt++){
                Row rowData = sheet.getRow(intCnt);
                Cell cellData = rowData.getCell(intCoulmnIndex);
                String strCellContent = cellData.getStringCellValue();
                if(strCellContent.equals("Not Used")){
                    //get the row number here
                    intRowNumber = intCnt;
                    break;
                }
            }

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return intRowNumber;
    }*/

}
