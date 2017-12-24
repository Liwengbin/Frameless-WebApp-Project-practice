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
   		 	<div class="layout-data-preview">
   		 		<div class="layout-data-ul">
					<ul class="layout-data-p-ul">
	   		 			<c:forEach var="List_Information" items="${List_Information}" varStatus="idx">
		   		 			<li>
			   		 			<div class="layout-data-listone">
			   		 				<dl>
			   		 					<dt>
											<img alt="" src="<c:url value="/style/img/imgToos/rar.png"/>">
			   		 					</dt>
			   		 					<dd>
			   		 						<h3>${List_Information.information_filename}</h3>
			   		 						<div class="layout-data-listone-base">
			   		 							<span>${List_Information.information_time}</span>
			   		 							&nbsp;<!-- &nbsp;空格符号 -->
			   		 							<span>大小：<em>${List_Information.information_size}</em></span>
			   		 							<a>${List_Information.information_type}</a>
			   		 						</div>
			   		 					</dd>
			   		 				</dl>
			   		 				<div class="layout-data-listone-share">
			   		 				<a href="javascript:void((function(s,d,e,r,l,p,t,z,c){var%20f='http://v.t.sina.com.cn/share/share.php?appkey=真实的appkey',u=z||d.location,p=['&url=',e(u),'&title=',e(t||d.title),'&source=',e(r),'&sourceUrl=',e(l),'&content=',c||'gb2312','&pic=',e(p||'')].join('');function%20a(){if(!window.open([f,p].join(''),'mb',['toolbar=0,status=0,resizable=1,width=440,height=430,left=',(s.width-440)/2,',top=',(s.height-430)/2].join('')))u.href=[f,p].join('');};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else%20a();})(screen,document,encodeURIComponent,'','','<c:url value="/style/img/imgToos/rar.png"/>','${List_Information.information_filename}: ${List_Information.information_txt}','内容链接|默认当前页location','utf-8'));"><img alt="" src="<c:url value="/style/img/imgToos/weib.png"/>" title="分享到微博"></a>
			   		 				<a class="layout-data-listone-share-a2" href="#"><img alt="" src="<c:url value="/style/img/imgToos/weix.png"/>" title="分享到微信"></a>
			   		 				</div>
			   		 			</div>
			   		 			<div class="layout-data-listtwo">
			   		 				<div>
			   		 				<span>${List_Information.information_txt}</span>
			   		 				</div>
			   		 			</div>
			   		 			<div class="layout-data-listthree">
			   		 				<a>
			   		 				<img alt="" src="<c:url value="/style/img/imgToos/shouc1.png"/>">
			   		 				<i>收藏(${List_Information.information_praise})</i>
			   		 				</a>
			   		 				<button>下载点我哦 </button>
			   		 			</div>
		   		 			</li>
	   		 			</c:forEach>
	   		 		</ul>
   		 		</div>
   		 	</div>
   		 	<a class="layout-data-upload-but" href="<c:url value="/dynamic"/>?act=upload">点击到资料上传</a>
   		 </div>
  </body>
</html>

