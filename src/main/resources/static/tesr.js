		var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
		var count = 60;
		var InterValObj1;
		var curCount1;
		function sendMessage1() {
			curCount1 = count;
			var phone = $.trim($('#phone').val());
			if(!phoneReg.test(phone)) {
				alert(" 请输入有效的手机号码");
				return false;
			}

			$("#btnSendCode1").attr("disabled", "true");
			$("#btnSendCode1").val(+curCount1 + "秒再获取");
			InterValObj1 = window.setInterval(SetRemainTime1, 1000);

		}

		function SetRemainTime1() {
			if(curCount1 == 0) {
				window.clearInterval(InterValObj1);
				$("#btnSendCode1").removeAttr("disabled");
				$("#btnSendCode1").val("重新发送");
			} else {
				curCount1--;
				$("#btnSendCode1").val(+curCount1 + "秒再获取");
			}
		}

		

