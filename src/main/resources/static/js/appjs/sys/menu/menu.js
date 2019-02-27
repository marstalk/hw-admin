var prefix = "/sys/menu"
$(document).ready(function () {
    load();
});
var load = function () {
    $('#exampleTable')
        .bootstrapTreeTable(
            {
                id: 'menuId',
                code: 'menuId',
                parentCode: 'parentId',
                type: "GET", // 请求数据的ajax类型
                url: prefix + '/list', // 请求数据的ajax的url
                ajaxParams: {sort:'order_num'}, // 请求数据的ajax的data属性
                expandColumn: '1',// 在哪一列上面显示展开button
                striped: true, // 是否各行渐变色
                bordered: true, // 是否显示边框
                expandAll: false, // 是否全部展开
                // toolbar : '#exampleToolbar',
                columns: [
                    {
                        title: 'ID',
                        field: 'menuId',
                        visible: false,
                        align: 'center',
                        valign: 'center',
                        width: '5%'
                    },
                    {
                        title: 'Name',
                        valign: 'center',
                        field: 'name',
                        width: '20%'
                    },

                    {
                        title: 'icon',
                        field: 'icon',
                        align: 'center',
                        valign: 'center',
                        width : '5%',
                        formatter: function (item, index) {
                            return item.icon == null ? ''
                                : '<i class="' + item.icon
                                + ' fa-lg"></i>';
                        }
                    },
                    {
                        title: 'Type',
                        field: 'type',
                        align: 'center',
                        valign: 'center',
                        width : '10%',
                        formatter: function (item, index) {
                            if (item.type === 0) {
                                return '<span class="label label-primary">directory</span>';
                            }
                            if (item.type === 1) {
                                return '<span class="label label-success">menu</span>';
                            }
                            if (item.type === 2) {
                                return '<span class="label label-warning">button</span>';
                            }
                        }
                    },
                    {
                        title: 'link',
                        valign: 'center',
                        width : '20%',
                        field: 'url'
                    },
                    {
                        title: 'permission',
                        valign: 'center',
                        width : '20%',
                        field: 'perms'
                    },
                    {
                        title: 'Operation',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        formatter: function (item, index) {
                            var e = '<a class="btn btn-primary btn-sm '
                                + s_edit_h
                                + '" href="#" mce_href="#" title="Edit" onclick="edit(\''
                                + item.menuId
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var p = '<a class="btn btn-primary btn-sm '
                                + s_add_h
                                + '" href="#" mce_href="#" title="add child" onclick="add(\''
                                + item.menuId
                                + '\')"><i class="fa fa-plus"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '
                                + s_remove_h
                                + '" href="#" title="Del"  mce_href="#" onclick="remove(\''
                                + item.menuId
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d + p;
                        }
                    }]
            });
}

function reLoad() {
    load();
}

function add(pId) {
    layer.open({
        type: 2,
        title: 'new menu',
        maxmin: true,
        shadeClose: false, //
        area: ['800px', '520px'],
        content: prefix + '/add/' + pId //
    });
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
            success: function (data) {
                if (data.code == 0) {
                    layer.msg("delete successfully");
                    reLoad();
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    })
}

function edit(id) {
    layer.open({
        type: 2,
        title: 'menu update',
        maxmin: true,
        shadeClose: false, //
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id //
    });
}

function batchRemove() {
    // var rows = $('#exampleTable').bootstrapTable('getSelections');

}