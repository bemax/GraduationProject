<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%
int[] messageID = {2001,2002,2003,2004};
String[] honbun= {"１７時から会議","明日は晴れ","今日は寒い","明日も寒い"};
String[] update = {"2012/10/24","2012/10/25","2012/10/26","2012/10/27"};

for(int i = 0; i < messageID.length; i++){ %>
	<p>-------------<%=i+1 %>件目のデータ------------</p>
	<%=messageID[i] %><br>
	<%=honbun[i] %><br>
	<%=update[i] %><br>
	<p>----------------------------------------------</p>
<%}%>


</body>
</html>