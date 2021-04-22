package adact.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelInteg {
public static String getData(int row,int cell) throws IOException
{
	File f=new File("C:\\Users\\sethu\\eclipse-workspace\\FaceBook\\Sheet_Assign9_10\\AdactWorkbook.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fis);
	Sheet s = w.getSheet("Sheet3");
	Row r=s.getRow(row);
	Cell c =r.getCell(cell);
	int cellType = c.getCellType();
	String value=null;
	if(cellType==1)
	{
		value=c.getStringCellValue();
		//System.out.println(value);
	}
	else if(cellType==0)
	{
		if(DateUtil.isCellDateFormatted(c))
		{
			Date dateCellValue = c.getDateCellValue();
			System.out.println(dateCellValue);
			SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy");
			value=sim.format(dateCellValue);
			//System.out.println(value);
		}
		else
		{
			double numericCellValue = c.getNumericCellValue();
			long l =(long)numericCellValue;
			String valueOf = String.valueOf(1);
			//System.out.println(valueOf);
		}
	}
	return value;
	}
}
