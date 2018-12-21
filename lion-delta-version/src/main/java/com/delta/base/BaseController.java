package com.delta.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class BaseController {

	protected Logger logger = null; 
	
	private static final Map info = new HashMap();
	
	public BaseController(){
		  logger = Logger.getLogger(getClass().getName());
	}
	
	public Logger getLogger(){
		return logger;
	}

	public Map getFailureInfo(String data) {
		info.put("info", "-1");
		info.put("data", data);
		return info;
	}

	public Map getSuccessInfo(String data) {
		info.put("info", "1");
		info.put("data", data);
		return info;
	}

	public Map getFailureInfo() {
		return getFailureInfo("操作失败");
	}
	public Map getSuccessInfo() {
		return getSuccessInfo("操作成功");
	}
	
	
	
	
}
