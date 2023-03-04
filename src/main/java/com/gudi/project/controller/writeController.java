package com.gudi.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gudi.project.dao.writeDAO;
import com.gudi.project.dto.ClothDTO;
import com.gudi.project.dto.ColorDTO;
import com.gudi.project.dto.PostDTO;
import com.gudi.project.dto.WeatherDTO;
import com.gudi.project.dto.WriteDTO;
import com.gudi.project.service.listService;
import com.gudi.project.service.writeService;

@Controller
public class writeController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired writeService service;
	@Autowired listService listService;
	@Autowired writeDAO writedao;

	//	@RequestMapping(value = "/", method = RequestMethod.GET)
	//	public String home(Model model) {
	//		logger.info("정상 실행");
	//		model.addAttribute("test", "test" );
	//
	//		return "test2";
	//	}



	@RequestMapping(value = "/writeForm")
	public String writeForm(Model model, HttpServletRequest req) throws IOException, ParseException {
		HttpSession session = req.getSession();
		String mem_num = (String) session.getAttribute("loginId");
		String home = "redirect:/";
		if(mem_num != null && !mem_num.equals("")) {
			logger.info("글작성");
			//		ArrayList<ClothDTO> list = service.list();
			//		model.addAttribute("list", list);
			//		HashMap<String, Object> map = new HashMap<String, Object>();
			//		ArrayList<ClothDTO> list = service.list();
			//		map.put("list", list);
			LocalDate nowDate = LocalDate.now();
			String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
			// 占쏙옙占쏙옙 키
			String serviceKey = "0C0KxQlchEfYKRkvh2LGG%2BA1EWgJYxjN9yNA1TOUc94OOtJV9yHRv8a0yJj5DnyLaR%2F3qbtacF808BhBY8tr3w%3D%3D";
			// 占쏙옙占쏙옙, 占썸도
			String dataType = "JSON";
			String base_date = nowDate.toString().replace("-", "");
			String base_time = "0500";
			String nx = "55";
			String ny = "127";
			String page = "1";
			String numOfRows = "1000";

			StringBuilder urlBuilder = new StringBuilder(apiUrl); /* URL */

			StringBuilder serv = urlBuilder
					.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey); /* Service Key */


			// 占쏙옙占쏙옙占쏙옙 占쏙옙호
			StringBuilder pag = urlBuilder
					.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(page, "UTF-8"));

			// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙호
			StringBuilder row = urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode(numOfRows, "UTF-8")); /* 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙 */

			// 占쏙옙占쏙옙占쏙옙 타占쏙옙
			StringBuilder data = urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "="
					+ URLEncoder.encode(dataType, "UTF-8")); /* 占쏙옙청占쌘뤄옙占쏙옙占쏙옙(XML/JSON) Default: XML */

			// 占쏙옙회 占쏙옙짜
			StringBuilder date = urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "="
					+ URLEncoder.encode(base_date, "UTF-8")); /* 占쏙옙21占쏙옙 6占쏙옙 28占쏙옙 占쏙옙표 */

			StringBuilder time = urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "="
					+ URLEncoder.encode(base_time, "UTF-8")); /* 06占쏙옙 占쏙옙표(占쏙옙占시댐옙占쏙옙) */

			StringBuilder x = urlBuilder
					.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); /* 占쏙옙占쏙옙 X : 58 */

			StringBuilder y = urlBuilder
					.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); /* 占쏙옙占쏙옙 Y : 125 */


			URL url = new URL(urlBuilder.toString());
			//logger.info("url"+url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;

			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			Object result = sb.toString();
			//logger.info("msg" + result);

			JSONParser parser = new JSONParser();
			//JSONObject obj = (JSONObject)parser.parse(result); 
			JSONObject obj = (JSONObject) parser.parse((String) result);
			logger.info("obj",obj);
			JSONObject response = (JSONObject) obj.get("response");
			JSONObject body = (JSONObject) response.get("body"); 
			JSONObject items =(JSONObject) body.get("items"); 
			JSONArray item = (JSONArray)items.get("item");
			JSONObject TMX = (JSONObject) item.get(120);
			JSONObject TMN = (JSONObject) item.get(591);
			JSONObject SKY = (JSONObject) item.get(5);
			//logger.info("TMX : "+TMX);
			//logger.info("TMN : "+TMN);
			//logger.info("SKY : "+SKY);

			JSONObject weather; 
			String category;
			String day = ""; 
			String val  = "";

			for (int i = 0; i < item.size(); i++) { 

				weather = (JSONObject) item.get(i);
				Object fcstValue = weather.get("fcstValue");
				Object fcstDate = weather.get("fcstDate");
				category = (String) weather.get("category");

				if(!day.equals(fcstDate.toString())) {
					day = fcstDate.toString();
				}
				if(!val.equals(fcstValue.toString())) {
					val = fcstValue.toString();
				}
			}	

			model.addAttribute("TMX",TMX);
			model.addAttribute("TMN",TMN);
			model.addAttribute("SKY",SKY);
			home = "writeForm2";

		}else {
			model.addAttribute("msg", "아이디 또는 패스워드를 확인해 주세요"); 
			home = "index";
		}
		return home;
	}

	@ResponseBody	  
	@RequestMapping(value = "/weather_listCall", method = RequestMethod.GET) 
	public HashMap<String, Object> weather_List(HttpSession session, HttpServletRequest req) {
		logger.info("list 요청 :"); 
		HashMap<String, Object> map = new HashMap<String, Object>();
		logger.info("날씨 리스트 호출"); // DTO 대신 MAP 을 쓰면 어떤 데이터를 가져오는 파악하기 힘들다(DTO 를안만들어도 사용가능) 
		// 소스 파악 등에 힘드니 가급적 쓰지 말것 
		// 언제 쓰나? 여러개의 테이블이 조인하는 등 구조가 복잡한 데이터를가져올 때 
		ArrayList<WeatherDTO> weather_list = service.weatherlist();
		map.put("weather_list", weather_list);

		return map; 
	} // 날씨 리스트 호출

	@ResponseBody	  
	@RequestMapping(value = "/bottomCall", method = RequestMethod.GET) 
	public HashMap<String, Object> bottomlist(HttpSession session) {
		logger.info("list 요청 :"); 
		HashMap<String, Object> map = new HashMap<String, Object>();

		logger.info("게시판 리스트 호출"); // DTO 대신 MAP 을 쓰면 어떤 데이터를 가져오는 파악하기 힘들다(DTO 를안만들어도 사용가능) 
		// 소스 파악 등에 힘드니 가급적 쓰지 말것 
		// 언제 쓰나? 여러개의 테이블이 조인하는 등 구조가 복잡한 데이터를가져올 때 
		ArrayList<ClothDTO> list = service.bottomlist();
		map.put("list", list);

		return map; 
	}	//하의 호출
	@ResponseBody	  
	@RequestMapping(value = "/topCall", method = RequestMethod.GET) 
	public HashMap<String, Object> toplist(HttpSession session) {
		logger.info("list 요청 :"); 
		HashMap<String, Object> map = new HashMap<String, Object>();

		logger.info("게시판 리스트 호출"); // DTO 대신 MAP 을 쓰면 어떤 데이터를 가져오는 파악하기 힘들다(DTO 를안만들어도 사용가능) 
		// 소스 파악 등에 힘드니 가급적 쓰지 말것 
		// 언제 쓰나? 여러개의 테이블이 조인하는 등 구조가 복잡한 데이터를가져올 때 
		ArrayList<ClothDTO> list = service.toplist();
		map.put("list", list);	


		return map; 
	}	//상의 호출
	@ResponseBody	  
	@RequestMapping(value = "/outerCall", method = RequestMethod.GET) 
	public HashMap<String, Object> outerlist(HttpSession session) {
		logger.info("list 요청 :"); 
		HashMap<String, Object> map = new HashMap<String, Object>();

		logger.info("게시판 리스트 호출"); // DTO 대신 MAP 을 쓰면 어떤 데이터를 가져오는 파악하기 힘들다(DTO 를안만들어도 사용가능) 
		// 소스 파악 등에 힘드니 가급적 쓰지 말것 
		// 언제 쓰나? 여러개의 테이블이 조인하는 등 구조가 복잡한 데이터를가져올 때 
		ArrayList<ClothDTO> list = service.outerlist();
		map.put("list", list);

		return map; 
	}	//아우터 호출
	@ResponseBody	  
	@RequestMapping(value = "/dressCall", method = RequestMethod.GET) 
	public HashMap<String, Object> dresslist(HttpSession session) {
		logger.info("list 요청 :"); 
		HashMap<String, Object> map = new HashMap<String, Object>();

		logger.info("게시판 리스트 호출"); // DTO 대신 MAP 을 쓰면 어떤 데이터를 가져오는 파악하기 힘들다(DTO 를안만들어도 사용가능) 
		// 소스 파악 등에 힘드니 가급적 쓰지 말것 
		// 언제 쓰나? 여러개의 테이블이 조인하는 등 구조가 복잡한 데이터를가져올 때 
		ArrayList<ClothDTO> list = service.dresslist();
		map.put("list", list);

		return map; 
	}	//원피스 호출
	@ResponseBody	  
	@RequestMapping(value = "/shoesCall", method = RequestMethod.GET) 
	public HashMap<String, Object> shoeslist(HttpSession session) {
		logger.info("list 요청 :"); 
		HashMap<String, Object> map = new HashMap<String, Object>();

		logger.info("게시판 리스트 호출"); // DTO 대신 MAP 을 쓰면 어떤 데이터를 가져오는 파악하기 힘들다(DTO 를안만들어도 사용가능) 
		// 소스 파악 등에 힘드니 가급적 쓰지 말것 
		// 언제 쓰나? 여러개의 테이블이 조인하는 등 구조가 복잡한 데이터를가져올 때 
		ArrayList<ClothDTO> list = service.shoeslist();
		map.put("list", list);

		return map; 
	}	//신발 호출


	@RequestMapping(value = "/write") 
	public String write(MultipartFile photo, HttpServletRequest req, @RequestParam HashMap<String, String> params, @RequestParam(value="mem_num", required=false) String mem_num) { 

		HttpSession session = req.getSession();
		mem_num = (String) session.getAttribute("loginId");
		logger.info("id: "+mem_num);
		logger.info("params : {}",params); 
		//		logger.info("List"+delList);
		logger.info("photo : {}",photo.getOriginalFilename()); 
		//logger.info(""+weather);
		//		service.write(photo, params,mem_num);


		ArrayList<String> Cloth = new ArrayList<String>();
		String top = req.getParameter("topVal");
		String bottom = req.getParameter("bottomVal");
		String outer = req.getParameter("outerVal");
		String dress = req.getParameter("dressVal");
		String shoes = req.getParameter("shoesVal");
		ArrayList<String> Color = new ArrayList<String>();
		String topcolor = req.getParameter("topcolor");
		String bottomcolor = req.getParameter("bottomcolor");
		String outercolor = req.getParameter("outercolor");
		String dresscolor = req.getParameter("dresscolor");
		String shoescolor = req.getParameter("shoescolor");

		if(!top.equals("")) {
			Cloth.add(top);
		}
		if(!bottom.equals("")) {
			Cloth.add(bottom);
		}
		if(!outer.equals("")) {
			Cloth.add(outer);
		}
		if(!dress.equals("")) {
			Cloth.add(dress);

		}
		if(!shoes.equals("")) {
			Cloth.add(shoes);

		}

		if(!topcolor.equals("")) {
			Color.add(topcolor);
		}
		if(!bottomcolor.equals("")) {
			Color.add(bottomcolor);
		}
		if(!outercolor.equals("")) {
			Color.add(outercolor);
		}
		if(!dresscolor.equals("")) {
			Color.add(dresscolor);
		}
		if(!shoescolor.equals("")) {
			Color.add(shoescolor);
		}

		logger.info("ArrayList: "+Cloth);

		logger.info("Val:"+top+"/"+bottom+"/"+outer+"/"+dress+"/"+shoes);

		logger.info("Val:"+topcolor+"/"+bottomcolor+"/"+outercolor+"/"+dresscolor+"/"+shoescolor);

		PostDTO dto = new PostDTO();
		dto.setBoard_date(params.get("board_date"));
		dto.setBoard_place(params.get("board_place"));
		dto.setWeather_num(params.get("weather"));
		dto.setBoard_tmx(params.get("board_tmx"));
		dto.setBoard_tmn(params.get("board_tmn"));
		dto.setMem_num(mem_num);
		int success = writedao.insertBoard(dto);
		int idx = dto.getBoard_num();
		for(int i=0; i<Cloth.size(); i++) {
			String clothData = Cloth.get(i);
			String colorData = Color.get(i);
			writedao.insertBoardOutfit(idx, clothData, colorData);


		}
		if(success > 0 && !photo.getOriginalFilename().equals("")) {
			logger.info("업로드 성공");
			service.fileUpload(photo, idx);

		}


		return "redirect:/"; 
	}	//글쓰기 작성 완료
	//	@RequestMapping(value = "/update") 
	//	public String write(@RequestParam HashMap<String, String> params) { 
	//		
	//		logger.info("params : {}",params); 
	////		logger.info("List"+delList);
	//		service.update(params);
	//		
	//		
	//		return "writeForm2"; 
	//	}

	@RequestMapping(value = "/popup") 
	public String popup(Model model, @RequestParam HashMap<String, String> params) { 
		ArrayList<ColorDTO> list = service.colorlist();
		logger.info("list size : "+list.size());
		model.addAttribute("list", list);

		return "colorPopup"; 
	}


	//	public HashMap<String, Object> colorPop() {
	//		
	//	HashMap<String, Object> map = new HashMap<String, Object>();
	//		
	//		logger.info("게시판 리스트 호출"); // DTO 대신 MAP 을 쓰면 어떤 데이터를 가져오는 파악하기 힘들다(DTO 를안만들어도 사용가능) 
	//		// 소스 파악 등에 힘드니 가급적 쓰지 말것 
	//		// 언제 쓰나? 여러개의 테이블이 조인하는 등 구조가 복잡한 데이터를가져올 때 
	//		ArrayList<ColorDTO> list = service.colorlist();
	//		map.put("list", list);
	//		
	//		return map;
	//	}

	//	@RequestMapping(value="/update", method = RequestMethod.POST)
	//	public String update(Model model, @RequestParam HashMap<String, String> params) {
	//
	//		String page = "redirect:/write";
	//		
	//		logger.info("params : {}", params);
	//		service.update(params);
	//	
	//		return page;
	//	}

	//	@RequestMapping(value = "/write") 
	//	public HashMap<String, Object> write(@RequestParam(value = "delList[]") List<String> delList) { 
	//		logger.info("List :{} ", delList);
	//		//logger.info(""+weather);
	//		service.clothWrite(delList);
	//		HashMap<String, Object> map = new HashMap<String, Object>();
	//		int msg = delList.size();
	//		map.put("msg", msg);
	//		
	//		return map; 
	//	}
}
