<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="mail">
		<table border="1">
			<tr>
				<td>入力者</td>
				<td><textarea cols=40 rows=1 name="fromName" style="overflow: hidden;"></textarea></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><textarea cols=40 rows=1 name="toAddr" style="overflow: hidden;"></textarea></td>
			</tr>
			<tr>
				<td>タイトル</td>
				<td><textarea cols=40 rows=1 name="subject" style="overflow: hidden;"></textarea></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea cols=40 rows=5 name="message"></textarea></td>
			</tr>
		</table>
		メッセージの送信先:<br>
		<input type="checkbox" name="a0" value="2341004@bemax.jp">伝言<br>
		<input type="checkbox" name="a1" value="2341007@bemax.jp">登録したメールアドレス<br>
		<input type="submit" value="送信">
	</form>
</body>
</html>