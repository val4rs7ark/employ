/**
 * 내가만든 js
 */

const consPath = location.host;

let socket;

function onInit(){
	var key = "cussecmsg";
	var value = window.location.search.substring(window.location.search.indexOf(key)+key.length+1);
	if(value == 1){
		$("#cussecmsg").text("로그인이 필요합니다.");	
	}
}

function logo(){
	location.href="http://"+consPath+"/main";
}

function btn_signUp(){
	location.href="http://"+consPath+"/signUp";
}

function btn_insertSignUp(){
	var csrfHeader = $('meta[name="_csrf_header"]').attr('content');
    var csrfToken = $('meta[name="_csrf"]').attr('content');  
	var insId = $("#ins_id").val();
	var insPw = $("#ins_pw").val();
	var insEmail = $("#ins_email").val();
	var datas = {
			ins_id : insId,
			ins_pw : insPw,
			ins_email : insEmail
	}
	$.ajaxSetup({
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
        }  
    })
	$.ajax({
		url : '/insertSignUpAjax',
		method : 'post',
		data : datas,
		success : function(data){
			alert(data);
			if(data == "회원가입 성공") location.href="http://"+consPath+"/main";
		}
	});
}

function btn_search(){
	if(search_TF){
		let q = $("#inp_search").val();
		if(q == '' || q == null){
			alert("검색어를 입력하세요.");
		}else{
			let search = encodeURIComponent(q);
			location.href="http://"+consPath+"/search?q="+search;
		}
		search_TF = false;
	}
}

function btn_memUpd(){
	alert("개인정보 수정 버튼");
}

function btn_forget(){
	alert("아이디/비밀번호 찾기 버튼");
}

function searchForm(){
	
}

function onEnter(){
	//if(window.event.keyCode == 13) {
	//	 btn_search();
    //}
	$("#inp_search").keyup(function(e){
		if(e.keyCode == 13)  btn_search(); 
	});
}
/****************format함수만들기***********************/
Date.prototype.format = function (f) {

    if (!this.valueOf()) return " ";



    var weekKorName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];

    var weekKorShortName = ["일", "월", "화", "수", "목", "금", "토"];

    var weekEngName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

    var weekEngShortName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

    var d = this;



    return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi, function ($1) {

        switch ($1) {

            case "yyyy": return d.getFullYear(); // 년 (4자리)

            case "yy": return (d.getFullYear() % 1000).zf(2); // 년 (2자리)

            case "MM": return (d.getMonth() + 1).zf(2); // 월 (2자리)

            case "dd": return d.getDate().zf(2); // 일 (2자리)

            case "KS": return weekKorShortName[d.getDay()]; // 요일 (짧은 한글)

            case "KL": return weekKorName[d.getDay()]; // 요일 (긴 한글)

            case "ES": return weekEngShortName[d.getDay()]; // 요일 (짧은 영어)

            case "EL": return weekEngName[d.getDay()]; // 요일 (긴 영어)

            case "HH": return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)

            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2); // 시간 (12시간 기준, 2자리)

            case "mm": return d.getMinutes().zf(2); // 분 (2자리)

            case "ss": return d.getSeconds().zf(2); // 초 (2자리)

            case "a/p": return d.getHours() < 12 ? "오전" : "오후"; // 오전/오후 구분

            default: return $1;

        }

    });

};

String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };

String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };

Number.prototype.zf = function (len) { return this.toString().zf(len); };