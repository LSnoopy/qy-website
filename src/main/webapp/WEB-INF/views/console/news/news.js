var $table = $('#table');
var url = {
    list: '/console/news/get',
    saveOrUpdate: '/console/news/saveOrUpdate', del: '/console/news/delete'
};
$(function () {
    initTable();
    $('#search').click(function () {
        reloadDataList(url.list);
    });
    $('#submitNews').click(function () {
        submit();
    });
    $('#preview').click(function () {
        var data = $("#data-form").serializeObject();
        data.content = window.editor.html();
        preview('<h3>' + data.title + '</h3>' + data.content);
    });
    $('#submitCoverImg').click(function () {
        ajaxFileUpload('cover-img');
    });
});
function initTable() {
    $table.bootstrapTable({
        url: url.list,
        // ajaxOptions: {'sort': ''},
        sortName: '',
        columns: [{
            title: '标题',
            field: 'title',
            width: 550
        }, {
            title: '置顶',
            field: 'topFlag',
            width: 80,
            formatter: 'booleanCommonFormat',
            sortable: true
        }, {
            title: '显示',
            field: 'showFlag',
            width: 80,
            formatter: 'booleanCommonFormat',
            sortable: true
        }, {
            title: '创建时间',
            field: 'createTime',
            width: 170,
            formatter: 'timeFormat',
            sortable: true
        }, {
            title: '操作',
            field: 'operate',
            width: 120,
            formatter: 'operateFormat'
        }]
    });
}

function queryParams(params) {
    var title = $.trim($('input[name="titleQry"]').val());
    var beginTimeStr = $.trim($('input[name="beginTimeStr"]').val());
    var endTimeStr = $.trim($('input[name="endTimeStr"]').val());
    if (title != '') {
        params.title = '%' + title + '%';
    }
    if (beginTimeStr != '') {
        params.beginTimeStr = dealDate(beginTimeStr);
    }
    if (endTimeStr != '') {
        params.endTimeStr = dealDate(endTimeStr);
    }
    if (params.sort != undefined && params.sort != '') {
        if (params.sort == 'addTime') {
            params.sort = 'add_time';
        }
    }
    if (params.sort == 'createTime') {
        params.sort = 'create_time';
    }
    if (params.sort == 'topFlag') {
        params.sort = 'top_flag';
    }
    if (params.sort == 'showFlag') {
        params.sort = 'show_flag';
    }
    return params;
}

function reloadDataList(url) {
    var params = {};
    queryParams(params);
    $.ajax({
        url: url,
        dataType: 'json',
        data: params,
        type: 'get',
        success: function (res) {
            responseHandler(res);
            $table.bootstrapTable('load', res);
        }
    });
}

function responseHandler(res) {
    $.each(res.rows, function (i, row) {
        // row.operate = '<a onclick="detail('+row+')"><i class="glyphicon glyphicon-fullscreen"></i></a>&nbsp;&nbsp;&nbsp;';
        // row.operate += '<a onclick="edit('+row+')"><i class="glyphicon glyphicon-edit"></i></a>&nbsp;&nbsp;&nbsp;'
        // row.operate += '<a onclick="del('+row.id+')"><i class="glyphicon glyphicon-remove"></i></a>'
    });
    return res;
}
function submit() {
    var data = $("#data-form").serializeObject();
    data.content = window.editor.html();
    if ($.trim(data.title) == '') {
        showWarningMsg('请填写标题 &and;_&and;')
        return;
    }
    if ($.trim(data.content) == '') {
        showWarningMsg('请填写内容 &and;_&and;')
        return;
    }
    if (data.topFlag == undefined || data.topFlag == null) {
        data.topFlag = 0;
    }
    $('#warningDiv').html('');
    data.content = data.content.replace(/"/g, '&quot;');
    $.ajaxFileUpload({
        url: url.saveOrUpdate,
        type: 'POST',
        secureuri: false, //是否需要安全协议，一般设置为false
        fileElementId: 'cover-img', //文件上传域的ID
        dataType: 'json',
        data: data,
        cache: false,
        success: function (resp) {
            console.info(resp.success);
            if (!resp.success) {
                showErrorMsg(resp.msg);
                return;
            }
            showSuccessMsg('');
            reloadDataList(url.list);
            setTimeout(function () {
                $('#warningDiv').html('');
                setTimeout(function () {
                    back();
                }, 100)
            }, 800)
        }, error: function () {
            alert('操作失败,请重试');
        }
    });
}
function add() {
    $('#list-div').addClass('hide');
    $('#edit-div').removeClass('hide');
    initFormData();
}
var showFlagFalse = '<input type="radio" name="showFlag" value="1">' +
    '显示' +
    '<input type="radio" name="showFlag" value="0" checked="checked">' +
    '隐藏';
var showFlagTrue = '<input type="radio" name="showFlag" value="1" checked="checked">' +
    '显示' +
    '<input type="radio" name="showFlag" value="0">' +
    '隐藏';
var topFlagTrue = '<input type="checkbox" name="topFlag" value="1" checked="checked"> 置顶';
var topFlagFalse = '<input type="checkbox" name="topFlag" value="1" > 置顶';
function initFormData() {
    $('#data-form input:text[name="title"]').val('');
    $('#data-form input:text[name="source"]').val('');
    $('#data-form input[name="id"]').val('');
    $('#topFlag-row').html(topFlagFalse);
    $('#showFlag-row').html(showFlagTrue);
    $('#cover-img-p').html('');
    window.editor.html('');
}
function detail(id) {
    var row = $table.bootstrapTable('getRowByUniqueId', id);
    var html = row.coverImgUrl != '' ? '<img width="240" height="160" src="' + row.coverImgUrl + '" />' : '';
    html += '<h4 style="font-size: 18px;font-weight: bold;line-height: 1.5;">标题：' + row.title + '</h4>';
    var s = row.source != null ? row.source.length > 0 ? row.source : '-' : '-';
    html += '<h6><p>来源：' + s + '</p></h6>';
    html += '<span class="font-12">创建时间：' + getLocalTime(row.createTime, 4) + '&nbsp;&nbsp;修改时间：' + getLocalTime(row.modifyTime, 4) + '</span>';
    html += '<br/><span class="font-12">置顶：' + booleanCommonFormat(row.topFlag) + '&nbsp;&nbsp;显示：' + booleanCommonFormat(row.showFlag) + '</span>';
    html += '<br/>内容：<p>' + row.content + '</p>';
    preview(html);
}
function edit(id) {
    var row = $table.bootstrapTable('getRowByUniqueId', id);
    $('#data-form input:text[name="title"]').val(row.title);
    $('#data-form input:text[name="source"]').val(row.source);
    $('#data-form input[name="id"]').val(row.id);
    if (row.topFlag)
        $('#topFlag-row').html(topFlagTrue);
    else
        $('#topFlag-row').html(topFlagFalse);
    if (row.showFlag)
        $('#showFlag-row').html(showFlagTrue);
    else
        $('#showFlag-row').html(showFlagFalse);
    var coverImgUrl = row.coverImgUrl;
    if (coverImgUrl != '') {
        $('#cover-img-p').html('<img alt="封面图片" title="封面图片" width="240" height="160" src="' + coverImgUrl + '" />');
    }
    window.editor.html(row.content);
    $('#list-div').addClass('hide');
    $('#edit-div').removeClass('hide');
}
function del(id) {
    if (!isNaN(id)) {
        $.ajax({
            url: url.del,
            type: 'GET',
            dataType: 'json',
            data: {id: id},
            success: function (resp) {
                if (resp.success) {
                    reloadDataList(url.list);
                }
                // $table.bootstrapTable('removeByUniqueId', id)
            }
        });
    }
}

function back() {
    $('#edit-div').addClass('hide');
    $('#list-div').removeClass('hide');
}

function preview(content) {
    var html = '<div class="panel-body" style="line-height: 1.5;">';
    html += '<a class="close font-14" onclick="closePreview()" data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove"></i></a>';
    html += content;
    html += '</div>';
    $('.preview').html(html);
    $('.preview').removeClass('hide');
}

function closePreview() {
    $('.preview').addClass('hide');
    $('.preview').html('');
}

function operateFormat(value, row, index) {
    var operate = '<a onclick="detail(' + row.id + ')"><i class="glyphicon glyphicon-fullscreen"></i></a>&nbsp;&nbsp;&nbsp;';
    operate += '<a onclick="edit(' + row.id + ')"><i class="glyphicon glyphicon-edit"></i></a>&nbsp;&nbsp;&nbsp;'
    operate += '<a onclick="del(' + row.id + ')"><i class="glyphicon glyphicon-remove"></i></a>'
    return operate;
}

//日期插件
$(function () {
    $('.datetimepicker').datetimepicker({
        // language:  'en'
        // format: 'yyyy-mm-dd hh:ii:ss'
    }).on('changeDate', function (ev) {
        console.info(ev);
    });
    ;
})

function dealDate(timeStr) {
    if (timeStr.indexOf('/') > -1) {
        timeStr = timeStr.replace(/\//g, '-');
        var arr = timeStr.split(' ');
        var y = arr[0].substring(arr[0].lastIndexOf('-') + 1, arr[0].length);
        var md = arr[0].substring(0, arr[0].lastIndexOf('-'));
        return y + '-' + md + ' ' + arr[1];
    }
}
