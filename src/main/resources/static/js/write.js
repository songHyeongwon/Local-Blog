const URL = "http://"+location.host + "/Api/boardRest";

function userAction(method , param) {
    if(!method) return false;
    /*var xhttp = new XMLHttpRequest();
    xhttp.open(method, URL, false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(param));
    return xhttp.responseText;*/
    var result = "";
    $.ajax({
        type : method,            // HTTP method type(GET, POST) 형식이다.
        url : URL,      // 컨트롤러에서 대기중인 URL 주소이다.
        data : param,            // Json 형식의 데이터이다.
        success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            result = res.responseText;
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            result = "실패";
        }
    });

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
        alert(userAction("Post" , obj));
    });
});