<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>

<div class="form-group col-md-12" data-ng-app="angularApp" data-ng-controller="angularCtrl" data-ng-init="getBoardDetailInit()" data-ng-class="{loading:IsLoading}">
   	<div class="form-group col-md-12 pickBorder">
   		<div class="row">
   			<div class="col-md-12" data-ng-bind="boardDetailMap.BOARD_TITLE"></div>
   		</div>
   		<hr class="my-2">
   		<div class="row">
	  		<div class="col-md-2" data-ng-bind="boardDetailMap.BOARD_WRITER"></div>
	  		<div class="col-md-6"></div>
	  		<div class="col-md-2" data-ng-bind="boardDetailMap.BOARD_DATE"></div>
	  		<div class="col-md-1" align="right">조회</div>
	  		<div class="col-md-1" data-ng-bind="boardDetailMap.BOARD_HIT"></div>
  		</div>
   	</div>
    <div class="form-group pickBorder">
        <div class="col-md-12" data-ng-bind-html="boardDetailMap.BOARD_CONTENT" style="min-height : 250px;"></div>
    </div>
    <div class="form-group pickBorder">
    	<div class="row">
    		<ul class="col-md-12 comment_ul" data-ng-repeat="list in boardCommentList">
				<li class="col-md-12" data-ng-init="replyForm(list,$index)">
					<div class="row" data-ng-style="replyStyle[$index]">
						<span class="col-md-1"  data-ng-bind-html="list.BOARD_WRITER"></span>
						<div class="col-md-9 comment_content">
							<div class="row">
								<span data-ng-bind="replyMark[$index]" style="color : blue; margin-right : 5px;"></span>
								<span data-ng-click="btn_selectComment($index)" data-ng-bind-html="list.BOARD_CONTENT"></span>
							</div>
						</div>
						<span class="col-md-2"  data-ng-bind-html="list.BOARD_DATE"></span>
					</div>
					<div><hr class="my-2"></div>
				</li>
   				<li class="row reply_box" data-ng-if="replyYn[$index]" data-ng-init="replyOnload()">
   					<div class="col-md-10">
   						<textarea id="reply_content" maxlength="400" placeholder="댓글을 입력하세요."></textarea>
   					</div>
   					<div class="col-md-2" style="align-self: flex-end;">
   						<button type="button" style="margin-top : 5px;" class="btn btn-secondary" data-ng-click="btn_insertReply('<c:out value="${pageContext.request.remoteUser}"/>',list)">댓글등록</button>
   					</div>
				</li>
   			</ul>

	    	<div class="col-md-10"><textarea class="col-md-12" id="comment_content" maxlength="400" placeholder="댓글을 입력하세요."></textarea></div>
	        <div class="col-md-2" align="justify">
	            <button type="button" style="margin-top : 5px;" class="btn btn-secondary" data-ng-click="btn_insertComment('<c:out value="${pageContext.request.remoteUser}"/>')">댓글등록</button>
	            <button type="button" style="margin-top : 5px;" class="btn btn-secondary" data-ng-click="btn_pageBack()">이전으로</button>
	        </div>
        </div>
    </div>
    
    <div class="loadingModal"></div>

<script>
    $(function(){
    	var comment_editor = CKEDITOR.replace( 'comment_content', {//해당 이름으로 된 textarea에 에디터를 적용
        	toolbar : [],
            width:'100%',
            height: '80px',
            extraPlugins : 'confighelper'
        });
    	CKEDITOR.instances.comment_content.on('instanceReady',function(){
    	});
    	comment_editor.on("key",function(e){
        	var keyCode = e.data.keyCode;
        	// Filter movement keys and related
			if ( keyCode == 46 ||keyCode == 8 || keyCode == 2228240 ||  
				 keyCode == 1114129 || keyCode == 4456466){}else{
				 var txt= comment_editor.getData();
	            if (txt.length > 50){
	            	alert("댓글길이 최대치입니다.");
	            	comment_editor.setData(txt);
	            }
			}
       	})
    });
</script>
</div>