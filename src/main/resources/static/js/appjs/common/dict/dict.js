
var prefix = "/common/dict"
$(function() {
	
	//	var config = {
	//		'.chosen-select' : {},
	//		'.chosen-select-deselect' : {
	//			allow_single_deselect : true
	//		},
	//		'.chosen-select-no-single' : {
	//			disable_search_threshold : 10
	//		},
	//		'.chosen-select-no-results' : {
	//			no_results_text : '没有数据'
	//		},
	//		'.chosen-select-width' : {
	//			width : "95%"
	//		}
	//	}
	//	for (var selector in config) {
	//		$(selector).chosen(config[selector]);
	//	}
	load();
});
function selectLoad() {
	var html = "";
	$.ajax({
		url : '/common/dict/type',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].type + '">' + data[i].description + '</option>'
			}
			$(".chosen-select").append(html);
			$(".chosen-select").chosen({
				maxHeight : 200
			});
			//点击事件
			$('.chosen-select').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}
function load() {
	selectLoad();
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get',
				url : prefix + "/list",
				//	showRefresh : true,
				//	showToggle : true,
				//	showColumns : true,
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
				//search : true,
				showColumns : false,
				sidePagination : "server",
				queryParams : function(params) {
					return {
						//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						// name:$('#searchName').val(),
						type : $('#searchName').val(),
					};
				},
				// //
				columns : [
					{
						checkbox : true
					},
					{
						field : 'id',
						title : 'ID'
					},
					{
						field : 'name',
						title : '标签名'
					},
					{
						field : 'value',
						title : '数据值',
						width : '100px'
					},
					{
						field : 'type',
						title : 'Type'
					},
					{
						field : 'description',
						title : '描述'
					},
					{
						visible : false,
						field : 'sort',
						title : '排序（升序）'
					},
					{
						visible : false,
						field : 'parentId',
						title : '父级编号'
					},
					{
						visible : false,
						field : 'createBy',
						title : '创建者'
					},
					{
						visible : false,
						field : 'createDate',
						title : '创建时间'
					},
					{
						visible : false,
						field : 'updateBy',
						title : '更新者'
					},
					{
						visible : false,
						field : 'updateDate',
						title : '更新时间'
					},
					{
						visible : false,
						field : 'remarks',
						title : 'remark Info'
					},
					{
						visible : false,
						field : 'delFlag',
						title : 'Delete标记'
					},
					{
						title : 'Operation',
						field : 'id',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="Edit" onclick="edit(\''
								+ row.id
								+ '\')"><i class="fa fa-edit"></i></a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="Del"  mce_href="#" onclick="remove(\''
								+ row.id
								+ '\')"><i class="fa fa-remove"></i></a> ';
							var f = '<a class="btn btn-success btn-sm ' + s_add_h + '" href="#" title="增加"  mce_href="#" onclick="addD(\''
								+ row.type +'\',\''+row.description
								+ '\')"><i class="fa fa-plus"></i></a> ';
							return e + d +f;
						}
					} ]
			});
}
function reLoad() {
	var opt = {
		query : {
			type : $('.chosen-select').val(),
		}
	}
	$('#exampleTable').bootstrapTable('refresh', opt);
}
function add() {
	layer.open({
		type : 2,
		title : 'New',
		maxmin : true,
		shadeClose : false, //
		area : [ '800px', '520px' ],
		content : prefix + '/add' //
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : 'Edit',
		maxmin : true,
		shadeClose : false, //
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id //
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

function addD(type,description) {
	layer.open({
		type : 2,
		title : 'New',
		maxmin : true,
		shadeClose : false, //
		area : [ '800px', '520px' ],
		content : prefix + '/add/'+type+'/'+description //
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
			ids[i] = row['id'];
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