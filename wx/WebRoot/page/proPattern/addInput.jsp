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
    
    <title>My JSP 'listCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/default.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/gray/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/icon.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>

  </head>
  
  <body>

<form id="form1" name="form1" method="post" action="" onsubmit="return retValue()">
  <table  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="40">
    <th colspan="2" bgcolor="#0066FF" align="left">
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>
	<tr height="40" >
	<td>产品样式名称</td>
   <td colspan="">
	<s:textfield name="pattern.name" theme="simple"/>
	</td>
     </tr>
     <tr height="40" >
	<td>单价</td>
   <td colspan="">
	<s:textfield name="pattern.unitPrice" theme="simple"/>
	</td>
     </tr>



	
	<tr height="20">
	
    <td colspan="2" bgcolor="#0066FF" align="center">
     <a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="ajaxSubmit()"><font color="white">新增</font></a>
    <a href="javascript:void(0)"  onclick="window.close()" class="easyui-linkbutton"  iconCls='icon-no' plain="true"><font color="white">关闭</font></a>
    </td>
    </tr>
   
    </table>
 
     
 
</form>
<script>



function ajaxSubmit(){
//alert($('#form1').serialize());
 $.ajax({
    url:'proPattern_addProPattern',
    data:$('#form1').serialize(),
    dataType:'json',
    type:'POST',
    error:function(){
    alert("error");
    },
    success:function(data){
    
    var str=" <li><div  style='width:70px; height:30px;line-height:30px;background-color:#0066FF;font-size:12px'><input type='hidden' name='patternNo' value='"+data.patternNo+"' />"+data.name+
                  " <font color='red'>&nbsp;[X]</font></div></li>";//也可以把type设置成隐藏.在ie下没问题,其它浏览器没有测试
	window.opener.document.getElementById("more").innerHTML+=str;
	window.close();
    }
 });

	
	}
</script>
</body>

  </body>
</html>
