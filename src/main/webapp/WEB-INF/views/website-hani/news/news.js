$(function () {

    loadList(1);

    function loadList(type) {
        var currPageNum = $('#curr-page-num').val();
        var total = $('#total').val();
        if (type == -1) {
            currPageNum = currPageNum - 1;
            if (currPageNum <= 0) {
                currPageNum = 1;
            }
        }
        if (type == 1) {
            currPageNum = currPageNum + 1
        }
        var start = (currPageNum - 1) * 10;
        if (start > total) {
            return;
        }
        $.ajax({
            url: '/news/getList',
            type: 'get',
            data: {
                currPageNum: currPageNum,
                offset: start
            },
            dataType: 'json',
            success: function (resp) {
                if (resp.rows != undefined && resp.rows != null) {
                    $('#curr-page-num').val(resp.currPageNum);
                    if (start <= 0) {
                        $('#pre').hide();
                    }
                    if (start > total) {
                        $('#next').hide();
                    }
                }
            }
        });
    }
})