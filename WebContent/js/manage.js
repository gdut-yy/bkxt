window.onload=function(){
	var fm = document.getElementsByTagName('form')[0];
	var adminname = document.getElementById('adminname');
	var adminpass = document.getElementById('adminpass');
	var code = document.getElementById('code');
	var adminLoginMess = document.getElementById('adminLoginMess');
	var reset = document.getElementById('reset');
	reset.onclick = function() {
		adminname.value = '';// 清空
		adminpass.value = '';// 清空
		code.value = '';// 清空
		adminname.focus();// 将焦点移动到表单字段
	};

	fm.onsubmit = function(){
		//用户名验证
		if(!/^\w{6,20}$/.test(adminname.value)){
			adminLoginMess.innerHTML = "* 用户名错误！";
			adminname.value="";//清空
			adminname.focus();//将焦点移动到表单字段
			return false;
		}
		//密码验证
		if(!/^\w{6,20}$/.test(adminpass.value)){
			adminLoginMess.innerHTML = "* 密码错误！";
			adminpass.value='';//清空
			adminpass.focus();//将焦点移动到表单字段
			return false;
		}
		//验证码验证
		if(!/^\d{4}$/.test(code.value)){
			adminLoginMess.innerHTML = "* 验证码错误！";
			code.value='';//清空
			code.focus();//将焦点移动到表单字段
			return false;
		}
		return true;
	};
};