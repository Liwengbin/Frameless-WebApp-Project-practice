<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>猜猜站</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/style/main_css.css"/>">
  </head>
  <body>
  		<div class="layout-logo"><i></i></div>
  		<div class="layout-m-navigation">
  			<ul class="layout-nav-lu">
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=main">
		  				<i class="all-ico home-ico"></i>
		  				<span>首页</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=blogger">
		  				<i class="all-ico blogger-ico"></i>
		  				<span>博客</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=data">
		  				<i class="all-ico data-ico"></i>
		  				<span>资料</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=share">
		  				<i class="all-ico share-ico"></i>
		  				<span>分享</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=tools">
		  				<i class="all-ico tools-ico"></i>
		  				<span>工具</span>
	  				</a>
  				</li>
  			</ul>
  		</div>
  	<%@include file="jsps/footer.jsp" %>
  </body>
</html>
