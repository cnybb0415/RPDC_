package com.gudi.project.dao;

import java.util.ArrayList;

import com.gudi.project.dto.AdminMsgDTO;
import com.gudi.project.dto.AlarmDTO;
import com.gudi.project.dto.MemberDTO;

public interface memberDAO {

	String login(String id, String pw);

	String overlay(String id);

	int join(String id, String pw, String pw2, String name, String nick, String birth, String phone, String gender);

	String over(String nickName);

	int selectMemNum(String id);

	int profileInsert(int mem_num);

	String find_idForm1(String name, String phone);

	String find_pwForm_2(String name, String id);

	int pwUpdate(String newPw, String id);

	int profilePhoto(int mem_num);

	AdminMsgDTO adminMsg();

	MemberDTO memberInfo(int mem_num);

	ArrayList<AlarmDTO> alramCommt(int mem_num);

	int mem_ban(String loginId);

	
}
