<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>update dept</h3>
	<form action="DeptServlet.do?method=update" method="post">
		<input type="hidden" name="did" value="${dept.did }" />
		部门名:<input name="dname" value="${dept.dname }" /> <br />
		<button type="submit">修改</button>
	</form>
</body>
</html>