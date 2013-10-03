<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title></title>

</head>
<body>
<form id="sender" action="register" method="POST">
<table border="1">
	<tr>
		<th>名前</th>
		<td>${vo.title}さん</td>
	</tr>
	
	<tr>
		<th>状況</th>
		<td>${vo.task}</td>
	</tr>
</table>
</form>
</body>
</html>