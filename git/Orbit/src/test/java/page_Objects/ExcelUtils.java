package page_Objects;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
//componenets of excel- file,workbook,sheet,row,cell
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	//file classes from java//xssf from apache poi
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile);// to read the file use fileInputStream
		wb=new XSSFWorkbook(fi);//purticular file workbook
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();//this method provides upto data row
		wb.close();
		fi.close();
		return rowcount;
	}
	public static int getCellCount(String xlfile,String xlsheet, int rownum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);//rownum 
		int cellcount=row.getLastCellNum();//upto data cell count
		wb.close();
		fi.close();
		return cellcount;
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);//purticular row cell data
		cell=row.getCell(colnum);
		
		String data;
		try
		{
			//data=cell.toString();
			DataFormatter formatter=new DataFormatter();//class use this to  dataformater to get data otherwise throw exception
			data= formatter.formatCellValue(cell);
			return data;
			
		}catch(Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
		
	}
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());//fill the green color to cell
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());//fill the red color to cell
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}}
