<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<style type="text/css">
	body{
		margin: 0 auto;
		padding: 0;
		background-color: #0666ff;
	}
	#content{
	padding:0;
	position:absolute;
		width: 1200px;
		height:2000px;
		margin-left:-600px;
		left:50%;
		background-color: black;

	}
		#scrollPics{
		padding:0;
    height: 400px;
    width: 100%;
    position:absolute;
    top:0;
  
    overflow: hidden;

}
.num{
	z-index:10;
    position:absolute;
    right:47%;
    bottom:5px;
    margin: 0 auto;
}
#scrollPics .num li{
    float: left;
    color: #FF7300;
    text-align: center;
    line-height: 16px;
    width: 16px;
    height: 16px;
    cursor: pointer;
    overflow: hidden;
    margin: 3px 1px;
    border: 1px solid #FF7300;
    background-color: #fff;
   	border-radius:90%;
}
#scrollPics .num li.on{
    color: #fff;
    line-height: 21px;
    width: 21px;
    height: 21px;
    font-size: 16px;
    margin: 0 1px;
    border: 0;
    background-color: #FF7300;
    font-weight: bold;
}
#scrollPics .slider{


width:100%;
padding: 0;

}
#scrollPics .slider li{
border:1px solid #000;
list-style: none;
width:100%;
padding: 0;
margin: 0 0 0 0;
}
#scrollPics .slider img{
padding:0;
z-index:-1;
width: 100%;

}
#img_title{
z-index:3;
	position: absolute;
	bottom: 0px;
	display: none;
	text-align: center;
	background-color: black;
	opacity:0.5;
	color: white;
	width: 100%;
	height: 30%;
	cursor: pointer;
}
#content_topic{
	width: 100%; height: 300px; background: white;position: absolute; top: 430px;
	overflow: hidden;
}
.topic_list{
	height: 100%;
	width: 267px;
	float: left;
	border: 1px solid #000;
	margin-right: 30px;
}

.topic_component1{
 height: 150px;
}
.topic_component2{
height: 70px;overflow:auto;word-break:break-all;
}
.topic_component3{
height: 35px; line-height:35px;font-size: 12px;
}
.topic_component3_1{
height: 35px;width: 100px;position: relative; left: 0px; float: left;
}
.topic_component3_2{
height: 35;width: 50px;position: relative; left: 5px; float: left;
}
.topic_component3_3{
height: 35;width: 50px;position: relative; left: 10px; float: left;
}
.topic_component4{
 height: 45px;clear: both;
}
#content_topic2{
	background-color: #fff;position: absolute;top:750px;width: 100%;height: 650px;
}
#handpick{
position: absolute;width: 850px;top: 0;height: 300px;border: 1px solid #000;
}
#handpick_title{
position: absolute;width: 100%;top: 0;height: 30px;line-height:30px; border: 1px solid #000;
}
#handpick_channel_contain{
position: absolute;width: 100%;top: 30px;height: 270px;line-height:50px; border: 1px solid #000;
}
.handpick_channel{
float: left;height: 270px;width: 230px; margin-right:45px; border: 1px solid #000;
}
#ranking_contain{
width: 300px;height: 100%;border: 1px solid #000; position:absolute; right: 0px;
}
#ranking{
width: 100%;border: 1px solid #000;height: 40px;line-height: 40px;
}
.ranking_button{
text-align: center; color: green;border-color: green;border: 1px solid; width: 98px;height:100%; float: left;cursor: pointer;
}
.ranking_topic{
width: 100%;border: 1px solid #000;height: 100px;
}
	</style>
	<script type="text/javascript" src="<%=basePath %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
		<script type="text/javascript"  >
		$(function(){
		 var len = $(".num > li").length;
    var index = 0;  
    var adTimer;
    $("#scrollPics .slider li").on('mouseover',function(){  	
    	$("#img_title").slideDown("slow");
    });
      $("#scrollPics").on('mouseleave',function(){
    	$("#img_title").slideUp("slow");
    });
    
    $(".num li").mouseover(function() {
        index = $(".num li").index(this); 
      
        showImg(index);
    }).eq(0).mouseover();
 
    $('#scrollPics').hover(function() {
        clearInterval(adTimer);
    }, function() {
        adTimer = setInterval(function() {
            showImg(index);
            index++;
            if (index == len) {       
                index = 0;
            }
        }, 3000);
    }).trigger("mouseleave");

    function showImg(index) {
        var adHeight = $("#scrollPics>ul>li:first").height();
        $(".slider").stop(true, false).animate({
            "marginTop": -adHeight * (index) -10+ "px"    
        }, 1000);
        $(".num li").removeClass("on")
            .eq(index).addClass("on");
    }
		});
   
		</script>
	</head>
	<body>
<div id="content">
	<div id="scrollPics">
    <ul class="slider" >
        <li><img src="upload/1438338066336.jpg" /></li>
        <li><img src="upload/1438338066336.jpg"/></li>
        <li><img src="upload/1438338066336.jpg"/></li>
        <li><img src="upload/1438338066336.jpg"/></li>
        <li><img src="upload/1438338066336.jpg"/></li>
        
    </ul>
    <ul class="num" >
        <li class="on"></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
    <div id="img_title">
    	asd
    </div>
</div>
	<div id="content_topic" > 
		<div class="topic_list"> 
		<div class="topic_component1" ><img src="upload/thumb/1438338066336.jpg" height="100%"/></div>
		<div class="topic_component2">
			asddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
		</div>
		<div class="topic_component3"  >
		<div class="topic_component3_1">
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>09-01 12:30
		</div>
		<div class="topic_component3_2" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>25
		</div>
		<div class="topic_component3_3" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>
		30		
		</div>		
		</div>
		
		<div class="topic_component4" >
		<div style="width: 90%;margin: 0 auto;height: 5px;margin-top: -5px;"><hr/></div>
		<img src="upload/thumb/1438338066336.jpg" height="25px" width="25px;"/>asdas
		</div>
		</div>
				<div class="topic_list"> 
		<div class="topic_component1" ><img src="upload/thumb/1438338066336.jpg" height="100%"/></div>
		<div class="topic_component2">
			asddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
		</div>
		<div class="topic_component3"  >
		<div class="topic_component3_1">
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>09-01 12:30
		</div>
		<div class="topic_component3_2" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>25
		</div>
		<div class="topic_component3_3" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>
		30		
		</div>		
		</div>
		
		<div class="topic_component4" >
		<div style="width: 90%;margin: 0 auto;height: 5px;margin-top: -5px;"><hr/></div>
		<img src="upload/thumb/1438338066336.jpg" height="25px" width="25px;"/>asdas
		</div>
		</div>
				<div class="topic_list"> 
		<div class="topic_component1" ><img src="upload/thumb/1438338066336.jpg" height="100%"/></div>
		<div class="topic_component2">
			asddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
		</div>
		<div class="topic_component3"  >
		<div class="topic_component3_1">
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>09-01 12:30
		</div>
		<div class="topic_component3_2" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>25
		</div>
		<div class="topic_component3_3" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>
		30		
		</div>		
		</div>
		
		<div class="topic_component4" >
		<div style="width: 90%;margin: 0 auto;height: 5px;margin-top: -5px;"><hr/></div>
		<img src="upload/thumb/1438338066336.jpg" height="25px" width="25px;"/>asdas
		</div>
		</div>
				<div class="topic_list"> 
		<div class="topic_component1" ><img src="upload/thumb/1438338066336.jpg" height="100%"/></div>
		<div class="topic_component2">
			asddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
		</div>
		<div class="topic_component3"  >
		<div class="topic_component3_1">
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>09-01 12:30
		</div>
		<div class="topic_component3_2" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>25
		</div>
		<div class="topic_component3_3" >
		<img src="upload/thumb/1438338066336.jpg" height="20px" width="20px"/>
		30		
		</div>		
		</div>
		
		<div class="topic_component4" >
		<div style="width: 90%;margin: 0 auto;height: 5px;margin-top: -5px;"><hr/></div>
		<img src="upload/thumb/1438338066336.jpg" height="25px" width="25px;"/>asdas
		</div>
		</div>
	
		
	</div>
	
	<div id="content_topic2" style=" ">
	
		<div id="handpick" style="">
		<div id="handpick_title" style="">
				<span style="position: absolute;left: 10px;">精选</span>
				<span style="position: absolute;right: 50px;">更多>></span>
		</div>
		<div id="handpick_channel_contain" style="" >
			<div class="handpick_channel" style="">
				<div style="width: 100%;height: 40%;border: 1px solid #000;">1</div>
				<div style="width: 100%;height: 59%;border: 1px solid #000;">2</div>
			</div>
			<div class="handpick_channel" style="float: left;height: 270px;width: 230px; margin-right:45px;border: 1px solid #000;"></div>
			<div class="handpick_channel" style="float: left;height: 270px;width: 230px; margin-right:45px;border: 1px solid #000;"></div>
		</div>
		</div>
		
		<div class="channel_topics" style="width:850px;height: 300px;position: absolute;left: 0px;top: 350px;border: 1px solid #000;">
			<div class="channel_list" style="width:400px;height: 330px;position: absolute;left: 0px;top: 0px;border: 1px solid #000;">
				<div style="width:400px;height: 130px;position: absolute;left: 0px;top: 0px;border: 1px solid #000;color: #fff;background: blue;">
				<span style="font-size: 36px;">asd</span>asd<br/>
				asd asd asd
				</div>
				<div style="width:400px;height: 170px;position: absolute;left: 0px;bottom: 0px;border: 1px solid #000;"></div>
			</div>
			<div class="channel_topic_contain" style="width:400px;height: 330px;position: absolute;right: 0px;top: 0px;border: 1px solid #000;"></div>
		</div>
		
		<div id="ranking_contain" style="">
			<div id="ranking" style="">	
				<div class="ranking_button" >热门点击</div>
				<div class="ranking_button" >最新发布</div>
				<div class="ranking_button" >最多参与</div>
			</div>
			<div class="ranking_topic" style=""></div>
			<div class="ranking_topic" style=""></div>
			<div class="ranking_topic" style=""></div>
			<div class="ranking_topic" style=""></div>
			<div class="ranking_topic" style=""></div>
			<div class="ranking_topic" style=""></div>
			<div class="ranking_topic" style=""></div>
		</div>
		
	
	</div>
</div>
	
	</body>

</html>