
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
    
    <title>登录</title>
    
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
 
  <script type="text/javascript">
  $(function(){
 $("#items").delegate(".charge",function(){alert("a")});
   alert($(".chagre").size());
   $(".chagre").each(function(){
     alert($(this));
   });
  });
   
  
  </script>

    <s:form name="loginForm" action="/login_login" method="post">
 
    <table id="items" width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="40">
    <th colspan="5" bgcolor="#0066FF" align="left">
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>
    <s:set var="total" value="0"/>
    <s:iterator value="scartItemDTOs" var="item">
	<tr height="40" >
	<td>
	<img src="<%=basePath%>upload/thumb/${attNames[0]}">
	${product.name}
	</td>
   <td colspan="">
	${pattern.name}
	</td>
	<td colspan="">
	单价：${pattern.unitPrice}
	</td>
	<td colspan="">
	数量：<input type="number"  value="${quantity}" />
	</td>
	</td>
   <td colspan="">
	金额:<div class="charge">${charge}</div>
	</td>
     </tr>
      <s:set var="total" value="charge+#total"/>
     </s:iterator>
     
  <tr height="100" >
	<td colspan="5" align="right">
	<h1>合计：<s:property value="#total" /></h1>
	<br/>
	<a>结账</a>
     </td>
     </tr>


	
	<tr height="20">
    <td colspan="5" bgcolor="#0066FF" align="center">
    <a href="javascript:loginForm.submit()"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true"><font color="white">保存</font></a>
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </td>
    </tr>
   
    </table>
    </s:form>
  </body>
</html>

