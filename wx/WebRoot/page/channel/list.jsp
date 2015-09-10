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
<title>部门管理</title>
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
		var pid=node.id;
		$("#channelFrame").attr({src:"channel_listByParent?pid="+pid});
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
  
  	$.fn.zTree.init($("#dpTree"), setting, treeNodes);
     zTree = $.fn.zTree.getZTreeObj("dpTree"); 
});

</script>
</head>
<body class="easyui-layout" >

    <div region="west" split="true" style="width:180px; ">
				<ul class="ztree" style="margin-top:20px; margin-left:15px" id="dpTree">
				</ul>
	</div>
<div id="body" region="center"  style="width: 100%; height: 100%;"> 
 <iframe src="" id="channelFrame" width="100%" height="100%" frameborder="no" border="0"></iframe>
 </div>
</body>
</html>
