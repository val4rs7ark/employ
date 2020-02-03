package com.basic.emp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paging {
	
	private int totalRow = 0;
	private int startNo = 0;
	private int endNo = 0;
	private Double nowPage = 0.0;
	private int pagePer_num = 5;
	private int blockPer_num = 10;
	/**
	 * 파라미터 : [로우 수-totalRow],[현재 페이지-nowPage]
	 * @param pMap
	 */
	public Paging(Map<String,Object> pMap){
		totalRow = (int) pMap.get("totalRow");
		this.nowPage = (pMap.get("nowPage") != null) ? (double) pMap.get("nowPage") : 1.0;
	}
	/**
	 * 리턴 : [시작번호-startNo],[끝번호-endNo],[현재블럭-nowBlock],[총블럭-totalBlock],[페이징배열-pagingArray]
	 * @return
	 */
	public Map<String,Object> getPaging(){
		Map<String, Object> result = new HashMap<>();
		System.out.println("+++++++++++++++++++ totalRow --> "+totalRow);
		int totalPage = (int)Math.ceil((double)totalRow/pagePer_num);
		if(totalPage == 0) totalPage = 1;
		System.out.println("+++++++++++++++++++ totalPage --> "+totalPage);
		result.put("totalPage", totalPage);
		int nowBlock = (int)Math.ceil((double) nowPage/blockPer_num);
		System.out.println("+++++++++++++++++++ nowBlock --> "+nowBlock);
		result.put("nowBlock", nowBlock);
		int totalBlock = (int)Math.ceil((double)totalPage/blockPer_num);
		System.out.println("+++++++++++++++++++ totalBlock --> "+totalBlock);
		result.put("totalBlock", totalBlock);
		
		if(totalRow == 0){
			startNo = 1;
		} else {
			startNo = ((nowBlock - 1) * blockPer_num) + 1;
		}
		System.out.println("+++++++++++++++++++ startNo --> "+startNo); 
		result.put("startNo", startNo);
		if(nowBlock < totalBlock) {
			endNo = nowBlock * blockPer_num;
		}else if(nowBlock >= totalBlock) {
			endNo = totalPage;
		}
		System.out.println("+++++++++++++++++++ endNo --> "+endNo);
		result.put("endNo", endNo);
		List<Integer> pagingArray = new ArrayList<>();
		if(startNo < endNo) {
			for(int i = startNo; i <= endNo; i++){
				pagingArray.add(i);
			}
		}else if(startNo >= endNo) {
			pagingArray.add(startNo);
		}
		result.put("pagingArray", pagingArray);
		System.out.println("+++++++++++++++++++ pagingArray --> "+pagingArray.toString()); 
		return result;
	}
}
