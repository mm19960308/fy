<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script>
	$(function() {
		$(".del").click(function() {
			// 在事件处理函数中，如果返回false，则就当这件事没发生过！！
			return confirm("你确定要删除吗？");
		});
	});
</script>
</head>
<body>
	<h3>dept list</h3>
	
	<a href="dept/saveUI.jsp">继续注册</a>
	<table class="table">
		<tr>
			<td>did</td>
			<td>dname</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="d">
			<tr>
				<td>${d.did }</td>
				<td>${d.dname }</td>
				<td>
					<a class="del" href="DeptServlet.do?method=delete&did=${d.did}">删除</a>
					|
					<a  href="DeptServlet.do?method=updateUI&did=${d.did}">修改</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
			
				<span style="color:red;font-size:30px;">
					${page.p }
				</span>
				/
				${page.maxPage }
			
				<a href="DeptServlet.do?method=findAll&p=1">首页</a>
				<a href="DeptServlet.do?method=findAll&p=${page.prev }">上一页</a>
				
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="x">
					<c:if test="${x == page.p }">
						<span style="color:red;">${x }</span>
					</c:if>
					<c:if test="${x != page.p }">
						<a href="DeptServlet.do?method=findAll&p=${x }">${x }</a>
					</c:if>
				</c:forEach>
				
				<a href="DeptServlet.do?method=findAll&p=${page.next }">下一页</a>
				<a href="DeptServlet.do?method=findAll&p=${page.maxPage }">末页</a>
				
				
				<form action="DeptServlet.do?method=findAll" method="post" style="display: inline;">
					跳到第<input size="1" type="text" name="p" />页
					<button type="submit">GO</button>
				</form>
				
				共【${page.rowCount }】条记录
				
			</td>
		</tr>
	</table>
	
</body>
</html>