<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
<link href="<%=basePath %>js/uploadify/uploadify.css"rel="stylesheet" type="text/css" />
  </head>
  
  <body>

<form id="form1" name="form1" method="post" action="" onsubmit="return retValue()">
  <p>
    <label>
      <input name="ret" type="radio"  value="1" checked="checked" />
      值1 </label>
    <label>
      <input type="radio" name="ret"  value="2" />
      值2 </label>
    <label>
      <input type="radio" name="ret"  value="3" />
      值3 </label>
    <label>
      <input type="radio" name="ret"  value="4" />
      值4 </label>
  </p>
  <p>
    <label>
     <a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="ajaxSubmit()"><font color="white">新增</font></a>
     
      <input type="submit" name="button" id="button" value="提交" />
      
    </label>
  </p>
</form>
<script>
function ajaxSubmit(){
alert($('#form1').serialize());
 $.ajax({
    url:'proPattern_addProPattern',
    data:$('#form1').serialize(),
    dataType:'json',
    type:'POST',
    error:function(){
    alert("error");
    },
    success:function(data){
    
    var str=" <li><div style='width:70px; height:30px;background-color:#0066FF;font-size:12px'><input type='text' name='patternNo' value='"+data.patternNo+"' />"+data.name+"</div></li>";//也可以把type设置成隐藏.在ie下没问题,其它浏览器没有测试
	window.opener.document.getElementById("more").innerHTML+=str;
	window.close();
    }
 });

	
	}
</script>
</body>

  </body>
</html>
