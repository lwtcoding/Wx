<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/jquery-ui-1.11.4.custom/jquery-ui.min.css"/>

<script type="text/javascript" src="<%=basePath %>/js/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<html>
	 <style>

  #sortable { list-style-type: none; margin: 0; padding: 0; width: 450px; }

  #sortable li { margin: 3px 3px 3px 0; padding: 1px; float: left; width: 100px; height: 90px; font-size: 4em; text-align: center; }

  </style>

  <script>

  $(function() {

    $( "#sortable" ).sortable();
 $( "#tablea tbody" ).sortable({
    axis:'y',
    helper:function(e,ele){
      alert(e+"||"+ele);
      return ele;
    },
    update:function(e,ui){
      alert("update");
    }
 });
   // $( "#sortable" ).disableSelection();

  });

  </script>

</head>

<body>

 <table id="tablea" border="1">
   <th>
   <td>asd</td><td>asd</td>
   </th>
   <tbody>
   <tr><td>aaa1</td><td>aaa1</td></tr>
    <tr><td>aaa2</td><td>aaa2</td></tr>
     <tr><td>aaa3</td><td>aaa3</td></tr>
      <tr><td>aaa4</td><td>aaa4</td></tr>
   </tbody>
 </table>

<ul id="sortable">

  <li>1</li>

  <li>2</li>

  <li>3</li>

  <li>4</li>

  <li>5</li>

  <li>6</li>

  <li>7</li>

  <li>8</li>

  <li>9</li>

  <li>10</li>

  <li>11</li>

  <li>12</li>

</ul>

 

 

</body>

</html>
