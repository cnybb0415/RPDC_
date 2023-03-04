package com.gudi.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudi.project.dao.ChiefManageCategoriesDAO;
import com.gudi.project.dto.DecListDTO;

@Controller
public class ChiefManageCatrgoriesController {
	//테스트용 클래스
	//이거 복붙해서 써요
	//여기다 코드쓰면 바보
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired ChiefManageCategoriesDAO cmcDAO;
	
	
	
	@ResponseBody
	@RequestMapping(value="/clothListLoad", method=RequestMethod.GET)
	public HashMap<String, Object> clothTopListLoad(@RequestParam int cs_code, @RequestParam int page){
		HashMap<String,Object> map = new HashMap<String, Object>();
		int cntClothList = cmcDAO.cntClothListLoad(cs_code);
		logger.info("데이터 총 조회 : "+cntClothList);
		int offset = (page-1)*5;
		int totalPages=cntClothList/5;
		if(cntClothList%5!=0) {
			totalPages++;
		}
		logger.info("유저 총 페이지 수 조회 : "+totalPages);
		
		map.put("total",totalPages);
		//cs_code=1인것만 조회
		ArrayList<DecListDTO> clothList = cmcDAO.clothListLoad(cs_code, offset);
		for(int i=0; i<clothList.size(); i++) {
			logger.info("두둥등장  : "+clothList.get(i).getCloth_name());
			
		}
		map.put("clothList", clothList);
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/insertCategories", method=RequestMethod.GET)
	public HashMap<String, Object> insertCategories(@RequestParam int cs_code, @RequestParam String content){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.insertCategories(cs_code, content);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/categoryClothShowAndHide", method=RequestMethod.GET)
	public HashMap<String, Object> categoryClothShowAndHide(@RequestParam int cloth_num,@RequestParam boolean state){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.categoryClothShowAndHide(cloth_num,state);

		return map;
	}
	@ResponseBody
	@RequestMapping(value="/colorListLoad", method=RequestMethod.GET)
	public HashMap<String, Object> colorListLoad(@RequestParam int page){
		HashMap<String,Object> map = new HashMap<String, Object>();
		int cntColorList = cmcDAO.cntColorListLoad();
		logger.info("데이터 총 조회 : "+cntColorList);
		int offset = (page-1)*5;
		int totalPages=cntColorList/5;
		if(cntColorList%5!=0) {
			totalPages++;
		}
		logger.info("유저 총 페이지 수 조회 : "+totalPages);
		
		map.put("total",totalPages);
		//cs_code=1인것만 조회
		ArrayList<DecListDTO> colorList = cmcDAO.colorListLoad(offset);
		for(int i=0; i<colorList.size(); i++) {
			logger.info("두둥등장  : "+colorList.get(i).getColor_name());
			
		}
		map.put("colorList", colorList);
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/insertColorCategories", method=RequestMethod.GET)
	public HashMap<String, Object> insertColorCategories(@RequestParam String content){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.insertColorCategories(content);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/categoryColorShowAndHide", method=RequestMethod.GET)
	public HashMap<String, Object> categoryColorShowAndHide(@RequestParam int color_num,@RequestParam boolean state){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.categoryColorShowAndHide(color_num,state);

		return map;
	}
	//날씨
	@ResponseBody
	@RequestMapping(value="/weatherListLoad", method=RequestMethod.GET)
	public HashMap<String, Object> weatherListLoad(@RequestParam int page){
		HashMap<String,Object> map = new HashMap<String, Object>();
		int cntWeatherList = cmcDAO.cntWeatherListLoad();
		logger.info("데이터 총 조회 : "+cntWeatherList);
		int offset = (page-1)*5;
		int totalPages=cntWeatherList/5;
		if(cntWeatherList%5!=0) {
			totalPages++;
		}
		logger.info("유저 총 페이지 수 조회 : "+totalPages);
		
		map.put("total",totalPages);
		//cs_code=1인것만 조회
		ArrayList<DecListDTO> weatherList = cmcDAO.weatherListLoad(offset);
		for(int i=0; i<weatherList.size(); i++) {
			logger.info("두둥등장  : "+weatherList.get(i).getColor_name());
			
		}
		map.put("weatherList", weatherList);
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/insertweatherCategories", method=RequestMethod.GET)
	public HashMap<String, Object> insertweatherCategories(@RequestParam String content){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.insertWeatherCategories(content);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/categoryweatherShowAndHide", method=RequestMethod.GET)
	public HashMap<String, Object> categoryweatherShowAndHide(@RequestParam int weather_num,@RequestParam boolean state){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.categoryweatherShowAndHide(weather_num,state);

		return map;
	}
	//신고
	
	@ResponseBody
	@RequestMapping(value="/resReasonListLoad", method=RequestMethod.GET)
	public HashMap<String, Object> resReasonListLoad(@RequestParam int page){
		HashMap<String,Object> map = new HashMap<String, Object>();
		int cntResReasonList = cmcDAO.cntResReasonListLoad();
		logger.info("데이터 총 조회 : "+cntResReasonList);
		int offset = (page-1)*5;
		int totalPages=cntResReasonList/5;
		if(cntResReasonList%5!=0) {
			totalPages++;
		}
		logger.info("유저 총 페이지 수 조회 : "+totalPages);
		
		map.put("total",totalPages);
		//cs_code=1인것만 조회
		ArrayList<DecListDTO> resReasonList = cmcDAO.resReasonListLoad(offset);
		for(int i=0; i<resReasonList.size(); i++) {
			logger.info("두둥등장  : "+resReasonList.get(i).getColor_name());
			
		}
		map.put("resReasonList", resReasonList);
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/insertResReasonCategories", method=RequestMethod.GET)
	public HashMap<String, Object> insertResReasonCategories(@RequestParam String content){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.insertResReasonCategories(content);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/categoryResReasonShowAndHide", method=RequestMethod.GET)
	public HashMap<String, Object> categoryResReasonShowAndHide(@RequestParam int res_num,@RequestParam boolean state){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
				cmcDAO.categoryResReasonShowAndHide(res_num,state);

		return map;
	}
}
