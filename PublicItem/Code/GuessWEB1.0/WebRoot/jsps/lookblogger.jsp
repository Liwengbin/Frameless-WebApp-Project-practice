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
  
  <body class="layout-share-body">
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
		  				<span  style="color: #fff"  >博客</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=data">
		  				<span>资料</span>
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
   		<script type="text/javascript">
   			$(function(){$('.layout-blogger-typemenu ul li').click(function() {
						var _this=$(this);
						_this.addClass('layout-blogger-typemenuli').siblings('li').removeClass('layout-blogger-typemenuli');
						});
					});
   		</script>    
   		<div class="layout-blogger-main">
	   		<div class="layout-blogger-typemenu">
	   		<i class="layout-blogger-Logo"></i>
			<ul>
				<li class="layout-blogger-typemenu-licolor layout-blogger-typemenuli"><a href="#">All</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">Java</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">C++</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">C#</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">SQL</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">Pyhton</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">Html</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">CSS</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">MySql</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">Tool</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">前端</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="#">后台</a></li>
				<li class="layout-blogger-typemenu-licolor"><a href="<c:url value="/dynamic"/>?act=write_blogger">WriteB</a></li>
			</ul>
			</div> 
			
			<div class="layout-lookblo-top">
				${content.blogger_name}
			</div>  
			<div class="layout-lookblo-concent">
				${content.blogger_txt}
			</div>
			
			<div class="layout-lookblo-action">
			</div>
   		</div>
  </body>
</html>
