var prefix = "/activiti/process"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/list", // 服务器数据的加载link
				// showRefresh : true,
				// showToggle : true,
				// showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				// queryParamsType : "limit",
				// //设置为limit则会发送符合RESTFull格式的参数
				singleSelect : false, // 设置为true将禁止多选
				// contentType : "application/x-www-form-urlencoded",
				// //发送到服务器的数据编码类型
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				// search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
				// "server"
				queryParams : function(params) {
					return {
						// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						name : $('#searchName').val(),
					};
				},
				// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，e.g. toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含
				// limit, offset, search, sort, order 否则, 需要包含:
				// pageSize, pageNumber, searchText, sortName,
				// sortOrder.
				// 返回false将会终止请求
				columns : [
					{
						checkbox : true
					},
                    {
                        field : 'id', // 列字段名
                        title : 'ID' // 列标题
                    },
                    {
                        field : 'deploymentId', // 列字段名
                        title : '部署编号' // 列标题
                    },

                    {
                        field : 'name',
                        title : '流程名称'
                    },

                    {
                        field : 'id',
                        title : '流程XML',
						formatter:function (value,row,index) {
                            var e = '<a   href="/activiti/process/resource/read/xml/'+row.id+'"  title="xml" target="_blank">xml</a> ';
                            return e;
                        }
                    },
                    {
                        field : 'id',
                        title : '流程XML',
                        formatter:function (value,row,index) {
                            var e = '<a   href="/activiti/process/resource/read/image/'+row.id+'"  title="图片" target="_blank">图片</a> ';
                            return e;
                        }
                    },
					{
						title : 'Operation',
						field : 'id',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="Edit" onclick="edit(\''
								+ row.id
								+ '\')"><i class="fa fa-edit "></i></a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="Del"  mce_href="#" onclick="remove(\''
								+ row.deploymentId
								+ '\')"><i class="fa fa-remove"></i></a> ';
							var f = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="转为模型"  mce_href="#" onclick="covertToModel(\''
								+ row.id
								+ '\')"><i class="fa fa-cube"></i></a> ';
							return d + f;
						}
					} ]
			});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	// iframe层
	var page = layer.open({
		type : 2,
		title : '新建模型',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add'
	});
    layer.full(page);
}
function remove(id) {
	layer.confirm('sure to delete the selectd records？', {
		btn : [ 'Yes', 'No' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
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
	var page = layer.open({
		type : 2,
		title : '修改模型',
		maxmin : true,
		shadeClose : false,
		area : [ '100%', '100%' ],
		content : prefix + '/edit/' + id
	});
}

function covertToModel(id) {
    layer.confirm('确定要把流程转转换成流程吗吗？', {
        btn : [ 'Yes', 'No' ]
    }, function() {
        $.ajax({
            url : prefix+"/convertToModel/"+id,
            type : "get",
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

function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("Please select what you wanna delete");
		return;
	}
	layer.confirm("Are you sure to delete '" + rows.length + "'rocords?", {
		btn : [ 'Yes', 'No' ]
	// button
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
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