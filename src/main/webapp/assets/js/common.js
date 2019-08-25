function validateEmpty(input, msg) {
    var value = $.trim(input.val());
    if (value == '') {
        showWarningMsg(msg);
        return false;
    }
    $('#warningDiv').html('');
    return true;
}

function showWarningMsg(msg) {
    var tempWarning =
        '<div class="col-md-5 col-md-offset-3 alert alert-dismissible alert-warning"> ' +
        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        '<p><strong>' + msg + '</strong></p>' +
        '</div>';
    $('#warningDiv').html(tempWarning);
}

function showErrorMsg(msg) {
    var tempError =
        '<div class="col-md-5 col-md-offset-3 alert alert-dismissible alert-danger"> ' +
        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        '<p><strong>' + msg + '</strong></p>' +
        '</div>';
    $('#warningDiv').html(tempError);
}

function showSuccessMsg(msg) {
    var tempSuccess =
        '<div class="col-md-5 col-md-offset-3 alert alert-dismissible alert-success"> ' +
        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        '<p><strong>操作成功!' + msg + '</strong></p>' +
        '</div>';
    $('#warningDiv').html(tempSuccess);
}

function booleanCommonFormat(value) {
    if (value) {
        return '是';
    } else {
        return '否';
    }
}

function timeFormat(value) {
    return getLocalTime(value, 4);
}

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function bubbleMsg(msg, type) {
    if (type == 3)
        showSuccessMsg(msg);
    if (type == 2)
        showErrorMsg(msg)
    if (type == 1)
        showWarningMsg(msg)
    setTimeout(function () {
        $('#warningDiv').html('');
    }, 1000)
}
