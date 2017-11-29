/**
 * 学生修改密码页面引用的js文件
 * */
window.onload = function(){	
	var title = document.title;
	var menu = document.getElementById('menu');
	var items = menu.getElementsByTagName('a');
	for ( var i = 0; i < items.length; i++) {
		if (title == items[i].innerHTML) {
			items[i].className="checked";  
		}
	}
	var reset = document.getElementById('reset');
	var fm = document.getElementsByTagName('form')[0];
	var passModifyMess = document.getElementById('passModifyMess');
	reset.onclick = function() {
		oldpass.value = '';
		newpass.value = '';
		confirmpass.value = '';
		code.value = '';
		oldpass.focus();
	};
	fm.onsubmit = function() {
		if (!/^\w{6,20}$/.test(oldpass.value)) {
			passModifyMess.innerHTML = "* 旧密码错误！";
			oldpass.value = "";
			oldpass.focus();
			return false;
		}
		if (!/^\w{6,20}$/.test(newpass.value)) {
			passModifyMess.innerHTML = "* 新密码不合法！";
			newpass.value = '';
			newpass.focus();
			return false;
		}
		if (newpass.value != confirmpass.value) {
			passModifyMess.innerHTML = "* 两次输入的新密码不一致，请重新输入！";
			newpass.value = '';
			confirmpass.value = '';
			newpass.focus();
			return false;
		}
		if(!/^\d{4}$/.test(code.value)){
			passModifyMess.innerHTML = "* 验证码错误！";
			code.value = '';
			code.focus();
			return false;
		}
		return true;
	};
};