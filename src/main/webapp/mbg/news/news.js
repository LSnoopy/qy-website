var $table = $('#table');
var url = {
    list: '/console/news/get',
    saveOrUpdate: '', del: ''
};
$(function () {
    initTable();
});

function initTable() {
    $table.bootstrapTable({
        url: url.list,
        // ajaxOptions: {'sort': ''},
        sortName: '',
        columns: [{
            title: '',
            field: 'title',
            width: 550
        },{
            title: '',
            field: 'createTime',
            width: 170,
            formatter: 'timeFormat',
        }]
    });
}

function operateFormat(value, row, index) {
    var operate = '<a onclick="detail(' + row.id + ')"><i class="glyphicon glyphicon-fullscreen"></i></a>&nbsp;&nbsp;&nbsp;';
    operate += '<a onclick="edit(' + row.id + ')"><i class="glyphicon glyphicon-edit"></i></a>&nbsp;&nbsp;&nbsp;'
    operate += '<a onclick="del(' + row.id + ')"><i class="glyphicon glyphicon-remove"></i></a>'
    return operate;
}

function responseHandler(res) {
    $.each(res.rows, function (i, row) {
        // row.operate = '<a onclick="detail('+row+')"><i class="glyphicon glyphicon-fullscreen"></i></a>&nbsp;&nbsp;&nbsp;';
        // row.operate += '<a onclick="edit('+row+')"><i class="glyphicon glyphicon-edit"></i></a>&nbsp;&nbsp;&nbsp;'
        // row.operate += '<a onclick="del('+row.id+')"><i class="glyphicon glyphicon-remove"></i></a>'
    });
    return res;
}