$(function(){
    $("#category-manage-li").addClass("active");
    $("#category-list-li").addClass("active");
    var page = $("#current-page").val();
    if (page==null || page ==0 ){
        page = 1;
    }
    $.ajax({
        url : '/admin/category/initPage',
        data : 'page='+page,
        success  : function(data) {
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
                    // 加载分类列表
                    $("#current-page").text(num);
                    loadCategoryList();
                }
            });
        }
    });


})


// 跳转分页
function toPage(page){
    $("#page").val(page);
    loadCategoryList();
}

// 加载管理员列表
function loadCategoryList(){
    // 收集参数
    var param = buildParam();

    var page = $("#current-page").text();
    if(isEmpty(page) || page == 0){
        page = 1;
    }

    // 查询列表
    $.ajax({
        url : '/admin/category/load',
        data : 'page='+page+"&param="+param,
        success  : function(data) {
            $("#dataList").html(data);
        }
    });

}

// 收集参数
function buildParam(){
    var param = {};
    var keyword = $("#keyword").val();
    if(!isEmpty(keyword)){
        param["categoryName"] = encodeURI(encodeURI(keyword));
    }
    return JSON.stringify(param);
}

// 搜索
function search(){
    loadCategoryList();
}

// 删除
function deleteCategory(id){
    $.ajax({
        url : '/admin/category/delete',
        data : 'id='+id,
        success  : function(data) {
            if(data.resultCode == 'success'){
                autoCloseAlert(data.errorInfo,1000);
                window.href.location = "/admin/tag/list";
            }else{
                autoCloseAlert(data.errorInfo,1000);
            }
        }
    });
}

// 跳转编辑页
function editCategory(id){
    $.ajax({
        url : '/admin/category/editJump/',
        data: {id:id},
        success  : function(data) {
            $('#editCategoryContent').html(data);
            $('#editCategoryModal').modal('show');
            $('#editCategoryModal').addClass('animated');
            $('#editCategoryModal').addClass('flipInY');
        }
    });
}

// 关闭编辑管理员窗口
function closeEditWindow(){
    $('#editCategoryModal').modal('hide');
}

// 关闭新增管理员窗口
function closeAddWindow(){
    $('#addCategoryModal').modal('hide');
}


// 编辑管理员
function saveEditCategory(){
    if(validateEditCategory()){
        $.ajax({
            url : '/admin/category/update',
            data : encodeURI($("#editForm").serialize()),
            success  : function(data) {
                if(data.resultCode == 'success'){
                    $('#editCategoryModal').modal('hide');
                    closeEditWindow();
                    autoCloseAlert(data.errorInfo,1000);
                    window.href.location = "/admin/tag/list";
                }else{
                    autoCloseAlert(data.errorInfo,1000);
                }
            }
        });
    }
}

// 新增管理员
function saveAddCategory(){
    if(validateAddCategory()){
        $.ajax({
            url : '/admin/category/save',
            data : encodeURI($("#addForm").serialize()),
            success  : function(data) {
                if(data.resultCode == 'success'){
                    $('#addCategoryModal').modal('hide');
                    loadCategoryList();
                    closeAddWindow();
                    autoCloseAlert(data.errorInfo,1000);
                }else{
                    autoCloseAlert(data.errorInfo,1000);
                }
            }
        });
    }
}

// 校验新增管理员输入框
function validateAddCategory(){
    var categoryName = $("#categoryName").val();
    var aliasName = $("#aliasName").val();
    if(!isEmpty(categoryName)){
        if(isSpecialSymbols(categoryName)){
            autoCloseAlert("分类名称不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("分类名称不能为空",1000);
        return false;
    }
    if(!isEmpty(aliasName)){
        if(isSpecialSymbols(aliasName)){
            autoCloseAlert("分类别名不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("分类别名不能为空",1000);
        return false;
    }
    return true;
}

// 校验编辑管理员输入框
function validateEditCategory(){
    var CategoryName = $("#categoryName").val();
    var aliasName = $("#aliasName").val();
    if(!isEmpty(CategoryName)){
        if(isSpecialSymbols(CategoryName)){
            autoCloseAlert("标签不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("标签不能为空",1000);
        return false;
    }
    if(!isEmpty(aliasName)){
        if(isSpecialSymbols(aliasName)){
            autoCloseAlert("分类别名不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("分类别名不能为空",1000);
        return false;
    }

    return true;
}

// 跳转新增管理员页面
function addCategory(){
    $.ajax({
        url : '/admin/category/addJump',
        success  : function(data) {
            $('#addCategoryContent').html(data);
            $('#addCategoryModal').modal('show');
            $('#addCategoryModal').addClass('animated');
            $('#addCategoryModal').addClass('bounceInLeft');
        }
    });
}