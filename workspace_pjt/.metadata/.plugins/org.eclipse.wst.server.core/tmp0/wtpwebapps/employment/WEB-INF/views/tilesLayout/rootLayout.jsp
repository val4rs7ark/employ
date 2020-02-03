<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<title>시성이 포트폴리오</title>
<meta name="title" content="시성이 포트폴리오">
<meta name="keywords" content="웹사이트, 포트폴리오, 홈페이지 제작">
<meta name="description" content="포트폴리오용으로 제작한 홈페이지입니다.">
<tiles:insertAttribute name="inc"/>
</head>
<body onload="onInit()">
	<div class="container">
		<div class="row" style="height: 10%; margin-top: 10px;">
			<tiles:insertAttribute name="header"/>
		</div> 
		<div class="row" style="height: 10%; margin-top: 50px;">
			<tiles:insertAttribute name="menu"/> 
		</div>
		<div class="row" style="height: 70%; margin-top: 20px;">
			<c:if test="${param.boardTitle != null}">
				<div class="row col-sm-12">
					<div class="contentTitle">
						<h3>&nbsp;<c:out value="${param.boardTitle}"/>&nbsp;</h3>
					</div>
				</div>
			</c:if>
			<div class="row col-sm-12" style="margin-top: 20px;">
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
		<div class="row" style="height:10%; margin-top: 20px;"> 
			<tiles:insertAttribute name="chatting"/>
		</div>
		<div class="row" style="height:10%; margin-top: 20px;"> 
			<tiles:insertAttribute name="footer"/>
		</div>
	</div> 
</body>
</html>