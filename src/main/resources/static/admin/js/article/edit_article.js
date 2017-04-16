var testEditor;

$(function () {
    testEditor = editormd("article-editormd", {
        width: "100%",
        height: 640,
        syncScrolling: "single",
        path: "/admin/lib/"
    });


});

function getRootPath() {
	//获取当前网址，如： http://localhost:8080/GameFngine/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： GameFngine/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8080
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/GameFngine
	var projectName = pathName.substring(0,
			pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName + "/");
}

// 保存文章
function editArticle(){
	var articleId = $("#article-id").val();
    $.ajax({
        url: '/admin/article/updateInfo?articleId='+articleId,
        success: function (data) {
            $('#addArticleContent').html(data);
            $('#addArticleModal').modal('show');
            $('#addArticleModal').addClass('animated');
            $('#addArticleModal').addClass('flipInY');
            $(".chosen-select").chosen({
                max_selected_options: 5,
                no_results_text: "没有找到",
                allow_single_deselect: true
            });
            $(".chosen-select").trigger("liszt:updated");
        }
    });
}

function save() {
	var id = $("#articleId").val();

    var categoryId = $("#categoryId").val();
    if(isEmpty(categoryId)){
        autoCloseAlert("请选择栏目",500);
        return false;
    }
    var title = $("#title").val();
    if(isEmpty(title)){
        autoCloseAlert("请输入标题",500);
        return false;
    }

    var content = testEditor.getMarkdown();
    var description = $("#description").val();
    // 标签
    var tagIds = [];
    $("#tagId option:selected").each(function () {
        tagIds.push($(this).val());
    })
    if (isEmpty(tagIds)) {
        autoCloseAlert("请输入标签", 500);
        return false;
        // var ids = (tagId+"").split(",");
        // var tagArray = [];
        // for(var i=0;i<ids.length;i++){
        //     tagObj = {id:ids[i]};
        //     tagArray.push(tagObj);
        // }
        // param["tagList"] = tagArray;
        // console.info(tagArray);
    }

    // 保存文章
    $.ajax({
        type : "POST",
        url :  '/admin/article/update',
        data : 'id='+id+'&categoryId=' + categoryId + "&tags=" + tagIds + "&title=" + title + "&content=" + encodeURI(content) + "&description=" +  encodeURI(description),
        success  : function(data) {
            if(data.resultCode != 'success'){
                autoCloseAlert(data.errorInfo,1000);
                closeEditWindow();
                return false;
            }else{
                new $.flavr({
                    content: '修改文章成功!',

                    buttons: {
                        primary: {
                            text: '再写一篇', style: 'primary', action: function () {
                                window.location.href = "/admin/article/list";
                            }
                        },
                        success: {
                            text: '查看博客', style: 'danger', action: function () {
                                window.location.href = "/admin/article/list";
                            }
                        }
                    }
                });
                // 调到列表页

            }

        }
    });
}

function cancleEditArticle(){
	window.location.href = getRootPath()+ "admin/article/list";
}

//关闭编辑窗口
function closeEditWindow(){
    $('#addArticleContent').modal('hide');
}