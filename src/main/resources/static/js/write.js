const URL = "http://"+location.host + "/Api/boardRest";

function userAction(method , param) {
    if(!method) return false;
    var result = "";
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    $.ajax({
        type : method,            // HTTP method type(GET, POST) 형식이다.
        url : URL,      // 컨트롤러에서 대기중인 URL 주소이다.
        data : JSON.stringify(param),            // Json 형식의 데이터이다.
        contentType : 'application/json; charset=UTF-8',
        beforeSend : function(xhr) {
            xhr.setRequestHeader(header,  token);
        },
        success : function(res){
            result = res;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            result = "실패";
        }
    });
    return result;
}

$(document).ready(function() {
    $('#summernote').summernote({
        height: 300,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        focus: false,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",					// 한글 설정
        placeholder: '내용을 적어주세요'	//placeholder 설정
    });

    $("#writeSummit").click(function(){
        var obj = {
            title : $("#title").val(),
            menuId : $("#menuId").val(),
            text : $('#summernote').summernote('code'),
        }
        alert(userAction("POST" , obj));
    });
});