<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<div class="col-sm-12">
	<div class="talkWrap"></div>
	<div class="talkList"></div>
	<div class="cusBlank"></div>
 	<input type="text" class="talkInput" />
</div>
<c:set var="talkName" value="${pageContext.request.remoteUser}" />
<script>
	//var name = prompt("input your ID");                      //아이디를 입력받습니다.
	
	var name = '<c:out value="${talkName}"/>';
	
	$(function(){
	  	socket = io.connect('http://119.193.24.184:8888');    //서버에 연결합니다.
	  	socket.on('conn', function(data){                    //연결이 되었다면, 메세지를 받아옵니다.
	   		console.log(data);
	  	});
	  	$('.talkInput').bind('keypress', function(e){
	   		if(e.keyCode == 13){
	   			if(name != ""){
			    	var text = $('.talkInput').val();
			    	socket.emit('message', name+' : '+ text);    //input창에서 엔터를 누를때 message 키로 문자를 전송합니다. 
			    	$('.talkInput').val('');
	   			}else{
	   				alert("비로그인은 채팅불가.");
	   			}
		   	}
	  	});
	  	socket.on('firstMsg', function(data){
	  		var array = data;
	  		$('.talkWrap').html('');
	  		for(var i=0, item; item=array[i]; i++){
	   			$('.talkWrap').append('<div>'+item+'</div>');
	  		}
	  		$('.talkWrap').scrollTop($('.talkWrap')[0].scrollHeight);
	  	});
	  	socket.on('modal', function(data){                   
	   		alert(data);
	  	});
	  	socket.on('message', function(data){                   //server에서 보낸 message 키의 값을 받아오고 html에 추가합니다.
	   		$('.talkWrap').append('<div>'+data+'</div>');
	   		$('.talkWrap').scrollTop($('.talkWrap')[0].scrollHeight);
	  	});
		socket.on('talkList', function(data){
			var array = data;
			$('.talkList').html('');
			for(var i=0, item; item=array[i]; i++){
				if(item == name) $('.talkList').append('<div>'+item+'(나)</div>');
				else $('.talkList').append('<div>'+item+'</div>');
			}
		});
		if('<c:out value="${talkName}"/>' != "") socket.emit('talkLogin', name);
	 });
</script>