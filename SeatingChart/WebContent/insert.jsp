<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="sender" action="register" method="GET">
<table border="1">
	<tr>
		<th>ID</th>
		<td>
			<input type="text" name="employeeID" size="20"/>
		</td>
	</tr>
	<tr>
		<th>苗字</th>
		<td>
			<input type="text" name="firstName" size="20"/>
		</td>
	</tr>
	<tr>
		<th>名前</th>
		<td>
			<input type="text" name="lastName" size="20"/>
		</td>
	</tr>
		<tr>
		<th>IPアドレス</th>
		<td>
			<input type="text" name="ipAddress" size="20"/>
		</td>
	</tr>
		<tr>
		<th>IPアドレスの表示</th>
		<td>
			<input type="checkbox" name="viewIP" value="true"/>表示
			<input type="checkbox" name="viewIP" value="false"/>非表示
		</td>
	</tr>
		<tr>
		<th>社員Noの表示</th>
		<td>
			<input type="checkbox" name="viewID" value="true"/>表示
			<input type="checkbox" name="viewID" value="false"/>非表示
		</td>
	</tr>
		<tr>
		<th>内線番号</th>
		<td>
			<input type="text" name="localPhoneNumber" size="20"/>
		</td>
	</tr>
		<tr>
		<th>ステータス</th>
		<td>
			<input type="text" name="statusID" size="20"/>
		</td>
	</tr>
	</tr>
		<tr>
		<th>部屋ID</th>
		<td>
			<input type="text" name="roomID" size="20"/>
		</td>
	</tr>
	</tr>
		<tr>
		<th>メッセージ</th>
		<td>
			<input type="text" name="message" size="20"/>
		</td>
	</tr>
	</table>
	<input type="submit" value="新規登録">
	</form>
</body>
</html>