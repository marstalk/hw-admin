$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var procDefId = $("#procDefId").val();
	$.ajax({
		cache : true,
		type : "POST",
		url :"/act/salary/start/"+procDefId,
		data : $('#signupForm').serialize(),
		async : false,
		error : function(request) {
			laryer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("save successfully");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.msg(data.msg)
			}
		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "Please enter valid value"
			}
		}
	})
}