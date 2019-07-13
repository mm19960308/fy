<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css" />
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function() {
		$(".menu").css("cursor", "pointer");
		$(".menu").click(function() {
			$(this).next().slideToggle();
		});
		
	});
</script>
</head>
<body>
	<div id="container">
		<div id="top">
			蜗牛java14期，大后台管理系统！！
		</div>
		<div id="bottom">
			<div id="bottom_left">
				
				<ul>
					<li>
						<span class="menu">部门管理</span>
						<ul>
							<li>
								<a href="DeptServlet.do?method=findAll" target="mainFrame">查看部门</a>
							</li>
							<li>
								<a href="dept/saveUI.jsp" target="mainFrame">添加部门</a>
							</li>
						</ul>
					</li>
					<li>
						<span class="menu">员工管理</span>
						<ul >
							<li>查看员工</li>
							<li>添加员工</li>
						</ul>
					</li>
				</ul>
				
			</div>
			<div id="bottom_right">
				<iframe name="mainFrame" width="100%" height="100%" frameborder="0"></iframe>
			</div>
		</div>
	</div>
</body>
</html>