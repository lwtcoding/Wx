<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ztree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/zTree-zTree_v3-2ffc0fa/css/zTreeStyle/zTreeStyle.css">
     <script type="text/javascript" src="<%=basePath%>js/zTree-zTree_v3-2ffc0fa/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/zTree-zTree_v3-2ffc0fa/js/jquery.ztree.all-3.5.js"></script>
   <SCRIPT type="text/javascript" >
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
         alert("asd");
            zNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
            
        }  
    });  
    });
	var zTree;

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
			beforeClick: function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("dpTree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src",treeNode.file + ".html");
					return true;
				}
			}
		}
	};

	var zNodes ;
	$(document).ready(function(){
		var t = $("#dpTree");
		t = $.fn.zTree.init(t, setting, zNodes);
		var zTree = $.fn.zTree.getZTreeObj("dpTree");
		zTree.selectNode(zTree.getNodeByParam("id", 300));

	});


  </script>
  </head>
  
  <body>
  asdasd
  <ul id="dpTree" class="ztree" style="width:260px; overflow:auto;"></ul>
  </body>
</html>
