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
<title>employ-내가만든페이지</title>
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
		<div class="row" style="height: 60%; margin-top: 20px;">
			<c:if test="${param.boardTitle != null}">
				<div class="row col-sm-12">
					<h3>&nbsp;<c:out value="${param.boardTitle}"/>&nbsp;</h3>
				</div>
			</c:if>
			<div class="row col-sm-12" style="margin-top: 20px;">
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
		<div class="row" style="height:20%; margin-top: 20px;"> 
			<tiles:insertAttribute name="footer"/>
		</div>
	</div> 
</body>
</html>