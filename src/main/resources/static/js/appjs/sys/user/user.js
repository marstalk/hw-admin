var prefix = "/sys/user"
$(function() {
	var deptId = '';
	getTreeData();
	load(deptId);
});

function load(deptId) {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get',
				url : prefix + "/list",
				// showRefresh : true,
				// showToggle : true,
				// showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true,
				dataType : "json",
				pagination : true,
				// queryParamsType : "limit",
				//
				singleSelect : false,
				// contentType : "application/x-www-form-urlencoded",
				//
				pageSize : 10,
				pageNumber : 1,
				// search : true,
				showColumns : false,
				sidePagination : "server",
				// "server"
				queryParams : function(params) {
					return {

						limit : params.limit,
						offset : params.offset,
						name : $('#searchName').val(),
						deptId : deptId
					};
				},
				// //
				columns : [
					{
						checkbox : true
					},
					{
						field : 'userId', //
						title : 'ID' //
					},
					{
						field : 'name',
						title : 'Name'
					},
					{
						field : 'username',
						title : ' UserName'
					},
					{
						field : 'email',
						title : ' Email'
					},
					{
						field : 'status',
						title : 'Status',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '0') {
								return '<span class="label label-danger">Forbidden</span>';
							} else if (value == '1') {
								return '<span class="label label-primary">Normal</span>';
							}
						}
					},
					{
						title : 'Operation',
						field : 'id',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="Edit" onclick="edit(\''
								+ row.userId
								+ '\')"><i class="fa fa-edit "></i></a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="Del"  mce_href="#" onclick="remove(\''
								+ row.userId
								+ '\')"><i class="fa fa-remove"></i></a> ';
							var f = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
								+ row.userId
								+ '\')"><i class="fa fa-key"></i></a> ';
							return e + d + f;
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
		title : 'new user',
		maxmin : true,
		shadeClose : false, //
		area : [ '800px', '520px' ],
		content : prefix + '/add'
	});
}
function remove(id) {
	layer.confirm('sure to delete the selectd records？', {
		btn : [ 'Yes', 'No' ]
	}, function() {
		$.ajax({
			url : "/sys/user/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
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
		title : 'update User',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id //
	});
}
function resetPwd(id) {
	layer.open({
		type : 2,
		title : 'reset password',
		maxmin : true,
		shadeClose : false, //
		area : [ '400px', '260px' ],
		content : prefix + '/resetPwd/' + id //
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
	// button
	}, function() {
		var ids = new Array();
		//
		$.each(rows, function(i, row) {
			ids[i] = row['userId'];
		});
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
function getTreeData() {
	$.ajax({
		type : "GET",
		url : "/system/sysDept/tree",
		success : function(tree) {
			loadTree(tree);
		}
	});
}
function loadTree(tree) {
	$('#jstree').jstree({
		'core' : {
			'data' : tree
		},
		"plugins" : [ "search" ]
	});
	$('#jstree').jstree().open_all();
}
$('#jstree').on("changed.jstree", function(e, data) {
	if (data.selected == -1) {
		var opt = {
			query : {
				deptId : '',
			}
		}
		$('#exampleTable').bootstrapTable('refresh', opt);
	} else {
		var opt = {
			query : {
				deptId : data.selected[0],
			}
		}
		$('#exampleTable').bootstrapTable('refresh',opt);
	}

});