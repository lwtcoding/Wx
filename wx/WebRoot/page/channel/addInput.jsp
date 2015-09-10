
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
    
    <title>添加栏目</title>
    
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
.channelDiv{
font-size: 12px;
		 font-weight: bold;
		 color: #FF6600;
		 text-indent: 10px;
		 background-color: #DAEEF8;
		 line-height: 24px;
		 height: 24px;
		 width: 100px;
		 margin-left: 20px;
		 float:left;
		 overflow:hidden;
}
	</style>
  </head>
  
  <body>


    <s:form name="channelAddForm" action="channel_add" method="post">
 
    <table  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="40">
    <th colspan="2" bgcolor="#0066FF" align="left">
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>
	<tr height="40" >
	<td width="15%">栏目名称</td>
   <td width="85%">
   <s:hidden name="id"/>
	<input type="text" name="name" style="width:400px;"/>
	</td>
     </tr>
     
     <tr height="40" >   
	<td>是否自定义链接</td>
   <td colspan="">
	<s:select list="#{0:'否',1:'是'}" theme="simple" name="customLink"></s:select>
	</td>
     </tr>
     
      <tr height="40" >
     <td>自定义链接地址</td>
   <td colspan="">
<input type="text" name="customLinkURL" size="200px"/>
	
	</td>
     </tr>

  <tr height="40" >
     <td>栏目类型</td>
   <td colspan="">
	<s:select list="types" listKey="key" listValue="value" headerValue="网站系统栏目" name="channelType" theme="simple"></s:select>

	</td>
     </tr>
     
<tr height="40" >
     <td>是否主页栏目</td>
   <td colspan="">
	<s:select list="#{0:'否',1:'是'}" theme="simple" name="isIndex"></s:select>
	</td>
     </tr>
     
     <tr height="40" >
     <td>是否推荐栏目</td>
   <td colspan="">
	<s:select list="#{0:'否',1:'是'}" theme="simple" name="recommend"></s:select>
	</td>
     </tr>
     
     <tr height="40" >
     <td>栏目状态</td>
   <td colspan="">
	<s:select list="#{0:'停用',1:'发布'}" theme="simple" name="status"></s:select>
	</td>
     </tr>
     
       

     
          
<tr height="40" >
     <td>父类栏目</td>
   <td colspan="">
	<input type="text" name="pid" value="${pc.id}"/>
		 <div class="channelDiv">${pc.name }</div>	
	</td>
     </tr>
     
    <tr height="40" >
     <td>导航序号</td>
   <td colspan=""> 
   <input type="number" name="navOrder" value="20"/>		
	</td>
     </tr>
     
      
	
	<tr height="20">
    <td colspan="2" bgcolor="#0066FF" align="center">
    <a href="javascript:channelAddForm.submit()"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true"><font color="white">保存</font></a>
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </td>
    </tr>
   
    </table>
    </s:form>
  </body>
</html>

