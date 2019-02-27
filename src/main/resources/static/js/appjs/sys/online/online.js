var prefix = "/sys/online"
$(function() {
	load();
});

function load() {
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
						sidePagination : "client",
						// "server"
						queryParams : function(params) {
							return {

								limit : params.limit,
								offset : params.offset,
								name : $('#searchName').val()
							};
						},
						//
						columns : [
								{
									checkbox : true
								},
								{
									field : 'id',
									title : 'ID'
								},
								{
									field : 'username',
									title : 'userName'
								},
								{
									field : 'host',
									title : 'host'
								},
								{
									field : 'startTimestamp',
									title : 'login time'
								},
								{
									field : 'lastAccessTime',
									title : 'lastAccessTime'
								},
								{
									field : 'timeout',
									title : 'timeout'
								},
								{
									field : 'status',
									title : 'status',
									align : 'center',
									formatter : function(value, row, index) {
										if (value == 'on_line') {
											return '<span class="label label-success">online</span>';
										} else if (value == 'off_line') {
											return '<span class="label label-primary">offline</span>';
										}
									}
								},
								{
									title : 'Operation',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var d = '<a class="btn btn-warning btn-sm" href="#" title="Del"  mce_href="#" onclick="forceLogout(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										return d;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : 'new user',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '520px' ],
		content : prefix + '/add'
	});
}
function forceLogout(id) {
	layer.confirm('are you sure to offline user?', {
		btn : [ 'Yes', 'No' ]
	}, function() {
		$.ajax({
			url : prefix+"/forceLogout/" + id,
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
		title : 'update user',
		maxmin : true,
		shadeClose : true,
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id
	});
}
function resetPwd(id) {
	layer.open({
		type : 2,
		title : 'reset password',
		maxmin : true,
		shadeClose : false,
		area : [ '400px', '260px' ],
		content : prefix + '/resetPwd/' + id
	});
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections');
	if (rows.length == 0) {
		layer.msg("Please select what you wanna delete");
		return;
	}
	layer.confirm("Are you sure to delete '" + rows.length + "'rocords?", {
		btn : [ 'Yes', 'No' ]
	// button
	}, function() {
		var ids = new Array();
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
	}, function() {
	});
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
		$('#exampleTable').bootstrapTable('refresh', opt);
	}

});