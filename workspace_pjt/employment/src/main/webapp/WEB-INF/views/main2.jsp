<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 메인구간 -->
<div class="col-sm-12" data-ng-app="angularApp" data-ng-controller="angularCtrl" data-ng-init="getMainInit()" data-ng-class="{loading:IsLoading}">
	<div class="row pickBorder" style="min-height: 200px;">
	<!-- 게시판  -->
	<div class="col-sm-5">
		<a href='/board?boardTitle=자유게시판'><font style="font-weight : bold;">자유게시판 &gt;</font></a>
		<hr class="my-2">
		<ul>
			<li data-ng-repeat="list in boardMain">
				<a href="#" data-ng-click="btn_selectTitle(list.BOARD_NO)">{{list.BOARD_TITLE}}</a>
			</li>
		</ul>
	</div>
	<!-- 공지사항 -->
	<div class="offset-sm-2 col-sm-5">
		<a href='/notice?boardTitle=공지사항'><font style="font-weight : bold;">공지사항 &gt;</font></a>
		<hr class="my-2">
		<ul>
			<li data-ng-repeat="list in noticeMain">
				<a href="#" data-ng-click="adminYn = 'Y'; btn_selectTitle(list.NOTICE_NO)">{{list.NOTICE_TITLE}}</a>
			</li>
		</ul>
	</div>
	</div>
</div>

