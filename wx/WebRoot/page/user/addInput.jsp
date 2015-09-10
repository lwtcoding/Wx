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
    
    <title>添加用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/default.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/icon.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/extends.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/common.js"></script>
  </head>
  
  <body>
 <s:debug></s:debug>


    <s:form name="userAddForm" action="user_add" method="post">
 
    <table  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="40">
    <th colspan="7" bgcolor="#0066FF" align="right">
    <a href="javascript:userAddForm.submit()"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true"><font color="white">新增</font></a>
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>

	<tr height="0">
   <td colspan="2">
        <div class="fitem">
		
			<s:textfield  name="userName" class="easyui-validatebox" required="true" label="用户名" />
						
	      </div>	

	</td>
	</tr>
   <tr height="0">
   <td colspan="2">
        <div class="fitem">
		
			<s:textfield  name="password" class="easyui-validatebox" required="true" label="密码"/>
						
	      </div>	

	</td>
	</tr>
	   <tr height="0">
   <td colspan="2">
        <div class="fitem">
		
			<s:textfield  name="email" class="easyui-validatebox" validType="email" label="邮箱"/>
						
	      </div>	

	</td>
	</tr>
	<tr height="0">
   <td colspan="2">
	
			<s:textfield  name="phone"  label="电话"/>
	</td>
	</tr>
	
   <tr height="0">
   <td colspan="2">	
   		<s:checkboxlist list="roleList" label="选择角色" listKey="id" listValue="name" name="roleIds" required="true"></s:checkboxlist>
	</td>
	</tr>	

	 <tr height="0">
   <td colspan="2">	
   		<s:select list="sexMap" listKey="key" listValue="value" headerKey="NONE" headerValue="--选择性别--" name="sex"></s:select>
	</td>
	</tr>
	
	 <tr height="0">
   <td colspan="2">	
   		<s:select list="departmentList" listKey="id" listValue="name" headerKey="0" headerValue="--选择所属部门--" name="dpId"></s:select>
	</td>
	</tr>
	
	<tr height="20">
    <td colspan="7" bgcolor="#0066FF" align="center">
    <a href="javascript:userAddForm.submit()"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true"><font color="white">保存</font></a>
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </td>
    </tr>
   
    </table>
    </s:form>
  </body>
</html>
