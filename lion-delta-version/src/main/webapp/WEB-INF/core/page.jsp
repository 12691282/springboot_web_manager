 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pagination">
      <ul>
            <c:if test="${!data.isFirstPage}">
                 <li><a href="javascript:queryDeviceRecords(${data.firstPage});">首页</a></li>
                 <li><a href="javascript:queryDeviceRecords(${data.prePage});">上一页</a></li>
             </c:if>     
         	<c:forEach items="${data.navigatepageNums}"  var="navigatepageNum" >
       	  		<c:if test="${navigatepageNum==data.pageNum}">
                     <li href="javascript:queryDeviceRecords(${navigatepageNum});" class="active"><a>${navigatepageNum}</a></li>
                 </c:if>
                 <c:if test="${navigatepageNum!=data.pageNum}">
                     <li><a href="javascript:queryDeviceRecords(${navigatepageNum});">${navigatepageNum}</a></li>
                 </c:if>
         	</c:forEach>
         <c:if test="${!data.isLastPage}">  
         		 <li><a href="javascript:queryDeviceRecords(${data.nextPage});">下一页</a></li>      
                 <li><a href="javascript:queryDeviceRecords(${data.lastPage});">最后一页</a></li>
         </c:if>
         <li><a>共:${data.total}条数据 </a></li>
      </ul>
      <input type="hidden" id="pageSize" value="${data.pageSize}">
</div>
 <script type="text/javascript">
 	function queryDeviceRecords(_num){
 		
 		 var queryForm=document.forms[0];
 		var pageNum = document.createElement("input");
 		pageNum.setAttribute("name", "pageNum");
 		pageNum.setAttribute("value", _num);
 		pageNum.setAttribute("type", "hidden");
 		
 		var pageSize = document.createElement("input");
 		pageSize.setAttribute("name", "pageSize");
 		pageSize.setAttribute("value", document.getElementById("pageSize").value);
 		pageSize.setAttribute("type", "hidden");
 	 
 		queryForm.appendChild(pageNum);
 		queryForm.appendChild(pageSize);
 		$("form[action='list']").submit();
 	}
 </script>
 
