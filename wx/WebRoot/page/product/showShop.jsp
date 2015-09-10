
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
	
	addItem=function(){
	//alert($("#scartItemAddForm").serialize());
	
	  $.ajax({
	      url:'scartItem_addItem',
	       datatype:'json',
	       data:$("#scartItemAddForm").serialize(),
	       type:'post',
	       success:function(data){     
	    alert(data);
	         
	       },
	       error:function(){
	         alert('失败');
	       }
	  
	  });
	  
	};
</script>
  

    <s:form name="scartItemAddForm" id="scartItemAddForm" action="product_add" method="post">
 
    <table  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
    <tr height="40">
    <th colspan="2" bgcolor="#0066FF" align="left">
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>
	<tr height="200" >
	<td width="20%">
	<img  width="198px" height="150px" src="upload/thumb/${productDTO.attName[0]}"/>
	</td>
   <td width="80%">
   <input type="hidden" name="scartItemDTO.productId" value="${productDTO.id}"/>
   产品名称：${productDTO.name}<br/>
  市场价： <strike> ${productDTO.marketPrice}</strike><br/>
   优惠价：${productDTO.price}
   <br/>	  <br/>
   选择款式：<s:radio list="patterns" listKey="id" listValue="name" label="选择款式" name="scartItemDTO.patternId" theme="simple"></s:radio>
   <br/>
    <br/>
   选择购买数量：<input name="scartItemDTO.quantity" type="number" value="1" >
      <br/>
      <br/>
 <input type="button" onclick="" value="购买"/>&nbsp; <input type="button" onclick="addItem()" value="加入购物车"/>
	</td>
     </tr>
     
    
	<tr height="200" >
	<td colspan="2">
	<center>产品描述</center><hr/>
	<center>
	<img   src="upload/${productDTO.attName[0]}"/>
	</center>
	</td>
     </tr> 
 



	
	<tr height="20">
    <td colspan="2" bgcolor="#0066FF" align="center">
  
    </td>
    </tr>
   
    </table>
    </s:form>
  </body>
</html>

