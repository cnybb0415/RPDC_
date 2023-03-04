package com.gudi.project.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudi.project.dao.MainDAO;
import com.gudi.project.dto.MainDTO;
import com.gudi.project.dto.MemberDTO;
import com.gudi.project.dto.PhotoDTO;
import com.gudi.project.service.Main_Service;

@Controller
public class MainController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired Main_Service service;
	@Autowired MainDAO dao;
	
	
	@RequestMapping(value="/mainLogin")
	public String mainLogin() {
		return "index";
	}
	
	
	
	@RequestMapping(value="/list")
	@ResponseBody
	public HashMap<String, Object> list() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<MainDTO> list = service.list();
		map.put("list",list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/recommend")
	public HashMap<String, Object> recommend(@RequestParam int tmn, @RequestParam int tmx){
		//1. 테이블에 저장된 url 주소로 계속 뽑아옴
		logger.info("tmn : "+ tmn);
		logger.info("tmx : "+ tmx);
		HashMap<String, Object> map = new HashMap<String, Object>();
		//문자열로 주소를 초기화 폴더까지
		//가져올 사진이름을 초기화 dao에서 메서드실행
//		ArrayList<String> photoName = dao.recommend(tmn, tmx);
//		String url = "C:/upload/" + photoName;
//		logger.info("photoName ::" + photoName);
//		logger.info("photoName : "+photoName.size());
//		Path path = Paths.get("C:/upload/" + photoName);			
//		ArrayList<String> arr = new ArrayList();
		
		//arr에 담긴 모든 데이터를 출력
//		for(int i=0; i<photoName.size(); i++) {
//			//url + photoName의 i번째 인덱스o
//			url += photoName.get(i);
//			logger.info("url"+url);
//			//다른 배열에 추가
//			arr.add(url);
//			url="resources/img/";
//			logger.info(url);
//		}
		//map에 추가
//		map.put("url", arr);
//		logger.info("arr : "+arr);
		
		return service.recommend(tmn, tmx);
	}
	
	// 전체조회
	@ResponseBody
	@RequestMapping(value="/allShow")
	public HashMap<String, Object> allShow() {
		HashMap<String, Object> map = new HashMap<String, Object>();
//		ArrayList<String> photoName = dao.allShow();
//		logger.info("photoName!@#" + photoName);
//		Path path = Paths.get("C:/upload/" + photoName);
//		ArrayList<String> arr = new ArrayList();
//		logger.info("arr123 : " + arr);
//		
//		for (int i = 0; i < photoName.size(); i++) {
////			path += photoName.get(i);
//			logger.info("url!!! : " + path);
////			arr.add(path);
//			path = Paths.get("C:/upload/" + photoName);
//		}
//		map.put("allShow", arr); 
//		logger.info("arr : " + arr);
		
		return service.pho_List();
	}
	
	@ResponseBody
	@RequestMapping(value = "/newOrder")
	public HashMap<String, Object> newOrder(){
		String url = "resources/img/";
		HashMap<String, Object> map = new HashMap<String, Object>();
//		ArrayList<String> newOrder = dao.newOrder();
//		ArrayList<String> arr = new ArrayList();
//		for (int i = 0; i < newOrder.size(); i++) {
//			url += newOrder.get(i);
//			arr.add(url);
//			url = "resources/img/";
//		}
//		map.put("newOrder", arr);
		
		return service.newOrder();
	}
	
	@ResponseBody
	@RequestMapping(value = "/like")
	public HashMap<String, Object> like(){
		String url = "resources/img/";
		HashMap<String, Object> map = new HashMap<String, Object>();
//		ArrayList<String> like = dao.like();
//		ArrayList<String> arr = new ArrayList();
//		for (int i = 0; i < like.size(); i++) {
//			url += like.get(i);
//			arr.add(url);
//			url = "resources/img/";
//		}
//		map.put("like", arr);
		return service.like();
	}
	
	
	
	
	
	

}
