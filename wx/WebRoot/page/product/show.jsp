
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
    
    <title>添加产品</title>
    
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
ul li{width:10%;float:left;}
	</style>
  </head>
  
  <body>
 <script type="text/javascript">

	$(function(){
  

	$("#upload").click(function() {

			$("#attach").uploadify("upload","*");
		});
		$("#attach").uploadify({
			swf:"<%=basePath%>js/uploadify/uploadify.swf",
			uploader:"<%=basePath%>product_upload",
			fileObjName:"att",
			auto:false,
			'multi' : true,
			fileTypeExts:"*.jpg;*.gif;*.png;*.jpeg;*.*",
			onUploadSuccess:function(file, data, response) {
				//alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
				var ao = $.parseJSON(data);
				var DivNode=document.getElementById("imgDiv");
			alert(ao.result.newName);
				DivNode.innerHTML+="<span><br/><input type='hidden' name='attName' value='"+ao.result.newName+"'/>"+"<img alt='remove' src='upload/thumb/"+ao.result.newName+"'/></span>";
			}
		});
	     $('#more').delegate('li div','click',function(){
	    // $(this).parent().parent().remove();
	   // alert($('[name=patternNo]').val());
	    // alert($(this).find('[name=patternNo]').val()); 
	    var patternNo=$(this).find('[name=patternNo]').val();
	    $.ajax({
	       url:'proPattern_deleteByNo',
	       datatype:'json',
	       data:'patternNo='+patternNo,
	       type:'get',
	       success:function(data){     
	       var result=eval("("+data+")").result; 
	          if(result=='1'){
	           
	           }
	           if(result=='0'){
	            alert('款式编号不能为空');
	           }
	       },
	       error:function(){
	         alert('删除失败');
	       }
	    });
	$(this).parent().remove();
	     } ); 
	     
	     $('#more').delegate('li div','mouseenter',function(){
	    // $(this).parent().parent().remove();
	    //alert($(this).html());
	    $(this).css("background-color","yellow");
	     } ); 
	      
	     $('#more').delegate('li div','mouseleave',function(){
	    // $(this).parent().parent().remove();
	    //alert($(this).html());
	    $(this).css("background-color","#0066FF");
	     } ); 
	});
</script>
  

    <s:form name="departmentAddForm" action="product_add" method="post">
 
    <table  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="40">
    <th colspan="2" bgcolor="#0066FF" align="left">
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>
	<tr height="40" >
	<td>产品名称</td>
   <td colspan="">
   <s:hidden name="productDTO.id"></s:hidden>
	<s:textfield name="productDTO.name" theme="simple"/>
	</td>
     </tr>
     
     <tr height="40" >
     
	<td>市场价</td>
   <td colspan="">
	<s:textfield name="productDTO.marketPrice" theme="simple"/>
	</td>
     </tr>
     
      <tr height="40" >
     <td>本场价格</td>
   <td colspan="">
	<s:textfield name="productDTO.price" theme="simple"/>
	</td>
     </tr>

  <tr height="40" >
     <td>库存</td>
   <td colspan="">
	<s:textfield name="productDTO.store" theme="simple"/>
	</td>
     </tr>
  
     <tr height="40" >
	<td>选择分类</td>
   <td colspan="">
       <s:select list="categorys" listKey="id" listValue="name" name="productDTO.categoryId" theme="simple"></s:select>
	</td>
     </tr>  
   
      <tr height="40" >
	<td width="15%"> <a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="window.open('proPattern_addInput','_blank', 'height=350, width=650, top=60, left=255, toolbar=no,menubar=no, scrollbars=yes,resizable=yes,location=no, status=no')"><font color="black">添加产品款式</font></a></td>
   <td width="85%">
	<ul id="more">	
	
	<s:iterator value="patterns" var='pattern'>
	<li><div  style='width:70px; height:30px;line-height:30px;background-color:#0066FF;font-size:12px'><input type='hidden' name='patternNo' value='${pattern.patternNo }' />
	${pattern.name }<font color='red'>&nbsp;[X]</font></div></li>
	</s:iterator>
	
	</ul>
	
	</td>
     </tr>
   
  <tr height="40" >
     <td>是否上架</td>
   <td colspan="">
	<s:select list="proStatus" listKey="key" listValue="value" name="productDTO.proStatus" theme="simple"></s:select>
	</td>
     </tr>
     
    
     
      
     
	<tr height="0" align="center">
	<td>
	上传产品图片
	</td>
   <td  align="left">
     
	      <input type="file" id="attach"/>
	      <input type="button" value="upload" id="upload"/>
	<div id="imgDiv">
	  <s:iterator value="atts" var="att">
	  <span><br/><input type='hidden' name='attName' value='${newName}'/><img alt='remove' src='upload/thumb/${newName}'/></span>
	  </s:iterator>
	</div>				
	

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

