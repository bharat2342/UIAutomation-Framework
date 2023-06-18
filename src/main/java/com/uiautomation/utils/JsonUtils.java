package com.uiautomation.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uiautomation.constants.FrameworkConstants;
import com.uiautomation.enums.ConfigProperties;



public final class JsonUtils {

	private JsonUtils() {

	}

	
	private static Map<String,String> CONFIGMAP ;

	static {
		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonconfigfilepath()), 
					new TypeReference<HashMap<String,String>>(){});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property Name "+key+"is not found please check config properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
	
//	public static String getValue(String key) throws Exception {
//
//		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
//			throw new Exception("Property Name "+key+"is not found please check config properties");
//		}
//		return property.getProperty(key);
//	}
}
