<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<style></style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.js"
	integrity="sha512-uzuo1GprrBscZGr+iQSv8+YQQsKY+rSHJju0FruVsGHV2CZNZPymW/4RkxoHxAxw3Lo5UQaxDMF8zINUfAsGeg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script src="resources/js/jquery.twbsPagination.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>

</head>
<body>

	<div id="boardContents">
		<input type="radio" name="state" value="미처리">미처리 <input
			type="radio" name="state" value="블라인드">블라인드 <input
			type="radio" name="state" value="계정 탈퇴">계정 탈퇴

		<button onclick="load()">전체보기</button>
		<table>
			<thead>
				<tr>
					<th>신고 번호</th>
					<th>글 번호</th>
					<th>신고자 닉네임</th>
					<th>처리 담당자</th>
					<th>신고 일자</th>
					<th>신고 사유</th>
					<th>처리 결과</th>
				</tr>
			</thead>
			<tbody id="RecRepList">

			</tbody>
			<tr>
				<td colspan="6" id="paging">
					<div class="container">
						<nav area-label="Page navigation" style="text-align: center">
							<ui class="pagination" id="paginationAll"></ui>
							<ui class="pagination" id="paginationNoProc"></ui>
							<ui class="pagination" id="paginationBlind"></ui>
							<ui class="pagination" id="paginationBan"></ui>
						</nav>
					</div>
				</td>
			</tr>
		</table>
	</div>

	<!-- body end -->
</body>
<script>

var showPage = 1;
//게시글 전체 로딩
function load(page) {
	$.ajax({
		type : "GET",
		url : "RecRepLoad",
		data : {
			'page' : page
		},
		dataType : "JSON",
		success : function(result) {
			console.log("전체 페이징성공");
			console.log(result.RecRepLoad);
			console.log(result.boardDateStrs);
			console.log(result.repRecManager);
			createRepTable(result.RecRepLoad, result.RecRepDateStrs, result.repRecManager);
			var totalPages = result.total;
			//플러그인 적용
			$('#paginationAll').twbsPagination({
				startPage : page,//시작 페이지
				totalPages : totalPages,//총 페이지 수
				visiblePages : 10,//기본으로 보여질 페이지 수
				onPageClick : function(e, page) {//클릭했을 때 실행 내용
					console.log(e);
					console.log(page);
					load(page)
				}

			});

		},
		error : function(e) {
			console.log("error");
		}
	});

}
//리스트를 테이블로 뽑아주는 친구
function createRepTable(list, dateStrs, repRecManager) {
	console.log(list);
	console.log("이걸로 이제 테이블 만든다.");
	var content = '';
	if (list != undefined) {

		for (var i = 0; i < list.length; i++) {
			content += '<tr>';
			content += '<td>' + list[i].report_num + '</td>';
			content += '<td>' + list[i].write_num + '</td>';
			content += '<td>' + list[i].mem_nickname + '</td>';
			content += '<td>' + repRecManager[i] + '</td>';
			content += '<td>' + dateStrs[i] + '</td>';
			content += '<td>' + list[i].reason + '</td>';
			content += '<td>' + list[i].proc_cnt+'</td>'
			content += '</tr>';
		}
	} else {
		content += '<tr><td colspan=7>조회된 데이터가 없습니다.</td></tr>'
	}
	$("#RecRepList").empty();
	$("#RecRepList").append(content);

}


$('input[name="state"]').change(function(){
	var page=1;
	var value = $('input[name="state"]:checked').val();
	
	callStateRecRep(page,value);
});


function stateBoard(){
	var value = $('input[name="state"]:checked').val();
	console.log(value);
	page = 1;
	createRepTable(page, value);
}

function callStateRecRep(page, value) {
	console.log(value + "와 " + page)

	$.ajax({
		url : "stateRepSearch",
		type : "GET",
		data : {
			'state' : value,
			'page' : page
		},
		dataType : "JSON",

		success : function(result) {
			createRepTable(result.searchRepList, result.RecRepDateStrs, result.repRecManagerList);
			console.log('라인 테스트');
			var totalPages = result.total;
			console.log('라인 테스트 : ' + totalPages);
			//플러그인 적용

			if (value == '미처리') {
				console.log('정상 실행');
				$('#paginationAll').empty();
				$('#paginationBlind').empty();
				$('#paginationBan').empty();
				$('#paginationNoProc').twbsPagination({
					startPage : page,//시작 페이지
					totalPages : totalPages,//총 페이지 수
					visiblePages : 10,//기본으로 보여질 페이지 수
					onPageClick : function(e, page) {//클릭했을 때 실행 내용
						console.log(e);
						console.log(page);
						callStateRecRep(page, value);
					}

				});

			} else if (value == '블라인드') {
				console.log('블라인드 실행');
				$('#paginationAll').empty();
				$('#paginationNoProc').empty();
				$('#paginationBan').empty();
				$('#paginationState_Blind').twbsPagination({

					startPage : page,//시작 페이지
					totalPages : totalPages,//총 페이지 수
					visiblePages : 10,//기본으로 보여질 페이지 수
					onPageClick : function(e, page) {//클릭했을 때 실행 내용
						console.log(e);
						console.log(page);
						console.log(value);
						callStateRecRep(page, value);
					}

				});
			} else {
				console.log('계정 탈퇴');
				$('#paginationAll').empty();
				$('#paginationBlind').empty();
				$('#paginationNoProc').empty();
				$('#paginationBan').twbsPagination({
					startPage : page,//시작 페이지
					totalPages : totalPages,//총 페이지 수
					visiblePages : 10,//기본으로 보여질 페이지 수
					onPageClick : function(e, page) {//클릭했을 때 실행 내용
						console.log(e);
						console.log(page);
						console.log(value);
						callStateRecRep(page, value);
					}

				});
			}
		},
		error : function(e) {
			console.log(e)
		}
	});
}

load(showPage);


</script>
