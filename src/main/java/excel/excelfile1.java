package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelfile1 {
	XSSFSheet sheet;

	excelfile1() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Nikhil\\Downloads\\MavenExcelFile.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			sheet=workbook.getSheet("Sheet1");
			
		}
	public String readData(int i,int j)
	{
		Row row=sheet.getRow(i);
		Cell cell=row.getCell(j);
		CellType type=cell.getCellType();
		    switch (type)
		     {
		       case NUMERIC:
			   return String.valueOf(cell.getNumericCellValue());
		       case STRING:
			   return cell.getStringCellValue();
	         }
		return null;
	}
	public int rowsize()
	{
		return sheet.getLastRowNum()+1;
	}
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		excelfile1 ae=new excelfile1();
		for(int i=0;i<ae.rowsize();i++)
		    {
			for (int j=0;j<2;j++)
			{
		//String value=ae.readData(i,j);
		System.out.println(ae.readData(i,j));
	         }

             }
	}
}