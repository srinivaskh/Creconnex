package test.Support;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Himanth
 * Date: 8/8/13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class OfficeCommonFunctions {
     public static void UpdateDataToExcel(String pStrSheetName, String pStrFilePath,
                                          int intRowIndex,String pStrColumnName, String pStrData){
         try {
             int intColumnIndex = 0;
             FileInputStream file = new FileInputStream(new File(pStrFilePath));
             HSSFWorkbook workbook = new HSSFWorkbook(file);
             int intSheetIndex= workbook.getSheetIndex(pStrSheetName);
             workbook.setActiveSheet(intSheetIndex);
             HSSFSheet sheet = workbook.getSheetAt(intSheetIndex);
             Cell cell = null;

             Row row = sheet.getRow(0);
             //For each row, iterate through each columns
             Iterator<Cell> cellIterator = row.cellIterator();
             while(cellIterator.hasNext()) {
                cell = cellIterator.next();
                 if(cell.getStringCellValue().trim().equalsIgnoreCase(pStrColumnName.trim())) {
                     intColumnIndex= cell.getColumnIndex();
                     break;
                 }
             }


             //Update the value of cell
             cell = sheet.getRow(intRowIndex).getCell(intColumnIndex);
             cell.setCellValue(pStrData);
             file.close();
             FileOutputStream outFile =new FileOutputStream(new File(pStrFilePath));
             workbook.write(outFile);


             outFile.close();

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    public void AppendDataToExcel(String pStrSheetName,String[] pStrData){
        try {
            int intColumnIndex = 0;
           // InputStream is = this.getClass().getResourceAsStream(System.getProperty("TestCase.file", "/src/test/Resources/ResultsReport.xls"));
           // String file = this.getClass().getResource(System.getProperty("TestCase.file", "/src/test/Resources/ResultsReport.xls")).getPath();
            String file = "D:/RealConnex/out/production/RealConnex/test/Resources/ResultsReport.xls";

            File newFile = new File(file);

            FileInputStream fs = new FileInputStream(new File(newFile.getAbsolutePath()));

            System.out.println("Result Path :" +newFile);
            HSSFWorkbook workbook = new HSSFWorkbook(fs);
            int intSheetIndex= workbook.getSheetIndex(pStrSheetName);
            workbook.setActiveSheet(intSheetIndex);
            HSSFSheet sheet = workbook.getSheetAt(intSheetIndex);
            Cell cell = null;

            Row row = sheet.getRow(0);
            //Get the last row Number
            int intTotalRows = sheet.getLastRowNum();

            //Create new row and cell
            Row NextRow = sheet.createRow(intTotalRows+1);
            for(int intCnt=0;intCnt<pStrData.length;intCnt++){
                cell = NextRow.createCell(intCnt);
                CellStyle cs = workbook.createCellStyle();
                cs.setWrapText(true);
                cell.setCellStyle(cs);
                cell.setCellValue(pStrData[intCnt]);
            }

            FileOutputStream outFile = new FileOutputStream(newFile);
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
