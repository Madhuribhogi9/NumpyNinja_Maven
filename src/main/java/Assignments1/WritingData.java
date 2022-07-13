package Assignments1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WritingData
{
    public static void main(String[] args) throws IOException
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet worksheet = workbook.createSheet("student");
        XSSFRow row;

        Map<String,Object[]> map = new HashMap<String, Object[]>();
        map.put("1",new Object[]{"rollno","name","year","grade","gender","city"});
        map.put("2",new Object[]{"1", "raja", "2012", "a", "m", "vizag"  });
        map.put("3",new Object[]{"2", "roja", "2011", "b", "f", "srikakulam"  });
        map.put("4",new Object[]{"3", "mahesh", "2032", "a", "m", "vizag"  });
        map.put("5",new Object[]{"4", "rani", "2012", "a", "f", "Hyderabad"  });

        Set<String> keyid = map.keySet();
        int rowid =0;
        for (String key : keyid)
        {
            row = worksheet.createRow(rowid++);
            Object [] obj = map.get(key);
            int cellid =0;
            for (Object o : obj)
            {
              Cell cell = row.createCell(cellid++);
              cell.setCellValue((String)o);
            }
        }
        FileOutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\testingdata.xlsx");
        workbook.write(out);
        out.close();





    }
}
