package com.basic.emp.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	private static final Logger logger = Logger.getLogger(ViewController.class);
	
	@RequestMapping("/")
	public void defaultView(HttpServletResponse response) {
		logger.info("defaultView() 호출 성공");
		try {
			response.sendRedirect("main");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("index")
	public void indexView() {
		logger.info("indexView() 호출 성공");
	}
	@RequestMapping("signUp")
	public void signUpView() {
	}
	@RequestMapping("main")
	public void mainView() {
	}
	@RequestMapping("search")
	public void searchView() {
	}
	@RequestMapping("board")
	public void boardView() {
	}
	@RequestMapping("notice")
	public void noticeView() {
	}
	@RequestMapping("boardInsert")
	public void boardInsertView() {
	}
	@RequestMapping("boardDetail")
	public void boardDetailView() {
	}
	@RequestMapping("noticeDetail")
	public void noticeDetailView() {
	}
	@RequestMapping("admin/board")
	public void adminBoardView() {
	}
}
