<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	    <#if order?? && order?size>0)>	   
	        <div class="ui_content">
	            <div class="ui_text_indent">
	                <div id="box_border">
	                    
	                    <div id="box_bottom">
	                    	<#assign columnMap=orderResourcePool.header.columns/>
							<#assign columnNames=columnMap?keys/>   
							<p><span>【OrderResourcePool】 </span>
	                        <#list columnNames as columnName>
		                        <span>${columnName}</span>
		                        <#if columnMap[columnName].equal>
		                        [ <span>${columnMap[columnName].meValue!""},${columnMap[columnName].dbValue!""}</span> ]
		                        <#else>
		                        [ <span id="span">${columnMap[columnName].meValue!""},${columnMap[columnName].dbValue!""}</span>]
		                        </#if>
		                        &nbsp;&nbsp;
	                        </#list>
	                        </p>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="ui_content">
	            <div class="ui_tb">
	                <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
	                   <#list orderResourcePool.items as row>
	                    	<#assign columnMap=row.columns/>
							<#assign columnNames=columnMap?keys/> 
														
	                    	<#if row_index == 0>	                    			                    	       
		                        <!-- 输出Item部分Header -->
		                        <tr>
		                        	<th>ID</th>
		                        	<th>Item</th>
			                        <#list columnNames as columnName>
			                        	<th title = "${columnMap[columnName].descption}" >${columnName}</th>
			                        </#list>			                        
		                        </tr>
		                    </#if>
		                    
		                    <!-- 输出Item的内存部分 -->
	                        	<#if (row_index+1) % 2 == 0>
	                            	<tr>
	                            <#else>
	                            	<tr id="tr_odd">
	                            </#if>	   
	                            		<td rowspan=2>${row_index + 1}</td>
	                            		<td>new</td>	                 	
				                        <#list columnNames as columnName>
				                        	<td>
					                        	<#if columnMap[columnName].equal>
							                        <span>${columnMap[columnName].meValue!""}</span>
							                        <#else>
							                        <span id="span">${columnMap[columnName].meValue!""}</span>
					                        	</#if>
					                        </td>					                        
				                        </#list>
		                        	</tr>	                    	
	                		<!-- 输出Item的DB部分 -->                	
	                 		<#if (row_index+1) % 2 == 0>
	                         	<tr>
	                         <#else>
	                         	<tr id="tr_odd">
	                         </#if>	      
	                         		<td>old</td>	              	
	                        <#list columnNames as columnName>
	                        	<td>					                        	
				                    <span>${columnMap[columnName].dbValue!""}</span>							                        					                        	
		                        </td>					                        
	                        </#list>
	                      	</tr>	                    	                    		
	                	</#list>
	                </table>
	            </div>
	        </div>
		<#else>
	    	<font style="color:red">没有计算出order</font>
	    </#if>
	    </div>

</body>
</html>