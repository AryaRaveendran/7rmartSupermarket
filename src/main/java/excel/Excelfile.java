package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfile {

static FileInputStream f;  
static XSSFWorkbook w;
static XSSFSheet s;   

public static String readstringdata(int i,int j,String sheetName,String exelSheet)throws IOException
{   
f=new FileInputStream(exelSheet);   
w=new XSSFWorkbook (f);
s=w.getSheet(sheetName);
Row r =s.getRow(i);//interface
Cell c=r.getCell(j); //interface
return c.getStringCellValue();
}
public static String readIntData(int i,int j,String sheetName,String exelSheet)throws IOException
{
f=new FileInputStream("C:\\Users\\SHABNA\\OneDrive\\Desktop\\Book1.xlsx");
w=new XSSFWorkbook (f);//workbook reading
s=w.getSheet("Sheet1");
Row r =s.getRow(i);
Cell c=r.getCell(j);
//int d=(int)c.getNumericCellValue();
//return String.valueOf(d); //String valueOf  

return c.getStringCellValue();
}
}