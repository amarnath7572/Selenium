import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcel {

	public ArrayList<String> getData (String sheetName, String ColumnName, String testcaseName) throws IOException
	{
		//ArrayList to store the testdata values
				ArrayList<String> a = new ArrayList();
				
				//external documents can be passed to java objects using FileInputStream 
				FileInputStream fis = new FileInputStream("C:\\Amar_2022\\Automation_Basics\\Selenium_course\\testdata.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				
				//get the sheet count and find the sheet needed
				int count = workbook.getNumberOfSheets();
				
				for(int i=0;i<count;i++)
				{
					if(workbook.getSheetName(i).equalsIgnoreCase(sheetName));
					{
						XSSFSheet sheet = workbook.getSheetAt(i);
						//identify the column which you are looking for i.e. Testcases
						
						Iterator<Row> rows = sheet.iterator();
						Row firstrow = rows.next();
						
						// Iterate through the first row cells
						Iterator<Cell> columns = firstrow.cellIterator();
						
						int k=0;
						int column =0;
						//iterate through first row to find out TestCases
						while(columns.hasNext())
						{
							Cell value = columns.next();
							if(value.getStringCellValue().equalsIgnoreCase(ColumnName))
							{
								//if Testcases column is found, k value is the column index
								column=k;		
							}
							
							k++;	
						}
						
						// Iterate through that column to identify the tc you are looking for i.e. purchase
						while(rows.hasNext())
						{
							Row r = rows.next();
							if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
							{
								// Get all cell values of the tc you are looking for
								Iterator<Cell> cv=  r.cellIterator();
								while(cv.hasNext())
								{
																	
									Cell c = cv.next();
									if(c.getCellType()==CellType.STRING)
									{
										//this method works if all cell values are strings
										a.add(c.getStringCellValue());
									}
									
									else
									{
										//Convert the number to String and then add to the arrayList
										a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
										
									}
									
									
								}
								
							}
						}
						
						
					}
								
				}
				return a;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			
		
	}

}
