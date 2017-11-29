/**
 * 
 */
window.onload = function() {
	var fm = document.getElementsByTagName('form')[0];
	var stuLoginMess = document.getElementById('stuLoginMess'); 
	var reset = document.getElementById('reset');
	reset.onclick = function() {
		username.value = '';// 清空
		password.value = '';// 清空
		code.value = '';// 清空
		username.focus();// 将焦点移动到表单字段
	};
	fm.onsubmit = function() {
		if (!/^\w{6,20}$/.test(username.value)) {
			stuLoginMess.innerHTML = "* 用户名错误！";
			username.value = "";// 清空
			username.focus();// 将焦点移动到表单字段
			return false;
		}
		if (!/^\w{6,20}$/.test(password.value)) {
			stuLoginMess.innerHTML = "* 密码错误！";
			password.value = '';// 清空
			password.focus();// 将焦点移动到表单字段
			return false;
		}
		if (!/^\d{4}$/.test(code.value)) {
			stuLoginMess.innerHTML = "* 验证码错误！";
			code.value = '';// 清空
			code.focus();// 将焦点移动到表单字段
			return false;
		}
		return true;
	};
};