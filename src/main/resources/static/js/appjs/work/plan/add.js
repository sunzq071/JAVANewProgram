//var menuTree;

$(function() {
    validateRule();
    laydate({
        elem : '#preFinishTime'
    });
});
$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});
function save() {
    var workPlan = $('#signupForm').serialize();
    $.ajax({
        cache : true,
        type : "POST",
        url : "/work/plan/save",
        data : workPlan, // 你的formid

        async : false,
        error : function(request) {
            alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                //parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引

                parent.layer.close(index);

            } else {
                parent.layer.msg(data.msg);
            }
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            workTask : {
                required : true
            }
        },
        messages : {
            workTask : {
                required : icon + "请输入工作计划"
            }
        }
    });
}