package com.delta.tools;

import java.util.UUID;

public class IDGeneratorUtil {
	
	public static String getUUID() {
		
		return UUID.randomUUID().toString().replaceAll("-", "");
		 
	}

}
