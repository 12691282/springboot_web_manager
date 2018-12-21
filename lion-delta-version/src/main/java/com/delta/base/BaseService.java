package com.delta.base;

import org.apache.log4j.Logger;

import com.delta.tools.PaginationContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;

public class BaseService {

	protected Logger logger = null; 
	
	public BaseService(){
		  logger = Logger.getLogger(getClass().getName());
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	
	public Page setPageNumber(String orderBy) {
		 if(orderBy == null){
			 orderBy = "id DESC";
		 }
		 return PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize(), orderBy);
	}
	
	public Page setPageNumber() {
		 return  setPageNumber(null);
	}
	
}
