function getId(name) {
	var target = document.getElementById("batch");
		var t_name = target.innerHTML;
		var result;
		if(t_name == ""){
			result = name;
		}else{
			result = t_name + "," + name;
		}
		document.updForm.names.value=result;
		target.innerHTML = result;
}