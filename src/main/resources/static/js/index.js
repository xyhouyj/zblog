var pager = {page:1,start:0,limit:10};
/*初始化文章分页信息*/
$(function () {
    $('body').addClass('loaded');
            $.ajax({
                type: 'GET',
                url: '/pager/articles/load',
                data:pager,
                success: function (data){
                    pager = data;
                    $("#pagination").data("type","article");
                    initPage(null);
                }
        });

})

/*function initPage() {
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
}*/
/*将初始化页面封装成一个方法*/
function initPage(id) {
    console.log(pager.totalCount);
    $("#total-num").text(pager.totalCount);
    $("#total-page").text(pager.totalPageNum);
    $("#current-page").text(pager.page);
    $.jqPaginator('#pagination', {
        totalPages: pager.totalPageNum,
        visiblePages: 5,
        currentPage: pager.page,
        prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
        next: '<li class="next"><a href="javascript:;">Next</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            pager.page = num;
            var type = $("#pagination").data("type");
            loadList(type,id);
            // 当前第几页
            $("#current-page").text(num);
            $(".chosen-select").chosen({
                max_selected_options: 5,
                no_results_text: "没有找到",
                allow_single_deselect: true
            });
            $(".chosen-select").trigger("liszt:updated");
        }
    });
}

/*将加载文章,文章分类,标签分类重构成一个方法*/
function  loadList(type,id) {
    var url = "";
    if (type == "article"){
        url = '/'+type+'/load';
    }
    else{
        url = '/'+type+'/load/'+id;
    }
    $.ajax({
        type: 'GET',
        url: url,
        data: pager,
        success: function (data) {
            $("#main-article").html(data);
            //初始化文章分页信息
            //初始化文章
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

$("#main-article").on('click','.article-tag-link',function () {
    var tagId = $(this).data("id");
    console.log("tagId:"+tagId);
    var loadPager = {page:1,start:0,limit:10};
    $.ajax({
        type: 'GET',
        url: '/pager/tags/' + tagId,
        data: loadPager,
        success: function (data) {
            pager = data;
            $("#pagination").data("type","tags");
            initPage(tagId);
        }
    });
})


$(".category-list-link").on('click',function () {
    var categoryId = $(this).data("id");
    var loadPager = {page:1,start:0,limit:10};
    console.log("categoryId:"+categoryId);
    $.ajax({
        type: 'GET',
        url: '/pager/categories/' + categoryId,
        data: loadPager,
        success: function (data) {
            pager = data;
            $("#pagination").data("type","categories");
            initPage(categoryId);
        }
    });
})

/*为动态元素绑定lick事件*/
$("#main-article").on('click','.article-category-link',function () {
    var categoryId = $(this).data("id");
    var loadPager = {page:1,start:0,limit:10};
    $.ajax({
        type: 'GET',
        url: '/pager/categories/' + categoryId,
        data: loadPager,
        success: function (data) {
            pager = data;
            $("#pagination").data("type","categories");
            initPage(categoryId);
        }
    });
})

