<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>emp update</h3>
	<form action="EmpServlet.do?method=update" method="post">
		eid:<input name="eid" type="hidden" value="${emp.eid }" />
		ename:<input name="ename" value="${emp.ename }" /> <br />
	    hiredate:<input name="hiredate" value="${emp.hiredate }" /> <br />
		sal:<input name="sal" value="${emp.sal }" /> <br />	
		did:<input name="did" value="${emp.did }" /> <br />
		<button type="submit">GO</button>
	</form>
</body>
</html>