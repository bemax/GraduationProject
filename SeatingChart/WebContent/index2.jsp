<%@page import="todo.vo.TodoValueObject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="./header.js"></script>
<script type="text/javascript" src="./redips-drag-min.js"></script>

<title>Insert title here</title>
</head>
<body onload="REDIPS.drag.init()">

	<%
		//ソースでコメントアウトしてるところがデータ取得の操作です
		//TodoValueObject vo = (TodoValueObject)request.getAttribute("roomInfo");
		//vo.getWidth();
		//vo.getHeight();

		//以下はリクエストから受け取った部屋名を元に、部屋の基本情報の値をデータベースから受け取った前提
		int width = 5;
		int height = 6;

		//String emp[][] = (String[][])request.getAttribute("empList");
		String[][] b = { { "2442001", "有岡", "0", "0", "1", "2" },//0
				{ "2442005", "矢田貝", "0", "2", "1", "1" },//1
				{ "2442008", "竹内", "0", "3", "1", "1" },//2
				{ "2442007", "今城", "1", "0", "3", "1" },//3
				{ "2442003", "武田", "1", "3", "1", "1" },//4
				{ "2442004", "細川", "2", "1", "1", "2" },//5
				{ "2442006", "吉永", "3", "2", "3", "3" },//6
				{ "2442002", "植月", "4", "0", "2", "2" } //7
		};
		//疑似データベースからの戻り値。行の昇順,列の昇順で整列済み
		int listCounter = 0;//ループの中での無駄を省く変数

		int[][][] throughList = new int[height][width][1];
		for (int i = 0; i < throughList.length; i++) {
			for (int j = 0; j < throughList[i].length; j++) {
				throughList[i][j][0] = 0;
			}
		}//throughリスト(1*1以上の席の大きさを持つ社員がいる場合のレイアウト調整用配列)の作成および初期化
	%>
<div id="drag">
	<table border=2;>
		<%
			for (int i = 0; i < height; i++) {
		%>
		<tr height="40">
			<%
				for (int j = 0; j < width; j++) {
			%>
			<%
				if (listCounter < b.length) {
			%>
			<%
				if (Integer.parseInt(b[listCounter][2]) == i
									&& Integer.parseInt(b[listCounter][3]) == j
									&& throughList[i][j][0] == 0) {
			%>
			<th width="100" rowspan=<%=Integer.parseInt(b[listCounter][4])%>
				colspan=<%=Integer.parseInt(b[listCounter][5])%>><div class="drag"><%=b[listCounter][1]%><%=i%>_<%=j%></div></th>

			<!--  縦長とか横長とか -->
			<%
				if (Integer.parseInt(b[listCounter][4]) > 1
										&& Integer.parseInt(b[listCounter][5]) == 1) {
									int deleteY = Integer
											.parseInt(b[listCounter][4]) - 1;
									while (deleteY > 0) {
										throughList[i + deleteY][j][0] = 1;
										deleteY--;
									}
								}
			%>

			<!--  縦長とか横長とか -->
			<%
				if (Integer.parseInt(b[listCounter][5]) > 1
										&& Integer.parseInt(b[listCounter][4]) == 1) {
									int deleteX = Integer
											.parseInt(b[listCounter][5]) - 1;
									while (deleteX > 0) {
										throughList[i][j + deleteX][0] = 1;
										deleteX--;
									}
								}
			%>

			<!--  四角いとき -->
			<%
				if (Integer.parseInt(b[listCounter][4]) > 1
										&& Integer.parseInt(b[listCounter][5]) > 1) {
									int deleteX = Integer
											.parseInt(b[listCounter][5]) - 1;
									while (deleteX > 0) {
										throughList[i][j + deleteX][0] = 1;
										deleteX--;
									}
									int deleteY = Integer
											.parseInt(b[listCounter][4]) - 1;
									while (deleteY > 0) {
										deleteX = Integer
												.parseInt(b[listCounter][5]) - 1;
										throughList[i + deleteY][j][0] = 1;
										while (deleteX > 0) {
											throughList[i + deleteY][j + deleteX][0] = 1;
											deleteX--;
										}
										deleteY--;
									}
								}
			%>

			<%
				listCounter++;
							} else if (throughList[i][j][0] == 0) {
			%>
			<th width="100"><div class="drag"><%=i%>_<%=j%></div></th>
			<%
				}
			%>
			<%
				} else if (throughList[i][j][0] == 0) {
			%>
			<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<th width="100"><div class="drag"><%=i%>_<%=j%></div></th>
			<%
				}
			%>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
	</div>
</body>
</html>