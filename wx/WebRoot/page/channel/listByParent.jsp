
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
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-ui-1.11.4.custom/jquery-ui.min.css"/>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<link href="<%=basePath %>js/uploadify/uploadify.css"rel="stylesheet" type="text/css" />

	<!-- uploadify js -->
	<script type="text/javascript" src="<%=basePath %>js/uploadify/jquery.uploadify.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/uploadify/jquery.uploadify.min.js"></script>

     <script type="text/javascript" src="<%=basePath %>/js/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
	
	<style type="text/css">
ul{overflow:hidden;width:100%;list-style:none;}
ul li{float:left;margin-left:20px;margin-top:5px}
.div_op{
         font-size: 12px;		
		 color: FFFFFF ;
		 text-indent: 0px;
		 background-color: #CC0000;
		 line-height: 18px;
		 height: 18px;
		 width: 60px;	
		 overflow:hidden;
		 float:left;
		 margin-left:20;
}
.emp{
  fron-size:12px;
  color:#FF5511;
}


	</style>
	<script type="text/javascript">
	var sort=false;
	
	 $(function(){
	//$("#listChannel").sortable("disable");
	   $(".div_op").on('mouseenter',function(){
	     $(this).css("background-color","#0044BB");
	   });
	  $(".div_op").on('mouseleave',function(){
	     $(this).css("background-color","#CC0000");
	   });
	   
	$("#listChannel").sortable({
	 axis:"y",
	 helper:function(e,ele){
	   var _original =ele.children();
	   var _helper=ele.clone();
	   _helper.children().each(function(index){
	       $(this).width(_original.eq(index).width());
	   });

	   _helper.css("background","#aaf");
	   return _helper;
	 },
	 update:function(e,ui){
	 if(sort){
	    $("#listChannel tr").each(function(index){
	    $(this).find("td:last").html(index+1);
	   });
	 }else{
	 $("#thead").append("<td>序号（拖动排序）</td>");
	  $("#listChannel tr").each(function(index){
	    $(this).append("<td>"+(index+1)+"</td>");   
	    sort=true; 
	 });
	 }
	 }
	} ); 
	  
	 });
	 
   beginSort=function(){
   //   $("#listChannel").sortable( 'enable' )   ;
   };
	endSort=function(){
	if(sort){
	sort=false;
	var ids=$("#listChannel").sortable("serialize",{key:"ids"});
	alert(ids);
	$.ajax({
	  url:"channel_saveOrders",
	  dataType:"json",
	  data:ids,
	  type:"post",
	  success:function(data){
	    
	  },
	  error:function(){
	    alert("request error");
	  }
	});
	$("#thead").find("td:last").remove();
	 $("#listChannel tr").each(function(index){
	    $(this).find("td:last").remove();
	   });
	// $("#channelTable tbody").sortable("disable");
	 }else{
	  alert(" 拖动栏目完成排序");
	 }
	};
	</script>
  </head>
  
  <body>


    <s:form name="channelAddForm" action="channel_add" method="post">
 
    <table id="channelTable" width="90%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="30">
    <th colspan="10" bgcolor="#0066FF" align="right">
      <a href="javascript:void(0)"   class="easyui-linkbutton" plain="true"><font color="white">当前所在栏目:${pc.name}[${pc.id}]</font></a>
   <a href="channel_addInput?pid=${pc.id}"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true"><font color="white">增加子栏目</font></a>
   <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a> 
    </th>
   
    </tr>
     <tr id="thead" align="center" height="40"><td>栏目名称 </td>
     <td> 栏目类型</td><td>是否主页栏目</td><td>是否推荐栏目</td><td>栏目状态 </td><td>操作</td>
     </tr>
     
     
     <tbody id="listChannel">
     <s:iterator value="channels" var="c">
     <tr id="id_${id}" align="center" height="30">
     <td width="20%">${name }</td>
      <td width="20%">${channelType.name}</td>
       <td width="15%"><s:if test="isIndex==0"><div class="emp">不是</div></s:if><s:else><div class="">是</div></s:else></td>
        <td width="15%"><s:if test="recommend==0"><div class="emp">不是</div></s:if><s:else><div class="">是</div></s:else></td>
         <td width="15%"><s:if test="status==0"><div class="emp">停用</div></s:if><s:else><div class="">发布</div></s:else></td>
         <td width="15%">
          <a  href="channel_updateInput?id=${id}"><div class="div_op">更新</div></a>
         <a  href="channel_delete?id=${id}"><div class="div_op">删除</div></a>
         </td>
     </tr>
     </s:iterator>         
    </tbody>
     

      
	
	<tr height="30">
    <td colspan="10" bgcolor="#0066FF" >
   <a href="javascript:void(0)" onclick="endSort()"><div class="div_op" style="text-indent:5px ; float:right ; margin-right:10px">储存排序</div></a>
  <a href="javascript:void(0)" onclick="beginSort()" > <div class="div_op" style="text-indent:5px ; float:right ; margin-right:10px">开始排序</div></a>
   
    </td>
    </tr>
   
    </table>
    </s:form>
  </body>
</html>

