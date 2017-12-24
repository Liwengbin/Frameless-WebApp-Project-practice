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
  	function submitShare(){
	document.form.action="<c:url value="/dynamicadd"/>?act=shareadd";
    document.form.submit(); 
    }
    
    function removeShare(share_number,user_email)
    {
    	if(confirm("确认删除这条记录吗？"))
    	{
    		location.href="<c:url value="/dynamicdelete"/>?act=sharedelete&share_number="+share_number+"&user_email="+user_email+"";
    	}
    }
  </script>
  
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
		  				<span style="color: #fff" >分享</span>
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
   			 分享 <br>
   		 </div>
   		 <div class="layout-share-main">
   		 <form name="form" action="" method="post" accept-charset="utf-8">
   		 	<div class="layout-share-main-write">
   		 		<i></i>
   		 		<input type="text" class="layout-share-main-write-weburl share-write-font" name="share_web_url" placeholder="Url">
   		 		<input type="text" class="layout-share-main-write-describe share-write-font" name="share_describe" placeholder="描述">
   		 		<button class="layout-share-main-write-button" onclick="submitShare();">分享</button>
   		 	</div>
   		 </form>
   		 	<div class="layout-share-main-conter">
   		 		<ul>
   		 			<c:forEach var="user_to_share" items="${share_to_user_list}" varStatus="idx">
	   		 			<li>
	   		 				<i>${user_to_share.user_all.user_basic.user_name}</i>
	   		 				<a href="${user_to_share.blogger_share.share_web_url}" target="_blank">${user_to_share.blogger_share.share_web_url}</a>
	   		 				<span>${user_to_share.blogger_share.share_describe}</span>
	   		 				<button onclick="removeShare('${user_to_share.blogger_share.share_number}','${user_to_share.blogger_share.user_email}')">删除</button>
	   		 			</li>
   		 			</c:forEach>
   		 		</ul>
   		 	</div>
   		 </div>
  </body>
</html>