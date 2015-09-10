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
<style type="text/css">
.product{ border:1px solid #000;}
  ul,li{margin:0px;padding:0px;}
  ul{width:200px;background:white;float:left;list-style:none;}
  .content{margin-left:20px;margin-top:20px;}
</style>
</head>
<body class="easyui-layout" >


<div id="body" region="center" > 
<div>用户：${loginUser.userName}---------<a href="scartItem_showScart">购物车商品<strong><s:if test="#session.myScart.itemNum==null">0</s:if><s:else>${myScart.itemNum}</s:else></strong>件</a></div>

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
  <s:iterator value="productDTOs" var="dto">

  <ul class="content" >
    <div class="product">
  <li><img  width="198px" height="150px" src="upload/thumb/${attName[0]}"/></li>
  <li >${name}</li>
  <hr/>
  <li>
  <strike>${marketPrice }</strike></li>
   <hr/>
  <li><font color="red">${price}</font></li>
    <hr/>
  <li><a href="product_showShop?id=${id}">购买</a></li>
   </div>
  </ul>
  
  </s:iterator>
 
</body>
</html>
