<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/style/css.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/all-animation.js"/>"></script>
  </head>
  
  <body>
  	  <body class="layout-data-body">
   		<div class="layout-share-top">
   		 <div class="navigation"><!-- 导航栏 -->
   		 	<ul class="layout-navigation-lu">
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=main">
		  				<span>首页</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=blogger">
		  				<span>博客</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=data">
		  				<span style="color: #fff">资料</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=share">
		  				<span>分享</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=tools">
		  				<span>工具</span>
	  				</a>
  				</li>
  			</ul>
  			<div class="layout-navigationuser">
  				<div class="layout-navigationuser-div"><span class="layout-navigationuser-div-span">myUser</span></div>
  				<div class="layout-navigationuser-ulimg" onmouseover="ulover(this);" onmouseout="ulout(this);">
  					<c:if test="${not empty USERALL}">
  						<img src="<c:url value="${USERALL.user_minute.user_headimg}"/>">
  					</c:if>
  					<c:if test="${empty USERALL}">
  						<img src="<c:url value="/img/imgDafault/headimg5.png"/>">
  					</c:if>
	  				<ul onmouseover="ulover(this);" onmouseout="ulout(this);">
	  					<li><a href="#">猜猜</a></li>
	  					<li><a href="#">收藏</a></li>
	  					<li><a href="#">历史</a></li>
	  					<li><a href="<c:url value="/dynamic"/>?act=sign">Login</a></li>
	  					<li><a href="#">关于</a></li>
	  				</ul>
  				</div>
  			</div>			
  			</div>
  		</div>
  			 <script type="text/javascript">
				  	function SelectFile(){
				  		$("#_file1").click();
				    }
				    function upfle()
				    {
				    	$("#_upfile").click();
				    }
				    
				    function type(obj)
				    {
				    	/* alert(obj); */
				    	document.getElementById("_ch").value=obj;
				    }
				    $(function(){$('.layout-upload-choose div').click(function() {
						var _this=$(this);
						_this.addClass('layout-upload-choose-div-add').siblings('div').removeClass('layout-upload-choose-div-add');
						//_this.siblings('li').removeClass('menuli');
						//_this.addClass('menuli');
						});
					});
  		</script>
		    <div class="layout-data-main">
		    	<div class="layout-uplod-main">
			    	<span class="layout-data-spansubmit" onclick="SelectFile()">点击上传资料</span>
			    	<span class="layout-data-submitfile-button" onclick="upfle()">上传</span>
			   		<form class="layout-data-formfile" action="<c:url value="/fileupload"/>" enctype="multipart/form-data" method="post">
			   			<div class="layout-data-filename">资料名称：<input type="text" name="filename"></div>
			   			<div class="layout-uploud-textarea">资料描述：<br><textarea name="information_txt"  rows="3" cols="70"></textarea></div>
			  			<input class="layout-data-inputfile" type="file" name="file1" id="_file1">
			  			<div class="layout-upload-choose">
			  				资料类型：<br>
							<div id="qd" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>前端</span></div>
							<div id="ht"  class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>后台</span></div>
							<div id="java"  class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>Java</span></div>
							<div id="cs" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>C#</span></div>
							<div id="cc" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>C++</span></div>
							<div id="c" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>C</span></div>
							<div id="html" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>html</span></div>
							<div id="css" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>CSS</span></div>
							<div id="python" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>Python</span></div>
							<div id="mvc" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>MVC</span></div>
							<div id="sql" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>SQL</span></div>
							<div id="tool" class="layout-upload-choose-div-background-color" onclick="type(this.id)"><span>Tool</span></div>
							<div id="all" class="layout-upload-choose-div-background-color layout-upload-choose-div-add" onclick="type(this.id)"><span>All</span></div>
			  			</div>
			  				<input type="hidden" id="_ch" value="all" name="information_type">
			  				<input id="_upfile" class="layout-data-submitfile" type="submit">
			 		</form>
			 	</div>
		    </div>
  </body>
</html>
