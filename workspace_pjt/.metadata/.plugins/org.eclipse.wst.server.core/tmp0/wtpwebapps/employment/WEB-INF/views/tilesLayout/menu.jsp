<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 버튼  -->    
<div class="btn-group col-sm-9" style="background-color: #000000; height : 10%;">
	<c:forEach var="menuItem" items="${menuList}" varStatus="status">
		<c:if test="${menuItem.MENU_ENABLED eq 1}">
			<c:if test="${menuItem.MENU_LVL eq 1 }">
				<button type="button" class="btn btn-outline-secondary btn-lg" style="margin-left: 10px; border: 0; outline: 0; color: #fff;" onclick="location.href='${menuItem.MENU_CONTENT}'">
					<c:out value="${menuItem.MENU_NAME}"/>
				</button>
			</c:if>
			<c:if test="${menuItem.MENU_LVL eq 9 && 'ROLE_ADMIN' eq s_userLVL}">
				<button type="button" class="btn btn-outline-secondary btn-lg" style="margin-left: 10px; border: 0; outline: 0; color: #fff;" onclick="location.href='${menuItem.MENU_CONTENT}'">
					<c:out value="${menuItem.MENU_NAME}"/>
				</button>
			</c:if>
		</c:if>
	</c:forEach>
</div>
<!-- 로그인구간  -->
<div class="col-sm-3" style="height : 10%;">
		<c:if test="${pageContext.request.remoteUser != null}">
			<div style="border: 2px; border-style: solid;">
			 <form action="/logout" method="post">
				<table style="text-align: left; margin-top: 5px; margin-bottom: 5px; margin-right: 2px; margin-left: 2px; padding-right: 0px;">
					<tr>
						<td style="width: 74%;text-align: center;"><font style="font-weight: bold ;"><c:out value="${pageContext.request.remoteUser}"/></font></td>
						<td rowspan="2"><button type="submit" style="display: inline-block; width: 65px; height:60px; color: #ffffff; background-color: #000000; border: 0; outline: 0; margin-right: -4px;"><font size="1">로그아웃</font></button></td>
					</tr>
					<tr>
						<td><button type="button" style="display: inline-block; background-color: #000000; color: #fff; border: 0; outline: 0; width: 100%; margin-right: -4px;" onclick="btn_memUpd()"><font size="1">개인정보 수정</font></button></td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			 </form>
			</div>
		</c:if>
		<c:if test="${pageContext.request.remoteUser == null}">
			<div style="border: 2px; border-style: solid;">
				<form name="f" action="/login" method="POST">	
					<table style="text-align: left; margin-top: 5px; margin-bottom: 5px; margin-right: 2px; margin-left: 2px; padding-right: 0px;">
						<tr>
							<td><input class="myLogin" name="member_id" id="inp_id" type="text" placeholder="아이디" ></td>
							<td rowspan="2"><button type="submit" style="display: inline-block; width: 65px; height:60px; color: #ffffff; background-color: #000000; border: 0; outline: 0; margin-right: -4px;"><font size="1">로그인</font></button></td>
						</tr>
						<tr>
							<td><input class="myLogin" name="member_pw" id="inp_pw" type="password" placeholder="비밀번호" ></td>
						</tr>
						<tr style="width: 70%;">
							<td><font color="red" size="1" id="cussecmsg"><c:out value="${errormsg}"/></font></td>
						</tr>
						<tr>
							<td><button type="button" style="display: inline-block; background-color: #000000; color: #fff; border: 0; outline: 0; width: 100%; margin-right: -4px;" onclick="btn_forget()"><font size="1">아이디/비밀번호 찾기</font></button></td>
							<td><button type="button" style="display: inline-block; background-color: #000000; color: #fff; border: 0; outline: 0; width: 106%; margin-right: -4px;" onclick="btn_signUp()"><font size="1">회원가입</font></button></td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
			</div>			
		</c:if>	
</div>