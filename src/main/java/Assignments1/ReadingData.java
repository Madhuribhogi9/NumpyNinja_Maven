package Assignments1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingData
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\data1.xls");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet)
        {
            for (Cell cell : row)
            {
                System.out.print(cell+" ");
            }
            System.out.println(" ");
        }
    }

}
