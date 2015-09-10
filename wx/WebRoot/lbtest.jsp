<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	
	<style type="text/css">
	*{
		padding: 0;
		margin: 0 0 0 0;
	}
	#showUserImg{
		height: 232px;
		border: 1px solid #000;
		overflow: hidden;
	}
	#award{
	
		width: 200px;
		
		margin: 0 auto;
	}
	#award .userImg{
		width: 200px;
		height: 232px;
		
	}
		#award .userImg img{
		width: 200px;
		height: 232px;
		
	}
	</style>
	<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
	<script type="text/javascript">
	$(function(){
	var index=0;
	var awardTimer;
	$("#start").click(function(){
	awardTimer=setInterval(function(){
	 ++index;
	$("#award").animate({
            "marginTop": (-232 * (index)+2) + "px"    
        }, 100 ,function(){
        
        if(index>=10){
        	index=0;
        }
        });
       
	},100);
	});
		$("#pause").click(function(){
		//使用ajax从后台获取要停留的ID，再使图片停止，图片ID按用户Id编号
		clearInterval(awardTimer);
		//	alert(index);
			$("#award").animate({
            "marginTop": (-232 * (1)+2) + "px"    
        }, 50 );
		});
	});
		
	</script>
	</head>
	<body>
	<div id="showUserImg">
	<div id="award">
	 <div class="userImg">begin <img src="upload/1438338066336.jpg" id="u0"/></div>
     	 <div class="userImg"> 1 <img src="upload/1438338066336.jpg" id="u1"  alt="12"/></div>
         <div class="userImg">2 <img src="upload/1438338066336.jpg" id="u2"/></div>
         <div class="userImg"> 3<img src="upload/1438338066336.jpg" id="u3"/></div>
         <div class="userImg">4 <img src="upload/1438338066336.jpg" id="u4"/></div>
         <div class="userImg">5 <img src="upload/1438338066336.jpg" id="u5"/></div>
           <div class="userImg">6 <img src="upload/1438338066336.jpg" id="u5"/></div>
             <div class="userImg">7 <img src="upload/1438338066336.jpg" id="u5"/></div>
               <div class="userImg">8 <img src="upload/1438338066336.jpg" id="u5"/></div>
                 <div class="userImg">9 <img src="upload/1438338066336.jpg" id="u5"/></div>
                   <div class="userImg">10 <img src="upload/1438338066336.jpg" id="u5"/></div>
                   
       
    	
	</div>
	</div>
	<input type="button" id="start" value="start"/>
	<input type="button" id="pause" value="pause"/>
	
	</body>

</html>