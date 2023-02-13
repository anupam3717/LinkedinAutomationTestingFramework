package utlities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ReadXl {
	@DataProvider(name = "provide")
	public String[][] doingXlsx(Method m) throws Exception {
       String name= m.getName();
		File f= new File("D:\\Maven\\testng\\resource\\login.xlsx");
		FileInputStream file=new FileInputStream(f);

		//creating
		Workbook w= WorkbookFactory.create(file);
		Sheet sh=w.getSheet(name);

		int row=sh.getLastRowNum();
		System.out.println("row number"+row);
		int column= sh.getRow(0).getLastCellNum();
        System.out.println("column number "+column);
		String[][] value=new String[row][column];
		DataFormatter dataFormat=new DataFormatter();

		for(int i=1;i<=row;i++) {
			for(int j=0;j<column;j++) {
				value[i-1][j]=dataFormat.formatCellValue(sh.getRow(i).getCell(j));
			}
		}
		
		return value;
		}
	
}


