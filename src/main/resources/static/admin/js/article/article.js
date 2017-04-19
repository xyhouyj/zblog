$(function() {
    var page = $("#current-page").val();
    if (page == null || page == 0) {
        page = 1;
    }
    $.ajax({
        url: '/admin/article/initPage',
        data: 'page=' + page,
        success: function (data) {
            $("#total-num").text(data.totalCount);
            $("#total-page").text(data.totalPageNum);
            $("#current-page").text(data.page);
            $.jqPaginator('#pagination', {
                totalPages: data.totalPageNum,
                visiblePages: 5,
                currentPage: data.page,
                prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
                next: '<li class="next"><a href="javascript:;">Next</a></li>',
                page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
                onPageChange: function (num, type) {
                    // 加载管理员列表
                    $("#current-page").text(num);
                    loadArticleList();
                    $(".chosen-select").chosen({
                        max_selected_options: 5,
                        no_results_text: "没有找到",
                        allow_single_deselect: true
                    });
                    $(".chosen-select").trigger("liszt:updated");
                }
            });
        }
    });

});

// 跳转分页
function toPage(page){
	$("#page").val(page);
	loadArticleList();		
}

//0:可用  1：不可用 
function updateStatue(id,flag){
	flag = flag==1?0:1;
    new $.flavr().confirm('Are you sure to change status?',
        function () {
            $.ajax({
                url: '/admin/article/updateStatue',
                data: 'id=' + id + '&status=' + flag,
                success: function (data) {
                    if (data.resultCode == 'success') {
                        autoCloseAlert(data.errorInfo, 1000);
                        loadArticleList();
                    } else {
                        autoCloseAlert(data.errorInfo, 1000);
                    }
                }
            });
        },function () {
        });
}

// 加载文章列表
function loadArticleList(){

	var page = $("#page").val();
	if(isEmpty(page) || page == 0){
		page = 1;
	}
    var categoryId = $("#categoryId option:selected").val();
    var keyword = $("#keyword").val();
    var tagIds = [];
    $("#tagId option:selected").each(function () {
        tagIds.push($(this).val());
    })
	// 查询列表
	$.ajax({
        url : '/admin/article/load',
        data : 'page='+page+"&categoryId="+categoryId+"&title="+keyword+"&tagIds="+tagIds,
        success  : function(data) {
        	$("#dataList").html(data);
		}
    });
	
}


// 搜索
function search(){
	loadArticleList();
}

// 新增文章  跳转新页
function addArticle(){
	window.location.href = "/admin/article/addPage";
}

// 删除文章
function deleteArticle(id){
    new $.flavr({
        content: '您确定要删除吗?',

        buttons: {
            primary: {
                text: '确定', style: 'primary', action: function () {
                    $.ajax({
                        url : '/admin/article/delete',
                        data : 'id='+id,
                        success  : function(data) {
                            if(data.resultCode == 'success'){
                                autoCloseAlert(data.errorInfo,1000);
                                loadArticleList();
                            }else{
                                autoCloseAlert(data.errorInfo,1000);
                            }
                        }
                    });
                }
            },
            success: {
                text: '取消', style: 'danger', action: function () {

                }
            }
        }
    });
    // 调到列表页

}

function htmlArticle(id){
	$.ajax({
        url : '/admin/article/static/'+id,
        success  : function(data) {
        	if(data.resultCode == 'success'){
        		autoCloseAlert(data.errorInfo,1000);
        		loadArticleList();
        	}else{
        		autoCloseAlert(data.errorInfo,1000);
        	}
		}
    });
}

// 静态化全部文章
function htmlAllArticle(){
	$("#htmlAll").hide();
	$.ajax({
        url : '/admin/article/staticAll',
        success  : function(data) {
        	if(data.resultCode == 'success'){
        		autoCloseAlert(data.errorInfo,1000);
        		loadArticleList();
        	}else{
        		autoCloseAlert(data.errorInfo,1000);
        	}
        	$("#htmlAll").show();
		}
    });
}

// 编辑文章
function editArticle(id){
	window.open("/admin/article/editJump/?id="+id);
}