package com.uiautomation.constants;

import com.uiautomation.enums.ConfigProperties;
import com.uiautomation.utils.PropertyUtils;

public final class FrameworkConstants {
	
	
	
	private FrameworkConstants() {
		
	}
	
	private static final String RESOURCESPATH=System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH=RESOURCESPATH+"/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH=RESOURCESPATH+"/config/config.properties";
	private static final String JSONCONFIGFILEPATH=RESOURCESPATH+"/config/config.json";
	private static final String EXCELPATH=RESOURCESPATH+"/excel/testData.xlsx";
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output";
	private static String extentReportFilePath="";
	
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	

	public static String getExtentReportFilePath(){
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath(){
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"/index.html";
		}else {
		return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
	
	private static final int EXPLICITWAIT = 10;
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getJsonconfigfilepath() {
		return JSONCONFIGFILEPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}


	

}
