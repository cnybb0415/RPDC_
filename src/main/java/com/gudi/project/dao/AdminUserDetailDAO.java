package com.gudi.project.dao;

import java.util.ArrayList;

import com.gudi.project.dto.DecListDTO;

public interface AdminUserDetailDAO {

/*
 * 참고용.
 * start_mapper 확인할 것
 * 여기다 코드 적으면 바보
 * */

	DecListDTO adminUserDetailInfo(int mem_num);

	ArrayList<DecListDTO> adminUserBoardList(int mem_num);

	ArrayList<DecListDTO> adminUserLikeList(int mem_num);

	ArrayList<DecListDTO> adminUserRepList(int mem_num);

	ArrayList<DecListDTO> adminUserCommentList(int mem_num);

	ArrayList<DecListDTO> adminUserBookmarkList(int mem_num);

	DecListDTO adminUserBanDetailInfo(int mem_num);
}
