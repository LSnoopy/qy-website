$(function () {

    $('#submitPwd').click(function () {
        if (validateEmpty($('#oldPwd'), '原密码不能为空') && validateEmpty($('#newPwd'), '新密码不能为空')) {
            var opwd = $.md5($.trim($('#oldPwd').val()));
            var npwd = $.md5($.trim($('#newPwd').val()));
            $.ajax({
                url: '/console/updatePwd',
                data: {
                    oldPwd: opwd,
                    newPwd: npwd
                },
                dataType: 'json',
                type: 'GET',
                success: function (resp) {
                    if (!resp.success) {
                        showErrorMsg(resp.msg);
                        return;
                    }
                    showSuccessMsg(' <a href="/console/index">重新登录&gt;&gt;</a>');
                }
            });
        }
    });
});
