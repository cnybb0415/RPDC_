package com.gudi.project.dto;

import java.sql.Date;

public class DecListDTO {
	//dec_list
	private int report_num;
	private int write_num;
	private int mem_num;
	private int sortcode;
	private int res_num;
	private Date dec_date;
	
	//decs
	private int res_dis;
	private int res_state;
	private String reason;
	
	//member
	
	private String mem_name;
	private String mem_email;
	
	private String mem_nickname;
	private Date mem_birth;
	private Date mem_regDate;
	private String mem_phon;
	private String mem_pw;
	private String mem_sex;
	private boolean mem_ban;
	private String mem_autority;
	//mem_state
	private Date pro_time;
	private int pro_num;
	private String content;
	private int admin_num;
	
	
	//admin_msg
	private int msg_id;
	private String msg_content;
	private Date write_time;
	private int sender;
	
	//board
	private int board_num;
	private Date board_time;
	private int board_good;
	private String board_place;
	private Date board_date;
	private String board_State;
	private int weather_num;
	private int board_tmn;
	private int board_tmx;
	
	//proc_code
	private int proc_id;
	private String proc_cnt;
	private boolean proc_state;
	//comment
	private int comt_num;
	private Date comt_time;
	private Date newcomt_time;
	private boolean comt_state;
	private String comt_content;
	
	//cloth
	private int cloth_num;
	private boolean cloth_state;
	private String cloth_name;
	private int cs_code;
	//color
	private int color_num;
	private String color_name;
	private boolean color_state;
	//weather
	private boolean weather_state;
	public boolean isWeather_state() {
		return weather_state;
	}
	public void setWeather_state(boolean weather_state) {
		this.weather_state = weather_state;
	}
	public String getWeather_name() {
		return weather_name;
	}
	public void setWeather_name(String weather_name) {
		this.weather_name = weather_name;
	}
	private String weather_name;
	public int getColor_num() {
		return color_num;
	}
	public void setColor_num(int color_num) {
		this.color_num = color_num;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public boolean isColor_state() {
		return color_state;
	}
	public void setColor_state(boolean color_state) {
		this.color_state = color_state;
	}
	public int getCloth_num() {
		return cloth_num;
	}
	public void setCloth_num(int cloth_num) {
		this.cloth_num = cloth_num;
	}
	public boolean isCloth_state() {
		return cloth_state;
	}
	public void setCloth_state(boolean cloth_state) {
		this.cloth_state = cloth_state;
	}
	public String getCloth_name() {
		return cloth_name;
	}
	public void setCloth_name(String cloth_name) {
		this.cloth_name = cloth_name;
	}
	public int getCs_code() {
		return cs_code;
	}
	public void setCs_code(int cs_code) {
		this.cs_code = cs_code;
	}
	public Date getPro_time() {
		return pro_time;
	}
	public void setPro_time(Date pro_time) {
		this.pro_time = pro_time;
	}
	public int getPro_num() {
		return pro_num;
	}
	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}
	public int getComt_num() {
		return comt_num;
	}
	public void setComt_num(int comt_num) {
		this.comt_num = comt_num;
	}
	public Date getComt_time() {
		return comt_time;
	}
	public void setComt_time(Date comt_time) {
		this.comt_time = comt_time;
	}
	public Date getNewcomt_time() {
		return newcomt_time;
	}
	public void setNewcomt_time(Date newcomt_time) {
		this.newcomt_time = newcomt_time;
	}
	public boolean isComt_state() {
		return comt_state;
	}
	public void setComt_state(boolean comt_state) {
		this.comt_state = comt_state;
	}
	public String getComt_content() {
		return comt_content;
	}
	public void setComt_content(String comt_content) {
		this.comt_content = comt_content;
	}
	public int getProc_id() {
		return proc_id;
	}
	public void setProc_id(int proc_id) {
		this.proc_id = proc_id;
	}
	public String getProc_cnt() {
		return proc_cnt;
	}
	public void setProc_cnt(String proc_cnt) {
		this.proc_cnt = proc_cnt;
	}
	public boolean isProc_state() {
		return proc_state;
	}
	public void setProc_state(boolean proc_state) {
		this.proc_state = proc_state;
	}
	public String getMem_name() {
		return mem_name;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public Date getBoard_time() {
		return board_time;
	}
	public void setBoard_time(Date board_time) {
		this.board_time = board_time;
	}
	public int getBoard_good() {
		return board_good;
	}
	public void setBoard_good(int board_good) {
		this.board_good = board_good;
	}
	public String getBoard_place() {
		return board_place;
	}
	public void setBoard_place(String board_place) {
		this.board_place = board_place;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public String getBoard_State() {
		return board_State;
	}
	public void setBoard_State(String board_State) {
		this.board_State = board_State;
	}
	public int getWeather_num() {
		return weather_num;
	}
	public void setWeather_num(int weather_num) {
		this.weather_num = weather_num;
	}
	public int getBoard_tmn() {
		return board_tmn;
	}
	public void setBoard_tmn(int board_tmn) {
		this.board_tmn = board_tmn;
	}
	public int getBoard_tmx() {
		return board_tmx;
	}
	public void setBoard_tmx(int board_tmx) {
		this.board_tmx = board_tmx;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public Date getMem_regDate() {
		return mem_regDate;
	}
	public void setMem_regDate(Date mem_regDate) {
		this.mem_regDate = mem_regDate;
	}
	public String getMem_phon() {
		return mem_phon;
	}
	public void setMem_phon(String mem_phon) {
		this.mem_phon = mem_phon;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_sex() {
		return mem_sex;
	}
	public void setMem_sex(String mem_sex) {
		this.mem_sex = mem_sex;
	}
	public boolean isMem_ban() {
		return mem_ban;
	}
	public void setMem_ban(boolean mem_ban) {
		this.mem_ban = mem_ban;
	}
	public String getMem_autority() {
		return mem_autority;
	}
	public void setMem_autority(String mem_autority) {
		this.mem_autority = mem_autority;
	}
	private boolean exp_state;
	private Date exp_time;
	
	
	public int getReport_num() {
		return report_num;
	}
	public void setReport_num(int report_num) {
		this.report_num = report_num;
	}
	public int getWrite_num() {
		return write_num;
	}
	public void setWrite_num(int write_num) {
		this.write_num = write_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getSortcode() {
		return sortcode;
	}
	public void setSortcode(int sortcode) {
		this.sortcode = sortcode;
	}
	public int getRes_num() {
		return res_num;
	}
	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}
	public Date getDec_date() {
		return dec_date;
	}
	public void setDec_date(Date dec_date) {
		this.dec_date = dec_date;
	}
	public int getRes_dis() {
		return res_dis;
	}
	public void setRes_dis(int res_dis) {
		this.res_dis = res_dis;
	}
	public int getRes_state() {
		return res_state;
	}
	public void setRes_state(int res_state) {
		this.res_state = res_state;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public boolean isExp_state() {
		return exp_state;
	}
	public void setExp_state(boolean exp_state) {
		this.exp_state = exp_state;
	}
	public Date getExp_time() {
		return exp_time;
	}
	public void setExp_time(Date exp_time) {
		this.exp_time = exp_time;
	}
	
}
