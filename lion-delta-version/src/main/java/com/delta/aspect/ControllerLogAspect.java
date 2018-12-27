package com.delta.aspect;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.delta.tools.PaginationContext;


@Aspect
@Component
public class ControllerLogAspect {
    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(public * com.delta.controller.*.*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        this.setPageInfo(request);
        
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        
    }


	/**
	 * 处理分页数据
	 */
    private void setPageInfo(HttpServletRequest request) {
    	
    	int pageNum = 1;
        int pageSize = 10; // 默认每页10条记录
        
        try {
            String pageNums = request.getParameter("pageNum");
            if (pageNums != null && isNumeric(pageNums) ) {
                pageNum = Integer.parseInt(pageNums);
            }
            
            String pageSizes = request.getParameter("pageSize");
            if (pageSizes != null && isNumeric(pageSizes)) {
            	pageSize = Integer.parseInt(pageSizes);
            }
            
            
            PaginationContext.setPageNum(pageNum);
            PaginationContext.setPageSize(pageSize);
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
		
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
    
    public static boolean isNumeric(final CharSequence cs) {
        if (cs == null || cs.length() == 0) {
            return false;
        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
    
}
