<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listChildern.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/default.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/gray/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/JQuery-zTree-v3.5.15/css/zTreeStyle/zTreeStyle.css"/>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div id="search_area" >
    <div id="conditon">
      <table border="0">
        <tr>
          <td>用户名：</td>
          <td ><input  name="userName" id="userName"   /></td>
          <td>&nbsp;性别：</td>
          <td><input  name="sex" id="sex"  /></td>
          <td>&nbsp;部门：</td>
          <td><input  name="department" id="department"  /></td>
          <td>
              <a  href="javascript:void(0)" class="easyui-linkbutton my-search-button" iconCls="icon-search" plain="true">查询</a> 
              <a  href="javascript:void(0)" class="easyui-linkbutton my-search-button" iconCls="icon-reset" plain="true" >重置</a>
          </td>
        </tr>
      </table>
    </div>
<table id="tt"  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF" >
  <!-- 表格顶部工具按钮 -->
  <tr height="40">
  <th  colspan="3" bgcolor="#0066FF" align="right">
  <div id="tt_btn">
      <a href="<%=basePath %>department_addInput?pid=${pId}"  id="save12" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
      <a href="javascript:void(0)"  id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
      <a href="javascript:void(0)"  id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
   </div>
</div>
</th>
</tr>
<tr align="center"><td>编号</td><td>部门名称</td><td>所属部门</td></tr>
<s:iterator value="departments" var="department">
<tr height="30" align="center">
<td width="10%">${id}</td>
<td width="40%">${name}</td>
<td width="50%">${parent.name}</td>

</tr>
</s:iterator>




<tr height="20">
  <td  colspan="3" bgcolor="#0066FF" align="center">

</td>
</tr>
</table>

  </body>
</html>
