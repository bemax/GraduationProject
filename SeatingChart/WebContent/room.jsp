<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>座標</title>
<script>
	function load() {
		sZahyou = [];
		eZahyou = [];
		nZahyou = [];
		bZahyou = [ 0, 0 ];
		nbZahyou = [0,0];
		flag = false;
		mathFlag = false;
		range = [];
	}
	function myFunction(e) //マウスを押した場所の座標取得
	{
		flag = true;
		e.target.style.color = "red";
		range.push(e.target);
		var x = e.clientX - document.getElementById("coorTable").offsetLeft;
		var y = e.clientY - document.getElementById("coorTable").offsetTop;
		sZahyou[0] = Math.floor(x / 60);
		sZahyou[1] = Math.floor(y / 60);
		nbZahyou = sZahyou;
		var box = "mousedown:" + sZahyou[0] + "," + sZahyou[1];
		document.getElementById("down").innerHTML = box;
	}

	function myFunction2(e) //マウスを離した場所の座標取得
	{
		var x = e.clientX - document.getElementById("coorTable").offsetLeft;
		var y = e.clientY - document.getElementById("coorTable").offsetTop;
		eZahyou[0] = Math.floor(x / 60);
		eZahyou[1] = Math.floor(y / 60);
		var box = "mouseup:" + eZahyou[0] + "," + eZahyou[1];
		document.getElementById("up").innerHTML = box;
		//ベース座標を初期化
		bZahyou = [ 0, 0 ];
		flag = false;
		for ( var i = 0; i < range.length; ++i) {
			range[i].style.color = "black";
		}
	}

	function areaFunc(e) {

		//このifはいらないかも
		if (flag) {
			e.target.style.color = "red";
			range.push(e.target);
			var x = e.clientX - document.getElementById("coorTable").offsetLeft;
			var y = e.clientY - document.getElementById("coorTable").offsetTop;

			nZahyou[0] = Math.floor(x / 5);
			nZahyou[1] = Math.floor(y / 60);

			//今のベース座標が前のベース座標より小さくなったら選択範囲を狭める
/*  			if (Math.abs(bZahyou[0]) > Math.abs(sZahyou[0]) - Math.abs(nZahyou[0])) {
				if (mathFlag) {
					bZahyou[0] -= 1;
				} else {
					bZahyou[0] += 1;
				}
			} else if (Math.abs(bZahyou[1]) > Math.abs(sZahyou[1]) - Math.abs(nZahyou[1])) {
				if (mathFlag) {
					bZahyou[1] -= 1;
				} else {
					bZahyou[1] += 1;
				}
			} */
			
			//x座標のベース座標との差を求める
			if (nbZahyou[0] != nZahyou[0]){
				console.log("nbZahyou[0]" + nbZahyou[0]);
				nbZahyou[0] = nZahyou[0];
				if (nZahyou[0] - sZahyou[0] > 0) {
					bZahyou[0] += 1;
					mathFlag = true;
					console.log("baseの計算");
				} else if (nZahyou[0] - sZahyou[0] < 0) {
					bZahyou[0] -= 1;
					mathFlag = false;
					console.log("baseの計算");
				}
			}
			
			if(nbZahyou[1] != nZahyou[1]){	
				//y座標のベース座標との差を求める
				nbZahyou[1] = nZahyou[1];
				if (nZahyou[1] - sZahyou[1] > 0) {
					bZahyou[1] += 1;
					mathFlag = true;
					console.log("baseの計算");
				} else if (nZahyou[1] - sZahyou[1] < 0) {
					bZahyou[1] -= 1;
					mathFlag = false;
					console.log("baseの計算");
				}
			}
			
		}
		a = "移動量:" + bZahyou[0] + "," + bZahyou[1];
		document.getElementById("move").innerHTML = a;

		b = "移動座標:" + nZahyou[0] + "," + nZahyou[1];
		document.getElementById("move2").innerHTML = b;
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
				<div id="coordiv"
					style="width: 50px; height: 50px; border: 1px solid"
					onmousedown="myFunction(event)" onmouseup="myFunction2(event)"
					onmousemove="areaFunc(event)"><%=h%></div>
					<%
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

	<p id="down"></p>
	<p id="up"></p>
	<p id="move"></p>
	<p id="move2"></p>

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