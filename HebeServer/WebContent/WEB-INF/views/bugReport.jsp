<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hebe</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/hebe.js"></script>
<script type="text/javascript">
	function checkSubmit() {
		var empt = document.forms["form1"]["bugTitle"].value;
		if (empt == "") {
			alert("Please input a Value");
			return false;
		}
	}
</script>
</head>
<body>
	<div id="background">
		<div id="page">
			<div id="body">
				<div id="sidebar">
					<a id="logo" href="/HebeServer">&nbsp;</a>
					<ul>
						<li><a href="mainIntroduction"><span
								style="color: green;">掌上暨大</span></a></li>
						<li><a href="maintenance"><span style="color: green;">参与维护</span></a>
						</li>
						<li><a href="bugReport"><span style="color: green;">错误报告</span></a>
						</li>
					</ul>
				</div>
				<div id="content">
					<div id="header">
						<ul class="navigation">
							<li class="first"><a class="active" href="/">主页</a></li>
							<li><a href="mainIntroduction">Hebe</a></li>
							<li><a href="manual">使用指南</a></li>
							<li><a href="downloadData/hebeVersion1">下载服务</a></li>
							<li><a href="joinUs">加入我们</a></li>
						</ul>
					</div>
					<div class="body">
						<img src="images/seedling.jpg" width="631" height="107" alt="">
						<div class="content">
							<h2>欢迎提交错误报告</h2>
							<button id="bugReportButton">提交一个</button>
							<div id="bugReportForm">
								<form name="form1" action="bugReport" method="post"
									onsubmit="checkSubmit()">
									<table align="center">
										<tr>
											<td>错误名称：</td>
											<td><input type="text" id="bugTitle" name="bugTitle"
												maxlength="58" size="58" /></td>
										</tr>
										<tr>
											<td>错误描述</td>
											<td><textarea rows="4" cols="50" type="text"
													id="bugDescription" name="bugDescription">
									          </textarea></td>
										</tr>
										<tr>
											<td></td>
											<td align="right"><input type="submit" class="submit"
												value="" /></td>
										</tr>
									</table>
									<input type="hidden" id="reporterName" value="unname"
										name="reporterName" />
								</form>
							</div><br/>
							<ul>
								<%
									int i = 1;
								%>
								<c:forEach items="${bugAndReply}" var="entry">
									<li
										style="font-family: 'Times New Roman'; font-size: 18px; color: green;"><%=i%>.${entry.key.title}</li>
									<ul style="margin-left:15px;list-style-type:circle;">
									    <li><c:out value="${entry.key.description}" /></li>
										<c:forEach var="bugReply" items="${entry.value}">
											<li>${bugReply.content}</li>
										</c:forEach>	
									</ul>
									<form action="bugReply" name="form2" method="post">
											<textarea type="text" name="bugReplyContent" rows="1" cols="40" placeholder="评论" /></textarea>
											<input type="hidden" name="bugId" value="${entry.key.id}" />
											<input type="submit" style="position:relative; left:-28px; top:-15px;" value=""/>
										</form>
									<HR
										style="border: dashed #84aa01; border-width: 3px 0 0; height: 0;">
									<%
										i++;
									%>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="featured">
					<ul>
						<li>
							<h2>
								<a href="developTeam">开发团队</a>
							</h2> <img src="images/developers.jpg" width="280" height="140" alt="">
							<p>感谢暨大，感恩暨大计算机。我们是一群充满热情的暨大计算机人，匆忙的大四。我们 全力投入，真诚为暨大服务。</p>
						</li>
						<li>
							<h2>
								<a href="futureVersion">后期版本展望</a>
							</h2> <img src="images/golf-court.jpg" width="280" height="140" alt="">
							<p>一个崭新的开始接下来就是更精彩的继续。展望很接近的明天即将拥有的更多，更丰富的功能。</p>
						</li>
						<li>
							<h2>
								<a href="serveJnu">服务暨大</a>
							</h2> <img src="images/trees.jpg" width="280" height="140" alt="">
							<p>人生最美好的年华我们在暨大度过，暨大给了我们太多，太多。让我们用一颗感恩的心去为暨大的建设奉献一份爱。</p>
						</li>
					</ul>
				</div>
			</div>
			<div id="footer">
				<div class="section">
					<h2>&nbsp;</h2>
					<ul>
						<li style="float: left">
							<h1>友情链接</h1>
							<p style="text-align: center;">
								<a href="http://www.jnu.edu.cn" style="font-size: 14px;">暨南大学主页</a><br />
								<a href="http://xxxy.jnu.edu.cn" style="font-size: 14px;">暨南大学信息科学技术学院</a><br />
								<a href="http://jwc.jnu.edu.cn" style="font-size: 14px;">暨南大学教务处</a><br />
								<a href="http:// xsc.jnu.edu.cn" style="font-size: 14px;">暨南大学学生处</a>
							</p>
						</li>
						<li style="float: right">
							<h1>关注我们</h1>
							<p style="text-align: center;">
								<img class="link_sina" src="images/link_sina.jpg" /><a
									href="http://www.jnu.edu.cn" style="font-size: 14px;">新浪微博</a><br />
								<img class="link_tencent" src="images/link_tencent.jpg" /><a
									href="http://xxxy.jnu.edu.cn" style="font-size: 14px;">腾讯微博</a><br />
								<img class="link_renren" src="images/link_renren.jpg" /><a
									href="http://jwc.jnu.edu.cn" style="font-size: 14px;">&nbsp;人人网&nbsp;&nbsp;</a><br />
								<img class="link_qqzone" src="images/link_qqzone.jpg" /><a
									href="http:// xsc.jnu.edu.cn" style="font-size: 14px;">&nbsp;QQ空间</a>
							</p>
						</li>
						<li>
							<h1></h1>
							<p></p>
						</li>
					</ul>
				</div>
				<div class="footnote">
					<span>&copy; 2012-2013 <a href="index.html">暨南大学</a> . All
						rights Reserved.
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>