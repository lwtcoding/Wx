<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/default.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/icon.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/extends.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/common.js"></script>

</head>
<body class="easyui-layout" >


<div id="body" region="center" > 
<s:debug></s:debug>
  <!-- 查询条件区域 -->
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
    <span id="openOrClose">111</span> 
  </div>
  <!-- 数据表格区域 -->
  <table id="tt"  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF" >
  <!-- 表格顶部工具按钮 -->
  <tr height="40">
  <th  colspan="9" bgcolor="#0066FF" align="right">
  <div id="tt_btn">
      <a href="<%=basePath %>product_addInput"  id="save12" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
      <a href="javascript:void(0)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true">返回</a> 
  
   </div>
</div>
</th>
</tr>

<tr align="center"><td>编号</td><td>产品编号</td><td>产品名称</td><td>产品状态</td><td>市场价</td><td>销售价</td><td>库存量</td><td>所属类别</td><td>操作</td></tr>
<s:iterator value="products" var="product">
<tr height="30" align="center">
<td width="5%">${id}</td>
<td width="15%">${productNo}</td>
<td width="5%">${name}</td>
<td width="10%">${proStatus.name}</td>
<td width="10%">${marketPrice}</td>
<td width="15%">${price}</td>
<td width="10%">${store}</td>
<td width="10%">${category.name}</td>
<td width="15%"> 
<a href="product_show?id=${id }"  id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
 <a href="product_delete?id=${id }"  id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
</td>

</tr>
</s:iterator>




<tr height="20">
  <td  colspan="9" bgcolor="#0066FF" align="center">


</td>
</tr>
</table>
</body>
</html>
