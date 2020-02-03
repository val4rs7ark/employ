var angularApp = angular.module('angularApp', ["ngRoute","ngSanitize"]);

document.write('<script src="/js/angularSetting.js"></script>');

//팩토리 정의
angularApp.factory('Ajax',function($http){
	
	//전역 variable 정의
	var service = {
		getParam : getParameter,
		getMenuMap : getMenuMapAjax,
		getSearchMap : getSearchMapAjax,
		getBoardList : getBoardListAjax,
		getNoticeList : getNoticeListAjax,
		insertBoard : insertBoardAjax,
		insertComment : insertCommentAjax,
		updateMenu : updateMenuAjax,
		AdminInsertBoard : AdminInsertBoardAjax,
		getBoardDetail : getBoardDetailAjax,
		getNoticeDetail : getNoticeDetailAjax
	};
	
	return service;
	
	//전역 variable 구현
	function getParameter(param){
		var key = param;
		var value = window.location.search.substring(window.location.search.indexOf(key)+key.length+1);
		return value;
	};
	
	function getMenuMapAjax(params){
		return $http.post("getMenuMapAjax", params).then(handleSuccess, handleError);
	};
	
	function getSearchMapAjax(params){
		return $http.post("/getSearchMapAjax", params).then(handleSuccess, handleError);
	};
	
	function getBoardListAjax(params){
		return $http.post("getBoardListAjax", params).then(handleSuccess, handleError);
	};
	
	function getNoticeListAjax(params){
		return $http.post("getNoticeListAjax", params).then(handleSuccess, handleError);
	};
	
	function updateMenuAjax(params){
		return $http.post("updateMenuAjax", params).then(handleSuccess, handleError);
	};
	
	function insertBoardAjax(params){
		return $http.post("insertBoardAjax", params).then(handleSuccess, handleError);
	};
	
	function insertCommentAjax(params){
		return $http.post("insertCommentAjax", params).then(handleSuccess, handleError);
	};
	
	function AdminInsertBoardAjax(params){
		return $http.post("AdminInsertBoardAjax", params).then(handleSuccess, handleError);
	};
	
	function getBoardDetailAjax(params){
		return $http.post("getBoardDetailAjax", params).then(handleSuccess, handleError);
	};
	
	function getNoticeDetailAjax(params){
		return $http.post("getNoticeDetailAjax", params).then(handleSuccess, handleError);
	};
	
	/********************************************/
    function handleSuccess(res){
        return res.data;
    }
    
    function handleError(error){
        return function(){
            return {success: false, message: error};
        };
    }
});

       

       


