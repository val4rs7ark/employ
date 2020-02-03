<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 빈공간만들기 -->
<span style="display: inline-block; height: 10%; width: 10%;"></span>
<!-- 로고구간 -->
<span style="display: inline-block; height: 10%; width: 10%;">
	<a href="javascript:logo()">
		<img src="/resources/logo.png" class="img-fluid" alt="Responsive image" style="height: 50%; width: 50%;">
	</a>
</span>
<!-- 검색구간 -->
<span style="display: inline-block; width: 40%; border: 1px solid #3c4790; background: #000000;">
	<span style="display: inline-block; margin: 5px 0 0 5px; width: 85%; margin-right: -4px;">
		<input id="inp_search" onkeydown="search_TF = true; onEnter();" type="text" placeholder="통합 검색" style="width: 100%; height:40px;">
	</span>
	<span style="display: inline-block; margin: 5px 0 0 5px; width: 10%;">
		<button onclick="search_TF = true; btn_search()"style="display: inline-block; background-color: #000000; border: 0; outline: 0; width: 100%; margin-right: -4px;">
			<img src="/resources/search.png" class="img-fluid" alt="Responsive image" style="height: 50%; width: 50%;">
		</button>
	</span>
</span>