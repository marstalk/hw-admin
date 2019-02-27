var prefix = "/common/log"
$(function () {
    load();

});
$('#exampleTable').on('load-success.bs.table', function (e, data) {
    if (data.total && !data.rows.length) {
        $('#exampleTable').bootstrapTable('selectPage').bootstrapTable('refresh');
    }
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get',
                url: prefix + "/list",
                // showRefresh : true,
                // showToggle : true,
                // showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true,
                dataType: "json",
                pagination: true,
                // queryParamsType : "limit",
                //
                singleSelect: false,
                // contentType : "application/x-www-form-urlencoded",
                //
                pageSize: 10,
                pageNumber: 1,
                // search : true,
                // showColumns : true,
                sidePagination: "server",
                // "server"
                queryParams: function (params) {
                    return {
                        limit: params.limit,
                        offset: params.offset,
                        name: $('#searchName').val(),
                        sort: 'gmt_create',
                        order: 'desc',
                        operation: $("#searchOperation").val(),
                        username: $("#searchUsername").val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式New一些额外的参数，e.g. toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'id', //
                        title: 'ID' //
                    },
                    {
                        field: 'userId',
                        title: '用户Id'
                    },
                    {
                        field: 'username',
                        title: ' UserName'
                    },
                    {
                        field: 'operation',
                        title: 'Operation'
                    },
                    {
                        field: 'time',
                        title: '用时'
                    },
                    {
                        field: 'method',
                        title: '方法'
                    },
                    {
                        field: 'params',
                        title: '参数'
                    },
                    {
                        field: 'ip',
                        title: 'IPlink'
                    },
                    {
                        field: 'gmtCreate',
                        title: '创建时间'
                    },
                    {
                        title: 'Operation',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="Edit" onclick="edit(\''
                                + row.userId
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm" href="#" title="Del"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
                                + row.userId
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return d;
                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function remove(id) {
    layer.confirm('sure to delete the selectd records？', {
        btn: ['Yes', 'No']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            beforeSend: function (request) {
                index = layer.load();
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.close(index);
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
    var rows = $('#exampleTable').bootstrapTable('getSelections'); //
    if (rows.length == 0) {
        layer.msg("Please select what you wanna delete");
        return;
    }
    layer.confirm("Are you sure to delete '" + rows.length + "'rocords?", {
        btn: ['Yes', 'No']
        // button
    }, function () {
        var ids = new Array();
        //
        $.each(rows, function (i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: prefix + '/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {
    });
}