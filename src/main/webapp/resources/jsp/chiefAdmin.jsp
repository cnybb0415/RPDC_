<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<style></style>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.twbsPagination.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>



</head>
<body>
	<ul class="nav nav-tabs" id="tab">
		<li class="nav-item"><a class="nav-link active" id="cloth-tab"
			data-toggle="tab" href="#manageClothes">의상</a></li>
		<li class="nav-item"><a class="nav-link" id="color-tab"
			data-toggle="tab" href="#manageColord">색상</a></li>
		<li class="nav-item"><a class="nav-link" id="weather-tab"
			data-toggle="tab" href="#manageWeathers">날씨</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="Report-tab" data-toggle="tab" href="#manageRepReasoms">신고 사유</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="manageClothes">

			<ul class="nav nav-tabs" id="tab">
				<li class="nav-item"><a class="nav-link active"
					id="clothTop-tab" data-toggle="tab" href="#manageClothes_Top">상의</a></li>
				<li class="nav-item"><a class="nav-link" id="clothBottom-tab"
					data-toggle="tab" href="#manageClothes_Bottom">하의</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="clothOuter-tab" data-toggle="tab" href="#manageClothes_Outer">아우터</a></li>
				<li class="nav-item"><a class="nav-link" id="clothOnePiece-tab"
					data-toggle="tab" href="#manageClothes_OnePiece">원피스</a></li>
				<li class="nav-item"><a class="nav-link" id="clothShoe-tab"
					data-toggle="tab" href="#manageClothes_Shoe">신발</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="manageClothes_Top">
					상의 관리
					<table>
						<thead>
							<tr>
								<th>카테고리 명</th>
								<th>사진파일 명</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody id="clothTopListManage">
						</tbody>
						<tr>

							<h4>
								상의 카테고리 추가 : <input type="text" id="addTopCategory">
								<button onclick="insertCategories(1)">추가</button>
							</h4>
						</tr>
						<tr>
							<td colspan="3" id="paging">
								<div class="container">
									<nav area-label="Page navigation" style="text-align: center">
										<ui class="pagination" id="paginationClothTop"></ui>
									</nav>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div class="tab-pane" id="manageClothes_Bottom">
					하의 관리
					<table>
						<thead>
							<tr>
								<th>카테고리 명</th>
								<th>사진파일 명</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody id="clothBottomListManage">
						</tbody>
						<tr>

							<h4>
								하의 카테고리 추가 : <input type="text" id="addBottomCategory">
								<button onclick="insertCategories(2)">추가</button>
							</h4>
						</tr>
						<tr>
							<td colspan="3" id="paging">
								<div class="container">
									<nav area-label="Page navigation" style="text-align: center">
										<ui class="pagination" id="paginationClothBottom"></ui>
									</nav>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div class="tab-pane" id="manageClothes_Outer">
					아우터 관리
					<table>
						<thead>
							<tr>
								<th>카테고리 명</th>
								<th>사진파일 명</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody id="clothOuterListManage">
						</tbody>
						<tr>

							<h4>
								아우터 카테고리 추가 : <input type="text" id="addOuterCategory">
								<button onclick="insertCategories(3)">추가</button>
							</h4>
						</tr>
						<tr>
							<td colspan="3" id="paging">
								<div class="container">
									<nav area-label="Page navigation" style="text-align: center">
										<ui class="pagination" id="paginationClothOuter"></ui>
									</nav>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div class="tab-pane" id="manageClothes_OnePiece">
					원피스 관리
					<table>
						<thead>
							<tr>
								<th>카테고리 명</th>
								<th>사진파일 명</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody id="clothOnePieceListManage">
						</tbody>
						<tr>

							<h4>
								원피스 카테고리 추가 : <input type="text" id="addOnepieceCategory">
								<button onclick="insertCategories(4)">추가</button>
							</h4>
						</tr>
						<tr>
							<td colspan="3" id="paging">
								<div class="container">
									<nav area-label="Page navigation" style="text-align: center">
										<ui class="pagination" id="paginationClothOnePiece"></ui>
									</nav>
								</div>
							</td>
						</tr>
					</table>
				</div>

				<div class="tab-pane" id="manageClothes_Shoe">
					신발 리스트
					<table>
						<thead>
							<tr>
								<th>카테고리 명</th>
								<th>사진파일 명</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody id="clothShoeListManage">
						</tbody>
						<tr>

							<h4>
								신발 카테고리 추가 : <input type="text" id="addShoeCategory">
								<button onclick="insertCategories(5)">추가</button>
							</h4>
						</tr>
						<tr>
							<td colspan="3" id="paging">
								<div class="container">
									<nav area-label="Page navigation" style="text-align: center">
										<ui class="pagination" id="paginationClothShoe"></ui>
									</nav>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- cloth manage -->
		<div class="tab-pane" id="manageColord">
			색상 관리
			<table>
				<thead>
					<tr>
						<th>카테고리 명</th>
						<th>사진파일 명</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody id="clothColorsListManage">
				</tbody>
				<tr>

					<h4>
						색상 카테고리 추가 : <input type="text" id="addColorCategory">
						<button onclick="insertColorCategories(1)">추가</button>
					</h4>
				</tr>
				<tr>
					<td colspan="3" id="paging">
						<div class="container">
							<nav area-label="Page navigation" style="text-align: center">
								<ui class="pagination" id="paginationColors"></ui>
							</nav>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="tab-pane" id="manageWeathers">

			날씨를 관리를 해보죠
			<table>
				<thead>
					<tr>
						<th>카테고리 명</th>
						<th>사진파일 명</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody id="WeatherListManage">
				</tbody>
				<tr>
				<h4>
					날씨 카테고리 추가 : <input type="text" id="addweatherCategory">
					<button onclick="insertweatherCategories()">추가</button>
				</h4>

				</tr>
				<tr>
					<td colspan="3" id="paging">
						<div class="container">
							<nav area-label="Page navigation" style="text-align: center">
								<ui class="pagination" id="paginationWeathers"></ui>
							</nav>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="tab-pane" id="manageRepReasoms">

			신고사유 관리!
			<table>
				<thead>
					<tr>
						<th>카테고리 명</th>
						<th>사진파일 명</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody id="RepReasonListManage">
				</tbody>
				<tr>
				<h4>
					신고사유 카테고리 추가 : <input type="text" id="addResReasonCategory">
					<button onclick="insertResReasonCategories()">추가</button>
				</h4>

				</tr>
				<tr>
					<td colspan="3" id="paging">
						<div class="container">
							<nav area-label="Page navigation" style="text-align: center">
								<ui class="pagination" id="paginationRepReasoms"></ui>
							</nav>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script>
const triggerTabList = [...document.querySelectorAll('#myTab a')];
triggerTabList.forEach((triggerEl) => {
  const tabTrigger = new bootstrap.Tab(triggerEl)

  triggerEl.addEventListener('click', (e) => {
    e.preventDefault()
    tabTrigger.show()
  })
})
$("#manageClothes_Top").click(clothTopListLoad());
$("#manageClothes_Bottom").click(clothBottomListLoad());
$("#manageClothes_Outer").click(clothOuterListLoad());
$("#manageClothes_OnePiece").click(clothOnePieceListLoad());
$("#manageClothes_Shoe").click(clothShoeListLoad());
$("#color-tab").click(colorListLoad(1));
$("#weather-tab").click(weatherListLoad(1));
$("#Report-tab").click(resReasonListLoad(1));
//전역 변수
var content='';

//의상 테이블을 생성
function makeClothTableContent(list, cs_code){
	var state='';
	for(var i=0; i<list.length; i++){
		
	if(list[i].cloth_state){
		state='노출';
	}else{
		state='숨김';
	}
	content += '<tr>';
	content += '<td>'+list[i].cloth_name+'</td>';
	content += '<td>'+list[i].cloth_name+'.png</td>';
	content += '<td><a onclick=categoryClothShowAndHide('+list[i].cloth_num+','+list[i].cs_code+','+list[i].cloth_state+')>'+state+'</a></td>';
	content += '</tr>'
	}
	
	switch(cs_code){
	
		case 1:
			$("#clothTopListManage").empty();
			$("#clothTopListManage").append(content);
			content='';
			break;
		case 2:
			$("#clothBottomListManage").empty();
			$("#clothBottomListManage").append(content);
			content='';
			break;
		case 3:
			$("#clothOuterListManage").empty();
			$("#clothOuterListManage").append(content);
			content='';
			break;
		case 4:
			$("#clothOnePieceListManage").empty();
			$("#clothOnePieceListManage").append(content);
			content='';
			break;
		case 5:
			$("#clothShoeListManage").empty();
			$("#clothShoeListManage").append(content);
			content='';
			break;
	}
		
}
//각각 요소를 조회
function clothTopListLoad(){
	page=1;
	cs_code=1;
	clothListLoad(page, cs_code);
		
}
function clothBottomListLoad(){
	page=1;
	cs_code=2;
	clothListLoad(page, cs_code);
		
}
function clothOuterListLoad(){
	page=1;
	cs_code=3;
	clothListLoad(page, cs_code);
		
}
function clothOnePieceListLoad(){
	page=1;
	cs_code=4;
	clothListLoad(page, cs_code);
		
}
function clothShoeListLoad(){
	page=1;
	cs_code=5;
	clothListLoad(page, cs_code);
		
}

//로드하는 AJAX
function clothListLoad(page, cs_code){
	

	$.ajax({
		url:'clothListLoad',
		type:'GET',
		data:{
			'page':page,
			'cs_code':cs_code
		},
		dataType:'JSON',
		success:function(result){
			console.log(result.clothList);
			makeClothTableContent(result.clothList,cs_code);
			
			var totalPages = result.total;
			//플러그인 적용
			switch(cs_code){
			
				case 1:
					$('#paginationClothTop').twbsPagination({
					startPage:1,//시작 페이지
					totalPages:totalPages,//총 페이지 수
					visiblePages:5,//기본으로 보여질 페이지 수
					onPageClick:function(e,page){//클릭했을 때 실행 내용
						console.log(e);	
						console.log(page);	
						clothListLoad(page, 1);
					}	
					});
				case 2:
					$('#paginationClothBottom').twbsPagination({
						startPage:1,//시작 페이지
						totalPages:totalPages,//총 페이지 수
						visiblePages:5,//기본으로 보여질 페이지 수
						onPageClick:function(e,page){//클릭했을 때 실행 내용
							console.log(e);	
							console.log(page);	
							clothListLoad(page, 2);
						}	
						});
						
				case 3:
					$('#paginationClothOuter').twbsPagination({
						startPage:1,//시작 페이지
						totalPages:totalPages,//총 페이지 수
						visiblePages:5,//기본으로 보여질 페이지 수
						onPageClick:function(e,page){//클릭했을 때 실행 내용
							console.log(e);	
							console.log(page);	
							clothListLoad(page, 3);
						}	
						});
						
				case 4:
					
					$('#paginationClothOnePiece').twbsPagination({
						startPage:1,//시작 페이지
						totalPages:totalPages,//총 페이지 수
						visiblePages:5,//기본으로 보여질 페이지 수
						onPageClick:function(e,page){//클릭했을 때 실행 내용
							console.log(e);	
							console.log(page);	
							clothListLoad(page, 4);
						}	
						});
				case 5:
					
					$('#paginationClothShoe').twbsPagination({
						startPage:1,//시작 페이지
						totalPages:totalPages,//총 페이지 수
						visiblePages:5,//기본으로 보여질 페이지 수
						onPageClick:function(e,page){//클릭했을 때 실행 내용
							console.log(e);	
							console.log(page);	
							clothListLoad(page, 5);
						}	
						});
				}
			
			},
		error:function(e){
			console.log(e)
		}
	});

}
//의상 카테고리 추가
function insertCategories(cs_code){
	page=1;
	var content = '';
	switch(cs_code){

	case 1:
		content=$("#addTopCategory").val();
		$("#addTopCategory").val('');
		break;
		
	case 2:
		content=$("#addBottomCategory").val();
		$("#addBottomCategory").val('');
		break;
		
	case 3:
		content=$("#addOuterCategory").val();
		$("#addOuterCategory").val('');
		break;
		
	case 4:
		content=$("#addOnepieceCategory").val();
		$("#addOnepieceCategory").val('');
		break;
		
	case 5:
		content=$("#addShoeCategory").val();
		$("#addShoeCategory").val('');
		break;
	}
	
	console.log("Content : "+content);
	
	$.ajax({
		url:'insertCategories',
		type:'GET',
		data:{
			'cs_code':cs_code,
			'content' : content
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			clothListLoad(page, cs_code);
		},
		error : function(e){
			
		}
	});
}
//의상들의 카테고리 노출과 숨김 처리
function categoryClothShowAndHide(cloth_num,cs_code,state){
	console.log(cloth_num+'번 의상을 숨기거나 노출시킬꺼야');
	$.ajax({
		url:'categoryClothShowAndHide',
		type:'GET',
		data:{
			'cloth_num':cloth_num,
			'state':state
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			clothListLoad(page, cs_code);
		},
		error : function(e){
			
		}
	});
}
//색상 관리
function makeColorTableContent(list){
	var state='';
	for(var i=0; i<list.length; i++){
		
	if(list[i].color_state){
		state='노출';
	}else{
		state='숨김';
	}
	content += '<tr>';
	content += '<td>'+list[i].color_num+'</td>';
	content += '<td>'+list[i].color_name+'.png</td>';
	content += '<td><a onclick=categoryColorShowAndHide('+list[i].color_num+','+list[i].color_state+')>'+state+'</a></td>';
	content += '</tr>'
	}
	$("#clothColorsListManage").empty();
	$("#clothColorsListManage").append(content);
	content='';
}
//색상 테이블 조회
function colorListLoad(page){

	$.ajax({
		url:'colorListLoad',
		type:'GET',
		data:{
			'page':page,
		},
		dataType:'JSON',
		success:function(result){
			console.log(result.colorList);
			makeColorTableContent(result.colorList);
			
			var totalPages = result.total;
			//플러그인 적용
					$('#paginationColors').twbsPagination({
					startPage:1,//시작 페이지
					totalPages:totalPages,//총 페이지 수
					visiblePages:5,//기본으로 보여질 페이지 수
					onPageClick:function(e,page){//클릭했을 때 실행 내용
						console.log(e);	
						console.log(page);	
						colorListLoad(page);
					}	
					});
			
			},
		error:function(e){
			console.log(e)
		}
	});

}
//색상 카테고리 추가
function insertColorCategories(){
	page=1;
	var content = $("#addColorCategory").val();
	$("#addColorCategory").val('');
	console.log("Content : "+content);
	
	$.ajax({
		url:'insertColorCategories',
		type:'GET',
		data:{
			'content' : content
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			clothListLoad(page);
		},
		error : function(e){
			
		}
	});
}

//색상 카테고리 노출과 숨김 처리
function categoryColorShowAndHide(color_num,state){
	console.log(color_num+'번 의상을 숨기거나 노출시킬꺼야');
	$.ajax({
		url:'categoryColorShowAndHide',
		type:'GET',
		data:{
			'color_num':color_num,
			'state':state
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			colorListLoad(page);
		},
		error : function(e){
			
		}
	});
}
//날씨

//날씨 관리
function makeweatherTableContent(list){
	var state='';
	for(var i=0; i<list.length; i++){
		
	if(list[i].weather_state){
		state='노출';
	}else{
		state='숨김';
	}
	content += '<tr>';
	content += '<td>'+list[i].weather_num+'</td>';
	content += '<td>'+list[i].weather_name+'.png</td>';
	content += '<td><a onclick=categoryweatherShowAndHide('+list[i].weather_num+','+list[i].weather_state+')>'+state+'</a></td>';
	content += '</tr>'
	}
	$("#WeatherListManage").empty();
	$("#WeatherListManage").append(content);
	content='';
}
//날씨 테이블 조회
function weatherListLoad(page){

	$.ajax({
		url:'weatherListLoad',
		type:'GET',
		data:{
			'page':page,
		},
		dataType:'JSON',
		success:function(result){
			console.log(result.weatherList);
			makeweatherTableContent(result.weatherList);
			
			var totalPages = result.total;
			//플러그인 적용
					$('#paginationWeathers').twbsPagination({
					startPage:1,//시작 페이지
					totalPages:totalPages,//총 페이지 수
					visiblePages:5,//기본으로 보여질 페이지 수
					onPageClick:function(e,page){//클릭했을 때 실행 내용
						console.log(e);	
						console.log(page);	
						weatherListLoad(page);
					}	
					});
			
			},
		error:function(e){
			console.log(e)
		}
	});

}
//색상 카테고리 추가
function insertweatherCategories(){
	page=1;
	var content = $("#addweatherCategory").val();
	$("#addweatherCategory").val('');
	console.log("Content : "+content);
	
	$.ajax({
		url:'insertweatherCategories',
		type:'GET',
		data:{
			'content' : content
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			weatherListLoad(page);
		},
		error : function(e){
			
		}
	});
}

//날씨 카테고리 노출과 숨김 처리
function categoryweatherShowAndHide(weather_num, state){
	console.log(weather_num+'번 날씨정보을 숨기거나 노출시킬꺼야');
	$.ajax({
		url:'categoryweatherShowAndHide',
		type:'GET',
		data:{
			'weather_num':weather_num,
			'state':state
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			weatherListLoad(page);
		},
		error : function(e){
			
		}
	});
}

//신고 사유

//날씨 관리
function makeResReasonTableContent(list){
	var state='';
	for(var i=0; i<list.length; i++){
		
	if(list[i].res_state){
		state='노출';
	}else{
		state='숨김';
	}
	content += '<tr>';
	content += '<td>'+list[i].res_num+'</td>';
	content += '<td>'+list[i].reason+'.png</td>';
	content += '<td><a onclick=categoryResReasonShowAndHide('+list[i].res_num+','+list[i].res_state+')>'+state+'</a></td>';
	content += '</tr>'
	}
	$("#RepReasonListManage").empty();
	$("#RepReasonListManage").append(content);
	content='';
}
//날씨 테이블 조회
function resReasonListLoad(page){

	$.ajax({
		url:'resReasonListLoad',
		type:'GET',
		data:{
			'page':page,
		},
		dataType:'JSON',
		success:function(result){
			console.log(result.resReasonList);
			makeResReasonTableContent(result.resReasonList);
			
			var totalPages = result.total;
			//플러그인 적용
					$('#paginationRepReasoms').twbsPagination({
					startPage:1,//시작 페이지
					totalPages:totalPages,//총 페이지 수
					visiblePages:5,//기본으로 보여질 페이지 수
					onPageClick:function(e,page){//클릭했을 때 실행 내용
						console.log(e);	
						console.log(page);	
						resReasonListLoad(page);
					}	
					});
			
			},
		error:function(e){
			console.log(e)
		}
	});

}
//색상 카테고리 추가
function insertResReasonCategories(){
	page=1;
	var content = $("#addResReasonCategory").val();
	$("#addResReasonCategory").val('');
	console.log("Content : "+content);
	
	$.ajax({
		url:'insertResReasonCategories',
		type:'GET',
		data:{
			'content' : content
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			resReasonListLoad(page);
		},
		error : function(e){
			
		}
	});
}

//색상 카테고리 노출과 숨김 처리
function categoryResReasonShowAndHide(res_num,state){
	console.log(res_num+'번 날씨정보을 숨기거나 노출시킬꺼야');
	$.ajax({
		url:'categoryResReasonShowAndHide',
		type:'GET',
		data:{
			'res_num':res_num,
			'state':state
		},
		dataType:'JSON',
		success : function(result){
			console.log(result);
			resReasonListLoad(page);
		},
		error : function(e){
			
		}
	});
}


</script>
</html>