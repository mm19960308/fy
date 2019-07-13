<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$(".del").click(function()) {
			return confirm("你确定要删除吗？");
			}
		})
</script>
</head>
<body>
	<h3>emp list</h3>
	
	<a href="emp/saveUI.jsp">继续注册</a>
	<table class="table">
		<tr>
			<td>eid</td>
			<td>ename</td>
			<td>hiredate</td>
			<td>sal</td>
			<td>eid</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="e">
			<tr>
				<td>${e.eid }</td>
				<td>${e.ename }</td>
				<td>${e.hiredate }</td>
				<td>${e.sal }</td>
				<td>${e.did }</td>
				<td>
					<a class="del" href="EmpServlet.do?method=delete&eid=${e.eid}">删除</a>
					|
					<a href="EmpServlet.do?method=updateUI&eid=${e.eid}">修改</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				
				<span style="color: red; font-size: 30px;">
					${page.p }
				</span>
				/
				${page.maxPage }
				
				<a href="EmpServlet.do?method=findAll&p=1">首页</a>
				<a href="EmpServlet.do?method=findAll&p=${page.prev }">上一页</a>
				
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="x">
					<c:if test="${x == page.p }">
						<span style="color: red;">${x }</span>
					</c:if>
					<c:if test="${x != page.p }">
						<a href="EmpServlet.do?method=findAll&p=${x }">${x }</a>
					</c:if>
				</c:forEach>
				
				<a href="EmpServlet.do?method=findAll&p=${page.next }">下一页</a>
				<a href="EmpServlet.do?method=findAll&p=${page.maxPage}">末页</a>
				
				<form action="EmpServlet.do?method=findAll" method="post" style="display: inline;">
					调到第<input size="1" type="text" name="p">页
					<button type="submit">GO</button>
				</form>
				
				共【${page.rowCount }】条记录
				
			</td>
		</tr>
	</table>
</body>
</html>