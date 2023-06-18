package com.uiautomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiautomation.constants.FrameworkConstants;
import com.uiautomation.exceptions.FrameworkException;
import com.uiautomation.exceptions.InvalidPathForExcelException;

public final class ExcelUtils {

	private ExcelUtils() {
		
	}
	
	public static List<Map<String,String>> getTestDetails(String sheetname){
		List<Map<String, String>> list = null;	
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelpath());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			
			XSSFSheet sheet = workbook.getSheet(sheetname);
			
			Map<String, String> map =null;
			list = new ArrayList<Map<String, String>>();
			
			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();
			
			for(int i=1;i<=lastrownum;i++) {
				map=new HashMap<String, String>();
				for(int j=0;j<lastcolnum;j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
					
				}
				list.add(map);
			}
			
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			throw new InvalidPathForExcelException("Excel File you are trying to read is not found");
		} catch (IOException e) {
//			e.printStackTrace();
			throw new FrameworkException("Some IO Exception triggered while reading file");
		}
//		finally {
//			try {
//				if(Objects.nonNull(fs)) {
//					fs.close();
//				}
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		return list;
		
	}
}
