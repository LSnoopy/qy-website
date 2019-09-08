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
            width: 550,
            formatter: 'operateFormat'
        }, {
            title: '',
            field: 'createTime',
            width: 170,
            formatter: 'timeFormat'
        }]
    });
}

function operateFormat(value, row, index) {
    // return value;
    return '<a style="cursor:pointer;" onclick="detail(&apos;' + row.id + '&apos;)">' + value + '</a>';
}

function detail(id) {
    var row = $table.bootstrapTable('getRowByUniqueId', id);
    console.info(row);
    var html = row.coverImgUrl != '' ? '<img width="240" height="160" src="' + row.coverImgUrl + '" />' : '';
    html += '<div style="text-align: center;"><h4 style="font-size: 18px;font-weight: bold;line-height: 1.5;">' + row.title + '</h4></div>';
    var s = row.source != null ? row.source.length > 0 ? row.source : '-' : '-';
    // html += '<h6><p>来源：' + s + '</p></h6>';
    html += '<span class="font-12">' + getLocalTime(row.createTime, 4) + '</span>';
    // html += '<br/><span class="font-12">置顶：' + booleanCommonFormat(row.topFlag) + '&nbsp;&nbsp;显示：' + booleanCommonFormat(row.showFlag) + '</span>';
    html += '<br/><br/>';
    html += row.content;
    $('#newsDetail').show();
    $('#newsDetail>div>section').html(html);
}
