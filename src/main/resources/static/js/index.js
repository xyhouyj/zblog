var pager = {page:1,start:0,limit:10};
var pager1 = {page:1,start:0,limit:10};
$(function () {
    //初始化文章
    $.ajax({
        type: 'GET',
        url: '/article/load',
        data:pager,
        success: function (data){
            $("#main").html(data);
            //初始化文章分页信息
            //初始化文章
            $.ajax({
                type: 'GET',
                url: '/pager/article/load',
                data:pager,
                success: function (data){
                    pager = data;
                    initPage();

                    /*分享初始化*/
                    $(".socialShare").socialShare({
                        content: '这是我的个人博客内容',
                        url:'http://kiritor.github.io/2015/09/28/shiro-Authentication/',
                        title:'这是我的个人博客标题',
                        summary:'这是我的博客描述',
                        pic:'https://user-gold-cdn.xitu.io/2017/4/8/0bc6a6ba97cff243292f7c26560e71fb.gif'
                    });
                }
            });
        }
    });

})

function initPage() {
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


function loadCategory(categoryId) {
    var loadPager = {page:1,start:0,limit:10};
    $.ajax({
        type: 'GET',
        url: '/category/load/' + categoryId,
        data: loadPager,
        success: function (data) {
            $("#main").html(data);

            //初始化标签分页信息
            $.ajax({
                type: 'GET',
                url: '/category/pager/'+categoryId,
                data:loadPager,
                success: function (data) {
                    pager = data;
                    initPage();
                }
            });
        }
    });

}

function loadTag(tagId) {
    var loadPager = {page:1,start:0,limit:10};

    $.ajax({
        type: 'GET',
        url: '/tag/load/'+tagId,
        data: loadPager,
        success: function (data) {
            $("#main").html(data);

            //初始化标签分页信息
            $.ajax({
                type: 'GET',
                url: '/category/pager/'+tagId,
                data:loadPager,
                success: function (data) {
                    pager = data;
                    initPage();
                }
            });
        }
    });
}