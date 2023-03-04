package com.gudi.project.dao;

import java.util.ArrayList;

import com.gudi.project.dto.DecListDTO;

public interface ChiefManageCategoriesDAO {

/*
 * 참고용.
 * start_mapper 확인할 것
 * 여기다 코드 적으면 바보
 * */


	ArrayList<DecListDTO> clothListLoad(int cs_code, int offset);

	int cntClothListLoad(int cs_code);

	void insertCategories(int cs_code, String content);
	void categoryClothShowAndHide(int cloth_num, boolean state);

	void categoryColorShowAndHide(int color_num, boolean state);

	void insertColorCategories(String content);

	int cntColorListLoad();

	ArrayList<DecListDTO> colorListLoad(int offset);

	void insertWeatherCategories(String content);

	ArrayList<DecListDTO> resReasonListLoad(int offset);

	void insertResReasonCategories(String content);

	void categoryResReasonShowAndHide(int res_num, boolean state);

	void categoryweatherShowAndHide(int weather_num, boolean state);

	ArrayList<DecListDTO> weatherListLoad(int offset);

	int cntWeatherListLoad();

	int cntResReasonListLoad();
}
