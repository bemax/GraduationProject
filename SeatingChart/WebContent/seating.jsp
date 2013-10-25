<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="java.util.List"%>
<%@page import="todo.vo.TodoValueObject"%>
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
<SCRIPT src="batch.js"></SCRIPT>
</head>

<body>

	<h1>行先掲示板</h1>
	<h2>○○部</h2>
	苗字名前
	<h3>○○課</h3>
	<% 
		List<TodoValueObject> list = (List<TodoValueObject>)request.getAttribute("todoList");
		for(TodoValueObject vo : list){
			System.out.println(vo.getFirstName());
		}
	%>
	<div>
 		<form method="get" action="detail">
			<table border="1" style="float: left">
				<tr>
					<c:forEach items="${todoList}" var="vo" varStatus="status">
						<td>
						<a onmouseover="getDetail('${vo.firstName}')" onmousedown="getId('${vo.firstName}');"><c:out
									value="${vo.firstName}" />さん</a></td>
						<c:if test="${ status.count % 4 == 0 && status.count != 12 }">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</form>
	</div>
	<div id="result"></div>

	<div>
	
	<form name="updForm" method="get" action="search" style="float: left">
		
		<input type="hidden" id="names" name="names">
		<input type="submit" value="更新">
		<!--   選択した名前を表示するタグ -->
		<div id="batch"></div>
	</form>
	
	<form method="get" action="insert.jsp">
		<input type="submit" value="新規登録">
	</form>
	
	
	</div>
	<table border="1">
		<tr>
			<td style="background-color: red">在籍</td>
			<td style="background-color: blue">退席</td>
		</tr>
	</table>
</body>
</html>
