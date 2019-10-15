package Tester;

import static org.junit.Assert.*;
import java.io.*;
import java.math.BigInteger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class ConverterTest {

//Test from file that contains user number
@Test
    public void testConverterAuto() throws IOException {
        Converter converter = new Converter();
        FileInputStream fileInputStream = new FileInputStream("DataTest/TestConverter.xls");
        Workbook workbook = new HSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for(int i = 0; i < sheet.getLastRowNum()+1; i++) {
            Integer number = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
               String word = sheet.getRow(i).getCell(1).getStringCellValue();

              assertEquals("Error in number: " + number, word,
                        converter.converter(new BigInteger(String.valueOf(number))));
            }

          fileInputStream.close();
       }



    @Test(expected = NumberFormatException.class)
    public void testNumberFormatException() throws Exception {
        Converter converter = new Converter();
        converter.converter(new BigInteger("ABC1334"));
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException() throws Exception {
        Converter converter = new Converter();
        converter.converter(new BigInteger("500000000000000000000000000000000000000000000000000000000000000000000"));
    }
}
