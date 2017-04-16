//加载markdown文本编辑器
var testEditor;

$(function () {
    testEditor = editormd("article-editormd", {
        width: "100%",
        height: 640,
        syncScrolling: "single",
        path: "/admin/lib/"
    });


});


// 保存文章
function saveArticle() {
    $.ajax({
        url: '/admin/article/term',
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
    var param = {};

    // 收集参数 校验
    var categoryId = $("#categoryId option:selected").val();
    if (isEmpty(categoryId)) {
        autoCloseAlert("请选择分类", 500);
        return false;
    }

    var title = $("#title").val();

    if (isEmpty(title)) {
        autoCloseAlert("请输入标题", 500);
        return false;
    }
    var description = $("#description").val();
    if (isEmpty(description)) {
        autoCloseAlert("请输入文章描述", 500);
        return false;
    }
    // var arr = [];
    // arr.push(UE.getEditor('editor').getContent());
    // var content = arr.join("\n");

    // 简介
    var content = testEditor.getMarkdown();
    console.log(content);
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
        type: "POST",
        url: '../article/save',
        data: 'categoryId=' + categoryId + "&tags=" + tagIds + "&title=" + title + "&content=" + encodeURI(content) + "&description=" +  encodeURI(description),
        success: function (data) {
            if (data.resultCode != 'success') {
                autoCloseAlert(data.errorInfo, 1000);
                return false;
            } else {
                new $.flavr({
                    content: '添加文章成功!',

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

function cancelSaveArticle() {
    $('#addArticleModal').modal('hide');
}