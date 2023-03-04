package com.gudi.project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.gudi.project.dto.ClothDTO;
import com.gudi.project.dto.WeatherDTO;

public interface DAOFilter {

	ArrayList<HashMap<String, String>> submit(HashMap<String, Object> requestMap);

	ArrayList<WeatherDTO> weatherlist();

	ArrayList<ClothDTO> toplist1();
	
	ArrayList<ClothDTO> bottomlist1();
	
	ArrayList<ClothDTO> outerCall1();
	
	ArrayList<ClothDTO> dressCall1();
	
	ArrayList<ClothDTO> shoesCall1();
}
