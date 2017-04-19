$(function() {
    var page = $("#current-page").val();
    if (page == null || page == 0) {
        page = 1;
    }
    $.ajax({
        url: '/admin/partner/initPage',
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
                    loadPartnerList();
                }
            });
        }
    });
});


// 跳转分页
function toPage(page) {
    $("#page").val(page);
    loadPartnerList();
}

// 加载菜单列表
function loadPartnerList() {
    var param = $("#keyword").val();
    console.log("param:"+param);
    // 收集参数
    var page = $("#now").val();
    if (isEmpty(page) || page == 0) {
        page = 1;
    }

    // 查询列表
    $.ajax({
        url: '/admin/partner/load',
        data: 'page=' + page+"&param="+param,
        success: function (data) {
            $("#dataList").html(data);
        }
    });

}


// 搜索
function search() {
    loadPartnerList();
}

// 删除栏目
function deletePartner(id) {
    new $.flavr().confirm('Are you sure to delete?',
        function () {
            $.ajax({
                url: '/admin/partner/delete',
                data: 'id=' + id,
                success: function (data) {
                    if (data.resultCode == 'success') {
                        autoCloseAlert(data.errorInfo, 1000);
                        loadPartnerList();
                    } else {
                        autoCloseAlert(data.errorInfo, 1000);
                    }
                }
            });
        },
        function () {
        });

}

// 跳转栏目编辑页
function editPartner(id) {

    $.ajax({
        url: '/admin/partner/editJump',
        data: 'id=' + id,
        success: function (data) {
            $('#editPartnerContent').html(data);
            $('#editPartnerModal').modal('show');
            $('#editPartnerModal').addClass('animated');
            $('#editPartnerModal').addClass('flipInY');
        }
    });
}

// 跳转新增页面
function addPartner() {
    $.ajax({
        url: '/admin/partner/addJump',
        success: function (data) {
            $('#addPartnerContent').html(data);
            $('#addPartnerModal').modal('show');
            $('#addPartnerModal').addClass('animated');
            $('#addPartnerModal').addClass('bounceInLeft');
        }
    });
}



