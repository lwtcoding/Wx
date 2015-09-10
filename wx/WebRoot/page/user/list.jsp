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
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/default.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-easyui-1.3.5/themes/icon.css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/extends.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/common.js"></script>

</head>
<body class="easyui-layout" >

<div region="west" split="true" style="width:120px;">

				<ul class="easyui-tree">
					<li>
						<span>Library</span>
						<ul>
							<li><span>easyui</span></li>
							<li><span>Music</span></li>
							<li><span>Picture</span></li>
							<li><span>Database</span></li>
						</ul>
					</li>
				</ul>
			</div>
<div id="body" region="center" > 
<s:debug></s:debug>
  <!-- 查询条件区域 -->
  <div id="search_area" >
    <div id="conditon">
      <table border="0">
        <tr>
          <td>用户名：</td>
          <td ><input  name="userName" id="userName"   /></td>
          <td>&nbsp;性别：</td>
          <td><input  name="sex" id="sex"  /></td>
          <td>&nbsp;部门：</td>
          <td><input  name="department" id="department"  /></td>
          <td>
              <a  href="javascript:void(0)" class="easyui-linkbutton my-search-button" iconCls="icon-search" plain="true">查询</a> 
              <a  href="javascript:void(0)" class="easyui-linkbutton my-search-button" iconCls="icon-reset" plain="true" >重置</a>
          </td>
        </tr>
      </table>
    </div>
    <span id="openOrClose">111</span> 
  </div>
  <!-- 数据表格区域 -->
  <table id="tt"  width="100%" border="1" cellspacing="0" cellpadding="0"
     bordercolor="#000000" bordercolordark="#FFFFFF" bgcolor="#FFFFFF" >
  <!-- 表格顶部工具按钮 -->
  <tr height="40">
  <th  colspan="7" bgcolor="#0066FF" align="right">
  <div id="tt_btn">
      <a href="<%=basePath %>user_addInput"  id="save12" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
      <a href="javascript:void(0)"  id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
      <a href="javascript:void(0)"  id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
   </div>
</div>
</th>
</tr>
<tr align="center"><td>编号</td><td>用户名</td><td>性别</td><td>邮箱</td><td>电话</td><td>用户角色</td><td>所属部门</td></tr>
<s:iterator value="userlist" var="user">
<tr height="30" align="center">
<td width="5%">${id}</td>
<td width="15%">${userName}</td>
<td width="5%">${sex.name}</td>
<td width="20%">${email}</td>
<td width="10%">${phone}</td>
<td width="25%">${phone}</td>
<td width="10%">${department.name}</td>
</tr>
</s:iterator>




<tr height="20">
  <td  colspan="7" bgcolor="#0066FF" align="center">
  <div id="tt_btn">
      <a href="<%=basePath %>user_addInput"  id="save12" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
      <a href="javascript:void(0)"  id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
      <a href="javascript:void(0)"  id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
   </div>
</div>
</td>
</tr>
</table>
</body>
</html>
