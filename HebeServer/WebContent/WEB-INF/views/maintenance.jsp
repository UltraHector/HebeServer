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
							<ul id="list-nav">
								<li><a id="maintenance_buildingLink" href="#" onclick="switchMaintenanceToBuilding()">建筑物数据库</a></li>
								<li><a id="maintenance_yellowPageLink" href="#" onclick="switchMaintenanceToYellowPage()">校园黄页数据库</a></li>
								<li><a id="maintenance_publicIdeaLink" href="#" onclick="switchMaintenanceToPublicIdea()">新功能推介</a></li>
								<li><a id="maintenance_manualLink" href="#" onclick="switchMaintenanceToManual()">维护说明</a></li>
							</ul>
							<br /> <br />
							<div class="maintenance_navigation" id="maintenance_building">
								<%
									int i = 1;
								%>
								<c:forEach items="${buildingList}" var="entry">
									<ul>
										<li
											style="font-family: 'Times New Roman'; font-size: 18px; color: green;"><%=i%>.${entry.key.name}</li>
										<button class="uploadCellButton" style="float: right;">添加详细</button>
										<button class="showBuildingInfoButton" style="float: right;">建筑概况

										</button>
										<div class="buildingInfoDiv">
											<c:out value="${entry.key.description}" />
										</div>
										<ul style="margin-left: 15px; list-style-type: circle;">
											<c:forEach var="cell" items="${entry.value}">
												<li><b>${cell.name}:</b> ${cell.description}</li>
											</c:forEach>
										</ul>
										<li>&nbsp;</li>
										<div class="uploadCellDiv">
											<br />
											<form action="uploadCell" name="form1" method="post">
												<table>
													<tr>
														<td>名称：</td>
														<td><input type="text" name="cellName" maxLength="30"
															size="45" /></td>
													</tr>
													<tr>
														<td>简单描述：</td>
														<td><textarea type="text" name="cellDescription"
																rows="1" cols="40" /></textarea></td>
													</tr>
													<tr></tr>
													<tr>
														<td><input type="hidden" name="cellBuildingId"
															value="${entry.key.id}" /></td>
														<td align="right"><input type="submit"
															style="position: relative; left: - 28px; top: -15px;"
															value="" /></td>
													</tr>
												</table>

											</form>
										</div>
										<HR
											style="border: dashed #84aa01; border-width: 3px 0 0; height: 0;">
										<%
											i++;
										%>
									</ul>
								</c:forEach>
							</div>
							<div class="maintenance_navigation" id="maintenance_public_idea">
								<ul>
									<button id="uploadPublicIdeaButton" style="float: right;">建议新功能</button>
									<div id="uploadPublicIdeaDiv">
										<form action="uploadPublicIdea" method="post">
											<table>
												<tr>
													<td>功能名称：</td>
													<td><input type="text" name="publicIdeaTitle"
														maxLength="30" size="45" /></td>
												</tr>
												<tr>
													<td>简单描述：</td>
													<td><textarea type="text" name="publicIdeaDescription"
															rows="1" cols="40" /></textarea></td>
												</tr>
												<tr></tr>
												<tr>
													<td>&nbsp:</td>
													<td align="right"><input type="submit"
														style="position: relative; left: - 28px; top: -15px;"
														value="" /></td>
												</tr>
											</table>
										</form>
									</div>
									<%
										int x = 1;
									%>
									<c:forEach items="${publicIdeaList}" var="entry">
										<li
											style="font-family: 'Times New Roman'; font-size: 18px; color: green;"><%=x%>.${entry.key.title}</li>
										<ul style="margin-left: 15px; list-style-type: circle;">
											<li><c:out value="${entry.key.description}" /></li>
											<c:forEach var="publicIdeaReply" items="${entry.value}">
												<li>${publicIdeaReply.content}</li>
											</c:forEach>
										</ul>
										<form action="uploadPublicIdeaReply" name="form2"
											method="post">
											<textarea type="text" name="publicIdeaReplyContent" rows="1"
												cols="40" placeholder="评论" /></textarea>
											<input type="hidden" name="publicIdeaId"
												value="${entry.key.id}" /> <input type="submit"
												style="position: relative; left: -28px; top: -15px;"
												value="" />
										</form>
										<HR
											style="border: dashed #84aa01; border-width: 3px 0 0; height: 0;">
										<%
											x++;
										%>
									</c:forEach>
								</ul>
							</div>
							<div class="maintenance_navigation" id="maintenance_yellow_page">
								<button id="uploadYellowPageButton" style="float: right;">添加黄页</button>
								<div id="uploadYellowPageDiv">
									<form action="uploadYellowPage" method="post">
										名称：<input type="text" name="yellowPageName" /> 电话：<input
											type="text" name="yellowPageNumber" /> <input
											style="position: relative; top: -3px;" type="submit" value="" />
									</form>
								</div>
								<ul>
									<c:forEach items="${yellowPages}" var="yellowPage">
										<%
											int y = 1;
										%>
										<li>${yellowPage.name}</li>
										<li>电话：${yellowPage.number}</li>
										<HR
											style="border: dashed #84aa01; border-width: 2px 0 0; height: 0;">
										<%
											y++;
										%>
									</c:forEach>
								</ul>
							</div>
							<div id="maintenance_manual">
								<ol>
									<li>
										<h4>建筑物数据库</h4>
										<p style="position: relative; right: 28px;">
											掌上暨大的校园地点搜索能力主要借助于建筑物的数据库，建筑物数据库信息越多，掌上暨大的搜索能力也就会越强。
											点击左侧“建筑物数据库”， 可以看到一系列暨大本部的建筑物名称。名称下是该建筑物内部的分设的科室和简介。点击“<b>建筑概况</b>”，可以看到建筑物的整体概况。点击
											“<b>添加详细</b>”，可以添加一个该建筑物内部的分设单元。就像<b>Wiki百科</b>，建筑物内部的单元只有被添加了才能被别人搜索的到。
										</p>
									</li>
									<li>
										<h4>校园黄页数据库</h4>
										<p style="position: relative; right: 28px;">
											校园黄页数据库主要提供暨大的信息查询。暨南大学有几百个科室，强大的校园黄页数据库可以让他们的联系方式触手可及。 点击"<b>添加黄页</b>"可以添加一个新的联系方式。
										</p>
									</li>
									<li>
										<h4>新功能推介</h4>
										<p style="position: relative; right: 28px;">
											掌上暨大的宗旨为 “服务暨南人”，凡是您能想到的功能都会认真考虑。一切对您有帮助的功能我们都会尽全力实现。 点击“<b>建议新功能</b>”，您可以把您的大胆想法让我们知道。
										</p>
									</li>
								</ol>
							</div>

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