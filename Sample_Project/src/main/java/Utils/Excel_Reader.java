package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excel_Reader {
	
	WebDriver driver;
	List<String> keyword ;
	String projectPath = System.getProperty("user.dir");
	
	
	@SuppressWarnings("resource")
	public List<String> Keywords(int activesheet) throws InterruptedException, IOException {
	List<String> keyword = new ArrayList<String>();
	XSSFRow row = null;
	
	File file = new File("C:\\Users\\pdeepika\\eclipse-workspace\\Sample_Project\\src\\test\\resources\\Utilities\\Excel\\Top_keywords.xlsx");
	FileInputStream inputStream = new FileInputStream(file);

	XSSFWorkbook workbook = null;

	workbook = new XSSFWorkbook(inputStream);
	int sheetind = workbook.getNumberOfSheets();


		XSSFSheet sheet = workbook.getSheetAt(activesheet);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(" row count :" +rowCount);
		int value = rowCount + 1 ;
		System.out.println("number of keywords present : " +value);


		for (int j = 0; j <= rowCount; j++) {

			try {
				row = sheet.getRow(j);
				keyword.add(row.getCell(0).getStringCellValue());

			} catch (Exception e) {
				keyword.add(String.valueOf((int)row.getCell(0).getNumericCellValue()));
			}

		}
		System.out.println("Arraylist of keywords : " +keyword);

	
	return keyword;

}}
