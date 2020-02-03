<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
	<font size="5">회원가입</font>
</div>
<hr size="10px" width="100%">
<!-- 내용구간  -->
<div>
	<table>
		<tr>
			<td>아이디 :</td>
			<td><input type="text" id="ins_id"></td>
		</tr>
		<tr>
			<td>비밀번호 :</td>
			<td><input type="password" id="ins_pw"></td>
		</tr>
		<tr>
			<td>이메일 :</td>
			<td><input type="text" id="ins_email"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" style="display: inline-block; background-color: #000000; color: #fff; border: 0; outline: 0; width: 100%; margin-right: -4px;" onClick="btn_insertSignUp()">가입하기</button></td>
		</tr>
	</table>
</div>