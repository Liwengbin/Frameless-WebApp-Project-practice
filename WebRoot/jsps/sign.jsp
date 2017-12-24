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
	<link rel="stylesheet" href="<c:url value="/style/css.css"/>">
	<link rel="stylesheet" href="<c:url value="/style/email.css"/>">
	<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
	<script src="<c:url value="/js/all-animation.js"/>"></script>
	<script src="<c:url value="/js/emailAutoComplete.js"/>"></script>
  </head>
  <script type="text/javascript">
  	
  	function submitLogin(){
	document.formsubmitlogin.action="<c:url value="/dynamiccheck"/>?act=login";
    document.formsubmitlogin.submit(); 
    }
    
    function submitSign(){
	document.formsubmitSign.action="<c:url value="/dynamiccheck"/>?act=sign";
    document.formsubmitSign.submit(); 
    }
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
   		<div class="layout-sign">
		    <form name="formsubmitSign" action="" method="post" accept-charset="utf-8">
		    	<ul class="layout-sign-ul">
		    		<li>注册</li>
			    	<li><div class="parentCls"><input class="inputElem" type="text" placeholder="Email" name="user_email"></div></li>
			    	<li><input type="text" placeholder="password" name="user_password"></li>
			    	<li><input type="text" placeholder="name" name="user_name"></li>
			    	<li><input class="layout-sign-submit" type="button" onclick="submitSign();" value="Sign"></li>
		   		</ul>
		    </form>
		    </div>
		    <div class="layout-login">
		    <form name="formsubmitlogin" action="" method="post" accept-charset="utf-8">
		    	<ul class="layout-login-ul">
		    		<li>登录</li>
			    	<li><div class="parentCls"><input class="inputElem" type="text" placeholder="Email" name="user_email" value="${param.user_email}"></div></li>
			    	<li><input type="text" placeholder="password" name="user_password" value="${param.user_password}"></li>
			    	<li><input class="layout-sign-submit" type="button" onclick="submitLogin();" value="Login"></li>
			    	<c:if test="${not empty errMsg}">
	  					<li><div class="msg">${errMsg}</div></li>
	  				</c:if>
		   		</ul>
		    </form>
	    </div>
    </div>
  </body>
</html>
