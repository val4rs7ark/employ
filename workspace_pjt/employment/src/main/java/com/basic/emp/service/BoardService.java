package com.basic.emp.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface BoardService {
	
	List<List<Map<String, Object>>> getMainList();
	
	Map<String, Object> getSearchMap(Map<String, Object> pMap);
	
	List<Map<String,Object>> getMemberList();
	
	List<Map<String, Object>> getMyMenu();
	
	String memUpdate(String member_id, String enPw);

	String testing(String toDate);

	String insertSignUp(Map<String, Object> pMap);

	void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest upload);

	int boardInsert(Map<String, Object> pMap);
	
	int commentInsert(Map<String, Object> pMap);
	
	int updateMenu(Map<String, Object> pMap);
	
	int adminBoardInsert(Map<String, Object> pMap);

	Map<String, Object> getBoardList(Map<String, Object> pMap);
	
	Map<String, Object> paging(Map<String, Object> pMap);

	Map<String, Object> getBoardDetail(Map<String, Object> pMap);

	Map<String, Object> getNoticeDetail(Map<String, Object> pMap);
	
	Map<String, Object> getNoticeList(Map<String, Object> pMap);

	List<Map<String, Object>> getBoardCommentList(Map<String, Object> pMap);







	

}
