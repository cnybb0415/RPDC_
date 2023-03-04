package com.gudi.project.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gudi.project.dao.AdminUserDetailDAO;
import com.gudi.project.dto.DecListDTO;

@Controller
public class AdminDetailController {
	//테스트용 클래스
	//이거 복붙해서 써요
	//여기다 코드쓰면 바보
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired AdminUserDetailDAO aduDAO;
	@RequestMapping(value="/adminDetail")
	public String adminUserDetailInfo(Model model, @RequestParam int mem_num) {
		logger.info("Controller :"+mem_num+"번 유저 디테일");
		//유저 상세 정보 조회하고
		DecListDTO adminUserDetailInfo = aduDAO.adminUserDetailInfo(mem_num);
		model.addAttribute("adminUserDetailInfo", adminUserDetailInfo);
		if(adminUserDetailInfo.isMem_ban()) {
			logger.info("이 유저는 탈퇴된 유저입니다.");
			logger.info("탈퇴 정보를 불러옵니다.");
			DecListDTO adminUserBanDetailInfo = aduDAO.adminUserBanDetailInfo(mem_num);
			
			model.addAttribute("adminUserBanDetailInfo", adminUserBanDetailInfo);
		}
		//유저에 관한 모든걸 가져온다.
		//1. 게시판
		ArrayList<DecListDTO> adminUserBoardList = aduDAO.adminUserBoardList(mem_num);
		model.addAttribute("adminUserBoardList", adminUserBoardList);
		//2. 좋아요
		ArrayList<DecListDTO> adminUserLikeList = aduDAO.adminUserLikeList(mem_num);
		model.addAttribute("adminUserLikeList", adminUserLikeList);
		//3. 신고
		ArrayList<DecListDTO> adminUserRepList = aduDAO.adminUserRepList(mem_num);
		model.addAttribute("adminUserRepList", adminUserRepList);
		
		//4. 댓글
		ArrayList<DecListDTO> adminUserCommentList = aduDAO.adminUserCommentList(mem_num);
		model.addAttribute("adminUserCommentList", adminUserCommentList);
		
		//5. 북마크
		ArrayList<DecListDTO> adminUserBookmarkList = aduDAO.adminUserBookmarkList(mem_num);
		model.addAttribute("adminUserBookmarkList", adminUserBookmarkList);
		
		
		//Tpa으로
		return "adminUserDetail";
	}
	
}
