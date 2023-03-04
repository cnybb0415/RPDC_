package com.gudi.project.controller;



import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudi.project.dto.ClothDTO;
import com.gudi.project.dto.WeatherDTO;
import com.gudi.project.service.ServiceFilter;
@Controller
public class ControllerFilter {

   Logger logger = LoggerFactory.getLogger(this.getClass());

   @Autowired ServiceFilter service;


   @RequestMapping("/submit")
   public void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HashMap<String, Object> resultMap = new HashMap<String, Object>();
      
      HashMap<String, Object> requestMap = new HashMap<String, Object>();
            
         
      try {
         String[] sexArr = request.getParameterValues("sex");      
         requestMap.put("SEX", sexArr);
         for(String data: sexArr) {
        	 logger.info("SEX DATA: "+data);
        	 System.out.println("SEX DATA: "+data);
         }
         } catch (NullPointerException e) {
         }
      try {
         String[] weatherArr = request.getParameterValues("weather");
         requestMap.put("WEATHER", weatherArr);
         for(String data: weatherArr) {
        	 logger.info("weather DATA: "+data);
         }
         } catch (NullPointerException e) {
         }
      try {
         String[] seasonArr = request.getParameterValues("season");
         requestMap.put("SEASON", seasonArr);
         for(String data: seasonArr) {
        	 logger.info("SEASON DATA: "+data);
        	 System.out.println("SEASON DATA: "+data);
         }
         } catch (NullPointerException e) {
         }
      try {
         String[] ageArr = request.getParameterValues("age");
         requestMap.put("AGE", ageArr);
         } catch (NullPointerException e) {
         }
      try {
         String[] termArr = request.getParameterValues("term");
         requestMap.put("TERM", termArr);
         } catch (NullPointerException e) {
         }
      
      
      

      
      try {
         String[] topArr = request.getParameterValues("top1");
         requestMap.put("TOP", topArr);
         
         for(String data: topArr) {
        	 logger.info("TOP DATA: "+data);
        	 System.out.println("TOP DATA: "+data);
        	 
         }
      } catch (NullPointerException e) {
      }
      
      
      
      
      logger.info("requestMap: "+requestMap);
       ArrayList<HashMap<String,String>> ArrayList = service.submit(requestMap);
       logger.info("ArrayList: "+ArrayList);
       
       resultMap.put("ArrayList", ArrayList);
       JSONObject resultJson = new JSONObject(resultMap);
       
      response.getWriter().print(resultJson);
   }
   
   


   
   
   
   
   @ResponseBody     
      @RequestMapping(value = "/weatherCall", method = RequestMethod.GET) 
      public HashMap<String, Object> weatherlist(HttpSession session) {
	   logger.info("list 요청 :");
         HashMap<String, Object> map = new HashMap<String, Object>();
         logger.info("게시판 리스트 호출");
         ArrayList<WeatherDTO> weatherlist = service.weatherlist();
         logger.info("게시판 리스트 호출"+service.weatherlist());
         map.put("weatherlist", weatherlist);
         
         return map; 
      }
   
      @ResponseBody     
      @RequestMapping(value = "/topCall1", method = RequestMethod.GET) 
      public HashMap<String, Object> toplist1(HttpSession session) {
         HashMap<String, Object> map = new HashMap<String, Object>();
         ArrayList<ClothDTO> list = service.toplist1();
         map.put("list", list);   
         
         return map; 
      } 
      @ResponseBody    
      @RequestMapping(value = "/bottomCall1", method = RequestMethod.GET) 
      public HashMap<String, Object> bottomlist1(HttpSession session) {
    	  logger.info("list 요청 :"); 
         HashMap<String, Object> map = new HashMap<String, Object>();
         logger.info("list 요청 :"+map); 
         ArrayList<ClothDTO> list = service.bottomlist1();
         logger.info("list 요청 :"+service.bottomlist1()); 
         map.put("list", list);   
         
         return map; 
      } 
      @ResponseBody    
      @RequestMapping(value = "/outerCall1", method = RequestMethod.GET) 
      public HashMap<String, Object> outerCall1(HttpSession session) {
    	  logger.info("list 요청 :"); 
         HashMap<String, Object> map = new HashMap<String, Object>();
         logger.info("list 요청 :"+map); 
         ArrayList<ClothDTO> list = service.outerCall1();
         logger.info("list 요청 :"+service.outerCall1()); 
         map.put("list", list);   
         
         return map; 
      } 
      
      @ResponseBody    
      @RequestMapping(value = "/dressCall1", method = RequestMethod.GET) 
      public HashMap<String, Object> dressCall1(HttpSession session) {
    	  logger.info("list 요청 :"); 
         HashMap<String, Object> map = new HashMap<String, Object>();
         logger.info("list 요청 :"+map); 
         ArrayList<ClothDTO> list = service.dressCall1();
         logger.info("list 요청 :"+service.dressCall1()); 
         map.put("list", list);   
         
         return map; 
      } 
      
      @ResponseBody    
      @RequestMapping(value = "/shoesCall1", method = RequestMethod.GET) 
      public HashMap<String, Object> shoesCall1(HttpSession session) {
    	  logger.info("list 요청 :"); 
         HashMap<String, Object> map = new HashMap<String, Object>();
         logger.info("list 요청 :"+map); 
         ArrayList<ClothDTO> list = service.shoesCall1();
         logger.info("list 요청 :"+service.shoesCall1()); 
         map.put("list", list);   
         
         return map; 
      } 
      
      
}