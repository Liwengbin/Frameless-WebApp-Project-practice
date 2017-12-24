<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'data.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/style/css.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/all-animation.js"/>"></script>
  </head>
  <script type="text/javascript">
  </script>
  
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
	  					<li><a href="<c:url value="/dynamic"/>?act=homepage">Home</a></li>
	  					<li><a href="#">收藏</a></li>
	  					<li><a href="#">历史</a></li>
	  					<li><a href="<c:url value="/dynamic"/>?act=sign">Login</a></li>
	  					<li><a href="#">关于</a></li>
	  				</ul>
  				</div>
  			</div>		
  		</div>
  	</div>
   	<div class="layout-data-main">
   		<div class="layout-userbase">
   			<ul>
   				<li><a href="<c:url value="/dynamic"/>?act=userbase">用户信息修改</a></li>
   				<li><a href="<c:url value="/dynamic"/>?act=sign">登录/注册</a></li>
   			</ul>
  		<c:if test="${not empty USERALL.user_basic.user_email}">
	  			<a href="#" class="layout-userself-head">
	  		 		<img class="layout-userself-headimg" src="<c:url value="${USERALL.user_minute.user_headimg}"/>">
	  		 		<c:if test="${USERALL.user_minute.user_sex=='w'}"><img src="<c:url value="/style/img/imgToos/w.png"/>" class="layout-userself-span-sex"></img></c:if>
	  		 		<c:if test="${USERALL.user_minute.user_sex=='m'}"><img src="<c:url value="/style/img/imgToos/m.png"/>" class="layout-userself-span-sex"></img></c:if>
	  		 		<span class="layout-userself-span-name">${ USERALL.user_basic.user_name}</span>
	  		 	</a>
	  		 	<img class="layout-userself-signimg" src="<c:url value="/style/img/imgToos/sign.png"/>">
	  		 	<span class="layout-userself-span-signature">${USERALL.user_minute.user_signature}</span>	  		 	
  		</c:if>
		 </div>
   	</div>
  </body>
</html>