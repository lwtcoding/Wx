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
    isSimpleData : true,              //数据是否采用简单 Array 格式，默认false  
    treeNodeKey : "id",               //在isSimpleData格式下，当前节点id属性  
    treeNodeParentKey : "pId",        //在isSimpleData格式下，当前节点的父节点id属性  
    showLine : true,                  //是否显示节点间的连线  
    checkable : true ,
    callback: {
		onClick:function(e, id, node){
			 zTree = $.fn.zTree.getZTreeObj("dpTree");
			if(node.isParent) {
				zTree.expandNode();
			} else {
				addTabs(node.name, "department_listChildern?pid="+node.id);
			}
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
        url:"<%=basePath%>department_generateTree", 
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。  
           
           // alert(data);  
            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
        }  
    });  
  
  	$.fn.zTree.init($("#dpTree"), setting, treeNodes);
     zTree = $.fn.zTree.getZTreeObj("dpTree"); 
});
function addTabs(title, url, icon){
	if(!$('#tabs').tabs('exists', title)){
		$('#tabs').tabs('add',{  
			title:title,  
			content:'<iframe src="'+url+'" frameBorder="0" border="0" scrolling="no" style="width: 100%; height:500px;"/>',  
			closable:true
		});
	} else {
		$('#tabs').tabs('select', title);
	}
}
</script>
</head>
<body class="easyui-layout" >

<div region="west" split="true" style="width:120px;">

				<ul class="ztree" id="dpTree">
				
				</ul>
			</div>
<div id="body" region="center"  style="width: 100%; height: 100%;"> 
 <div id="tabs" class="easyui-tabs">
    <div title="首页" style="padding:5px;display:block;" >
      <p>模板说明：</p>
        <ul>
          <li>主界面使用 easyui1.3.5</li>
          <li>导航树使用 JQuery-zTree-v3.5.15</li>
        </ul>
      <p>特性说明：</p>
        <ul>
          <li>所有弹出框均显示在顶级父窗口</li>
          <li>修改easyui window拖动，移动时显示窗口而不显示虚线框，并限制拖动范围</li>
        </ul>
    </div>
 </div>
 </div>
</body>
</html>
