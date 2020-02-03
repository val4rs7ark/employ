<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>

<div class="form-group col-md-12" data-ng-app="angularApp" data-ng-controller="angularCtrl" data-ng-init="getNoticeDetailInit()" data-ng-class="{loading:IsLoading}">
   	<div class="form-group col-md-12 pickBorder">
   		<div class="row">
   			<div class="col-md-12" data-ng-bind="noticeDetailMap.NOTICE_TITLE"></div>
   		</div>
   		<hr class="my-2">
   		<div class="row">
	  		<div class="col-md-2" data-ng-bind="noticeDetailMap.NOTICE_WRITER"></div>
	  		<div class="col-md-6"></div>
	  		<div class="col-md-2" data-ng-bind="noticeDetailMap.NOTICE_DATE"></div>
	  		<div class="col-md-1" align="right">조회</div>
	  		<div class="col-md-1" data-ng-bind="noticeDetailMap.NOTICE_HIT"></div>
  		</div>
   	</div>
    <div class="form-group pickBorder">
        <div class="col-md-12" data-ng-bind-html="noticeDetailMap.NOTICE_CONTENT" style="min-height : 250px;"></div>
    </div>
    
    <div class="loadingModal"></div>

<script>
    $(function(){
    	var editor = CKEDITOR.replace( 'comment_content', {//해당 이름으로 된 textarea에 에디터를 적용
        	toolbar : [],
            width:'100%',
            height: '80px'
        });
        
    	CKEDITOR.instances.comment_content.on("key",function(e){
        	var keyCode = e.data.keyCode;
        	// Filter movement keys and related
			if ( keyCode == 46 ||keyCode == 8 || keyCode == 2228240 ||  
				 keyCode == 1114129 || keyCode == 4456466){}else{
				 var txt= CKEDITOR.instances.comment_content.getData();
	            if (txt.length > 50){
	            	alert("댓글길이 최대치입니다.");
	            	CKEDITOR.instances.comment_content.setData(txt);
	            }
			}
       	})
    });
</script>
</div>