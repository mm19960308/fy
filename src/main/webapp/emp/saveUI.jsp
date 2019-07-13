<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>emp save</h3>
<form action="../EmpServlet.do?method=save" method="post">
	ename:<input name="ename" /> <br />
	hiredate:<input name="hiredate" /> <br />
	sal:<input name="sal" /> <br />	
	did:<input name="did" /> <br />
	<button type="submit">GO</button>
</form>
</body>
</html>