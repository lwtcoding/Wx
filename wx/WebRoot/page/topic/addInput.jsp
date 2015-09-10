
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加文章</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

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
	<scripttype="text/javascript"src="js/ckeditor_4.5.2_standard/ckeditor/ckeditor.js"></script>
	     <script type="text/javascript" src="<%=basePath %>/js/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
	     <link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-ui-1.11.4.custom/jquery-ui.min.css"/>
	     <script type="text/javascript" src="<%=basePath %>js/JQuery-zTree-v3.5.15/jquery.ztree.all-3.5.min.js"></script>
	     <link rel="stylesheet" type="text/css" href="<%=basePath %>js/JQuery-zTree-v3.5.15/css/zTreeStyle/zTreeStyle.css"/>
	<style type="text/css">

.op{
         font-size: 12px;		
		 color: FFFFFF ;
		 text-indent: 13px;
		 background-color: #CC0000;
		 line-height: 20px;
		 height: 20px;
		 width: 70px;	
		 overflow:hidden;
		 float:left;
		 margin-left:20;
}
.kw_div{
         font-size: 12px;		
		 color: FFFFFF ;
		 text-indent: 13px;
		 background-color: #0066FF;
		 line-height: 20px;
		 height: 20px;
		 width: 70px;	
		 overflow:hidden;
		 float:left;
		 margin-left:20;
		  margin-top:3px;
		
}
	</style>
	<script type="text/javascript">

	$(function(){
  $("#publishTime").datepicker({
     dateFormat:"yy-mm-dd",
     maxDate:365
  }); 
var oEditor = CKEDITOR.instances.editor1;

	$("#upload").click(function() {

			$("#attach").uploadify("upload","*");
		});
		$("#attach").uploadify({
			swf:"<%=basePath%>js/uploadify/uploadify.swf",
			uploader:"<%=basePath%>topic_upload",
			fileObjName:"att",
			auto:false,
			'multi' : true,
			fileTypeExts:"*.*",
			onUploadSuccess:function(file, data, response) {
				//alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
				var att = $.parseJSON(data);
			if(att.isImage){
			$("#attinfo").append("<tr><td><input type='hidden' name='attid' value='"+att.id+"'/><input type='hidden' name='attNewName' value='"+att.newName+"'/><input type='hidden' name='attOldName' value='"+att.oldName+"'/><img width='80px' height='80px' src='<%=basePath%>upload/topic/thumb/"+att.newName+"'></td>"
			+"<td>"+att.oldName+"</td><td>"+att.size+"</td><td><input type='checkbox' name='indexPicId' value='"+att.id+"'  style='width:15px;height:15px ' /></td>"
			+"<td><input type='radio' name='channelPicId' value='"+att.id+"' checked='checked'  style='width:15px;height:15px '/></td>"
			+"<td><input type='checkbox' name='attachId' value='"+att.id+"' style='width:15px;height:15px '/><input type='hidden' name='isImage' value='"+att.isImage+"'/></td>"
				+"<td><a name='insert' href='javascript:void(0)'><div  class='op'>插入内容</div></a>"
				+"<a name='del' href='javascript:void(0)'><div  class='op' >删除附件</div></a></td></tr>"
			);
			}
			else{
			$("#attinfo").append("<tr><td><input type='hidden' name='attid' value='"+att.id+"'/><input type='hidden' name='attNewName' value='"+att.newName+"'/><input type='hidden' name='attOldName' value='"+att.oldName+"'/>普通附件类型</td>"
			+"<td>"+att.oldName+"</td><td>"+att.size+"</td><td>普通附件类型</td>"
			+"<td>普通附件类型</td>"
			+"<td><input type='checkbox' name='attachId' value='"+att.id+"'  style='width:15px;height:15px '/><input type='hidden' name='isImage' value='"+att.isImage+"'/></td>"
			+"<td><a name='insert' href='javascript:void(0)'><div  class='op'>插入内容</div></a>"
			+"<a name='del' href='javascript:void(0)'><div  class='op' >删除附件</div></a></td></tr>"
			);
			}			
			}
		});
		$("#attinfo").delegate("[name=del]",'click',function(){
		var attName=$(this).parent().parent().find("[name=attNewName]").val();
		var isImage=$(this).parent().parent().find("[name=isImage]").val();
		var trNode=$(this).parent().parent();
	//	alert(trNode);
	//	alert(attName);
	//alert(isImage);
		$.ajax({
			url:'topic_delAtt',
			data:"attName="+attName+"&isImage="+isImage,
			type:'post',
			dataType:'json',
			success:function(data){
			
				trNode.remove();
			},
			error:function(){
			  alert("删除失败");
			}
		});
		
		});
         
        	$("#attinfo").delegate("[name=insert]",'click',function(){
        	 var newName=$(this).parent().parent().find("[name=attNewName]").val();
        	  var oldName=$(this).parent().parent().find("[name=attOldName]").val();
        	  var isImage=$(this).parent().parent().find("[name=isImage]").val();
        	  alert(isImage);
        	//  alert(newName+"||"+oldName);
        	if(isImage==1){
        	 oEditor.setData(oEditor.getData()
         +"<img src='"+"<%=basePath%>upload/topic/"+newName+"'/>"
         );
        	}else{
         oEditor.setData(oEditor.getData()
         +"<a href='<%=basePath%>upload/topic/"+newName+"'>"+oldName+"</a>"
         );
        }
    
        	}); 
        	
        	
        	
         $("#kw_text").on('keydown',function(event){
        if(event.keyCode==32){
         var kw=$(this).val();
         if($.trim(kw)==""){
              $(this).val("");
         }
         else{
         var divNode="<a href='javascript:void(0)'><div class='kw_div'>"+kw+"&nbsp;X"
                      +"</div></a>";
         $(".kw").append(divNode);
       //  alert($("#kws").val());
        $("#kws").val($("#kws").val()+kw+"|");
         $(this).val("");
          } 
          }     
         });
         
         $("#kw_text").on('mouseenter',function(){
         if( $(this).val()=="请输入关键字，输入空格分割"){
           $(this).val("");
         }
           
         });
       
         $("#kw_text").on('mouseleave',function(){
         if( $(this).val()==""){
           $(this).val("请输入关键字，输入空格分割");
         }          
         });
         
         $(".kw").delegate(".kw_div","click",function(){
          var kwDiv= $(this).html();
          //alert(kw);123&nbsp;X
          var kw=$.trim(kwDiv.replace(/&nbsp;X/,""))+"|";
         var kws= $("#kws").val().replace(kw,"");
           $("#kws").val(kws);
         // alert($("#kws").val());
         $(this).parent().remove();
         });
         
         $(".kw").delegate(".kw_div","mouseenter",function(){
           $(this).css({
             "font-size": "14px",		
		 "color": "FFFFFF" ,
		 "background-color": "#228B22",
		 "line-height": "22px",
		 "height": "22px",
	      "width": "72px"
           });
         });
         
         $(".kw").delegate(".kw_div","mouseleave",function(){
           $(this).css({
           "font-size": "12px",		
		 "color": "FFFFFF" ,
		 "background-color": "#0066FF",
		 "line-height": "20px",
		 "height": "20px",
	      "width": "70px"
           });
         });
         
       $("#cname").on('click',showMenu);
	function showMenu(){
	 //alert($(this).offset().left+"||"+$(this).offset().top);
	 $("#ct_contain").css({left:$(this).offset().left+3,top:$(this).offset().top+$(this).height()+7,opacity:0.98}).toggle(1000);
	}
     
	});
	

</script>
  <script type="text/javascript">
var setting = {  
   view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pid",
				rootPId: ""
			}
		},
    callback: {
		onClick:function(e, id, node){
		//alert(node.id+"||"+node.name);
		$("#cname").val(node.name);
		$("#cid").val(node.id);
		$("#ct_contain").toggle(100);
		}
	}                
};  
  
var zTree;  
var treeNodes;  
  
$(function(){  
    $.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url:"<%=basePath%>channel_generateTree", 
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。  
       //var data=eval('('+data+')');
         //  var data=$.parseJSON(data);
         //  var jsonStr=JSON.stringify(data);  
            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
      
        }  
    });  
  
  	$.fn.zTree.init($("#ctree"), setting, treeNodes);
     zTree = $.fn.zTree.getZTreeObj("ctree"); 
     zTree.expandAll(true);
});
   
   
	  
</script>
  </head>
  
  <body >
    

    <s:form name="topicAddForm" action="topic_add" method="get">
 
    <table  width="90%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#0000CD" bgcolor="#FFFFFF"  style="margin:0 auto; min-width: 900px;">
    <tr height="40">
    <th colspan="2" bgcolor="#0066FF" align="left">
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </th>
    </tr>
	<tr height="40" >
	<td>文章标题</td>
   <td colspan="">
   <s:hidden name="id"/>
	<input type="text" name="title" style="width:200px;"/>
	</td>
     </tr>
     
     <tr height="40" >
	<td>文章栏目</td>
   <td colspan="">
   <div id=ct_contain style="width:150px;height:300px;background-color:#A9A9A9  ;display: none;position:absolute;" >
     <ul class="ztree" id="ctree"></ul>
   </div>
   <input type="text" id="cname" name="cname"  readonly="readonly"/>
	<input type="hidden" name="cid" id="cid" />
	</td>
     </tr>
     
      <tr height="40" >
	<td>文章状态</td>
   <td colspan="">
   <input type="radio" name="status" value="0" checked="checked" style="width:15px;height:15px "/>未发布
   <input type="radio" name="status" value="1" style="width:15px;height:15px "/>已发布
	</td>
     </tr>

  <tr height="40" >
	<td>是否推荐文章</td>
   <td colspan="">
   <input type="radio" name="recommend" value="0" checked="checked" style="width:15px;height:15px"/>不推荐
   <input type="radio" name="recommend" value="1" style="width:15px;height:15px "/>推荐
	</td>
     </tr>
     
    <tr height="40" >
	<td>发布时间</td>
   <td colspan="">
      <input type="text" name="publishDate" id="publishTime" readonly="readonly"/>
	</td>
     </tr>
     
      <tr height="40" >
	<td>文章关键字</td>
   <td colspan="">
   <input id="kws" name="keyword" type="hidden" value=""/>
       <div class="kw_contain">
       <div class="kw" style="width:500px;height:auto;float:top; ">
       
       </div>
       <div class="kw_input" style="width:100px; float:top; margin-left:15px;" >
         <input id="kw_text" type="text" value="请输入关键字，输入空格分割" style="width:200px" />
       </div>
       </div>
	</td>
     </tr>
     
      <tr height="40" >
	<td>文章关附件</td>
   <td colspan="">
   <input type="file" id="attach" multiple="true"/><input type="button" id="upload" value="上传文件"/>
	</td>
     </tr>
     
      <tr height="30" >
	
   <td colspan="2">
   已传附件
	</td>
     </tr>
     
     <tr height="30">
     <td colspan="2" align="center">
      <table id="attinfo" width="90%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bgcolor="#FFFFFF">
         <tr  bgcolor="#0066FF" style="color:#FFFFFF;"><td width="10%">文件名缩略图</td><td  width='15%'>文件名</td><td width="5%">文件大小</td><td  width='7%'>主页图片</td><td  width='7%'>栏目图片</td><td  width='5%'>附件信息</td><td  width='20%'>操作</td></tr>
      </table>
	</td>
     </tr>
      
     <tr height="30" >	
   <td colspan="2" >
文章内容
	</td>
     </tr>
     
     <tr >	
   <td colspan="2">
<textarea rows="" cols="" name="content" id="editor1"></textarea>
<ckeditor:replace replace="content" basePath="js/ckeditor_4.5.2_standard//ckeditor/" />
	</td>
     </tr>
	 <tr height="30" >	
   <td colspan="2" >
文章摘要
	</td>
     </tr>
     
     <tr >	
   <td colspan="2">
<textarea rows="5" cols="160" name="summary"></textarea>
	</td>
     </tr>
	<tr height="20">
    <td colspan="2" bgcolor="#0066FF" align="center">
    <a href="javascript:topicAddForm.submit()"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true"><font color="white">保存</font></a>
    <a href="javascript:history.go(-1)"  id="back" class="easyui-linkbutton" iconCls="icon-back" plain="true"><font color="white">返回</font></a>
    </td>
    </tr>
 
	<tr height="70">
   <td colspan="2">
    
   </td>
    </tr>
    
   
    </table>
    </s:form>
  </body>
</html>

