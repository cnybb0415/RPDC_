<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
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


</head>
<style></style>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<body>
사진 넣는 곳
<p id="picture">pictureName.png</p>
<p id="top">4</p>
<p id="topcolor">1</p>
<p id="bottom">14</p>
<p id="bottomcolor">1</p>
<p id="outer">3</p>
<p id="outercolor">1</p>
<p id="shoe">34</p>
<p id="shoecolor">1</p>
<p id="one_piece"></p>
<p id="one_piececolor">2</p>
<p id = "weather">1</p>
<p id =  "tmn">4</p>
<p id =  "tmx">10</p>
<p id =  "place">구디</p>
<a onclick="writeForm()">작성</a>

</body>
<script>


var cloth={};
var color={};

function writeForm(){

	var top=$('#top').text();
	var topcolor=$("#topcolor").text();
	var bottom=$("#bottom").text();
	var bottomcolor=$("#bottomcolor").text();
	var outer=$("#outer").text();
	var outercolor=$("#outercolor").text();
	var shoe=$("#shoe").text();
	var shoecolor=$("#shoecolor").text();
	var one_piece=$("#one_piece").text();
	var one_piececolor=$("#one_piececolor").text();
	var place=$("#place").text();

	var picture=$("#picture").text();

	var tmn=$("#tmn").text();
	var tmx=$("#tmx").text();
	console.log('상의 : ' + top);
	console.log('하의 : ' + bottom);
	console.log('아우터 : ' + outer);
	console.log('신발 : ' + shoe);
	console.log('원피스 : ' + one_piece);
	console.log('상의색 : ' + topcolor);
	console.log('하의색 : ' + bottomcolor);
	console.log('아우터색 : ' + outercolor);
	console.log('신발색 : ' + shoecolor);
	console.log('원피스색 : ' + one_piececolor);
	console.log('------------------- ');
	console.log('최저 온도와 최고 온도 : ' + tmn+"/"+tmx);
	console.log('------------------- ');
	console.log('사진명 : ' + picture);
	console.log('장소명 : ' + place);
	
	if((top!=''||bottom!='')&&one_piece!=''){
		alert('잘못된 의상 선택');
	}else{
		
	if(top!=''){
		cloth.top=top;
		if(topcolor!=''){
			color.topcolor=topcolor;
		}else{
			alert('상의 색 선택 안함;');
		}
	}
	
	if(bottom!=''){
		cloth.bottom=bottom;
		if(bottomcolor!=''){
			color.bottomcolor=bottomcolor;
		}else{
			alert('하의 색 선택 안함;');
		}
	}
	
	if(outer!=''){
		bottom.outer=outer;
		if(outercolor!=''){
			color.outercolor=outercolor;
		}else{
			alert('외투 색 선택 안함;');
		}
	}
	
	if(shoe!=''){
		cloth.shoe=shoe;
		if(shoecolor!=''){
			color.shoecolor=shoecolor;
		}else{
			alert('ㅅㅣㄴ발 색 선택 안함;');
		}
	}
	if(one_piece!=''){
		cloth.one_piece=one_piece;
		if(one_piececolor!=''){
			color.one_piececolor=one_piececolor;
		}else{
			alert('색 선택 안함;');
		}
	}
	
	console.log(cloth);
	console.log(color);
	
	$.ajax({
		url : 'writeBoard',
		type : 'GET',
		data : {
			'cloth':cloth,
			'color':color,
			'tmn':tmn,
			'tmx':tmx,
			'picture':picture,
			'place':place
		},
		dataType : 'JSON',
		success : function(result){
			console.log(result);
			
		},
		error : function(e){
			console.log(e);
		}
	});
	
	
	
	}
}



</script>
</html>