/**
 * Created by EumJi on 2017/4/16.
 */
$(function() {
    var testEditormdView;

    $.get("", function(markdown) {
        testEditormdView = editormd.markdownToHTML("article-content", {
            htmlDecode      : "style,script,iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析
        });

        //console.log("返回一个 jQuery 实例 =>", testEditormdView);

        // 获取Markdown源码
        console.log(testEditormdView);

        //alert(testEditormdView.getMarkdown());
    });
});



function loadCategory(categoryId) {
    var loadPager = {start:0,limit:10};
    $.ajax({
        type: 'GET',
        url: '/category/load/' + categoryId,
        data: {pager: pager},
        success: function (data) {
            $("#main").html(data);
        }
    });

}

function loadTag(tagId) {
    var loadPager = {start:0,limit:10};

    $.ajax({
        type: 'GET',
        url: '/tag/load/'+tagId,
        data: {pager: loadPager},
        success: function (data) {
            $("#main").html(data);
        }
    });
}
