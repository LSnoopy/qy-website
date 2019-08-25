$(function () {

    $.ajax({
        url: '/console/slider/getList',
        type: 'GET',
        dataType: 'json',
        success: function (resp) {
            if (resp.length > 0) {
                for (var i = 0; i < resp.length; i++) {
                    $('#img' + (i + 1) + '-id').val(resp[i].id);
                    if(resp[i].url != undefined && resp[i].url != null && resp[i].url != ''){
                        $('#img' + (i + 1) + '-p').html('<img width="800" src=' + resp[i].url + '/>');
                    }
                }
            }
        }
    });

    $('#delBtn1').click(function () {
        del($.trim($('#img1-id').val()), '#img1-p', '#img1-id');
    });
    $('#delBtn2').click(function () {
        del($.trim($('#img2-id').val()), '#img2-p', '#img2-id');
    });
    $('#delBtn3').click(function () {
        del($.trim($('#img3-id').val()), '#img3-p', '#img3-id');
    });
    $('#delBtn4').click(function () {
        del($.trim($('#img4-id').val()), '#img4-p', '#img4-id');
    });

    $('#submitBtn').click(function () {
        if ($.trim($('#img1').val()) == '' && $.trim($('#img2').val()) == '' && $.trim($('#img3').val()) == '' && $.trim($('#img4').val()) == '') {
            alert('至少上传一张轮播图');
            return;
        }
        ajaxFileUpload('img1', $('#img1-id').val(), '#img1-p');
        ajaxFileUpload('img2', $('#img2-id').val(), '#img2-p');
        ajaxFileUpload('img3', $('#img3-id').val(), '#img3-p');
        ajaxFileUpload('img4', $('#img4-id').val(), '#img4-p');
    });

    function ajaxFileUpload(fileId, id, imgIdP) {
        if ($.trim($('#' + fileId).val()) == '') {
            return;
        }
        var whichImg = 'banner' + fileId.substring(3);
        $.ajaxFileUpload({
                url: '/console/slider/save', //用于文件上传的服务器端请求地址
                secureuri: false, //是否需要安全协议，一般设置为false
                fileElementId: fileId, //文件上传域的ID
                dataType: 'json', //返回值类型 一般设置为json
                data: {
                    id: id
                },
                success: function (resp) {
                    if (!resp.success) {
                        alert(whichImg + '上传失败,请重试');
                        return;
                    }
                    $(imgIdP).html('<img width="800" src=' + resp.data + '/>');
                },
                error: function () {
                    alert(whichImg + '上传失败,请重试');
                }
            }
        )
    }

    function del(id, pid) {
        if (id == '') {
            return;
        }
        $.ajax({
            url: '/console/slider/del',
            type: 'GET',
            dataType: 'json',
            data: {id: id},
            success: function (resp) {
                if (resp.success) {
                    $(pid).html('');
                }
            }
        });
    }
})