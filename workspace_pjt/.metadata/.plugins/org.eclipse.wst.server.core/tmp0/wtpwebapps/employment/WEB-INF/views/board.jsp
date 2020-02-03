<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-sm-12" data-ng-app="angularApp" data-ng-controller="angularCtrl" data-ng-init="getBoardInit()" data-ng-class="{loading:IsLoading}">
	<button type="button" class="btn btn-secondary" data-ng-click="btn_boardInsertForm()">글쓰기</button>
	<!-- 게시판  -->
	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>글작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
				<tr data-ng-if="boardList != null" data-ng-repeat="list in boardList | limitTo : 5 : ((pagingNowPage-1)*5) ">
					<td>{{(((pagingNowPage - 1) * 5) + 1)+$index}}</td>
					<td style="cursor:pointer;" data-ng-click="btn_selectTitle(list.BOARD_NO)">{{list.BOARD_TITLE}}</td>
					<td style="cursor:pointer;" data-ng-click="btn_selectWriter(list.BOARD_WRITER)">{{list.BOARD_WRITER}}</td>
					<td>{{list.BOARD_DATE}}</td>
					<td>{{list.BOARD_HIT}}</td>
				</tr>
				<tr data-ng-if="boardList == null"><td colspan="5">조회 결과가 없습니다.</td></tr>
		</tbody>
	</table>
	<div class="row">
		<div style="flex: 0 0 23%;max-width: 23%;"></div>
		<!-- 페이징  -->
		<ul class="pagingItem" data-ng-repeat="item in pagingArray | limitTo : pagingArray.length">
			<li class="pagingItem" data-ng-if="$first && pagingNowPage == pagingStartNo && pagingNowBlock == 1" style="padding : 3px;"><button type="button" class="btn btn-secondary" disabled>&lt;&lt;</button></li>
			<li class="pagingItem" data-ng-if="$first && (pagingNowPage != pagingStartNo || pagingNowBlock != 1)" style="padding : 3px;"><button type="button" class="btn btn-secondary" data-ng-click="btn_pagingFirst()">&lt;&lt;</button></li>
			<li class="pagingItem" data-ng-if="$first && pagingNowPage == pagingStartNo && pagingNowBlock == 1" style="padding : 3px;"><button type="button" class="btn btn-secondary" disabled>&lt;</button></li>
			<li class="pagingItem" data-ng-if="$first && (pagingNowPage != pagingStartNo || pagingNowBlock != 1)" style="padding : 3px;"><button type="button" class="btn btn-secondary" data-ng-click="btn_pagingPrev()">&lt;</button></li>
			<li class="pagingItem" data-ng-if="pagingNowPage == item" style="padding : 3px;"><button type="button" class="btn btn-secondary" disabled  style="font-weight : bold;">{{item}}</button></li>
			<li class="pagingItem" data-ng-if="pagingNowPage != item" style="padding : 3px;"><button type="button" class="btn btn-secondary" data-ng-click="btn_pagingPick(item)">{{item}}</button></li>
			<li class="pagingItem" data-ng-if="$last && pagingNowPage == pagingEndNo && pagingNowBlock == pagingTotalBlock" style="padding : 3px;"style="padding : 3px;"><button type="button" class="btn btn-secondary" disabled>&gt;</button></li>
			<li class="pagingItem" data-ng-if="$last && (pagingNowPage != pagingEndNo || pagingNowBlock != pagingTotalBlock)" style="padding : 3px;"><button type="button" class="btn btn-secondary" data-ng-click="btn_pagingNext()">&gt;</button></li>
			<li class="pagingItem" data-ng-if="$last && pagingNowPage == pagingEndNo && pagingNowBlock == pagingTotalBlock" style="padding : 3px;"><button type="button" class="btn btn-secondary" disabled>&gt;&gt;</button></li>
			<li class="pagingItem" data-ng-if="$last && (pagingNowPage != pagingEndNo || pagingNowBlock != pagingTotalBlock)" style="padding : 3px;"><button type="button" class="btn btn-secondary" data-ng-click="btn_pagingLast()">&gt;&gt;</button></li>
		</ul>
	</div>
	<div class="loadingModal"></div>
</div>