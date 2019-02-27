var prefix = "/sys/role";
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get',
						url : prefix + "/list",
						striped : true,
						dataType : "json",
						pagination : true,
						// queryParamsType : "limit",
						//
						singleSelect : false,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						// contentType : "application/x-www-form-urlencoded",
						//
						pageSize : 10,
						pageNumber : 1,
						search : true,
						showColumns : true,
						sidePagination : "client",
						// "server"
						// queryParams : queryParams,
						//
						columns : [
								{ // 列配置项
									// 数据类型，详细参数配置参见文档http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
									checkbox : true
								// 列表中显示复选框
								},
								{
									field : 'roleId', //
									title : 'ID' //
								},
								{
									field : 'roleName',
									title : 'Role Name'
								},
								{
									field : 'remark',
									title : 'remark '
								},
								{
									field : '',
									title : 'Permission'
								},
								{
									title : 'Operation',
									field : 'roleId',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="Edit" onclick="edit(\''
												+ row.roleId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="Del"  mce_href="#" onclick="remove(\''
												+ row.roleId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										return e + d;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	//
	layer.open({
		type : 2,
		title : 'NewRole',
		maxmin : true,
		shadeClose : false, //
		area : [ '800px', '520px' ],
		content : prefix + '/add' //
	});
}
function remove(id) {
	layer.confirm('sure to delete the selectd records？', {
		btn : [ 'Yes', 'No' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code === 0) {
					layer.msg("delete successfully");
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})

}
function edit(id) {
	layer.open({
		type : 2,
		title : 'RoleUpdate',
		maxmin : true,
		shadeClose : true, //
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id //
	});
}
function batchRemove() {
	
	var rows = $('#exampleTable').bootstrapTable('getSelections'); //
	if (rows.length == 0) {
		layer.msg("Please select what you wanna delete");
		return;
	}
	layer.confirm("Are you sure to delete '" + rows.length + "'rocords?", {
		btn : [ 'Yes', 'No' ]
	}, function() {
		var ids = new Array();
		$.each(rows, function(i, row) {
			ids[i] = row['roleId'];
		});
		console.log(ids);
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {});
}