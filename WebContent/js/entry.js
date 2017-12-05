window.onload = function() {
	var fm = document.getElementsByTagName('form')[0];
	var entryMess = document.getElementById('entryMess');
	
	fm.onsubmit = function() {
		if(!/[\u4E00-\u9FA5]{2,4}/.test(sname.value)){
			entryMess.innerHTML = "* 姓名输入错误";
			sname.value = "";
			sname.focus();
			return false;
		}
		if (!/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/.test(idcode.value)) {
			entryMess.innerHTML = "* 身份证号错误！";
			idcode.value = "";// 清空
			idcode.focus();// 将焦点移动到表单字段
			return false;
		}
		if (!/^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/.test(gradutetime.value)) {
			entryMess.innerHTML = "* 日期错误！";
			gradutetime.value = '';// 清空
			gradutetime.focus();// 将焦点移动到表单字段
			return false;
		}
		if (!/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/.test(telphone.value)) {
			entryMess.innerHTML = "* 电话号码错误！";
			telephone.value = '';// 清空
			telephone.focus();// 将焦点移动到表单字段
			return false;
		}
		return true;
	};
};