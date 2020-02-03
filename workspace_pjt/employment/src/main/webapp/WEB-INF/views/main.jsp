<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 메인구간 -->
<div class="col-sm-12" data-ng-app="angularApp" data-ng-controller="angularCtrl" data-ng-class="{loading:IsLoading}">
	<div class="row pickBorder" style="min-height: 200px;">
		<!-- 게시판  -->
		<c:forEach var="menuItem" items="${menuList}" varStatus="status">
			<c:choose>
				<c:when test="${status.first}">
					<div class="col-sm-5">
						<c:if test="${menuItem.MENU_ENABLED eq 1}">
							<c:if test="${menuItem.MENU_LVL eq 1 }">
								<a href='${menuItem.MENU_CONTENT}'><font style="font-weight : bold;">${menuItem.MENU_NAME} &gt;</font></a>
								<hr class="my-2">
								<ul>
									<c:forEach var="mainItem" items="${mainList}" varStatus="vs">
										<c:if test="${vs.first}">
											<c:forEach var="onItem" items="${mainItem}">
												<li>
													<a href="#" data-ng-click="btn_selectTitle(${onItem.BOARD_NO})">${onItem.BOARD_TITLE}</a>
												</li>
											</c:forEach>
										</c:if>
									</c:forEach>
								</ul>
							</c:if>
						</c:if>
					</div>
				</c:when>
				<c:when test="${!status.first}">
					<div class="offset-sm-1 col-sm-5">
						<c:if test="${menuItem.MENU_ENABLED eq 1}">
							<c:if test="${menuItem.MENU_LVL eq 1 }">
								<a href='${menuItem.MENU_CONTENT}'><font style="font-weight : bold;">${menuItem.MENU_NAME} &gt;</font></a>
								<hr class="my-2">
								<ul>
									<c:forEach var="mainItem" items="${mainList}" varStatus="vs">
										<c:if test="${!vs.first}">
											<c:forEach var="onItem" items="${mainItem}">
												<li>
													<a href="#" data-ng-click="adminYn = 'Y'; btn_selectTitle(${onItem.NOTICE_NO})">${onItem.NOTICE_TITLE}</a>
												</li>
											</c:forEach>
										</c:if>
									</c:forEach>
								</ul>
							</c:if>
						</c:if>
					</div>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>
</div>

