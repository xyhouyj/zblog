var pager = {start:0,limit:10};
$(function () {
    //初始化文章分页信息
    $('.M-box').pagination({
        callback:function(api){
            $('.now').text(api.getCurrent());
        }
    },function(api){
        $('.now').text(api.getCurrent());
    });
    //初始化文章
    $.ajax({
        type: 'GET',
        url: '/article/aritcleDescList',
        data:{pager:pager},
        success: function (data){
            queryResult = data.data;
        }
    });
})