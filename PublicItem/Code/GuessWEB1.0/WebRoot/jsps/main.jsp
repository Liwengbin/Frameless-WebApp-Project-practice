<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>猜博客网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/style/css.css"/>">
  </head>
  
    <script type="text/javascript">
    function $(id)
    {
    	return document.getElementById(id);
    }
    
  	function submitLogin(){
	document.formsubmitlogin.action="<c:url value="/dynamiccheck"/>?act=login";
    document.formsubmitlogin.submit(); 
    }
    
    function submitcontent(){
    var id=$("content_user_email").value;
	    if(id=="")
	    {
	    	alert("请登录！");
	    }
	    else
	    {
		document.formsubmitcontent.action="<c:url value="/dynamicadd"/>?act=content";
	    document.formsubmitcontent.submit(); 
	    }
    }
    
    function inputsubmit(obj){
    var id=$("content_user_email").value;
    alert(dy_id);
	    if(id=="")
	    {
	    	alert("请登录！");
	    }
	    else if(txt=="")
	    {
	    alert("请输入评论内容！")
	    }
    }
    
    function submitclose()
    {
		document.formsubmitcontent.action="<c:url value="/dynamic"/>?act=enduser";
	    document.formsubmitcontent.submit(); 
    }
  </script>
  
  <body class="layout-main-body">
  	<div class="navigation"><!-- 导航栏 -->
  		<ul class="layout-navigation-lu">
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=main">
		  				<span style="color: #fff" >首页</span>
	  				</a>
  				</li>
  				<li>
	  				<a href="<c:url value="/dynamic"/>?act=blogger">
		  				<span>博客</span>
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
  	</div>
  	
  	
  	
  	<div class="layout-main">
  		<div class="layout-head"><!-- 头部样式 -->
  			<ul>
  				<li><a href="#">动态</a></li>
  				<li><a href="#">时光</a></li>
  				<li><a href="#">足迹</a></li>
  				<li><a href="#">收藏</a></li>
  			</ul>
  		</div>
  		<div class="layout-content"><!-- 主体样式 -->
  			<form name="formsubmitcontent" action="" method="post" accept-charset="utf-8">
  			<div class="layout-write"><!-- 发表动态 -->
  				<div class="layout-content-txt"><textarea name="dynamic_txt"  placeholder="说点什么吧！" rows="3" cols="70" required="required"></textarea></div>
  				<div class="layout-content-img"><i></i></div>
  				<div class="layout-content-tv"><i></i></div>
  			</div>
  			<div class="loyout-content-photo">
  				<ul class="loyout-content-photo-ul">
  					<li></li>
  				</ul>
  			</div>
  			<div class="loyout-content-submit">
  				<img class="loyout-content-submit-img1" alt="" src="<c:url value="/style/img/imgToos/s.png"/>">
  				<img class="loyout-content-submit-img2" alt="" src="<c:url value="/style/img/imgToos/f.png"/>">
  				<input id="content_user_email" type="hidden" name="content_user_email" value="${USERALL.user_basic.user_email}">
  				<input type="button" value="发表" onclick="submitcontent();">
  			</div>
  			</form>
  			<div class="layout-in">
  				<ul class="layout-contentAll-ul">
  					<c:forEach var="content" items="${all_content}" varStatus="idx">
  					<li class="layout-li-outer">
  						<div class="layout-content-div-top">
  							<span class="span-headimg"><img src=<c:url value="${content.user_minute.user_headimg}"/> title="${content.user_basic.user_email}"></span>
  							<span class="span-name" onclick="">${content.user_basic.user_name}</span>
  							<div class="layout-share">
  							<span class="layout-dynamic-time">${content.dynamic_content.dynamic_time}</span>
  							<span class="layout-dynamic-num">浏览(56)</span>
  							</div>
  						</div>
  						<div class="layout-content-div-middle">
  							<ul class="layout-content-ul">
  								<li>
  									<div class="layout-dynamic-txt"><span>${content.dynamic_content.dynamic_txt}</span></div>
  									<div class="layout-dynamic-img">
	  										<c:forEach var="adderss_img" items="${content.dynamic_content.dynamic_img}" varStatus="idx">
		  										<tr>
		  											<td>
		  											<span><img alt="" src=<c:url value="${adderss_img}"/>></span>
		  											</td>
		  										</tr>
	  										</c:forEach>
  									</div>
  									<span class="layout-dynamic-tv"><%-- ${content.dynamic_content.dynamic_tv} --%></span>
  								</li>
  								<li class="layout-interaction-li">
  								<!-- <div class="like-img"><i></i></div> -->
  									<ul class="layout-content-interaction-ul">
	  									<c:forEach var="interaction_content" items="${content.interaction_content}">
	  										<li>
	  											<div class="layout-interaction-user">
		  											<span class="user2-headimg"><img alt="" src=<c:url value="${interaction_content.user_minute_interaction.user_headimg}"/> title="${interaction_content.user_basic_interaction.user_name}"></span>
		  											<span class="interaction-content-txt">${interaction_content.interaction_txt}</span>
	  												<span class="interaction-content-time">${interaction_content.interaction_time}</span>
	  											</div>
	  										</li>
	  									</c:forEach>
  									</ul>
  								</li>
  								<li class="layout-interaction-li">
  								<form action="<c:url value="/dynamicadd"/>?act=interaction" method="post" accept-charset="utf-8">
  									<img class="user-img" alt="" src="<c:url value="/style/img/imgToos/head.jpg"/>">
  									<div class="interactiion-txt">
  									<textarea id="interaction_txt" name="interaction_txt" rows="2" cols="50" required="required"></textarea>
  									<input type="hidden" name="dynamic_id" value="${content.dynamic_content.dynamic_id}">
  									<input type="hidden" name="interaction_email" value="${USERALL.user_basic.user_email}">
  									<input type="hidden" name="user_email" value="${content.user_basic.user_email}">
  									<!-- <input type="submit" class="interaction-input-submit"> -->
  									<input type="submit"  value="评论" class="interaction-input">
  									</div>
  								</form>
  								</li>
  							</ul>
  						</div>
  					</c:forEach>
  				</ul>
  			</div>
  		</div>
  		<div class="layout-userself">
  		<c:if test="${not empty USERALL.user_basic.user_email}">
	  			<a href="#" class="layout-userself-head">
	  		 		<img class="layout-userself-headimg" src="<c:url value="${USERALL.user_minute.user_headimg}"/>">
	  		 		<c:if test="${USERALL.user_minute.user_sex=='w'}"><img src="<c:url value="/style/img/imgToos/w.png"/>" class="layout-userself-span-sex"></img></c:if>
	  		 		<c:if test="${USERALL.user_minute.user_sex=='m'}"><img src="<c:url value="/style/img/imgToos/m.png"/>" class="layout-userself-span-sex"></img></c:if>
	  		 		<span class="layout-userself-span-name">${ USERALL.user_basic.user_name}</span>
	  		 	</a>
	  		 	<img class="layout-userself-signimg" src="<c:url value="/style/img/imgToos/sign.png"/>">
	  		 	<span class="layout-userself-span-signature">${USERALL.user_minute.user_signature}</span>
	  		 	<button class="layout-userself-button-close" onclick="submitclose();">注销</button>
  		</c:if>
  			<c:if test="${empty USERALL.user_basic.user_email}">
	  			<form name="formsubmitlogin" action="" method="post" accept-charset="utf-8">
	  		 	<a href="#" class="layout-userself-headtow">
	  		 		<img class="layout-userself-headimg" alt="" src="<c:url value="/img/imgDafault/notloginheadimg.png"/>">
	  		 		<span class="layout-userself-head-span">么么哒</span>
	  		 	</a>
	  			<ul class="layout-userself-ul">
	  				<li><input id="user_email" type="text" placeholder="邮箱" name="user_email" required="required" value="${param.user_email}"></li>
	  				<li><input id="password" type="password" placeholder="密码" name="user_passwod" required="required" ></li>
	  				<li><button onclick="submitLogin();">登录</button></li>
	  				<c:if test="${not empty errMsg}">
	  					<li><div class="msg">${errMsg}</div></li>
	  				</c:if>
	  				<li class="layout-userself-ul-a">
	  				<a href="<c:url value="/dynamic"/>?act=sign">注册</a>|
	  				<a href="#">忘记密码</a><!-- <c:url value="/dynamic"/>?act=forgetpwd -->
	  				</li>
	  			</ul>
	  			</form>
  			</c:if>
  		</div>
  		</div>

  </body>
</html>
