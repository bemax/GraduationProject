<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>座標</title>
<script>
	function load() { //ページロード時にグローバル変数の宣言
		// スタート地
		sZahyou = [];
		// マウスダウンされているかのフラグ
		flag = false;
		// 選択範囲
		range = [];
	}
	function myFunction(e) //マウスを押した場所の座標取得
	{
		flag = true;
		e.target.style.color = "red";
		range[0] = e.target;
		var x = e.clientX - document.getElementById("coorTable").offsetLeft;
		var y = e.clientY - document.getElementById("coorTable").offsetTop;
		sZahyou[0] = Math.floor(x / 60);
		sZahyou[1] = Math.floor(y / 60);
	}

	function myFunction2(e) //マウスを離した場所の座標取得
	{
		flag = false;
		for ( var i = 0; i < range.length; ++i) {
			range[i].style.color = "black";
			var num = range[i].title;
			var x = num % 5;
			var y = Math.floor(num / 5);
			console.log(x + "," + y);
		}
		// 終了座標
		var x = Math.floor(e.clientX - document.getElementById("coorTable").offsetLeft/60);
		var y = Math.floor(e.clientY - document.getElementById("coorTable").offsetTop/60);
	}

	// 重複する値があるかチェックする
	var checkDuplicate = function(array, str) {
		for ( var i = 0; i < array.length; i++) {
			if (str == array[i]) {
				return true;
			}
		}
		return false;
	};

	function areaFunc(e) {
		// マウスダウンしていたら実行
		if (flag) {

			var num = e.target.title;
			var count = 0;

			// 現在地の座標を取得
			x = num % 5;
			y = Math.floor(num / 5);

			// スタート地と現在地の間の座標を取得
			if (sZahyou[0] > x) {
				ax = x;
				bx = sZahyou[0];
			} else {
				ax = sZahyou[0];
				bx = x;
			}
			if (sZahyou[1] > y) {
				ay = y;
				by = sZahyou[1];
			} else {
				ay = sZahyou[1];
				by = y;
			}
			for ( var i = ay; by >= i; i++) {
				for ( var j = ax; bx >= j; j++) {
					var id = i * 5 + j;
					var ele = document.getElementById("coordiv" + id);
					// 配列に重複する値がなければ色変更し配列に追加
					if (!checkDuplicate(range, ele)) {
						ele.style.color = "red";
						range.push(ele);
					}
					count++;
				}
			}

			// 選択範囲が小さくなった時の処理
			if (range.length > count) {
				for ( var i = 1; i < range.length; ++i) {
					range[i].style.color = "black";
				}
				var temp = range[0];
				range.length = 0;
				range[0] = temp;
			}
		}
		;
	}
</script>
</head>

<body style="margin: 0px;" onload="load()">

	<%!//新規登録された情報を受け取る
	String[] x = { "5", "5", "201号室", "高度情報1年" };
	int n = Integer.parseInt(x[0]);
	int w = Integer.parseInt(x[1]);
	String roomname = x[2];
	String name = x[3];%>

	<%!//他の部屋情報を受け取る
	String[] x2 = { "201号室", "202号室", "203号室", "204号室" };%>

	<table border="1" id="coorTable" align="left">
		<%
			int h = 0;
		%>
		<%
			for (int i = 0; n > i; i++) {
		%>
		<tr>
			<%
				for (int j = 0; w > j; j++) {
			%>
			<td align="center">
				<div id="coordiv<%=h%>" title="<%=h%>"
					style="width: 50px; height: 50px; border: 1px solid"
					onmousedown="myFunction(event)" onmouseup="myFunction2(event)"
					onmousemove="areaFunc(event)"><%=h%></div> <%
 	h++;
 %>
			</td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>

	<form action="search" method="get">
		<input type="hidden" id="downzahyou" name="downzahyou"> <input
			type="hidden" id="upzahyou" name="upzahyou"> <SELECT
			name="serect" onchange="Selc(this)">
			<%
				for (int i = 0; x2.length > i; i++) {
			%>
			<%
				if (i == 0) {
			%>
			<OPTION value="" selected><%=x2[i]%></OPTION>
			<%
				} else {
			%>
			<OPTION value=""><%=x2[i]%></OPTION>
			<%
				}
			%>
			<%
				}
			%>
		</SELECT> <input type="submit" value="移動" />
	</form>
</body>
</html>