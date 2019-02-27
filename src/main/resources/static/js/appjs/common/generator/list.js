var prefix = "/common/generator"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get',
						url : prefix + "/list",
						showRefresh : true,
						showToggle : true,
						showColumns : true,
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
						search : true,
						showColumns : true,
						sidePagination : "client",
						// "server"
						// queryParams : queryParams,
						//
						columns : [
								{
									checkbox : true
								},
								{
									field : 'tableName', //
									title : '表名称' //
								},
								{
									field : 'engine',
									title : 'engine'
								},
								{
									field : 'tableComment',
									title : '表描述'
								},
								{
									field : 'createTime',
									title : '创建时间'
								},
								{
									title : 'Operation',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="生成代码" onclick="code(\''
												+ row.tableName
												+ '\')"><i class="fa fa-code"></i></a> ';
										return e;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function code(tableName) {
	location.href = prefix + "/code/" + tableName;
}
function batchCode() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); //
	if (rows.length == 0) {
		layer.msg("请选择要生成代码的表");
		return;
	}
	var tables = new Array();
	//
	$.each(rows, function(i, row) {
		tables[i] = row['tableName'];
	});
	location.href = prefix + "/batchCode?tables=" + JSON.stringify(tables).replace('[','%5B').replace(']','%5D');
}

function edit(){
	console.log('打开配置页面');
	layer.open({
		type : 2,
		title : 'New',
		maxmin : true,
		shadeClose : false, 
		area : [ '800px', '520px' ],
		content : prefix + '/edit'
	});
}