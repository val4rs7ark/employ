package com.basic.emp.util;

import java.util.Map;

public class simul {
	
	public static void main(String[] args) {
		int totalRow = 33;
		int startNo = 0;
		int nowPage = 10;
		int pagePer_num = 10;
		int blockPer_num = 10;
		int endNo = 0;

		//////////////////////////////////
		int totalPage = (int)Math.ceil((double)totalRow/pagePer_num);
		int totalBlock = (int)Math.ceil((double)totalPage/blockPer_num);
		int nowBlock = (int)Math.ceil((double) nowPage/blockPer_num);
		if(totalRow == 0){
			startNo = 1;
		} else {
			startNo = ((nowBlock - 1) * pagePer_num) + 1;
		}
		endNo = nowBlock * pagePer_num;
		
		System.out.println("startNo -->"+startNo);
		System.out.println("endNo -->"+endNo);
	}
}
