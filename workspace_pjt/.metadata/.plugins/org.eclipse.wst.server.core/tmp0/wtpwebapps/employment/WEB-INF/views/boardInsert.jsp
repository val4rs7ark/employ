<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
   <div class="form-group" data-ng-app="angularApp" data-ng-controller="angularCtrl" data-ng-init="getInsertInit()">
   	<div class="form-group col-sm-12 pickBorder">
   		<span class="col-sm-2">
   			<label>제목 : </label>
   		</span>
  			<input class="col-sm-10" type="text" data-ng-model="board_title">
   	</div>
       <div class="form-group pickBorder">
           <div class="col-sm-12">
               <textarea id="board_content"></textarea>
           </div>
       </div>
       <div class="form-group">
           <div class="col-sm-12" align="right">
               <button type="button" class="btn btn-secondary" data-ng-click="btn_insertBoard('<c:out value="${pageContext.request.remoteUser}"/>')">저장</button>
           </div>
       </div>
   </div>
 
<script>
    $(function(){
        CKEDITOR.replace( 'board_content', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'100%',
            height:'400px',
            extraPlugins : 'uploadimage',
            filebrowserImageUploadUrl: '<c:url value="/ckeditor/imageUpload" />?${_csrf.parameterName}=${_csrf.token}' //여기 경로로 파일을 전달하여 업로드 시킨다.
        });
         
        CKEDITOR.on('uploading', function(){
			console.log("야호");
			alert("야호");
        });
         
        CKEDITOR.on('dialogDefinition', function( ev ){
            var dialogName = ev.data.name;
            var dialogDefinition = ev.data.definition;
          
            switch (dialogName) {
                case 'image': //Image Properties dialog
                    //dialogDefinition.removeContents('info');
                    //dialogDefinition.removeContents('Link');
                    //dialogDefinition.removeContents('advanced');
                    break;
            }
        });
         
    });
</script>