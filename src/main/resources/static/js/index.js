var pager = {page:1,start:0,limit:10};
$(function () {
    $('body').addClass('loaded');
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
                        content: "EumJi在IT,生活,音乐方面的分享",
                        url:"www.eumji025.com/",
                        title:$("#article-title").text(),
                        summary:'Eumji个人博客分享,欢迎指教',
                        pic:'http://of8rkrh1w.bkt.clouddn.com/2017/4/21/touxiang.jpg'
                    });

                    $('#loader-wrapper .load_title').remove();
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