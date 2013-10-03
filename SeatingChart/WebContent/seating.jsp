<%@page import="sun.rmi.runtime.Log"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>座席表</title>
<SCRIPT src="detail.js"></SCRIPT>
</head>

<body>

	<h1>行先掲示板</h1>
	<h2>○○部</h2>
	苗字名前
	<h3>○○課</h3>
	<div>
 		<form method="get" action="detail">
			<table border="1" style="float: left">
				<tr>
					<c:forEach items="${todoList}" var="vo" varStatus="status">
					<c:choose>
						<c:when test="${ vo.task == 'yes' }"><td style="background-color: red"></c:when>
						<c:when test="${ vo.task == 'no' }"><td style="background-color: blue"></c:when>
						<c:otherwise><td></c:otherwise>
					</c:choose>
						<a onmouseover="getDetail('${vo.title}');"><c:out
									value="${vo.title}" />さん</a></td>
						<c:if test="${ status.count % 4 == 0 && status.count != 12 }">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
					<%
						String name = (String) request.getParameter("name");
						if (name != null) {
					%><iframe src="detail?name=<%=name%>" style="margin-left: 20px;"></iframe>
					<%
						}
					%>
				</tr>
			</table>
		</form>
	</div>
	<div id="result"></div>

	<form method="get" action="search" style="clear: both;">
		<select name="task">
			<option value="yes">在籍</option>
			<option value="no">退社</option>
		</select> <select name="title">
		<c:forEach items="${todoList}" var="vo">
			<option value="${vo.title}"><c:out value="${ vo.title }">さん</c:out></option>
			</c:forEach>
		</select> <input type="submit" value="更新">
	</form>
</body>
</html>
