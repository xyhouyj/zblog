var pager = {start:0,limit:10};
$(function () {
    //初始化文章分页信息
    //初始化文章
    $.ajax({
        type: 'GET',
        url: '/pager/load',
        data:{pager:pager},
        success: function (data){
            pager = data;
            $('.M-box').pagination({
                pagerCount:pager.totalPageNum, //	总页数
                current:pager.pager,//当前第几页
                showData:pager.limit,//每页显示的条数
                count:3,//	当前选中页前后页数
                callback:function(api){
                    $('.now').text(api.getCurrent());
                }
            },function(api){
                $('.now').text(api.getCurrent());
            });
        }
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