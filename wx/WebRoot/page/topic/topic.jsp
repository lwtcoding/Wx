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
<title>文章管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/default.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/gray/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/JQuery-zTree-v3.5.15/css/zTreeStyle/zTreeStyle.css"/>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/JQuery-zTree-v3.5.15/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/extends.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/common.js"></script>
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
		var cid=node.id;
		$("#topicFrame").attr({src:"topic_list?cid="+cid});
		/*
			 zTree = $.fn.zTree.getZTreeObj("dpTree");
			if(node.isParent) {
				zTree.expandNode();
			} else {
				
			}
			*/
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
  
  	$.fn.zTree.init($("#tree"), setting, treeNodes);
     zTree = $.fn.zTree.getZTreeObj("tree"); 
     zTree.expandAll(true);
});

</script>
</head>
<body class="easyui-layout" style="" >

    <div region="west" split="true" style="width:180px; ">
				<ul class="ztree" style="margin-top:20px; margin-left:15px" id="tree">
				</ul>
	</div>
<div id="body" region="center"  style="width: 1300px; height: 100%;"> 
	<div style="width: 1200px; height: 50px; margin: 0 auto; background-color: #0066ff">
	 <div style="font-size: 12px;color: #fff; margin-top: 15px;margin-left:100px; float: left;">欢迎使用银联通莞CMS.技术支持由lwt提供</div>
	  <div style="font-size: 24px;color: #fff; margin-top: 6px;margin-right:6px; float: right;">新增</div>
	</div>
	 <div style="width: 1100px;height:100%; margin: 0 auto;">
	 <div style="background-color: #4169E1 ;color: #ffffff;">
	
	 <form action="">
	   标题：<input />
	     内容：<input />
	       作者：<input />
	   <select>
	     <option>按部门查询</option>
	   </select>
	    <a href="javascript:void(0)" style="text-decoration: none;" ><font style="color: #ffffff;font-size: 12px;"> 提交</font></a>
	   </form>
	 </div>
	 <iframe src="" id="topicFrame" width="100%" height="100%" frameborder="no" border="0"  scrolling="yes" ></iframe>
	 </div>
 </div>
</body>
</html>
