var prefix = "/sys/menu"
$(function() {
	validateRule();

	//打开图标列表
    $("#ico-btn").click(function(){
        layer.open({
            type: 2,
			title:'图标列表',
            content: '/FontIcoList.html',
            area: ['480px', '90%'],
            success: function(layero, index){
                //var body = layer.getChildFrame('.ico-list', index);
                //console.log(layero, index);
            }
        });
    });

});
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix + "/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			laryer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("save successfully");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // Get: 窗口索引
				parent.layer.close(index);

			} else {
				layer.alert(data.msg)
			}

		}
	});

}
function validate() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			type : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "please enter menu name"
			},
			type : {
				required : icon + "请选择menu类型"
			}
		}
	})
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			type : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "please enter menu name"
			},
			type : {
				required : icon + "请选择menu类型"
			}
		}
	})
}