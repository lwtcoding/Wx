
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加顾客</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<!--CSS-->
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/default.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/gray/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/icon.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<link href="<%=basePath %>js/uploadify/uploadify.css"rel="stylesheet" type="text/css" />

	<!-- uploadify js -->
	<script type="text/javascript" src="<%=basePath %>js/uploadify/jquery.uploadify.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/uploadify/jquery.uploadify.min.js"></script>
	
	<style type="text/css">
ul{overflow:hidden;width:100%;list-style:none;}
ul li{float:left;margin-left:20px;margin-top:5px}

	</style>
  </head>
  
  <body>

 

    <s:form name="departmentAddForm" action="customer_add" method="post">
 
    <table  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="40">
    <th colspan="2" bgcolor="#0066FF" align="left">
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>
	<tr height="40" >
	<td>帐号</td>
   <td colspan="">
   <s:hidden name="id"/>
	<s:textfield name="userName" theme="simple"/>
	</td>
     </tr>
     
     <tr height="40" >   
	<td>用户名</td>
   <td colspan="">
	<s:textfield name="nickName" theme="simple"/>
	</td>
     </tr>
     
      <tr height="40" >
     <td>密码</td>
   <td colspan="">
<input type="password" name="password"/>
	
	</td>
     </tr>

  <tr height="40" >
     <td>邮箱</td>
   <td colspan="">
	<s:textfield name="email"  theme="simple"/>	

	</td>
     </tr>
     
<tr height="40" >
     <td>性别</td>
   <td colspan="">
	<s:radio list="sexMap" listKey="key" listValue="value" theme="simple" name="sex"/>	
	</td>
     </tr>
     
       
<tr height="40" >
     <td>年龄</td>
   <td colspan=""> 
   <input type="number" name="age" value="20"/>		
	</td>
     </tr>
     
          
<tr height="40" >
     <td>地址</td>
   <td colspan="">
	<s:textfield name="address"  theme="simple"/>	
	</td>
     </tr>
     
    
     
      
	
	<tr height="20">
    <td colspan="2" bgcolor="#0066FF" align="center">
    <a href="javascript:departmentAddForm.submit()"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true"><font color="white">保存</font></a>
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </td>
    </tr>
   
    </table>
    </s:form>
  </body>
</html>

