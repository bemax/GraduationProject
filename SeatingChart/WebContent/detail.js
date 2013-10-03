var xmlhttp = this.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject(
		"Msxml2.XMLHTTP")
		|| new ActiveXObject("Microsoft.XMLHTTP");

function getDetail(name) {
	var target = this.XMLHttpRequest ? document.getElementById("result")
			: document.all("result");
	xmlhttp.open("GET", "detail?name=" + name);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			target.innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.send("");
}