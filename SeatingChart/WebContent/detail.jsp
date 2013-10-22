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
<table>
	<tr>
		<th>氏　名=</th>
		<td>${vo.firstName}さん</td>
	</tr>
	<tr>
		<th>内　線=</th>
		<td>0000</td>
	</tr>
	<tr>
		<th>状　態=</th>
		<td>${vo.statusID}さん</td>
	</tr>
	<tr>
		<th>行き先=</th>
		<td>　</td>
	</tr>
	<tr>
		<th>開　始=</th>
		<td>　</td>
	</tr>
	<tr>
		<th>終　了=</th>
		<td>　</td>
	</tr>
	<tr>
		<th>連絡先=</th>
		<td>　</td>
	</tr>
	<tr>
		<th>更　新=</th>
		<td>　</td>
	</tr>
	<tr>
		<th>-----メモ-----</th>
	</tr>
	<tr>
		<th>月）</th>
		<td>　</td>
	</tr>
	<tr>
		<th>火）</th>
		<td>　</td>
	</tr>
	<tr>
		<th>水）</th>
		<td>　</td>
	</tr>
	<tr>
		<th>木）</th>
		<td>　</td>
	</tr>
	<tr>
		<th>金）</th>
		<td>　</td>
	</tr>
</table>
</form>
</body>
</html>