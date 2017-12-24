<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>WriteBlogger</title>
	<link rel="stylesheet" href="<c:url value="/kindeditor/themes/default/default.css"/>" />
	<link rel="stylesheet" href="<c:url value="/kindeditor/plugins/code/prettify.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/style/css.css"/>">
	<script charset="utf-8" src="<c:url value="/kindeditor/kindeditor.js"/>"></script>
	<script charset="utf-8" src="<c:url value="/kindeditor/lang/zh_CN.js"/>"></script>
	<script charset="utf-8" src="<c:url value="/kindeditor/plugins/code/prettify.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/all-animation.js"/>"></script>
	<script type="text/javascript">
		function type(obj)
				    {
				    	/* alert(obj); */
				    	document.getElementById("_ch").value=obj;
				    }
				    $(function(){$('.layout-publish-choose div').click(function() {
						var _this=$(this);
						_this.addClass('layout-upload-choose-div-add').siblings('div').removeClass('layout-upload-choose-div-add');
						//_this.siblings('li').removeClass('menuli');
						//_this.addClass('menuli');
						});
					});
	</script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : './kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body class="layout-publish-body">
	<%=htmlData%>
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
   		<div class="layout-publish-form">	    
		<form class="layout-publish-formf" name="example" method="post" action="<c:url value="/dynamicadd"/>?act=publish">
		<div class="layout-publish-submit-div">
		<div class="layout-publish-blogger-title">
		<i><span>标题</span></i>
		<input type="text" name="blogger_name">
		</div>
		<input class="layout-publish-submit" type="submit" name="button" value="提交内容" />
		<a href="<c:url value="/dynamic"/>?act=blogger">返回</a>
		</div>
			<textarea class="layout-publish-textarea" name="content1" cols="100" rows="8"><%=htmlspecialchars(htmlData)%></textarea>
			<input type="hidden" id="_ch" value="all" name="blogger_type">
		</form>
		<div class="layout-publish-choose">
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
		</div>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>