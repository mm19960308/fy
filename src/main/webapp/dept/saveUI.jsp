<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>save dept</h3>
	<form action="../DeptServlet.do?method=save" method="post">
		部门名:<input name="dname" /> <br />
		<button type="submit">GO</button>
	</form>
</body>
</html>