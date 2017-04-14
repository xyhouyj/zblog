//加载markdown文本编辑器
var testEditor;
$(function() {
    // 初始化多选框
    $(".chosen-select").chosen({
        max_selected_options: 5,
        no_results_text: "没有找到",
        allow_single_deselect: true
    });
    testEditor = editormd("indexs.html-editormd", {
        width: "90%",
        height: 640,
        syncScrolling: "single",
        path: "../lib/"
    });
});



// 保存文章
function saveArticle(){
    var param = {};
    
    // 收集参数 校验
    var categoryId = $("#categoryId").val();
    if(categoryId == '-1'){
    	autoCloseAlert("请选择栏目",500);
    	return false;
    }
    param["categoryId"] = categoryId;
    
    var title = $("#title").val();
    if(isEmpty(title)){
    	autoCloseAlert("请输入标题",500);
    	return false;
    }
    param["title"] = title;
    
    var arr = [];
    arr.push(UE.getEditor('editor').getContent());
    var content = arr.join("\n");
    
    // 简介
    var description = UE.getEditor('editor').getContentTxt().substring(0,500);
    
    // 标签
    var tagId = $(".chosen-select").val();
    if(!isEmpty(tagId)){
    	var ids = (tagId+"").split("\,");
    	var tagArray = [];
    	for(var i=0;i<ids.length;i++){
    		tagObj = {id:ids[i]};
    		tagArray.push(tagObj);
    	}
    	param["tagList"] = tagArray;
    	console.info(tagArray);
    }else{
    	autoCloseAlert("请输入标签",500);
    	return false;
    }

    // 保存文章
    $.ajax({
        type : "POST",
        url : '../article/add',
        data : 'param='+encodeURI(encodeURI(JSON.stringify(param)))+"&content="+encodeURI(encodeURI(content)).replace(/\&/g, "%26").replace(/\+/g, "%2B")+"&description="+encodeURI(encodeURI(description)),
        success  : function(data) {
        	if(data.resultCode != 'success'){
        		autoCloseAlert(data.errorInfo,1000);
				return false;
			}else{
				// 调到列表页
				window.location.href = "../article/list";
			}
		}
    });
}

function cancelSaveArticle(){
	window.location.href = "../article/list";
}